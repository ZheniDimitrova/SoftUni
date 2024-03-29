#1
SELECT 
    d.manager_id AS 'employee_id',
    CONCAT_WS(' ', e.first_name, e.last_name) AS 'full_name',
    d.department_id AS 'department_id',
    d.name AS 'department_name'
FROM
    `departments` AS d
        JOIN
    `employees` AS e ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;

#2
SELECT 
    t.town_id, t.name, a.address_text
FROM
    `addresses` AS a
        JOIN
    `towns` AS t ON t.town_id = a.town_id
WHERE
    t.name IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.town_id , a.address_id;

#3
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    e.department_id,
    e.salary
FROM
    `employees` AS e
        RIGHT JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    e.manager_id IS NULL;


#4
SELECT 
   COUNT(*) AS 'count'
FROM
    employees AS e
WHERE
    e.salary > (SELECT 
            AVG(e1.salary)
        FROM
            employees AS e1);