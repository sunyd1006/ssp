

# 各类暑期、秋招分享记录



## 微软

![image-20210110150933286](all_company_talking.assets/image-20210110150933286.png)







# 阿里内推注意：

内推：要笔试，要素质测评，



**Q：内部推荐有什么优势？**
A： 1、 内推可以和阿里师兄或师姐充分沟通了解部门和岗位详细情况，选择自己心仪的部门和岗位。
2、内推不通过的同学还有机会进行网申。



题目：hot100，top100，



实习：合理的进度安排（一接受任务，就要开始了解）
暑期实习的时间：6.15（简历）







# 题

# 阿里大数据

问题：
 1.自我介绍
 2.项目细节
 3.题目 有用户对于微信文章表t_user_log,数据量约40亿，t_wx_doc表，数据量约400W,
 表结构信息如下
 create table default.t_user_log (
  ip string comment 'ip',
  ts string comment '时间戳',
  userid string comment '用户id',
  docid string comment '文章id',
  action string comment '用户行为1 阅读，2点赞，3 分享，4 打赏, 5 评论',
  entry string comment '如口'
 ) partitioned by (
  day string comment ''
 )

create table default.t_wx_doc (
cpid string comment '公众号id',
ts string comment '发文时间戳' ,
docid string comment '文章id',
text string comment '文章内容',
category string comment '文章分类'
) 
机器资源有限，（vcore 小与100， &&men<400G）请编程解决下面两个问题
计算框架 算法不限
1 .找出热门的公众号top10
\2. 给定一个10000w 大小用户包（userid 字符长度为16）计算他们各自最可能喜欢的5个公众号

\4. Flink如何保障在使用kafka的时候是execyly-one的？
\5. Flink与spark的区别
\6. Flink内存模型
\7. Spark内存模型
\8. Spark shuffle过程
\9. Spark Rdd属性
\10. Rdd的那个算子可以重分区但是不用shuffle
\11. 问题3热门文章数据量大的时候，出现数据倾斜如何解决







**阿里一面（35min）**



hadoop的基本组件详细介绍一下

zk的实现原理

zk如何实现分布式锁

并发编程如何实现

生产者，消费者模式的具体实现是什么

mysql的事务隔离级别是什么

[红黑树](https://www.nowcoder.com/jump/super-jump/word?word=红黑树)知道吗？大概说一下



**阿里二面（30min）**



[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)

hive的优点，为什么要使用hive

**tcp协议的重传机制**

问了转行的原因



**阿里三面（两个半小时）**



[算法题](https://www.nowcoder.com/jump/super-jump/word?word=算法题)一，在数组中随机选取是三个数，越大的数出现的频率越大

[算法题](https://www.nowcoder.com/jump/super-jump/word?word=算法题)二，根据字典来遍历输入字符串

[算法题](https://www.nowcoder.com/jump/super-jump/word?word=算法题)三，岛屿问题

**T的含义是什么**

[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)介绍一下

数据流中的中位数是怎么找到的



**阿里四面（30min）**



自我介绍

[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)的介绍

问了一下复杂[链表](https://www.nowcoder.com/jump/super-jump/word?word=链表)的复制

聊了一下疫情的问题



**hr面**



[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)遇到最大的困难

你最有压力的时候，怎么缓解

你最优成就感的[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)

你为跨专业考研

你未来的[职业规划](https://www.nowcoder.com/jump/super-jump/word?word=职业规划)

面试这么多次的收获是什么

你笔试题做下来是什么感觉，有没有对答案

你了不了解[阿里云](https://www.nowcoder.com/jump/super-jump/word?word=阿里云)的产品





# **[腾讯](https://www.nowcoder.com/jump/super-jump/word?word=腾讯)面试**



[项目](https://www.nowcoder.com/jump/super-jump/word?word=项目)

网站输入url的过程

dns协议是否使用udp

三次握手和四次挥手

为什么建立连接时三次握手，断开连接时四次挥手

tcp有什么别的保证可靠性的机制嘛

tcp出现包丢失要怎么处理呢？

滑动窗口啥的？我不知道啊

你说一说如果我要找出数组中重复的数字要怎么做呢？

hashmap

位图（不知道面试官提到的）

那你说一说hashmap中怎么解决冲突呢？

那你说一下怎么找到数组中的最大的k个值呢？

使用小根堆

还有别的方法吗

使用快速[排序](https://www.nowcoder.com/jump/super-jump/word?word=排序)的思想，时间复杂度是多少

看你会使用linux，说一说怎么查看内存，怎么查看磁盘空间，怎么查看进程

你会c/c嘛？





# 字节大数据

作者：求offer求转正
链接：https://www.nowcoder.com/discuss/613708?channel=&source_id=_discuss_interview_nctrack
来源：牛客网



\1. 自我介绍 

  \2. 实习经历 

  描述了在[滴滴]()的实习经历 


  \3. 大数据方面，[职业规划]() 

  \4. 对数据仓库有什么了解？ 

  讲了写与传统关系型数据库的区别 


  以及其他的一些我所知道的 


  \5. 你认为什么样的数据仓库是比较好的数据仓库？ 

  \6. 能讲讲hdfs么 

  主要讲了下hdfs写文件的过程 


  \7. mapreduce 能讲讲么？具体的过程又是怎么样的？ 

  \8. 实习提到经常用spark ，因此问了dag（有向无环图） 生成过程？ 

  \9. 遇到过数据倾斜么？怎么样解决呢？ 

  \10. hadoop 除了mapreduce 还有其他什么组件？ 

  11.两道sql 

  给定用户id，文章id，阅读时间 

  1⃣️ 前五个 阅读量最高的文章 

  2⃣️ 每个用户 最多连续阅读的天数 

  


  感觉问题基本在射程范围内





### 美团数据

作者：牛客505477420号
链接：https://www.nowcoder.com/discuss/618597?channel=&source_id=_discuss_interview_nctrack
来源：牛客网



一面： 60分钟左右 

 1、 http位于协议模型的哪一层？ 

 2、 post、get方式的区别? Post具体如何传输数据的？（好像是这样？） 

 3、 进线程的区别？ 

 4、 知道的数据结构？ 

 5、 [链表]()和数组的区别，队列跟栈的区别 

 6、 什么是索引，有哪些索引，索引的缺点？B树和B+树有什么优缺点？ 

 7、 数据库查询语言、数据库操纵语言、数据库定义语言、数据库控制语言 

 8、 事务的ACID特性 

 9、 数据库范式，第三范式举例说明 

 10、 Drop、truncate、delete的区别 

 11、表连接类型：inner/left/right join，（漏了个全连接）,以 left join为例说一下特点 

 12、Hadoop的问了点基础，但我不怎么会，答的不好 

  

 编程 2道sql： 

 一道python：求逆序对 （只会暴力，提示说用归并） 

  最后问了一个：无限的水， 3升跟 5升的桶，怎么装出 4升水？ 

  面试体验很好，面试官也很耐心。希望能有机会二面~