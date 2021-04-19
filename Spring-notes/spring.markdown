# 项目说明
狂神的Java Spring学习笔记

# 如何获取 Bean
```java
ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
People people = context.getBean("people", People.class);

ApplicationContext context = new AnnotationConfigApplicationContext(SunConfig.class);
Object getUser = context.getBean("getUser", User.class);
```

# 常用注解
- @Autowired: 自动装配，通过类型
    - @Autowired(required = false), 可以不注入属性
    - @Qualifier(value="xxx), 如果不能用autowired唯一装配
- @Resource: 自动装配，通过名字，在通过类型。
- @Component: 组件，放在类上，说明这个类 被Spring 管理了，就是bean.
    - @Repository   ：dao层的注解
    - @Service      ：Service层的注解
    - @Controller : 控制层的注解，他们三个是一样的

# 常用dependencys
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">


    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.4</version>
        </dependency>


        <!--Spring的事务管理器、必须要用他-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.6.RELEASE</version>
        </dependency>
        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.47</version>
        </dependency>
        <!--mybatis的包：-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <!--spring整合mybatis的包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>


        <!--常见测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!--自动生成：getter/setter/constructor/allArgsConstructor等等-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.10</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <!--                sun local 3.6.3-->
                <version>3.8.0</version>
                <configuration>
                    <source>12</source>
                    <target>12</target>
                </configuration>
            </plugin>
        </plugins>
        <resources>
            <!--配置资源过滤-->
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <!--解决java目录下XML cannot be founded问题-->
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

</project>
```



# 常用beans.xml
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/aop
            http://www.springframework.org/schema/aop/spring-aop.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
        
<!--        指定要扫描的包的位置： 这个包下的注解 @Component @Service @Controller @Repository就会生效-->
        <context:component-scan base-package="com" /> 
        <context:annotation-config />
</beans> 
```

# 动态代理类
```java
public class ProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target, args);
        return null;
    }

}

```

```java
public class Client {

    public static void main(String[] args) {
        Host host = new Host();

        // 1. 每个 代理调用程序：可以动态返回代理类、动态代理方法
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        // 2. ProxyInvacationHandler 需要代理 1个对象
        proxyInvocationHandler.setTarget(host);

        // 3. 获取代理类
        Rent proxy = (Rent) proxyInvocationHandler.getProxy();

        // 4. 执行方法。 proxyInvocationHandler invoke 调用相应的方法
        proxy.rent();
    }
}

```