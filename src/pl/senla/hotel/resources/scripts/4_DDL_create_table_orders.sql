-- hotel.orders definition

DROP TABLE IF EXISTS hotel.orders;

CREATE TABLE IF NOT EXISTS hotel.orders (
	orderID INT AUTO_INCREMENT PRIMARY KEY,
	guestID INT NOT NULL,
	FOREIGN KEY (guestID) REFERENCES hotel.guests(guestID) ON DELETE CASCADE
);