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
