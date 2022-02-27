# springboot
SpringBoot学习



# Bug1：*--2022.2.24*

Cannot resolve org.springframework.boot:spring-boot-starter-parent:2.5.1

Problems:Unresolved dependency:"org.springframework.boot:spring-boot-starter-parent:jar:2.5.1"

解决方法：在pom.xml文件中的<dependence>标签中的<artifactId>的内容写错了，不应该是spring-boot-starter-parent，而应该是spring-boot-starter-web。



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

解决方法：在解决Bug1的时候没有将之前引入的依赖删除，将这些依赖删除即可。



# Bug3：*--2022.2.26*

SpringBoot中使用server.context-path=/boot02配置项目访问路径没有生效

解决方法：将配置文件中项目访问路径的配置server.context-path=/boot02修改为server.servlet.context-path=/boot02，即可生效。



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

解决方法：写在方法外面会报错，将代码写全后错误会消失，写全代码即可。

```java
// 记录器
Logger logger = LoggerFactory.getLogger(getClass());
```



# Bug5：*--2022.2.27*

SpringBoot项目在访问resource下的static包下的js文件时，在浏览器的访问路径地址为：localhost:8080/asserts/js/Chart.min.js，这时一直报404错误。

解决方法：需要先 maven clean,然后重启项目即可。



# Bug6：*--2022.2.27*

SpringBoot项目在resources下的resources包下添加的favicon.ico，在Google Chrome浏览器中进行访问的时候，图标没有生效。

解决方法：换个浏览器就可以了，比如Firefox、Microsoft Edge。