#Application Requirements:
    Create a REST API for an online bookstore, where the user can perform the following operations:
    1- CRUD operations on Books
    2- Checkout operation for single or multiple books which will return the total payable amount.
#Points to consider:
    1- You can use either Spring boot or Quarkus
    2- Book object should have the following attributes:
        o Name
        o Description
        o Author
        o Type/Classification
        o Price
        o ISBN
    3- Checkout method will take list of books as parameters plus optional promotion code and return
       total price after discount (if applicable).
    4- Promotion/Discounts is variant according to book type/classification, ex: fiction books may have
       10% discount while comic books have 0% discount.
    5- You can use any persistence method for Books (i.e. in memory, database, etc.)
#Deliverable:
    1- Open API spec for your REST service.
    2- Unit tests for all operations
    3- Able to run it both locally (from terminal) and to run it on docker container.
#Setup And Build
    1- Import the project as a maven project.
    2- Clean and build the project through maven.
    3- Run the BookStoreApplication.java for starting the project.
    Now Project is up and running.
    
    Command line:
    mvn clean install (for clean install)
    mvn test (for running test)
#Technologies Used
    1- Spring Boot
    2- Swagger open api
    3- Lombok
    4- H2 in memory DB
    5- Spring data jpa
#URL for swagger open api
    http://localhost:8080/swagger-ui.html
#Sample URL & Requests for Testing
    PUT: http://localhost:8080/api/bookstore
    {
      "id": 0,
      "name": "string",
      "description": "string",
      "author": "string",
      "price": 0,
      "isbn": 0,
      "bookType": {
        "id": 0,
        "bookTypeEng": "string",
        "bookTypeAr": "string",
        "promotion": {
          "id": 0,
          "name": "string",
          "startDate": "2022-08-05T19:18:35.127Z",
          "endDate": "2022-08-05T19:18:35.127Z",
          "createdDate": "2022-08-05T19:18:35.127Z",
          "percentage": 0
        }
      }
    }

    POST: http://localhost:8080/api/bookstore
    {
      "id": 0,
      "name": "string",
      "description": "string",
      "author": "string",
      "price": 0,
      "isbn": 0,
      "bookType": {
        "id": 0,
        "bookTypeEng": "string",
        "bookTypeAr": "string",
        "promotion": {
          "id": 0,
          "name": "string",
          "startDate": "2022-08-05T18:57:14.794Z",
          "endDate": "2022-08-05T18:57:14.794Z",
          "createdDate": "2022-08-05T18:57:14.794Z",
          "percentage": 0
        }
      }
    }

    GET: http://localhost:8080/api/bookstore/all
    GET: http://localhost:8080/api/bookstore/{id}
    DELET: http://localhost:8080/api/bookstore/{id}
#Focused Area
    Modern Technologies
    Scalable Architecture and simple design
