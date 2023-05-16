SELECT `id` AS 'No.', 
`first_name` AS 'First Name', 
`last_name` AS 'Last Name',
 `job_title` AS 'Job Title'
FROM `employees`
ORDER BY `id`;

SELECT `id`,
 CONCAT (`first_name`, ' ', `last_name`)  AS 'full name',
	`job_title` AS 'job title',
    `salary` AS 'salary'
FROM `employees` WHERE salary > 1000
ORDER BY `id`;

SELECT `id`, `first_name`, `department_id`
FROM `employees`
WHERE  `department_id` IN (1,2);

SELECT * FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000;


SELECT * FROM `employees`
ORDER BY `salary` DESC
LIMIT 1;

CREATE VIEW `v_top_paid_employee` AS
	SELECT * FROM `employees`
	ORDER BY `salary` DESC
	LIMIT 1;

SELECT * FROM `v_top_paid_employee`;

UPDATE `employees`
	SET `salary` = `salary` + 100
	WHERE `job_title` = 'Manager';
    
    SELECT `salary` FROM `employees`;
    
    
    DELETE FROM `employees`
    WHERE `department_id` IN (1,2);
    
    SELECT * FROM `employees`;