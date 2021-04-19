# 项目说明

- mybatis-helloworld:
- mybatis-config: 
    - 使用了 log4j, db.properties
    - UserMapper.xml : 使用了 ResultMap
- spring-32-mybatis-manyone:
    - 多对一的项目：

# Spring常见pom

## pom.xml 导出问题

```xml
<build>
    <!--        这个目录是默认加载的，所以不用配置-->
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```

# resources 配置文件
## mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

<!--    导入 外部配置文件-->
    <properties resource="db.properties" />

    <settings>
<!--      官网》XML配置》Settings中：  指定 MyBatis 所用日志的具体实现，未指定时将自动查找。-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>   <!-- 标准的配置-->
    </settings>

<!--    为实体类，com.sun.pojo.User配置别名，就是为了在UserMapper中写起来，不那么麻烦而已-->
    <typeAliases>
        <typeAlias type="com.sun.pojo.User" alias="User"/>
    </typeAliases>

    <environments default="development">
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://121.40.254.238:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="1210"/>
            </dataSource>
        </environment>

        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>

<!--    一定要导入相关的mapper-->
    <mappers>
        <mapper resource="com/sun/mapper/UserMapper.xml"/>
    </mappers>
</configuration>
```


## db.properties
```$properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://121.40.254.238:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF-8
username=root
password=1210
```


## log4j.properties
```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/kuang.log
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
``` 

# 类 MybatisUtils
## 获取SqlSessionFactory
```java
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// //sqlSessionFactory --> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
```

## Test类
```java
try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    User userById = mapper.getUserById(5);
    System.out.println(userById);
}
```