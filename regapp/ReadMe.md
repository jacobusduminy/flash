# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.3/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.3/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

## The following Documentation is to run and deploy the RegApp

### Prep
Make sure to execute the Docker compose file for running this in your local
This will create the database with its schema, tables and user with correct credentials for the application

You will be using Postman to test the Application.
Please import the following json file that is located in the application directory(`regapp/documentation`)
File: New Regapp.postman_collection.json

### The following endpoints:

#### `/regapp/api/controller/save`
This will create the user please just add your details in the json body

#### `/regapp/api/controller/star`
This will star out the certain matching words and return the message with the stars

#### `/regapp/api/controller/passwordrest`
This is used to reset your password, But you will need to have the password reset code to execute this process

#### `/regapp/api/controller/user?email=@gmail.com`
This will return the user by using the email

#### `/regapp/api/controller/login?email=@gmail.com&password=1234`
This will confirm if you are a valid user.

## Local Docker deployment

# Running Compose
Make sure to run all services to create both the Database and Application