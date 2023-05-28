#1. One-To-One Relationship

CREATE DATABASE `Table_Relations`;
use Table_Relations;

CREATE TABLE `passports` (
	`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(50) UNIQUE
);

INSERT INTO `passports` (`passport_id`, `passport_number`)
VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

CREATE TABLE `people` (
`person_id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`salary` DECIMAL(9,2),
`passport_id` INT UNIQUE,
CONSTRAINT fk_people_passports
FOREIGN KEY (`passport_id`)
REFERENCES passports(`passport_id`)
);

INSERT INTO `people`(`first_name`, `salary`, `passport_id`)
VALUES
('Roberto', 43300.00, 102),
('Tom', 56100, 103),
('Yana', 60200, 101);

#2. One-To-Many Relationship

CREATE DATABASE `cars`;

CREATE TABLE `manufacturers` (
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`established_on` DATE
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES
('BMW', '1916/03/01'),
('Tesla', '2003/01/01'),
('Lada', '1966/05/01');

CREATE TABLE `models` (
`model_id`INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(70) NOT NULL,
`manufacturer_id` INT,
CONSTRAINT fk_models_manufacturers
FOREIGN KEY (`manufacturer_id`)
REFERENCES manufacturers(`manufacturer_id`)
);

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`)
VALUES
(101, 'X1', 1),
(102, 'i6', 1),
(103, 'Model S', 2),
(104, 'Model X', 2),
(105, 'Model 3', 2),
(106, 'Nova', 3);

#3. Many-To-Many Relationship

CREATE DATABASE `school`;

CREATE TABLE `students` (
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(70) NOT NULL
);

INSERT INTO `students` (`name`)
VALUES
('Mila'),
('Toni'),
('Ron');

CREATE TABLE `exams` (
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (100) NOT NULL
);

ALTER TABLE `exams`
AUTO_INCREMENT = 101;

INSERT INTO `exams` (`name`)
VALUES
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

CREATE TABLE `students_exams`(
	`student_id` INT NOT NULL,
	`exam_id` INT NOT NULL,
    
    CONSTRAINT pk
    PRIMARY KEY(`student_id`, `exam_id`),
    
    CONSTRAINT fk_students
    FOREIGN KEY(`student_id`)
    REFERENCES students(`student_id`),
    
    CONSTRAINT fk_exams
    FOREIGN KEY(`exam_id`)
    REFERENCES exams(`exam_id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

#4.	Self-Referencing

CREATE DATABASE `selfref`;

CREATE TABLE `teachers` (
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (50) NOT NULL, 
`manager_id` INT 
);

ALTER TABLE `teachers` AUTO_INCREMENT = 101;

INSERT INTO `teachers` (`name`, `manager_id`)
VALUES
	('John', NULL),
    ('Maya', 106),
    ('Silvia', 106),
    ('Ted', 105),
    ('Mark', 101),
    ('Greta', 101);
    
ALTER TABLE `teachers`
ADD CONSTRAINT fk
FOREIGN KEY(`manager_id`)
REFERENCES teachers(`teacher_id`);

#5
CREATE DATABASE `store`;

CREATE TABLE `cities`(
	`city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `item_types`(
	`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `customers`(
	`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT,
    CONSTRAINT fk_customer_city
    FOREIGN KEY (`city_id`)
    REFERENCES `cities`(`city_id`)
);

CREATE TABLE `orders`(
	`order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT,
    CONSTRAINT fk_order_customer
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`customer_id`)
);

CREATE TABLE `items`(
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
	`item_type_id` INT,
    CONSTRAINT fk_items_itemTypes
    FOREIGN KEY (`item_type_id`)
    REFERENCES `item_types`(`item_type_id`)
);

CREATE TABLE `order_items`(
	`order_id` INT,
	`item_id` INT,
    CONSTRAINT pk
    PRIMARY KEY (`order_id`,`item_id`),
    CONSTRAINT fk_order
    FOREIGN KEY (`order_id`)
    REFERENCES `orders`(`order_id`),
    CONSTRAINT fk_item
    FOREIGN KEY (`item_id`)
    REFERENCES `items`(`item_id`)    
);








#6

CREATE DATABASE `university`;

CREATE  TABLE `subjects`(
	`subject_id` INT PRIMARY KEY AUTO_INCREMENT,
    `subject_name` VARCHAR(50)
);

CREATE TABLE `majors`(
	`major_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) 
);

CREATE TABLE `payments`(
	`payment_id` INT PRIMARY KEY AUTO_INCREMENT,
    `payment_amount` DECIMAL(8,2),
    `payment_date` DATE,
	`student_id` INT
);

CREATE TABLE `students`(
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
	`student_number` VARCHAR(12) UNIQUE,
    `student_name` VARCHAR(50),
    `major_id` INT
);

CREATE TABLE `agenda`(
	`student_id` INT,
    `subject_id` INT,
    CONSTRAINT pk
    PRIMARY KEY (`student_id`, `subject_id`)
    
);
 
 # връзка между paymnets  и  students
ALTER TABLE `payments`
ADD CONSTRAINT fk_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`); 

 # връзка между  students и  majors
ALTER TABLE `students`
ADD CONSTRAINT fk_majors
FOREIGN KEY (`major_id`)
REFERENCES `majors`(`major_id`);

# връзка между  agenda и  subjects FK -> agenda
ALTER TABLE `agenda`
ADD CONSTRAINT fk_subject
FOREIGN KEY (`subject_id`)
REFERENCES `subjects`(`subject_id`);

# връзка между  agenda и  students FK -> agenda
ALTER TABLE `agenda`
ADD CONSTRAINT fk_students_agenda
foreign key(`student_id`)
REFERENCES `students`(`student_id`);

