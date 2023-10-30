-- hotel.reservations definition
DROP TABLE IF EXISTS hotel.reservations;

CREATE TABLE IF NOT EXISTS hotel.reservations (
  `serviceID` int AUTO_INCREMENT PRIMARY KEY,
  `orderID` int NOT NULL,
  `serviceType` enum('ROOM_RESERVATION','RESTAURANT','TRANSFER') NOT NULL,
  `guestID` int NOT NULL,
  `facilityID` int NOT NULL,
  `day` int NOT NULL,
  `checkIn` timestamp NOT NULL,
  `checkOut` timestamp NOT NULL,
  `cost` int NOT NULL,
  FOREIGN KEY (`guestID`) REFERENCES `guests` (`guestID`) ON DELETE CASCADE,
  FOREIGN KEY (`facilityID`) REFERENCES `rooms` (`facilityID`) ON DELETE CASCADE,
  FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE
);