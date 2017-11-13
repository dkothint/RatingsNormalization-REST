# RatingsNormalization-REST
This is a simple web application with RESTful web services to query the results of the ratings normalization application. 

Technologies Used:
1. This is a spring boot application exposing a couple of web services to extract the results.
2. Hibernate is the ORM solution used.
3. Postgres is the DB queried.
4. Maven is the project build management tool employed.

Server:
The application was tested by deploying locally on Apache Tomcat v8.0 server. 

Services:
http://localhost:8080/RatingsNormalization/business/affectedbusinesses: Returns all the businesses whose average rating is lesser than the normalized rating calculated by the application. 

http://localhost:8080/RatingsNormalization/business/business1: Returns the business object with the name 'business1'. 

Structure of the Business object:
  {
        "id": 1,
        "businessId": "someId",
        "businessName": "Business name",
        "businessRating": 4.5,
        "normalizedRating": 4.63888884
    }
