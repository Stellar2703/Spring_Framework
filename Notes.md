Spring Boot Notes
=================

Application layers
------------------
- Typical layers in a Spring application are:
  - Controller
  - Service
  - Repository
- Each layer is usually implemented as a separate class.
- The controller should call the service instead of containing business logic.
- The service layer handles the business logic.

IOC and DI
----------
- IOC means Inversion of Control.
- Dependency Injection is the concept used to achieve IOC.
- DI is a design pattern.

Types of dependency injection
-----------------------------
- Constructor injection
- Setter injection
- Field injection

Spring Boot
-----------
- In many cases, you do not need to create every object manually.
- In a normal Java application, you often need to configure many beans yourself.
- Spring Boot reduces this setup by handling most configuration automatically.
- Spring Boot applications usually run with an embedded Tomcat server.
- Instead of deploying a WAR file to an external server, you can create a runnable JAR.
- The main tradeoff is convention over configuration.
- If you want more control, plain Spring may be a better fit.

IOC container
-------------
- Spring has its own container inside the JVM called the IOC container.
- Spring creates and manages objects inside this container.
- Before creating beans, the container itself must exist.
- The container type is usually the ApplicationContext.

Using ApplicationContext
------------------------
- SpringApplication.run(MyappApplication.class, args) returns an ApplicationContext.
- You do not need to create a separate ApplicationContext object manually.

Example:

```java
ApplicationContext context = SpringApplication.run(MyappApplication.class, args);

Dev dev = context.getBean(Dev.class);
dev.build();
```

- If Dev is not registered as a bean, Spring throws:

```text
org.springframework.beans.factory.NoSuchBeanDefinitionException
No qualifying bean of type 'com.project.myapp.Dev' available
```

- This happens because Spring does not create the class automatically unless you tell it to.
- Use @Component to register a class as a Spring bean.

Autowiring
----------
- Suppose Dev depends on Laptop.
- Instead of creating Laptop manually, let Spring inject it.
- Annotate Laptop with @Component.
- Then use @Autowired in Dev to inject Laptop.

Field injection example:

```java
@Component
public class Dev {
    @Autowired
    private Laptop laptop;

    public void build() {
        laptop.compile();
        System.out.println("Building the project...");
    }
}
```

- With @Autowired on a field, this is field injection.
- By default, the field would be null without Spring injection.

Interfaces and multiple beans
------------------------------
- If you have an interface (e.g., Computer) implemented by multiple classes (e.g., Laptop, Desktop):
- You can inject using the interface type.
- Problem: If there are two beans of the same interface type, Spring cannot decide which one to use.
- Solution 1: Use @Primary to mark the default bean.
- Solution 2: Use @Qualifier("beanName") to specify which bean to inject.

Example:

```java
@Component
public class Dev {
    @Autowired
    @Qualifier("desktop")
    private Computer computer;
}
```

Default bean names
-------------------
- Spring creates bean names from class names by default.
- The first letter is lowercase.

| Class Name | Default Bean Name |
|-----------|------------------|
| Desktop   | desktop          |
| Laptop    | laptop           |
| Retro     | retro            |
| RETRO     | RETRO            |
| URLParser | URLParser        |
| XMLReader | XMLReader        |

Plain Spring (without Spring Boot)
-----------------------------------
- Plain Spring does not have @Component annotations by default.
- You must work directly with the container.
- You must create and configure the ApplicationContext manually.
- Add the Spring Context dependency from Maven Repository to your pom.xml.
- Create a spring.xml file to define beans manually.
- Use ClassPathXmlApplicationContext to load the XML configuration.

Example:

```java
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
```

spring.xml should define beans with their properties and references:

```xml
<beans>
    <bean id="desktop" class="com.project.myapp.Desktop" />
    <bean id="dev" class="com.project.myapp.Dev">
        <property name="computer" ref="desktop" />
    </bean>
</beans>
```

Spring Boot MVC
---------------
- Spring Boot includes built-in support for web applications using HTTP.
- Servlets handle HTTP requests and responses.
- Servlets run inside a web container.
- Tomcat is the traditional web container for running servlets.
- Spring Boot includes an embedded Tomcat server, so no separate installation is needed.
- Use @Controller or @RestController to create web endpoints.

Spring Boot Web
---------------
- Use the spring-boot-starter-web dependency from start.spring.io.
- Use spring-boot-devtools for faster development.
- @Controller is used when you return a view.
- @RestController is used when you return data directly.
- You can also use @Controller together with @ResponseBody on a method.
- Use @RequestMapping to define the path.

Front Controller
----------------
- Spring uses a front controller.
- If there are multiple controllers, it identifies the correct one and maps the request to it.

Lombok
------
- Lombok automatically generates boilerplate code.
- Add Lombok as a dependency in pom.xml.
- You can search for the artifact in Maven Repository.

Layering in web applications
----------------------------
- The controller only accepts requests and sends responses.
- Do not write business logic in the controller.
- Use the service layer for business logic.
- The model holds the data.
- Create separate packages for controller, service, model, and repository.

Annotations
-----------
- @Component and @Service are common Spring annotations.

HTTP methods
------------
- REST uses HTTP.
- GET fetches data.
- POST stores data.
- PUT updates data.
- DELETE removes data.

HTTP status codes
-----------------
- 100 series: informational
- 200 series: success
- 300 series: redirection
- 400 series: client error
- 500 series: server error
- 200 means success.
- 400 is a resource or request issue.
- 500 is a server issue.

Path variables
--------------
- @PathVariable is used to map a value from the request path to a method parameter.

Request mapping defaults
------------------------
- By default, request mapping methods are GET.
- Prefer @GetMapping and @PostMapping for clarity.
- Other requests include @PutMapping, @DeleteMapping, and @PatchMapping.

Collections
-----------
- Arrays.asList creates a fixed-size list.
- It is not a fully mutable list.

Request body
------------
- Use @RequestBody to match data from the client to the server.
- If the client sends data to the server through a method like POST, add @RequestBody to the function parameter.
- Use @PathVariable when the value comes from the URL path.
- Use @RequestBody when the value comes from a JSON request body.

Spring Data JPA
---------------
- The job of the repository layer is to connect with the database.
- Earlier JDBC (Java Database Connectivity) was a 7-step process handled in the repository layer.
- ORM means Object-Relational Mapping and is a shortcut for common CRUD operations.
- The object holds the data, and the ORM converts it into database queries.
- The user does not need to write SQL queries for every operation.
- ORM tools include Hibernate and EclipseLink.
- Most ORM tools implement the JPA standard.
- A connector or driver is needed to connect to the database.
- When using a driver, you should specify the database URL.
- Add the configuration in application.properties.

Example:

```properties
spring.datasource.url=jdbc:h2:mem:shash
spring.datasource.driverClassName=org.h2.Driver
```

- If you use the H2 database, add the H2 dependency in pom.xml.
- You can access the H2 console at http://localhost:8080/h2-console.
- The default username is sa and the password is empty.

Using JpaRepository
-------------------
- Create an interface and extend JpaRepository.
- Specify the entity class and the primary key type.
- Use @Repository to mark the interface as the repository layer.
- The JpaRepository parameters are the entity class and the primary key type.

