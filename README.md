# springboot
SpringBoot学习



# Bug1：*--2022.2.24*

**错误信息：**

Cannot resolve org.springframework.boot:spring-boot-starter-parent:2.5.1

Problems:Unresolved dependency:"org.springframework.boot:spring-boot-starter-parent:jar:2.5.1"

**解决方法：**在pom.xml文件中的<dependence>标签中的<artifactId>的内容写错了，不应该是spring-boot-starter-parent，而应该是spring-boot-starter-web。



# Bug2：*--2022.2.24*

**错误信息：**

```
2022-02-24 21:29:23.287 ERROR 14212 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

An attempt was made to call a method that does not exist. The attempt was made from the following location:

    org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer$CachingMetadataReaderFactoryPostProcessor.register(SharedMetadataReaderFactoryContextInitializer.java:104)

The following method did not exist:

    org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition(Ljava/lang/Class;Ljava/util/function/Supplier;)Lorg/springframework/beans/factory/support/BeanDefinitionBuilder;

The method's class, org.springframework.beans.factory.support.BeanDefinitionBuilder, is available from the following locations:

    jar:file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/springframework/spring-beans/5.3.8/spring-beans-5.3.8.jar!/org/springframework/beans/factory/support/BeanDefinitionBuilder.class

The class hierarchy was loaded from the following locations:

    org.springframework.beans.factory.support.BeanDefinitionBuilder: file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/springframework/spring-beans/5.3.8/spring-beans-5.3.8.jar


Action:

Correct the classpath of your application so that it contains a single, compatible version of org.springframework.beans.factory.support.BeanDefinitionBuilder
```

**解决方法：**在解决Bug1的时候没有将之前引入的依赖删除，将这些依赖删除即可。



# Bug3：*--2022.2.26*

**问题描述：**SpringBoot中使用server.context-path=/boot02配置项目访问路径没有生效

**解决方法：**将配置文件中项目访问路径的配置server.context-path=/boot02修改为server.servlet.context-path=/boot02，即可生效。



# Bug4：*--2022.2.27*

```java
// 记录器
LoggerFactory.getLogger(getClass());
```

**错误信息：**

```debug
	Cannot resolve symbol 'getLogger'
	Invalid method declaration; return type required
	'{' or ';' expected
	Unexpected token
```

**解决方法：**写在方法外面会报错，将代码写全后错误会消失，写全代码即可。

```java
// 记录器
Logger logger = LoggerFactory.getLogger(getClass());
```



# Bug5：*--2022.2.27*

**问题描述：**SpringBoot项目在访问resource下的static包下的js文件时，在浏览器的访问路径地址为：localhost:8080/asserts/js/Chart.min.js，这时一直报404错误。

**解决方法：**需要先 maven clean,然后重启项目即可。



# Bug6：*--2022.2.27*

**问题描述：**SpringBoot项目在resources下的resources包下添加的favicon.ico，在Google Chrome浏览器中进行访问的时候，图标没有生效。

**解决方法：**换个浏览器就可以了，比如Firefox、Microsoft Edge。



# Bug7：*--2022.2.28*

**错误信息：**

Could not find artifact org.thymeleaf:thymeleaf-spring5:jar:3.0.2.RELEASE in aliyunmaven

Cannot resolve org.thymeleaf:thymeleaf-spring5:3.0.2.RELEASE

**解决方法：**在[仓库服务 (aliyun.com)](https://developer.aliyun.com/mvn/search)里面搜索thymeleaf-spring5，没有找到这个版本，修改版本就可以了。



# Bug8：*--2022.2.28*

**错误信息：**

```java
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-02-28 14:56:29.435 ERROR 8644 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

An attempt was made to call a method that does not exist. The attempt was made from the following location:

    org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafDefaultConfiguration.templateEngine(ThymeleafAutoConfiguration.java:142)

The following method did not exist:

    org.thymeleaf.spring5.SpringTemplateEngine.setRenderHiddenMarkersBeforeCheckboxes(Z)V

The calling method's class, org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafDefaultConfiguration, was loaded from the following location:

    jar:file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/springframework/boot/spring-boot-autoconfigure/2.6.4/spring-boot-autoconfigure-2.6.4.jar!/org/springframework/boot/autoconfigure/thymeleaf/ThymeleafAutoConfiguration$ThymeleafDefaultConfiguration.class

The called method's class, org.thymeleaf.spring5.SpringTemplateEngine, is available from the following locations:

    jar:file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/thymeleaf/thymeleaf-spring5/3.0.9.RELEASE/thymeleaf-spring5-3.0.9.RELEASE.jar!/org/thymeleaf/spring5/SpringTemplateEngine.class

The called method's class hierarchy was loaded from the following locations:

    org.thymeleaf.spring5.SpringTemplateEngine: file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/thymeleaf/thymeleaf-spring5/3.0.9.RELEASE/thymeleaf-spring5-3.0.9.RELEASE.jar
    org.thymeleaf.TemplateEngine: file:/E:/JavaEE/maven/apache-maven-3.2.5/repository/org/thymeleaf/thymeleaf/3.0.9.RELEASE/thymeleaf-3.0.9.RELEASE.jar


Action:

Correct the classpath of your application so that it contains compatible versions of the classes org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafDefaultConfiguration and org.thymeleaf.spring5.SpringTemplateEngine


Process finished with exit code 1
```

**解决方法：**在pom.xml文件中的<properties>标签里配置了相关的属性，将下面的代码删除即可。

```xml
<thymeleaf.version>3.0.9.RELEASE</thymeleaf.version>
<thymeleaf-layout-dialect.version>2.2.2</thymeleaf-layout-dialect.version>
```



# Bug9：*--2022.2.28*

**问题描述：**SpringBoot项目启动后，直接访问静态资源文件一直出现出现404错误。

**解决方法：**在自己的配置类中，继承了WebMvcConfigurationSupport类。

```java
public class MyMvcConfig extends WebMvcConfigurerAdapter {
public class MyMvcConfig implements WebMvcConfigurer {
public class MyMvcConfig extends WebMvcConfigurationSupport {
```

只有在WebMvcConfigurationSupport这个类没有的情况下，才会走SpringBoot的Web自动配置。而在这里的时候，选择了继承了WebMvcConfigurationSupport类，所以代码自动配置失效了。可以选择其它的类，也可以选择添加代码。例如：

```java
registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/");
```



# Bug10：*--2022.3.1*

**问题描述：**SpringBoot项目启动后，在浏览器中第一次进入首页或者被拦截后重定向到首页，会出现以下错误：

```html
样式表单 http://localhost:8080/crud/webjars/bootstrap/4.0.0/css/bootstrap.css 未载入，因为它的 MIME 类型 "text/html" 不是 "text/css"。
样式表单 http://localhost:8080/crud/asserts/css/signin.css 未载入，因为它的 MIME 类型 "text/html" 不是 "text/css"。
```

发现在只有在每次进入浏览器第一次的时候会出现上面这个问题，之后就不会出现这个问题了。



# Bug11：*--2022.3.2*

**问题描述：**SpringBoot项目启动后，更新表数据 ，发送put请求不起作用，控制台每次都是走post请求。

**解决方法：**因为注解@ConditionalOnProperty限制了自动配置，默认false不开启配置，所以页面的put提交无法使用。需要在application.properties进行配置,才能使put请求生效。如下：

```properties
# 可以发送put请求的设置开启
spring.mvc.hiddenmethod.filter.enabled=true
```



# Bug12：*--2022.3.3*

**问题描述：**SpringBoot中在有模板引擎的情况下，自定义错误响应页面，但是exception和message的值获取不到，时间戳timestamp和错误码status却可以获取到。

**解决方法：**主要原因是没有在配置文件里指定，server错误信息要包含异常对象和异常信息（SpringBoot2.0以上的版面需要在配置文件指定）。在properties文件里面加上这两句即可：

```java
#自定义异常处理页面，异常对象。异常信息
server.error.include-exception=true
server.error.include-message=always
```



# Bug13：*--2022.3.4*

**问题描述：**SpringBoot2.x中找不到对应的EmbeddedServletContainerCustomizer类。

**解决方法：**在SpringBoot2.x中EmbeddedServletContainerCustomizer类已经被替换成WebServerFactoryCustomizer类。

```java
@FunctionalInterface
public interface WebServerFactoryCustomizer<T extends WebServerFactory> {
   /**
    * Customize the specified {@link WebServerFactory}.
    * @param factory the web server factory to customize
    */
   void customize(T factory);
}
```

使用如下：

```java
@Bean
public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryWebServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
}
```



# Bug14：*--2022.3.6*

**问题描述：**在CentOS 通过docker pull mysql下载mysql镜像并成功启动mysql容器。

当通过windows主机navicat连接虚拟的mysql时报如下错误。Client does not support authentication protocol requested by server; consider upgrading MySQL client.

**解决方法：**通过查看网上别人遇到的相关问题，发现是由于navicat版本的问题，出现连接失败的原因：mysql8 之前的版本中加密规则是mysql_native_password,而在mysql8之后,加密规则是caching_sha2_password。把用户密码登录的加密规则还原成mysql_native_password这种加密方式。

**解决步骤：**

（1） 在CentOS虚拟机中输入命令：**docker exec -it mysql bash** 登录mysql；

（2） 然后输入命令：**mysql -uroot -p**和密码进入MySQL的命令行模式；

（3） 输入相关命令修改相关机密方法。如下：

```shell
mysql> alter user 'root'@'%' identified by '123456' password expire never;
Query OK, 0 rows affected (0.06 sec)

mysql>  alter user 'root'@'%' identified with mysql_native_password by '123456';
Query OK, 0 rows affected (0.03 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.03 sec)
```

（4） 再次连接就可以了。



# Bug15：*--2022.3.6*

**问题描述：**SpringBoot运行schema脚本，一直报错。

**错误信息：**

```java
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-03-06 16:23:11.786 ERROR 5504 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'scriptDataSourceInitializer' defined in class path resource [org/springframework/boot/autoconfigure/jdbc/DataSourceInitializationConfiguration$SharedCredentialsDataSourceInitializationConfiguration.class]: Invocation of init method failed; nested exception is java.lang.IllegalStateException: No schema scripts found at location 'classpath:department.sql'
```

**解决方法：**点击IDEA上面Maven上面的**Reload All  Maven Projects**。重新加载项目，再启动就可以了。



# Bug16：*--2022.3.6*

**问题描述：**使用了Druid连接池之后出现下述错误。

**错误信息：**

```java
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-03-06 19:49:12.490 ERROR 14828 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'spring.datasource' to javax.sql.DataSource:

    Property: spring.datasource.filters
    Value: stat,wall,log4j
    Origin: class path resource [application.yml] - 21:14
    Reason: java.lang.ClassNotFoundException: org.apache.log4j.Priority

Action:

Update your application's configuration

2022-03-06 19:49:12.499 ERROR 14828 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@1bc72d1] to prepare test instance [com.at.springboot.Springboot06DataJdbcApplicationTests@1ea78b1]

java.lang.IllegalStateException: Failed to load ApplicationContext

Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'helloController': Unsatisfied dependency expressed through field 'jdbcTemplate'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Unsatisfied dependency expressed through method 'dataSourceScriptDatabaseInitializer' parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Unsatisfied dependency expressed through method 'dataSourceScriptDatabaseInitializer' parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: java.lang.NoClassDefFoundError: org/apache/log4j/Priority

Caused by: java.lang.ClassNotFoundException: org.apache.log4j.Priority

java.lang.IllegalStateException: Failed to load ApplicationContext

Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'helloController': Unsatisfied dependency expressed through field 'jdbcTemplate'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Unsatisfied dependency expressed through method 'dataSourceScriptDatabaseInitializer' parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Unsatisfied dependency expressed through method 'dataSourceScriptDatabaseInitializer' parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: java.lang.IllegalStateException: Unable to set value for property filters

Caused by: java.lang.reflect.InvocationTargetException

Caused by: java.lang.NoClassDefFoundError: org/apache/log4j/Priority
```

**解决方法：**发现在对应的Controller类中使用了@Autowired注解注入了JDBCTemplate类，将@Autowired注解去掉即可。【这个可能不需要使用，或许可以直接执行Bug17的解决方法】



# Bug17：*--2022.3.6*

**问题描述：**在解决了Bug16之后，出现下述问题。

**错误信息：**

```java
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-03-06 19:35:07.971 ERROR 9512 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'spring.datasource' to javax.sql.DataSource:

    Property: spring.datasource.filters
    Value: stat,wall,log4j
    Origin: class path resource [application.yml] - 21:14
    Reason: java.lang.ClassNotFoundException: org.apache.log4j.Priority

Action:

Update your application's configuration

2022-03-06 19:35:07.980 ERROR 9512 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@1bc72d1] to prepare test instance [com.at.springboot.Springboot06DataJdbcApplicationTests@1d0fc89]

java.lang.IllegalStateException: Failed to load ApplicationContext

Caused by: org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: java.lang.reflect.InvocationTargetException: null

Caused by: java.lang.NoClassDefFoundError: org/apache/log4j/Priority

java.lang.IllegalStateException: Failed to load ApplicationContext

Caused by: org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'druid': Could not bind properties to 'DataSource' : prefix=spring.datasource, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'spring.datasource' to javax.sql.DataSource

Caused by: java.lang.reflect.InvocationTargetException
```

**解决方法：**在yml文件中配置了日志：**filters: stat,wall,log4j**，而在pom.xml文件中没有引入log4j的相关依赖。在pom.xml文件中引入相关的依赖即可，如下：

```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```



# Bug18：*--2022.3.17*

**问题描述：**在使用Git提交代码到Github仓库的时候，出现下面问题。

**错误信息：**

```shell
asus@DESKTOP-UC0L2O3 MINGW64 /d/workspace/springboot_learning (main)
$ git pull origin main
kex_exchange_identification: read: Connection reset by peer
Connection reset by 52.74.223.119 port 22
fatal: Could not read from remote repository.

Please make sure you have the correct access rights
and the repository exists.
```

**解决方法：**在window防火墙设置22端口1。

1. window10安全中心 --> 防火墙和网络保护 --> 高级设置；
2. 入站规则 --> 新建规则；
3. 选择端口，点击下一步；
4. 端口输入22，点击下一步；
5. 选择允许连接，点击下一步；
6. 点击下一步；
7. 添加名称和描述（随意填写），点击完成。

在配置完成之后，再继续使用 git pull 和 git push 命令即可。

【或许可以直接先进行git clone命令】



# Bug19：*--2022.3.22*

**问题描述：**在使用虚拟机中使用docker安装redis，安装registry.docker-cn.com/library/redis，出现下面问题。

**错误信息：**

```shell
[root@192 ~]# docker pull registry.docker-cn.com/library/redis
Using default tag: latest
Trying to pull repository registry.docker-cn.com/library/redis ... 
Get https://registry.docker-cn.com/v1/_ping: dial tcp 106.14.52.175:443: i/o timeout
```

**解决方法：**安装docker中国的redis失败，直接安装redis即可。



# Bug20：*--2022.3.23*

**问题描述：**在使用虚拟机中使用docker安装redis，出现下面问题。

**错误信息：**

```shell
[root@192 ~]# docker pull redis
Using default tag: latest
Trying to pull repository docker.io/library/redis ... 
repository docker.io/redis not found: does not exist or no pull access
```

**解决方法：**导致此问题产生，主要是因为国家把docker国外镜像hub封掉了，导致镜像pull不下来，为此，改用国内的镜像。操作如下：

```shell
[root@192 ~]# vi /etc/docker/daemon.json
[root@192 ~]# cat /etc/docker/daemon.json
{
  "registry-mirrors": [
    "https://docker.mirrors.ustc.edu.cn/",
    "https://hub-mirror.c.163.com",
    "https://registry.docker-cn.com"
  ],
  "insecure-registries": ["10.0.0.12:5000"]
}
[root@192 ~]# systemctl restart docker
[root@192 ~]# docker pull redis
Using default tag: latest
Trying to pull repository docker.io/library/redis ... 
latest: Pulling from docker.io/library/redis
ae13dd578326: Pull complete 
e6f25d21ebb3: Pull complete 
601cc6106ba1: Pull complete 
5b8be2fd806e: Pull complete 
950c3791111a: Pull complete 
567b7ad78092: Pull complete 
Digest: sha256:81b50efa808d72f7965d4deecea18e42cab2fec25fafca447eb4bda615b9c8e4
Status: Downloaded newer image for docker.io/redis:latest
[root@192 ~]# docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
docker.io/redis     latest              87c26977fd90        5 days ago          113 MB
```

这样就可以正常拉取redis镜像了。



# Bug21：*--2022.3.25*

**问题描述：**在SpringBoot2.x中，自定义CacheManager，运行程序之后，发送相关的请求，然后就出现下面相关的信息。

**错误信息：**

```java
2022-03-25 21:04:32.901 DEBUG 10012 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Failed to complete request: org.springframework.data.redis.serializer.SerializationException: Could not read JSON: Unexpected character ('¬' (code 172)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"��\u0000\u0005sr\u0000\u001Acom.at.cache.bean.Employeeq�\u0013\u000E����\u0002\u0000\u0005L\u0000\u0003dIdt\u0000\u0013Ljava/lang/Integer;L\u0000\u0005emailt\u0000\u0012Ljava/lang/String;L\u0000\u0006genderq\u0000~\u0000\u0001L\u0000\u0002idq\u0000~\u0000\u0001L\u0000\u0008lastNameq\u0000~\u0000\u0002xppt\u0000\u000Fzhangsan@at.comsr\u0000\u0011java.lang.Integer\u0012⠤���8\u0002\u0000\u0001I\u0000\u0005valuexr\u0000\u0010java.lang.Number���\u001D\u000B���\u0002\u0000\u0000xp\u0000\u0000\u0000\u0000sq\u0000~\u0000\u0005\u0000\u0000\u0000\u0001t\u0000\u0006张三"; line: 1, column: 2]; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character ('¬' (code 172)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"��\u0000\u0005sr\u0000\u001Acom.at.cache.bean.Employeeq�\u0013\u000E����\u0002\u0000\u0005L\u0000\u0003dIdt\u0000\u0013Ljava/lang/Integer;L\u0000\u0005emailt\u0000\u0012Ljava/lang/String;L\u0000\u0006genderq\u0000~\u0000\u0001L\u0000\u0002idq\u0000~\u0000\u0001L\u0000\u0008lastNameq\u0000~\u0000\u0002xppt\u0000\u000Fzhangsan@at.comsr\u0000\u0011java.lang.Integer\u0012⠤���8\u0002\u0000\u0001I\u0000\u0005valuexr\u0000\u0010java.lang.Number���\u001D\u000B���\u0002\u0000\u0000xp\u0000\u0000\u0000\u0000sq\u0000~\u0000\u0005\u0000\u0000\u0000\u0001t\u0000\u0006张三"; line: 1, column: 2]
2022-03-25 21:04:32.907 ERROR 10012 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.data.redis.serializer.SerializationException: Could not read JSON: Unexpected character ('¬' (code 172)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"��\u0000\u0005sr\u0000\u001Acom.at.cache.bean.Employeeq�\u0013\u000E����\u0002\u0000\u0005L\u0000\u0003dIdt\u0000\u0013Ljava/lang/Integer;L\u0000\u0005emailt\u0000\u0012Ljava/lang/String;L\u0000\u0006genderq\u0000~\u0000\u0001L\u0000\u0002idq\u0000~\u0000\u0001L\u0000\u0008lastNameq\u0000~\u0000\u0002xppt\u0000\u000Fzhangsan@at.comsr\u0000\u0011java.lang.Integer\u0012⠤���8\u0002\u0000\u0001I\u0000\u0005valuexr\u0000\u0010java.lang.Number���\u001D\u000B���\u0002\u0000\u0000xp\u0000\u0000\u0000\u0000sq\u0000~\u0000\u0005\u0000\u0000\u0000\u0001t\u0000\u0006张三"; line: 1, column: 2]; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character ('¬' (code 172)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"��\u0000\u0005sr\u0000\u001Acom.at.cache.bean.Employeeq�\u0013\u000E����\u0002\u0000\u0005L\u0000\u0003dIdt\u0000\u0013Ljava/lang/Integer;L\u0000\u0005emailt\u0000\u0012Ljava/lang/String;L\u0000\u0006genderq\u0000~\u0000\u0001L\u0000\u0002idq\u0000~\u0000\u0001L\u0000\u0008lastNameq\u0000~\u0000\u0002xppt\u0000\u000Fzhangsan@at.comsr\u0000\u0011java.lang.Integer\u0012⠤���8\u0002\u0000\u0001I\u0000\u0005valuexr\u0000\u0010java.lang.Number���\u001D\u000B���\u0002\u0000\u0000xp\u0000\u0000\u0000\u0000sq\u0000~\u0000\u0005\u0000\u0000\u0000\u0001t\u0000\u0006张三"; line: 1, column: 2]] with root cause

com.fasterxml.jackson.core.JsonParseException: Unexpected character ('¬' (code 172)): expected a valid value (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
 at [Source: (byte[])"��\u0000\u0005sr\u0000\u001Acom.at.cache.bean.Employeeq�\u0013\u000E����\u0002\u0000\u0005L\u0000\u0003dIdt\u0000\u0013Ljava/lang/Integer;L\u0000\u0005emailt\u0000\u0012Ljava/lang/String;L\u0000\u0006genderq\u0000~\u0000\u0001L\u0000\u0002idq\u0000~\u0000\u0001L\u0000\u0008lastNameq\u0000~\u0000\u0002xppt\u0000\u000Fzhangsan@at.comsr\u0000\u0011java.lang.Integer\u0012⠤���8\u0002\u0000\u0001I\u0000\u0005valuexr\u0000\u0010java.lang.Number���\u001D\u000B���\u0002\u0000\u0000xp\u0000\u0000\u0000\u0000sq\u0000~\u0000\u0005\u0000\u0000\u0000\u0001t\u0000\u0006张三"; line: 1, column: 2]

2022-03-25 21:04:32.914 DEBUG 10012 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : "ERROR" dispatch for GET "/error", parameters={}
2022-03-25 21:04:32.915 DEBUG 10012 --- [nio-8080-exec-1] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)
2022-03-25 21:04:32.944 DEBUG 10012 --- [nio-8080-exec-1] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, text/html;q=0.8]
2022-03-25 21:04:32.949 DEBUG 10012 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Exiting from "ERROR" dispatch, status 500
```

**解决方法：**一般修改CacheManager之后会出现这个问题。只要删除redis保存的数据（或者直接简单粗暴清空redis）即可。



# Bug22：*--2022.3.29*

**问题描述：**在SpringBoot项目中，在配置文件application.properties中配置属性spring.elasticsearch.jest.uris的值时报错提示Deprecated configuration property 'spring.elasticsearch.jest.uris'。

**解决方法：**发现我的SpringBoot的版本有点高，为2.6.5，将SpringBoot的版本修改为1.5.9.RELEASE即可。



# Bug23：*--2022.3.30*

**问题描述：**在SpringBoot项目的测试类中，有@Test注解的测试方法不能运行，直接执行类时报错。

**错误信息：**这是未将测试类的修饰符从default变为public时的运行结果错误信息：

```java
java.lang.Exception: The class com.at.elastic.Springboot11ElasticApplicationTests is not public.
java.lang.Exception: Test class should have exactly one public constructor
```

这是未将测试方法的修饰符从default变为public时的运行结果错误信息：

```java
java.lang.Exception: Method contextLoads() should be public
```

**解决方法：**发现在SpringBoot的版本修改为1.5.9.RELEASE时，测试类的修饰符应该从default变为public，测试方法也应该加上public修饰符。



# Bug24：*--2022.3.30*

**问题描述：**在SpringBoot项目中，整合SpringBoot Data Elasticsearch时，配置好了相应的属性，运行程序出现了错误。

**错误信息：**

```java
2022-03-30 19:39:49.916  INFO 8356 --- [           main] org.elasticsearch.client.transport       : [Daredevil] failed to connect to node [{#transport#-1}{192.168.2.6}{192.168.2.6:9300}], removed from nodes list
org.elasticsearch.transport.ConnectTransportException: [][192.168.2.6:9300] connect_timeout[30s]
Caused by: java.net.ConnectException: Connection refused: no further information: /192.168.2.6:9300
```

**解决方法：**发现在虚拟机中的elasticsearch的版本是5.6.12，而SpringBoot对应的版本是2.4.6，这两个版本不匹配。可以升级SpringBoot版本或者安装对应版本的ES。这里是安装对应版本的ES，操作如下：

```shell
[root@192 ~]# docker images
REPOSITORY                TAG                 IMAGE ID            CREATED             SIZE
docker.io/rabbitmq        3.9.14-management   decffaa4e8b0        7 days ago          257 MB
docker.io/redis           latest              87c26977fd90        12 days ago         113 MB
docker.io/mysql           latest              c1558761f285        3 weeks ago         519 MB
docker.io/tomcat          latest              7a287e4562ea        4 weeks ago         680 MB
docker.io/elasticsearch   latest              5acf0e8da90b        3 years ago         486 MB
[root@192 ~]# docker pull elasticsearch:2.4.6
Trying to pull repository docker.io/library/elasticsearch ... 
2.4.6: Pulling from docker.io/library/elasticsearch
05d1a5232b46: Already exists 
5cee356eda6b: Already exists 
89d3385f0fd3: Already exists 
65dd87f6620b: Already exists 
78a183a01190: Already exists 
1a4499c85f97: Already exists 
2c9d39b4bfc1: Already exists 
1b1cec2222c9: Already exists 
59ff4ce9df68: Already exists 
1976bc3ee432: Already exists 
a27899b7a5b5: Pull complete 
b0fc7d2c927a: Pull complete 
6d94b96bbcd0: Pull complete 
6f5bf40725fd: Pull complete 
2bf2a528ae9a: Pull complete 
Digest: sha256:41ed3a1a16b63de740767944d5405843db00e55058626c22838f23b413aa4a39
Status: Downloaded newer image for docker.io/elasticsearch:2.4.6
[root@192 ~]# docker images
REPOSITORY                TAG                 IMAGE ID            CREATED             SIZE
docker.io/rabbitmq        3.9.14-management   decffaa4e8b0        7 days ago          257 MB
docker.io/redis           latest              87c26977fd90        12 days ago         113 MB
docker.io/mysql           latest              c1558761f285        3 weeks ago         519 MB
docker.io/tomcat          latest              7a287e4562ea        4 weeks ago         680 MB
docker.io/elasticsearch   latest              5acf0e8da90b        3 years ago         486 MB
docker.io/elasticsearch   2.4.6               5e9d896dc62c        3 years ago         479 MB
[root@192 ~]# docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9201:9200 -p 9301:9300 --name ES0
2 5e9d896dc62c
6aa0a08babb94c53d5037795d9715772af82e9b628ed3f3ed6b88428ad1ebd10
[root@192 ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS         
     PORTS                                            NAMES
6aa0a08babb9        5e9d896dc62c        "/docker-entrypoin..."   8 seconds ago       Up 7 seconds   
     0.0.0.0:9201->9200/tcp, 0.0.0.0:9301->9300/tcp   ES02
4b85689ef42c        5acf0e8da90b        "/docker-entrypoin..."   26 hours ago        Up 12 hours    
     0.0.0.0:9200->9200/tcp, 0.0.0.0:9300->9300/tcp   ES01
[root@192 ~]# 
```



# Bug25：*--2022.3.31*

**问题描述：**在SpringBoot项目整合Spring Security时，自定义认证规则，代码如下：

```java
 @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.inMemoryAuthentication().
                withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password("123456").roles("VIP1", "VIP3");
    }
```

**错误信息：**运行程序之后，点击需要权限的内容，进入登录页面，输入用户名和密码之后，出现下面错误：

```java
2022-03-31 21:41:07.705 ERROR 11680 --- [nio-8080-exec-6] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
```

**解决方法：**Spring Security 5.0中新增了多种加密方式，也改变了默认的密码格式。通过阅读官方文档，发现现如今Spring Security中密码的存储格式是“{id}…………”。前面的id是加密方式，id可以是BCrypt、sha256等，后面跟着的是加密后的密码。也就是说，程序拿到传过来的密码的时候，会首先查找被“{”和“}”包括起来的id，来确定后面的密码是被怎么样加密的，如果找不到就认为id是null。官方文档举的例子中是各种加密方式针对同一密码加密后的存储形式，原始密码都是“password”。需要修改一下configure中的代码，我们要将前端传过来的密码进行某种方式加密，Spring Security 官方推荐的是使用BCrypt加密方式。

（1） 在内存中存取密码的修改方式

修改之后如下：

```java
@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP3");
    }
```

“inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())”，这相当于登陆时用BCrypt加密方式对用户密码进行处理。以前的“.password("123456")”变成了 “.password(new BCryptPasswordEncoder().encode("123"))”，这相当于对内存中的密码进行BCrypt编码加密。如果比对时一致，说明密码正确，才允许登陆。

（2） 在数据库中存取密码的修改方式

如果你用的是在数据库中存储用户名和密码，那么一般是要在用户注册时就使用BCrypt编码将用户密码加密处理后存储在数据库中，并且修改configure()方法，加入“.passwordEncoder(new BCryptPasswordEncoder())”，保证用户登录时使用BCrypt对密码进行处理再与数据库中的密码比对。如下：

```java
//注入userDetailsService的实现类
auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
```



# Bug26：*--2022.4.1*

**问题描述：**在SpringBoot项目整合Spring Security时，在HTML页面使用SpringSecurity5时，添加xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5"后，提示URI is not registered (Settings | Languages & Frameworks | Schemas and DTDs)，并且使用sec的标签没反应。

**解决方法：**命名空间写错了，应该改为xmlns:sec="http://www.thymeleaf.org/extras/spring-security"就可以了。

