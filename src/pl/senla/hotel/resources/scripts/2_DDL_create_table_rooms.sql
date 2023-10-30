-- hotel.rooms definition
DROP TABLE hotel.rooms;

CREATE TABLE hotel.rooms (
  `facilityID` int AUTO_INCREMENT PRIMARY KEY,
  `category` enum('ROOM','TABLE','TRANSPORT') NOT NULL,
  `nameFacility` varchar(100) NOT NULL,
  `price` int NOT NULL,
  `capacity` int NOT NULL,
  `level` enum('ECONOM','STANDART','LUX') NOT NULL,
  `status` enum('AVAILABLE','REPAIRED') NOT NULL
);