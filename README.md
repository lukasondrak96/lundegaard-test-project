# lundegaard-test-project

Lundegaard test project is simple test web application with only one form written in Java Spring (BE) and Angular (FE). 
The project was not fully completed due to time constraints. Also no tests were added unfornatelly due this constraint. 
This app could be also used as basic template for creating Java Spring and Angular applications as two separate modules in one project.
It uses Postgresql as database system because it is easy and free. In project structure takes place file import.sql which is init file for database initialization.

This application was developed for Lundegaard company as task for testing my Java skills.

Author: Lukáš Ondrák, 2021

## Usage
To run this maven project, use JDK8 or higher. You will also need maven installed, node and Angular CLI will be installed automatically.
Clone project and in main project folder use maven command. It will take up to few minutes.
```
    [maven clean package]
```
Unless there's an error while cleaning and creating JAR file, use following commands to run whole app (it will run on localhost:8080).

```
    [cd backend/target]
    [java -jar backend-0.1-SNAPSHOT.jar]
```

If any problem occurs while building or running app, let me know and I will try to help (lukas.ondrak96@seznam.cz).
