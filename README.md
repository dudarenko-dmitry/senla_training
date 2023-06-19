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
- readAllOrdersSortByGuestName,
- readAllOrdersSortByGuestCheckOut;
4. Total number of available rooms:
- countRoomsFree;
5. Total number of guests:
- countNumberOfGuests;
6. List of rooms that will be available on a certain date in the future:
- readAllRoomsFreeForDate;
7. The amount of payment for the room to be paid by the guest:
- countTotalPaymentForGuest;
8. View the last 3 guests of the room and the dates of their stay:
- read3LastGuestAndDatesForRoom;
9. View the list of guest services and their price (sort by price, by date):
- readAllServicesAndPricesForGuestSortByPrice,
- readAllServicesAndPricesForGuestSortByDate;
10. Prices of services and rooms (sort by section(category), by price):
- showPriceListForServicesSortByCategory,
- showPriceListForServicesSortByPrice;
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
