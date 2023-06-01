#0.1 Проверяваме
SELECT `town_id` FROM `towns` WHERE `name` = 'Sofia';
SELECT * FROM `addresses` WHERE  `town_id`= 32;
SELECT * FROM `employees`WHERE `address_id` = 291;


#0.2
SELECT 
    COUNT(*) AS 'count'
FROM
    `employees` AS e
        JOIN
    `addresses` AS a ON a.`address_id` = e.`address_id`
        JOIN
    `towns` AS t ON t.`town_id` = a.`town_id`
WHERE
    t.`name` = 'Sofia'; 
    
#0.3
SELECT 
    COUNT(*) AS 'count'
FROM
    `employees` AS e
WHERE
    e.`address_id` IN (SELECT 
            `address_id`
        FROM
            `addresses` AS a
        WHERE
            a.`town_id` = (SELECT 
                    `town_id`
                FROM
                    `towns`
                WHERE
                    `name` = 'Sofia'));
                    
                   
#1
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE id_for_town INT;
    DECLARE count_by_town INT;
    
		SET id_for_town :=(SELECT `town_id` FROM `towns` WHERE `name` = `town_name`);
        SET count_by_town := (SELECT COUNT(*)  FROM `employees` AS e
								WHERE e.`address_id` IN (SELECT `address_id` FROM `addresses` WHERE `town_id` = id_for_town));
                                
		RETURN count_by_town;

END$$

SELECT ufn_count_employees_by_town('Sofia') AS 'count';

#2
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
	UPDATE `employees` SET `salary` = `salary` * 1.05
	WHERE `department_id` = (SELECT `department_id` FROM `departments` WHERE `name` = department_name);
END$$

CALL usp_raise_salaries('Engineering');

#3
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	 DECLARE count_by_id INT;
     
	 START TRANSACTION;
	SET count_by_id := (SELECT COUNT(*) FROM `employees` WHERE `employee_id` = id);
    
    UPDATE `employees` SET `salary` = `salary` * 1.05 WHERE `employee_id` = id;
    
    IF (count_by_id < 1) THEN ROLLBACK;
    ELSE COMMIT;
    
    END IF;
END$$

#4
CREATE TABLE `deleted_employees` (
employee_id INT PRIMARY KEY AUTO_INCREMENT, 
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
middle_name VARCHAR(50) DEFAULT NULL,
job_title VARCHAR(50) NOT NULL,
department_id INT NOT NULL,
salary DECIMAL(19,4) NOT NULL
);


CREATE TRIGGER tr_deleted_employees
AFTER DELETE 
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO `deleted_employees`
		(
		first_name,
        last_name,
        middle_name,
        job_title,
        department_id,
        salary
        )
    VALUES(
		OLD.first_name,
        OLD.last_name,
        OLD.middle_name,
        OLD.job_title,
        OLD.department_id,
        OLD.salary  
    );
    
    END;
    
    DROP TABLE `deleted_employees`;
    DROP TRIGGER tr_deleted_employees;
    


   
                    
	