# Curricula Tracker
Link to the front end repository: https://github.com/revature-curricula-tracker/curricula-tracker-frontend

# Description
Curricula Tracker is an application that will track information related to cohorts. Curricula Tracker manages and tracks the various curricula that is offered by the user of the software.

# Entity Relationship Diagram:
[<img src="https://i.imgur.com/18ejP3q.jpg">](https://drawsql.app/p3-backend/diagrams/p3-backend/)

# Technologies Used

* Spring Web
* Spring Cloud Sleuth
* Spring Data JPA
* JUnit
* H2 Database
* Postgres
* Grafana
* Zipkin
* JaCoCo
* Micrometer + Prometheus
* AWS CodePipeline
* AWS S3 Bucket
* Docker
* Angular

# Features

The Curricula Tracker backend allows the user to create, read, update, and delete any Curriculum, Topic, or Technology objects in the database.  Please find the details of all methods available at the API endpoints in the usage section below.

# Getting Started

After pulling the source code, simply execute the docker-compose.yml to run Zipkin, Prometheus, Grafana, and the Curricula-Tracker-Backend SpringBoot app in separate containers:
Container 1: Grafana on port 3000
Container 2: Prometheus on port 9090
Container 3: Zipkin on port 9411
Container 4: Curricula-tracker-backend Spring Boot App on port 5000

# Usage

* All curriculum endpoints are available at /curriculum/...
  - POST /add : insert a curricula by sending a curriculum object in the body of a post request
  - GET / : finds all curricula and returns a list
  - GET /findId/{id} : finds a specific curricula by its id number in the path variable
  - GET /findName/{name} : finds a specific curricula by name as a path variable
  - POST /update : updates a curricula object from a post request body
  - DELETE /deleteById/{id} : deletes a curricula by its id as a path variable
* All topic endpoints are available at /topics/...
  - POST /add : inserts a topic by taking an object in the body of a post request
  - GET / : finds all topics returned as a list
  - GET /{id} : finds a specific topic by its id as a path variable
  - GET /search/{name} : finds a topic by name as a path variable
  - PUT /{id} : updates a topic by taking its id as a path variable and topic object in the body of a put request
  - PUT /byname/{name} : updates a topic by taking its name as a path variable and topic object in the body of a put request
  - DELETE /{id} : delete a topic by id by sending a delete request with id as a path variable
  - DELETE /byname/{name} : delete a topic by name by sending a delete request with name as a path variable
* All technology endpoints are available at /tech/...
  - POST /add : inserts a technology object from the body of a post request
  - GET / : finds all technologies returned as a list
  - GET /{id} : finds a specific technology by its id in a path variable
  - GET /search/{name} : finds a technology by taking its name as a path variable
  - PATCH /{id} : update a technology by sending a patch request with id in the path and object the body
  - DELETE /{id} : delete a technology by sending a delete request with the id as a path variable

# Contributors
Teams were divided into threes to pilot construction of the three major entities used in this sprint.

* Curriculum team
  1. Ryan McOmber (Overall lead, Curriculum team lead)
  2. Joshua Liguid 
  3. Jochen Pendleton
* Topic team
  1. Ty Johnson (Topic team lead)
  2. Michael Weatherby
  3. Matthew Erikson
* Technology team
  1. Nathan Lee (Technology team lead)
  2. Noah Gaston
  3. Jasper Sommer
