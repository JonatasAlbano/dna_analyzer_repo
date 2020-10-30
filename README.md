## DNA Analyzer

This project features a REST API to distinguish simians from humans analyzing the DNA

## Running the project

-After importing the project, create a database in your MySQL. Example:
```bash
CREATE DATABASE dna_analyzer;
```

-After importing the project, change the <b>application.properties</b> file to connect to your MySQL database. Example:

![applicationPropExample](https://user-images.githubusercontent.com/13589045/97759159-37bb8f00-1adf-11eb-8fed-8eef5cc4de4f.png)

-Run the DnaAnalyzerApplication class in the <b>br.com.mercadolivre</b> package to start the REST API and create DNA table.

-Finally the API is ready to use

## Documentation

The documentation was built using Swagger. To access the complete documentation of models and endpoints just access:
```bash
http://base_url_application/swagger-ui.html
```
![docSwagger](https://user-images.githubusercontent.com/13589045/97759787-7aca3200-1ae0-11eb-82d9-35311c028af7.png)

## Tests

-To run the application tests, just go to DnaAnalyzerApplicationTests class in the <b>src/test/java</b> and run using JUnit

-Code Coverage:

![coverage](https://user-images.githubusercontent.com/13589045/97760176-4c008b80-1ae1-11eb-8e7e-d8420f6fbf82.png)

## Tecnologies

Spring Boot, Spring Data, Maven, JUnit, Lombok, MySQL, Swagger
