# Tailor-Management-System
# Day 1
Created Login page and connected Database for communication
# Queries are required to work with Database
CREATE TABLE users (
->     id INT AUTO_INCREMENT PRIMARY KEY,
->     username VARCHAR(50) NOT NULL,
->     password VARCHAR(50) NOT NULL
-> );

insert into users (username, password) values ('Your Name', 'Your Password');