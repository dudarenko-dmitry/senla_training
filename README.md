TASK 1 (difficulty 2)
Write a program:
-Display a randomly generated three-digit natural number and its largest digit;

TASK 2 (difficulty 3)
Write a program:
-Containing flower hierarchies for a flower shop. Assemble a bouquet and determine its cost.


TASK 3 (difficulty 4)
Implement an object assembly line that implements the interfaces shown in the following diagram:

The task of an assembly line is to assemble complex products consisting of 3 parts.
A specialised class (implementing ILineStep) must be used to set up each part,
which supplies the required part via the buildProductPart() method.
To assemble a product, its blank is passed to the assembleProduct() method.
Inside this method, the line receives the 3 necessary components and
"sets" them into the corresponding methods of the resulting product.
Once the "assembly" is complete, the finished product is returned from the assembleProduct() method.

Variants of assembly lines:
- Cars (body, chassis, engine).


Task 4 (difficulty 6)
This assignment will be refined throughout the course.

Write a programme:
1. Electronic hotel administrator.
   The program should provide the ability to:
-Check into a room;
-Check out of the room;
-Change the status of the room to a room under repair/maintenance;
-Change the price of a room or service;
-Add a room or service.

A requirement for the task:
-DO NOT implement console user interface to the program. Verify that the program works from a test class with the main method;
-A class diagram must be created for the program;
-The program must comply with OOP principles and "Strong Binding" and "Weak Binding" patterns;
-Use System.out.println(message) to output the results;
-The .java source files must be injected into GIT in the appropriate branch.

-----------------------------------------------------------------------------

Tasks for lecture No. 4
Electronic hotel administrator.

Task 1 (difficulty 6)
The program should allow you to show:
1. List of rooms (sort by price, by capacity, by number of stars):
- readAllRoomsSortByPrice,
- readAllRoomsSortByCapacity,
- readAllRoomsSortByLevel;
2. List of available rooms (sort by price, by capacity, by number of stars):
- readAllFreeRoomsSortByPrice,
- readAllFreeRoomsSortByCapacity,
- readAllFreeRoomsSortByStatus;
3. List of guests and their rooms (sort alphabetically and by check-out date):
- readAllRoomReservationsSortByGuestName,
- readAllRoomReservationsSortByGuestCheckOut;
4. Total number of available rooms:
- countFreeRoomsOnTime;
5. Total number of guests:
- countNumberOfGuestsTotal;
- countNumberOfGuestsOnDate;
6. List of rooms that will be available on a certain date in the future:
- readAllRoomsFreeAtTime;
7. The amount of payment for the room to be paid by the guest:
- countGuestPaymentForRoom;
8. View the last 3 guests of the room and the dates of their stay:
- read3LastGuestAndDatesForRoom;
9. View the list of guest services and their price (sort by price, by date):
- readAllServicesSortByPrice,
- readAllServicesSortByDate;
10. Prices of services and rooms (sort by section(category), by price):
- readPriceListForServicesSortByCategory,
- readPriceListForServicesSortByPrice;
11. Show the details of a separate room:
    - readRoom.                     
    Task 2 (difficulty 2)
    Assemble the program written during the previous task into an executable Jar file.
    Assemble the catalog of the finished program and create .bat/.sh the file to run the program.

The program directory should have the following structure:
program_folder
|--- program.jar
|--- run.bat

Task Requirement:
The archive of the folder with the assembled program and the startup file should be embedded in GIT in the appropriate branch.

-----------------------------------------------------------------------------

Tasks for lecture No. 5
Electronic hotel administrator.

Task 1 (difficulty 10)
Add a user interface module (UI) to the program from the previous task. 
The module should contain a user console interface and allow you to fully perform all the functions 
included in the program. To refactor the entire program code to bring it into compliance with the principles of MVC. 
Example of console interface implementation:

Task Requirements:
The resulting output program must comply with the principles of OOP and the MVC template;
It is desirable to use the following design patterns in the UI module:
Singleton;
Abstract factory.
Use Enum for sets of constants;

Task 2 (difficulty 3)
Replace the use of arrays in the program from the previous homework with the Collection API. 
You can use the Stream API and lambda expressions.

-----------------------------------------------------------------------------

Tasks for lecture No. 6
Electronic hotel administrator.

Task 1 (difficulty 5)
Add to the program being developed the ability to import and export data of the selected entity
(you will need to add an ID for each entity).
The import must support updating records with the same ID and adding new ones.
In addition, the program should automatically establish links between objects.
The file format for import/export must be CSV.

The UI should be supplemented with new menu items that allow importing and exporting for each entity.

Task 2 (difficulty 2)
Add high-quality exception handling for possible errors in the application.
The program must adequately inform the user about the problems that have arisen.

-----------------------------------------------------------------------------

Tasks for lecture No. 7
Electronic hotel administrator.

Task 1 (difficulty 3)
Add the ability to configure the program from the previous task using the property file:
Electronic hotel administrator:
- Enabling/disabling the ability to change the status of a number;
- Number of guest records in the room history.

Task 2 (difficulty 5)
Implement program state preservation by serializing its objects to a file.
Restore the saved state at the start, and write the new state to a file at the end.

It implies the use of standard serialization mechanisms (Serializable or Externalizable),
but it is permissible to use other ones (for example, Jackson as a serializer in JSON).

-----------------------------------------------------------------------------

Tasks for lecture No. 8
Electronic hotel administrator.

Task 1 (difficulty 5)
Change the program configuration mechanism to configuration using annotations:
It is necessary to allocate a separate module that will perform automatic configuration of the program.
An object containing annotated configuration parameters must be submitted to the input.
The module must fill in these parameters with values from the configuration file in accordance with
the annotations.

The annotation that needs to be implemented for this should have the following form:
@ConfigProperty(configFileName, propertyName, type)
It can be placed over any field (elementary value, reference, array or collection)
and must ensure the correct configuration of the corresponding element.

All annotation attributes are optional (when using an annotation, you can either specify them or not).
By default сonfigFileName attribute should be the name of the default configuration file,
propertyName - have the form CLASS_NAME.FIELD_NAME,
type - convert the value of the configurable parameter to the current field type, or to String if the type is common;

Task 2 (difficulty 10)
Develop a set of annotations and a separate module for their processing:

The module should allow dependency injections (DI) in the program modules.
An object containing annotated fields should be submitted to the input,
and the module should implement dependencies in them.

To organize low coupling between modules of the application developed in previous tasks.
For implementation, it is necessary to use the Dependency injection pattern and the Reflection mechanism.
All application modules must be changed to this solution.

-----------------------------------------------------------------------------

Tasks for lecture No. 11

Task 1**.**
Create an ER database diagram, a set of DDL scripts for creating a structure and a set of DML scripts
that allow you to fill the database for your program from previous classes with test data.
To create a .bat file that allows you to quickly install the database and fill it with test data.

Task 2.
Prepare model entities from the program written during the previous lessons for storage in the database
(presence of id, correct connections).

Task 3.
Implement connection to the database created in step 1 in your application using jdbc.

Task 4.
Implement transaction support in the developed program. 
Add transactionality to application methods where necessary.

Task Requirements:
•	the application must comply with the principles of OOP;
•	the application must have a DAO level to work with the database;
•	using the GenericDAO design pattern;
•	the object of the class of obtaining a connection to the database, as well as the connection itself,
must be in a single instance;
•	the application must have high-quality exception handling;
•	compliance with the principle of high cohesion;
•	all literals must be in constants;
•	jdbc configuration via properties;
•	the main CRUD methods should be implemented through an object-oriented approach
(an object should come to the “input” to the method, at the “output” we get an object or a list of objects);


-----------------------------------------------------------------------------

Tasks for lecture No. 12

Task 1.
Transfer the main project to Maven. The project should have a modular structure.

Task 2.
Сonnect any logging library and configure logging in the project as a dependency (logback, log4j2)

Task 3.
Add a plugin to the project assembly that checks code style.
Configure it (including linking the plugin to the execution phase).
Recommendations for choosing a plugin: maven-checkstyle-plugin, checkstyle. 
(https://maven.apache.org/plugins/maven-checkstyle-plugin/usage.html)
