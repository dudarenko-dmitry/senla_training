-- hotel.guests definition
DROP TABLE hotel.guests;

CREATE TABLE IF NOT EXISTS hotel.guests (
  `guestID` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) NOT NULL,
  `phone` int NOT NULL
);