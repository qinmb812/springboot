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

