# Tailor-Management-System
# Day 1
Created Login page and connected Database for communication
# Queries are required to work with Database
CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) NOT NULL,
                    password VARCHAR(50) NOT NULL);

insert into users (username, password) values ('Your Name', 'Your Password');

# Day 2
Work on backend classes (Shirt, Pant, Coat, Shalwar Kameez) measurements.
still remaining to connect with database and business logic.

# Day 3
Work on totally frontend classes and confused about the design strategy.
So, tomorrow will work on backend in the end work on fronted

# Day 4
Work on frontend and added side bar and landing page.
Added event handing and clear field functionality.

# Day 5
Worked on frontend and still working on database and backend strategies.
![Database Design](day5_database.png)


# Queries are required
CREATE TABLE details (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
shop_name VARCHAR(30),
address VARCHAR(50),
phone_no VARCHAR(11),
email VARCHAR(30)
);

create table customer (name varchar(20), phone varchar(11) primary key);

# Day 6
Completed database and added necessary field restrictions to program.
![Database](database.png)
# Queries are required
create table pant(id int auto_increment primary key,
waist float not null,
length float not null,
inseam float not null,
type tinyint not null,
status tinyint not null,
quantity int not null,
description varchar(100),
order_date date not null,
delivery_date date not null,
phone varchar(11) not null,
foreign key (phone) references customer(phone)
);

create table coat(id int auto_increment primary key,
chest float not null,
waist float not null,
sleeves float not null,
shoulder float not null,
status tinyint not null,
quantity int not null,
description varchar(100),
order_date date not null,
delivery_date date not null,
phone varchar(11) not null,
foreign key (phone) references customer(phone)
);

create table shirt(id int auto_increment primary key,
chest float not null,
neck float not null,
waist float not null,
shoulder float not null,
sleeves_length float not null,
shirt_length float not null,
cuff_type tinyint not null,
status tinyint not null,
quantity int not null,
description varchar(100),
order_date date not null,
delivery_date date not null,
phone varchar(11) not null,
foreign key (phone) references customer(phone)
);

create table kameez_shalwaar(id int auto_increment primary key,
kameez_length float not null,
sleeves_length float not null,
shoulder float not null,
neck float not null,
collar_type tinyint not null,
cuff_type tinyint not null,
kameez_type tinyint not null,
trouser_length float not null,
trouser_width float not null,
trouser_type tinyint not null,
status tinyint not null,
quantity int not null,
description varchar(100),
order_date date not null,
delivery_date date not null,
phone varchar(11) not null,
foreign key (phone) references customer(phone)
);