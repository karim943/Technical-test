# User Management project 

 
User Management project is a set of API exposed to manage users.

## To clone the project to your machine:

```bash
$ git clone https://github.com/karim943/Technical-test.git
```

## Requirements
To build/run the application you need:

* [JDK 8](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
* [Maven 3](https://maven.apache.org/index.html)

## To run the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the `Main` class from your IDE.

Alternatively you can use the Spring Boot Maven command :

```maven
mvn spring-boot:run
```
## API

| Method	     | Path            | Description          |
| :---         |     :---:       |          ---:        |
|    POST      |/api/users/create| create a new user    |
|    GET       | /api/users/{id} | retrieve a user by ID|

## Postman

In [POSTMAN](https://www.postman.com/) you click on Import button in the top left :

![Collection Postman Image 1](https://github.com/karim943/Technical-test/blob/6b71469688533c08bee6b74304a8682e84961506/Collection.bmp)

Click on Upload Files button, then select the User_Management.postman_collection.json file :

![Collection Postman Image 2](https://github.com/karim943/Technical-test/blob/6b71469688533c08bee6b74304a8682e84961506/HowToImportCollection.bmp)

Now User Management collection is added in the left pannel with the API :

![Collection Postman Image 3](https://github.com/karim943/Technical-test/blob/6b71469688533c08bee6b74304a8682e84961506/HowToImportCollection2.bmp)

## Swagger Documentation

After running the project you can access to the Swagger API in : 
[http://localhost:8082/swagger-ui.html#/]()
