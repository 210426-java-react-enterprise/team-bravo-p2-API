# team-bravo-p2-API
[Front End](https://github.com/210426-java-react-enterprise/team-bravo-p2-WebApp)


# StackExchange API

## Project Description

This project is a Spring based API used as a point of contact for the database and third party API to communicate withe the CollectExchange front-end.

## Technologies Used

* Spring Boot
* Spring Data
* JPA
* REST
* REST Templates
* JWT Authentication
* PostgreSQL
* AWS RDS

## Features

* Stores user and collection information via AWS RDS PostgreSQL database
* Contacts the omdb api in order to get information about movies for a users collection
* Authenticates users statelessly by making use of JWT technologies
* Takes and returns JSON to the front-end application

To-do list:
* Expand collection types beyond just movies
* Rewrite to include Spring Security library

## Application Configuration
   
CLONE: https://github.com/210426-java-react-enterprise/team-bravo-p2-API.git

Once cloned simply run the SQL table creation script provided in the ERD diagram folder in your DBMS of choice, then in the
resources folder edit the application.properties file to include the secret value of your choice and the application.yml
should be updated using your database credentials. 


