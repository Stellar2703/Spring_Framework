We always have different Layers
There are layers like
Controller
Service 
Repository

All these are different classes

in order to use service in controller then i should create a object of service in controller

So you take care of only the business logic

IOC - Inversion of Control
Concept of Dependency Injection
so this does the IOC
so this di is a Design Pattern

Types of DI
constructor 
setter
field injection

Sprig Boot

in most of the time i dont need all the objects
so in the config fie i specify the objects that should be created
for java we need a tomcat server

now sring boot handles all the config.
So you can basically build an appiclation using the spring framework or use the module of sprin gboot from the framework to build the application of yours.

start.spring.io 
you create a war file to deploy and tomcat to run 
but spring boot says you can ccreate a jar file rather the project itself has an embedded tomcat

only downside is convention over configuration
if more control then some prefer spring directly.


dependency injection using spring 


spring has its own conatainer inside the jvm called th ioc container
spring creates the object inside the container
that means the firt thing that we   need before the object creation is the container itself

type of the contianer id Application context 


SpringApplication.run(MyappApplication.class, args); already extends the application context so it is not required to cretae another object rather return or poin this like 


ApplicationContext context =SpringApplication.run(MyappApplication.class, args);

		Dev dev = context.getBean(Dev.class);

		dev.build();

        but this returns an error of 

        Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.project.myapp.Dev' available
    
    because spring itself does not create the class rahter you should spcify the classes that you want the spring to create the object of it in the container using the annotations


    use the @Component



    Autowiring 

    Let us think that we need we already have a build glass and we now need a laptop class so that the build glass can access the laptop glass to do so some work So in my laptop class I have two methods namely compile and debug So if I want to use them in the dev class I should either create the object after laptop plus but I don't want this I want the spring boot to create a container of it so I mentioned the annotation of component in laptop class but in order to use it in dev class either I should use the Application context again to get the container of the spin or Ioc or else I can use another annotation called auto wire which helps me to link with me or the dev class with the laptop class


