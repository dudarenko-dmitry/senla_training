-- hotel.reservations definition

CREATE TABLE hotel.reservations (
  `serviceID` int AUTO_INCREMENT PRIMARY KEY,
  `orderID` int NOT NULL,
  `serviceType` enum('ROOM_RESERVATION','RESTAURANT','TRANSFER') NOT NULL,
  `guestID` int NOT NULL,
  `facilityID` int NOT NULL,
  `day` int NOT NULL,
  `checkIn` timestamp NOT NULL,
  `checkOut` timestamp NOT NULL,
  `cost` int DEFAULT NULL,
  KEY `guestID` (`guestID`),
  KEY `facilityID` (`facilityID`),
  KEY `orderID` (`orderID`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`guestID`) REFERENCES `guests` (`guestID`) ON DELETE CASCADE,
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`facilityID`) REFERENCES `rooms` (`facilityID`) ON DELETE CASCADE,
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE
);