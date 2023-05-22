#1
SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE "Sa%"
ORDER BY `employee_id`; 

#2
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

#3
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3,10)
# WHERE (`department_id` = 3 OR `department_id` = 10) - тук трябва да има скоби, за да се приоретизира
AND 
YEAR (`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

#4
SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

#5
SELECT `name` FROM `towns`
WHERE char_length(`name`) = 5 OR char_length(`name`) = 6
# WHERE char_length(`name`) IN (5,6)
ORDER BY `name`;

#6
SELECT * FROM `towns` 
WHERE 
   `name` LIKE 'M%' 
OR `name` LIKE 'K%' 
OR `name` LIKE 'B%' 
OR `name` LIKE 'E%'
# WHERE `name` REGEXP'^[MKBE]'
ORDER BY `name`;

#7
SELECT * FROM `towns`
WHERE 
	`name` NOT LIKE 'R%'
AND `name` NOT LIKE 'B%'
AND `name` NOT LIKE 'D%'
ORDER BY `name`;

#8
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

#9
SELECT `first_name`, `last_name` FROM `employees`
WHERE char_length(`last_name`) = 5;

#10
SELECT `country_name`, `iso_code` FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

#11
SELECT
 `peak_name`, 
 `river_name`,
 CONCAT(LOWER(`peak_name`), SUBSTRING(LOWER(`river_name`), 2)) AS `mix`
FROM `peaks`, `rivers`
WHERE 
RIGHT(`peak_name`, 1) = LEFT(LOWER(`river_name`), 1) #последната буква на върха = първата буква на реката
ORDER BY `mix`;

#12
SELECT `name`, date_format(`start`, '%Y-%m-%d') AS `start`  FROM `games`
WHERE  YEAR(`start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;

#13
SELECT `user_name`, SUBSTRING(`email`, locate('@', `email`) + 1) AS `Email Provider` FROM `users`
ORDER BY `Email Provider`, `user_name`;
#Ако искаме да отпечатаме преди кльомбата (@):
# SELECT `user_name`, SUBSTRING(`email`,1, locate('@', `email`) - 1) AS `Email Provider` FROM `users`
# ORDER BY `Email Provider`, `user_name`;

#14
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE "___.1%.%.___"
ORDER BY `user_name`;

#15
SELECT `name` AS `game`, 
CASE
WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
ELSE 'Evening'
END
AS `Part of the Day`,
CASE
 WHEN `duration` <= 3 THEN 'Extra Short' 
 WHEN `duration` <= 6 THEN 'Short'
 WHEN `duration` <= 10 THEN 'Long' 
 ELSE 'Extra Long'
 END
AS `Duration` 
FROM `games`;

#16
SELECT `product_name`,
 `order_date`, 
 adddate(`order_date`, interval 3 day) AS `pay_due`,
 adddate(`order_date`, interval 1 month) AS `deliver_due`
 FROM `orders`;
