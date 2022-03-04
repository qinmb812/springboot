# springboot
SpringBoot学习



# Bug1：*--2022.2.24*

Cannot resolve org.springframework.boot:spring-boot-starter-parent:2.5.1

Problems:Unresolved dependency:"org.springframework.boot:spring-boot-starter-parent:jar:2.5.1"

**解决方法：**在pom.xml文件中的<dependence>标签中的<artifactId>的内容写错了，不应该是spring-boot-starter-parent，而应该是spring-boot-starter-web。



# Bug2：*--2022.2.24*

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

SpringBoot中使用server.context-path=/boot02配置项目访问路径没有生效

**解决方法：**将配置文件中项目访问路径的配置server.context-path=/boot02修改为server.servlet.context-path=/boot02，即可生效。



# Bug4：*--2022.2.27*

```java
// 记录器
LoggerFactory.getLogger(getClass());
```

报错：

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

SpringBoot项目在访问resource下的static包下的js文件时，在浏览器的访问路径地址为：localhost:8080/asserts/js/Chart.min.js，这时一直报404错误。

**解决方法：**需要先 maven clean,然后重启项目即可。



# Bug6：*--2022.2.27*

SpringBoot项目在resources下的resources包下添加的favicon.ico，在Google Chrome浏览器中进行访问的时候，图标没有生效。

**解决方法：**换个浏览器就可以了，比如Firefox、Microsoft Edge。



# Bug7：*--2022.2.28*

Could not find artifact org.thymeleaf:thymeleaf-spring5:jar:3.0.2.RELEASE in aliyunmaven

Cannot resolve org.thymeleaf:thymeleaf-spring5:3.0.2.RELEASE

**解决方法：**在[仓库服务 (aliyun.com)](https://developer.aliyun.com/mvn/search)里面搜索thymeleaf-spring5，没有找到这个版本，修改版本就可以了。



# Bug8：*--2022.2.28*

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

SpringBoot项目启动后，直接访问静态资源文件一直出现出现404错误。

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

SpringBoot项目启动后，在浏览器中第一次进入首页或者被拦截后重定向到首页，会出现以下错误：

```html
样式表单 http://localhost:8080/crud/webjars/bootstrap/4.0.0/css/bootstrap.css 未载入，因为它的 MIME 类型 "text/html" 不是 "text/css"。
样式表单 http://localhost:8080/crud/asserts/css/signin.css 未载入，因为它的 MIME 类型 "text/html" 不是 "text/css"。
```

发现在只有在每次进入浏览器第一次的时候会出现上面这个问题，之后就不会出现这个问题了。



# Bug11：*--2022.3.2*

SpringBoot项目启动后，更新表数据 ，发送put请求不起作用，控制台每次都是走post请求。

**解决方法：**因为注解@ConditionalOnProperty限制了自动配置，默认false不开启配置，所以页面的put提交无法使用。需要在application.properties进行配置,才能使put请求生效。如下：

```properties
# 可以发送put请求的设置开启
spring.mvc.hiddenmethod.filter.enabled=true
```



# Bug12：*--2022.3.3*

SpringBoot中在有模板引擎的情况下，自定义错误响应页面，但是exception和message的值获取不到，时间戳timestamp和错误码status却可以获取到。

**解决方法：**主要原因是没有在配置文件里指定，server错误信息要包含异常对象和异常信息（SpringBoot2.0以上的版面需要在配置文件指定）。在properties文件里面加上这两句即可：

```java
#自定义异常处理页面，异常对象。异常信息
server.error.include-exception=true
server.error.include-message=always
```



# Bug13：*--2022.3.4*

SpringBoot2.x中找不到对应的EmbeddedServletContainerCustomizer类。

在SpringBoot2.x中EmbeddedServletContainerCustomizer类已经被替换成WebServerFactoryCustomizer类。

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

