# 1 基础和应用篇



## 1.2 Redis的重要应用



## 1.3 分布式锁

需要解决的问题：

1. 超时问题：设置随机数，可以用用户ID，保证谁请求的锁，谁才能删除锁。自己别把别人的锁子给删除掉了
2. 可重入问题：一般可以规整为不重入的，重入的性能要求高。

```python
tag = random.nextint()
if redis.set(key, tag, nx=True, ex=5):
    do_something()
    redis.deifequals(key, tag)
```



## 1.4 延迟队列

队列空了怎么办：轮训 pop 队列，pop为空就 sleep(1) ，会导致 消息处理延迟增大。p26

阻塞读：用 blpop 和 brpop 解决超时问题。

锁冲突怎么办：抛异常、sleep、延时队列（过会再去获取锁，适合异步任务）



## 1.5 位图 p31



## 1.6 HyperLogLog ——大规模去重计数

背景：统计 `UV（Unique Visitor)` ，1个用户来多次只计算1次，需要去重。几百万个用户，用 Set 不现实。

用法：提供不精确的去重方案，但误差率很小，在0.81%作用

存储优化：数据量小，用的稀疏矩阵存储 `HyperLogLog`， 数据量大时，用的稠密矩阵



添加：

- `pfadd blog user1`   
- `pfadd blog user2 user3 user4` 

计数：

- `pfcount blog`

合并：

- 合并两个 pf 统计的 name (如，blog)：`pfmerge name1 name2`



## 1.7 布隆过滤器 —— 大规模判定存在

背景：100万个数据，判定其中是否存在，或者不存在某个数，怎么办？遍历，效率太低了。

答案：布隆过滤器，他说不存在，就一定不存在。他说存在，则99%存在，但也可能不存在。

用产品举例：

1. 推荐新闻的去重（去除已经看过的）
2. 已经爬过的URL去重
3. 垃圾邮件



包：lettuce（支持布隆过滤器，Java也推荐使用他）

自定义布隆过滤器：p57，`bf.reserve key error_rate initial_size` , 关于用多少个hash，多大的误差率，是有固定公式可以计算的。p61

原理：

1. 添加 key 时，用多个 `hash` 函数对 `key` 进行 `hash` ，算得索引值
2. 索引值 对 数组长度 取模，每个`hash` 都会获得 1个 数组坐标
3. 多个 `hash`，多个对应的取模坐标，赋值 为 1
4. 为什么会误判：1个`key`，本来不存在，但多个`hash`对应的位置，恰好被 `key2 key3` 等等给置为1了，所以就误判了



注意：

- 布隆过滤器实际容量 >> 预期容量：只能重建，否则 误判率很大。



## 1.8 限流 —— cl.throttle

背景：在网站上，如UGC社区，限制用户持续对系统施压，比如一直发帖一直发帖等

定义：限定用户 在特定的时间 `Time` 内 只能执行多少期 `Action`

**推荐使用方案： Redis-Cell**

解决办法：

1. `action` 较小，可用 `zset` 制作滑动窗口，做简单的限流
2. `action` 较大，**60s 内不得超过100万次**，可用 Redis 漏斗限流。
   1. 用法：`cl.throttle laoqian:reply 15 30 60 1`。意思是允许用户老钱回复行为的频率为每60s最多30次，漏水的初始容量为15,也就说一开始可以连续回复15个帖子，然后才开始受漏水速率的影响。



```
root@sun:~# redis-cli -v
redis-cli 6.0.6

# 限流命令，竟然没有执行成功
```



## 1.10 GeoHash

背景：计算附近的人，两两要计算一下距离，在上亿用户总，计算规模太大。

应用：附近的人p76，地图应用

GeoHash算法：

1. 用划刀法，对一个区域内的地理位置点进行编号，1个地理位置，形成1个整数
2. GeoHash对 整数做 1次 base32的编码，放进 zset
3. 对zset的 score 排序，两个位置近的，编码位置也近。

建议：p78

1. 集群中，单个key对应的数据量，不可超过1MB，否则迁移数据会卡顿
2. Geo的数据，建议用 单独的Redis 实例部署，不使用集群环境



命令：

- 添加：`geoadd company 116.48105 399.996794 juejin`
- 计算距离：`geodist company ireader meituan`
- 移除元素：`zrem company juejin`

```
geoadd company 116.48105 39.996794 juejin
geoadd company 116.514203 39.905490 ireader
geoadd company 116.489033 40.007669 meituan
geoadd company 116.562108 39.787602 jd 116.334255 40.027400 xiaomi

127.0.0.1:6379> geoadd company 116.489033 40.007669 meituan
(integer) 1
127.0.0.1:6379> geoadd company 116.48105 39.996794 juejin 116.514203 39.905490 ireader
(integer) 2
127.0.0.1:6379> geoadd company 116.562108 39.787602 jd 116.334255 40.027400 xiaomi 
(integer) 2

127.0.0.1:6379> geodist company ireader meituan
"11565.8907"


127.0.0.1:6379> zrem company ireader
(integer) 1
127.0.0.1:6379> geodist company ireader meituan
(nil)
```



## 1.10 scan —— 扫描Key

背景：成千上万的 key 中，查找特定前缀的 key 列表

怎么办：用scan



Redis 中 key 字典的扩容：

1. new hash = 0xxxx 或者 1xxxx（ xxxx 为old compacity的容量，比如这里是 16 扩容层32，就是16，用xxxx表示）
2. 扩容对遍历有影响吗：没有，Redis采用高位加法，扩容后只需要多扫描新的 hash（要么是0xxxx 和 1xxxx）位置即可，不必重复扫描已经扫描过（之前的）的位置。

渐进式Hash：Redis 会生成新的，旧的数组，定时任务中 以及后续 对 hash的指令操作中，渐渐的将 原来的hash 移动到现在的hash 上面。



总结：避免大Key产生，否则会带来卡顿：

```
redis-cli -h 127.0.0.1 -p 6379 --bigkeys

# 避免 OPS 剧烈升高
redis-cli -h 127.0.0.1 -p 6379 --bigkeys -i 0.1  # 每执行100条scan，就休眠0.1s
```



命令：

- 返回所有的key：key *
  - key company*



```python
# 插入数据

root@sun:~/test# cat redispy.py
import redis
client = redis.StrictRedis()
for i in range(1000):
    client.set("key%d" % i, i)
```



```
127.0.0.1:6379> keys *
1) "company"
127.0.0.1:6379> set com1 1
OK
127.0.0.1:6379> keys com*
1) "com1"
2) "company"
127.0.0.1:6379> scan 0 match key99* count 10         # count 10 , 是先扫描 10 个插槽。
1) "576"                                             # 游标值，不为0，就说明没有扫描完毕
2) (empty array)
127.0.0.1:6379> scan 576 match key99* count 100
1) "952"
2) 1) "key997"
   2) "key99"
127.0.0.1:6379> scan 952 match key99* count 1000
1) "0"
2) 1) "key992"
   2) "key998"
   3) "key993"
   4) "key999"
   5) "key996"
   6) "key995"
   7) "key994"
   8) "key990"
   9) "key991"
```



# 2 原理篇





