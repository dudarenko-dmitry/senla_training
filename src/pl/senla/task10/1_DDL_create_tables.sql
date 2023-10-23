CREATE TABLE product (
	maker varchar(10) NOT NULL,
	model varchar(50) NOT NULL PRIMARY KEY,
	`type` varchar(50) NOT null,
    constraint chk check (type in ('PC', 'Laptop', 'Printer')) 
);

create table if not exists laptop (
	`code` int not null primary key,
	model varchar(50) not null,
	speed smallint not null,
	ram smallint not null,
	hd real not null,
	price decimal(10,2),
	screen tinyint not null,
	foreign key (`model`)
		references product (`model`)
		on delete cascade
);

create table if not exists pc (
	`code` int not null primary key,
	model varchar(50) not null,
	speed smallint not null,
	ram smallint not null,
	hd real not null,
	cd varchar(10) not null,
	price int,
	foreign key (`model`)
		references product (`model`)
		on delete cascade
);

create table if not exists printer (
	`code` int not null primary key,
	model varchar(50) not null,
	color char(1) not null,
	type varchar(10) not null,
	price decimal(10,2),
	foreign key (`model`)
		references product (`model`)
		on delete cascade
);