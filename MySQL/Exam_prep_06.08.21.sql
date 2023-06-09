CREATE DATABASE sgd;
USE sgd;

#1
CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(10) NOT NULL
);

CREATE TABLE offices(
id INT PRIMARY KEY AUTO_INCREMENT,
workspace_capacity INT NOT NULL,
website VARCHAR(50),
address_id INT NOT NULL,
CONSTRAINT fk_offices_addresses
	FOREIGN KEY(address_id)
	REFERENCES addresses(id)
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    age INT NOT NULL,
    salary DECIMAL(10 , 2 ) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    happiness_level CHAR(1) NOT NULL
);

CREATE TABLE teams(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
office_id INT NOT NULL,
leader_id INT NOT NULL UNIQUE,
CONSTRAINT fk_teams_offices
	FOREIGN KEY (office_id)
	REFERENCES offices(id),
CONSTRAINT fk_teams_employees
	FOREIGN KEY (leader_id)
    REFERENCES employees(id)	
);

CREATE TABLE games(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL UNIQUE,
description TEXT,
rating FLOAT NOT NULL DEFAULT 5.5,
budget DECIMAL(10,2) NOT NULL,
release_date DATE,
team_id INT NOT NULL,
CONSTRAINT fk_games_teams
FOREIGN KEY (team_id)
REFERENCES teams(id)
);

CREATE TABLE games_categories(
game_id INT NOT NULL,
category_id INT NOT NULL,
CONSTRAINT fk_games_categories
PRIMARY KEY (game_id, category_id),
CONSTRAINT fk_games_categories_games
FOREIGN KEY (game_id)
REFERENCES games(id),
CONSTRAINT fk_games_categories_categories
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

#2
INSERT INTO games(name, rating, budget, team_id)
	SELECT REVERSE(LOWER(SUBSTRING(t.name,2))),
			t.id,
            leader_id * 1000,
            t.id            
FROM teams AS t
WHERE id BETWEEN 1 AND 9;

#3
UPDATE employees AS e
SET e.salary = e.salary + 1000
WHERE e.age < 40 AND e.salary <= 5000;

#4
DELETE FROM games AS g
WHERE release_date IS NULL
AND (SELECT COUNT(*) FROM games_categories AS gc
WHERE g.id = gc.game_id) = 0;

#5
SELECT first_name, last_name, age, salary, happiness_level
FROM employees
ORDER BY salary, id;

#6
SELECT 
	t.name AS 'team_name',
    a.name AS 'address_name', 
    LENGTH(a.name) AS 'count_of_characters'
FROM teams AS t
	JOIN offices AS o ON t.office_id = o.id
    JOIN addresses AS a ON o.address_id = a.id
WHERE website IS NOT NULL
ORDER BY team_name, address_name;

#7
SELECT
	c.name,
    COUNT(c.id) AS 'games_count',
    CAST(AVG(g.budget) AS DECIMAL(10,2)) AS 'avg_budget',
    MAX(g.rating) AS 'max_rating'
FROM categories AS c
	JOIN games_categories AS gc ON category_id = c.id
    JOIN games AS g ON gc.game_id = g.id
GROUP BY c.name
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;

#8
SELECT 
	   g.name,
	   (g.release_date),
       CONCAT(LEFT(g.description, 10), '...') AS 'summary',
       (CASE
			WHEN ((g.release_date) <= '2022-03-31') THEN 'Q1'
            WHEN ((g.release_date) <= '2022-06-30') THEN 'Q2'
            WHEN ((g.release_date) <= '2022-09-30') THEN 'Q3'
            ELSE 'Q4'
            END) AS 'quarter',
		t.name AS 'team_name'
FROM games AS g
		JOIN teams AS t ON g.team_id = t.id
WHERE MONTH(g.release_date) % 2 = 0
  AND YEAR(g.release_date) = 2022
  AND RIGHT(g.name, 1) = 2
ORDER BY quarter;

#9
SELECT
	g.name,
    IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
    t.name AS 'team_name',
    a.name AS 'address_name'
FROM addresses AS a
	JOIN offices AS o ON o.address_id = a.id
    JOIN teams AS t ON t.office_id = o.id
    JOIN games AS g ON t.id = g.team_id
    WHERE release_date IS NULL
AND (SELECT COUNT(*) FROM games_categories AS gc
WHERE g.id = gc.game_id) = 0
ORDER BY g.name;

#10
DELIMITER $$
CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS TEXT
DETERMINISTIC
BEGIN
DECLARE team_name, address TEXT;

	SET team_name := (SELECT t.name FROM games AS g
					JOIN teams AS t ON g.team_id = t.id
                    WHERE g.name = game_name);
	SET address := (SELECT a.name FROM games AS g
					JOIN teams AS t ON g.team_id = t.id
                    JOIN offices AS o ON t.office_id = o.id
                    JOIN addresses AS a ON o.address_id = a.id
                    WHERE g.name = game_name);
	
RETURN CONCAT_WS(' ', 'The', game_name, 'is developed by a',team_name, 
				'in an office with an address', address);
END$$

#11
DELIMITER $$
CREATE PROCEDURE udp_update_budget (min_game_rating FLOAT)
BEGIN

UPDATE games AS g
		SET budget = budget + 100000,
        g.release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR)
	WHERE(SELECT COUNT(*) FROM  games_categories AS gc
			WHERE gc.game_id = g.id) = 0
            AND release_date IS NOT NULL
            AND g.rating > min_game_rating;

END$$

  
   


