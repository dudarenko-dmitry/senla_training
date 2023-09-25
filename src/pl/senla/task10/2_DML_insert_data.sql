insert into product  
	(maker, model, `type`)
	values
		('Apple',   'Apple McBook A2', 'Laptop'),
		('Apple',   'Apple McBook A1', 'Laptop'),
		('Lenovo',  'Lenovo M5',       'Laptop'),
		('Lenovo',  'Lenovo M7',       'Laptop'),
		('Lenovo',  'Lenovo M11',      'Laptop'),
		('Samsung', 'Samsung S300',    'Laptop'),
		('Samsung', 'Samsung S200',    'Laptop'),
		('Samsung', 'Samsung S500',    'Laptop'),
		('HP',      'HP ENVY',	       'Laptop'),
		('HP',      'HP Pavilion',     'Laptop'),
		('HP',      'HP Pavilion PLUS','Laptop'),
		('Asus',    'ASUS A3000',      'Laptop'),
		('Apple',   'Apple1',    'PC'),
		('Apple',   'Apple2',    'PC'),
		('HP',	    'HP1',   	 'PC'),
		('HP',      'HP2',       'PC'),
		('SAMSUNG', 'SAMSUNG1',  'PC'),
		('SAMSUNG', 'SAMSUNG2',  'PC'),
		('INTEGRAL','INTEGRAL0', 'PC'),
		('HUAWEY',  'HUAWEY-2',  'PC'),
		('ASUS',    'ASUS-1',   'PC'),
		('ASUS',    'ASUS-2',   'PC'),
		('Canon', 'Canon1', 'Printer'),
		('Canon', 'Canon2', 'Printer'),
		('HP',	  'HP-1',	'Printer'),
		('HP',    'HP-2',    'Printer'),
		('Lex',   'Lexmark','Printer');
        
insert into laptop 
	(`code`, model, speed, ram, hd, price, screen)
	values
		(101, 'Apple McBook A2', 2400, 16, 1024, 2000.00, 13),
		(102, 'Apple McBook A1', 1200, 8,  256,  1000.00, 12),
		(103, 'Lenovo M5',	     300,  4,  126,  150.00,  13),
		(104, 'Lenovo M7',	     1200, 8,  512,  250.00,  15),
		(105, 'Lenovo M11',	   	 1800, 8,  512,  700.00,  17),
		(106, 'Samsung S300',    1200, 8,  512,  800.00,  15),
		(107, 'Samsung S200',    1000, 6,  256,  290.00,  15),
		(108, 'Samsung S500',    2000, 8,  512,  800.00,  15),
		(109, 'HP ENVY',         2300, 16, 1024, 1500.00, 14),
		(110, 'HP Pavilion',     2000, 16, 512,  1100.00, 14),
		(111, 'HP Pavilion PLUS',2300, 16, 1024, 1200.00, 14),
		(112, 'ASUS A3000',      700,  32, 256,  1200.00, 15);
        
insert into pc
	(`code`, model, speed, ram, hd, cd, price)
    values
		(201, 'Apple1',   2400, 32, 1024, '32x', 3000.00),
		(202, 'Apple2',   2000, 16, 512,  '24x', 2000.00),
		(203, 'HP1',  	  1400, 16, 1024, '24x', 1600.00),
		(204, 'HP2',      1800, 32, 256,  '24x', 1800.00),
		(205, 'SAMSUNG1', 700,  8,  128,  '12x', 700.00),
		(206, 'SAMSUNG2', 900,  16, 256,  '8x',  1100.00),
		(207, 'INTEGRAL0', 300,  4,  64,   '4x',  200.00),
		(208, 'HUAWEY-2',   1000, 8,  256,  '12x', 800.00),
		(209, 'ASUS-1',   1800, 16, 512,  '24x', 1300.00),
		(210, 'ASUS-2',   1400, 8,  1024, '12x', 1100.00);
        
insert into printer 
	(`code`, model, color, `type`, price)
    values
		(301, 'Canon1', 'n', 'Laser',   200.00),
		(302, 'Canon2', 'y', 'Jet',     170.00),
		(303, 'HP-1',	'n', 'Laser',   240.00),
		(304, 'HP-2',    'n', 'Laser',   220.00),
		(305, 'Lexmark','y', 'Matrixr', 100.00);
