## MongoDB Based Restful Service
### Introduction
This is a Restful Service which created using Spring boot and MongoDB as the backend Database

### Prerequisite
The project created using following sdk's and tools.
  - java version "1.8.0_74"
  - Java(TM) SE Runtime Environment (build 1.8.0_74-b02)
  - Apache Maven 3.3.9
  - Spring Boot 1.5.4.RELEASE
  - mongodb 3.2.3
  
### Configuration and building
First of all you need to setup the mongodb and up the server. After that Open the shell and navigata to database folder in the project.
 
 - cd $BASE_FOLDER/database

Then execute below command
   - mongoimport -d school -c student -o students.json
   
Now you have import the database into the mongodb
After that build the jar file and run it