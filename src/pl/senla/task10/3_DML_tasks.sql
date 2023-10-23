-- Task: 1
-- Find the model number, speed and size of the hard drive for all PCs that cost less than $500. Output: model, speed and hd
select model, speed, hd from pc where price < 500;

-- Task: 2
-- Find the printer manufacturers. Output: maker
select distinct maker from product where `type`='Printer';

-- Task: 3
-- Find the model number, memory capacity and screen sizes of Laptops, the price of which exceeds $ 1,000.
select model, hd, screen from laptop where price>1000;

-- Task: 4
-- Find all the Printer table entries for Color printers.
select * from printer where color='y';

-- Task: 5
-- Find the model number, speed and size of the hard disk of a PC with a 12x or 24x CD and a price of less than $600.
select model, speed, hd  from pc where price<600 and (cd='12x' or cd='24x');

-- Task: 6
-- Specify the manufacturer and speed for those Laptops that have a hard disk of at least 100 GB.
select p.maker, l.speed from
	product p join laptop l on p.model=l.model
		where  l.hd > 1000;

-- Task: 7
-- Find the model numbers and prices of all products (of any type) produced by manufacturer B.
	select model, price from
		product p1 join pc pc using (model)
		where maker = "HP"
		union
	select model, price from
		product p2 join laptop l using (model)
		where maker = "HP"
		union
	select model, price from 
		product p3 join printer pr using (model)
		where maker = "HP";
	
	
-- Task: 8
-- Find a manufacturer that produces PCs, but not Laptops.
select pr.maker from 
	pc p left join product pr using (model)
		except (select pr.maker from
			laptop l left join product pr using (model)); 
	
		
-- Task: 9
-- Find manufacturers of PCs with a processor of at least 450 Mhz. Output: Maker
select distinct p.maker from
	product p join pc p2 on p.model=p2.model 
		where p2.speed >= 450;
		
-- Task: 10
-- Find the printers that have the highest price. Output: model, price
select model, price from printer 
	where price = (select max(price) from printer);
		
-- Task: 11
-- Find the average PC speed.
select avg(speed) from pc;

		
-- Task: 12
-- Find the average speed of laptops whose price exceeds $ 1,000.
select avg(speed) from laptop l where price >= 1000;
		
-- Task: 13
-- Find the average speed of PCs released by manufacturer A.
select avg(speed) from
	pc p join product p2 on p.model=p2.model 
		where p2.maker = 'Apple';
		
-- Task: 14
-- For each speed value, find the average cost of a PC with the same processor speed. Bring out: speed, average price
select speed, avg(price) from pc p group by speed;

		
-- Task: 15
-- Find the sizes of hard drives that match two or more PCs. Output: HD
select hd from pc group by hd having count(hd)>=2; 
		
-- Task: 16
-- Find pairs of PC models that have the same speed and RAM.
-- As a result, each pair is specified only once, i.e. (i,j), 
-- but not (j,i), the order of output: model with a larger number, model with a smaller number, speed and RAM.
select p1.model, p2.model, p1.speed as speed, p1.ram as ram from
	(pc p1 join pc p2
		on p1.speed = p2.speed and p1.ram = p2.ram)
	where p1.code > p2.code;

		
-- Task: 17
-- Find laptop models whose speed is less than the speed of any of the PCs. Output: type, model, speed
select pr.type, l.model, l.speed from
	product pr join 
		(laptop l join pc p) as t
		on pr.model = t.model;
		
-- Task: 18
-- Find the manufacturers of the cheapest color printers. Output: maker, price
select p.maker, pr.price from
	 printer pr left join product p on pr.model = p.model 
		where pr.color='y' and pr.price = (select min(price) from printer);
	
-- Task: 19
-- For each manufacturer, find the average screen size of the laptops they produce. Output: maker, average screen size.
select p.maker, avg(l.screen) from
	product p right join laptop l on p.model = l.model 
		group by p.maker;
	
-- Task: 20
-- Find manufacturers that produce at least three different PC models. Output: Maker, number of models
select maker, count(model) from product where `type` = 'PC' group by maker having count(model)>=3;
		
-- Task: 21
-- Find the maximum price of PCs produced by each manufacturer. Output: maker, maximum price.
select maker, max(price) from
	pc left join product p using (model)
	group by p.maker;
	
-- Task: 22
-- For each PC speed value exceeding 600 MHz, determine the average price of a PC with the same speed. Output: speed, average price.
select speed, avg(price) from pc where speed > 600 group by speed; 
		
-- Task: 23
-- Find manufacturers that would produce both PCs with a speed of at least 750 MHz and laptops with a speed of at least 750 MHz.
-- Output: Maker
select distinct pr.maker from
	pc join product pr using (model) where pc.speed >= 750
intersect 
select distinct pr.maker from
	laptop l join product pr using (model) where l.speed >= 750;
		
-- Task: 24
-- List the model numbers of any types that have the highest price for all products available in the database.
select products.code as code from 
(select pc.code, pc.price from pc
	union
	select l.code, l.price from laptop l
	union
	select p.code, p.price from printer p) as products 
	where products.price = (select max(price) from
		(select pc.code, pc.price from pc
		union
		select l.code, l.price from laptop l
		union
		select p.code, p.price from printer p) as prod);
		
-- Task: 25
-- Find the printer manufacturers that produce PCs with the least amount of RAM and
-- with the fastest processor among all PCs with the least amount of RAM. Output: Make
SELECT max(speed) FROM 
	pc
JOIN
		(product p
	 JOIN 	
		(SELECT p.maker FROM pc JOIN product p USING (model)
		INTERSECT 
		SELECT p.maker FROM printer pr JOIN product p USING (model)
		) AS intersectedmakers
	USING (maker)
		)
USING (model)
WHERE pc.ram = (SELECT min(ram) FROM 
	      			pc
				JOIN
					(product p
					JOIN 	
						(SELECT p.maker FROM pc JOIN product p USING (model)
						INTERSECT 
						SELECT p.maker FROM printer pr JOIN product p USING (model)
						) AS intersectedmakers
					USING (maker)
					)
				USING (model));
	
	
	
