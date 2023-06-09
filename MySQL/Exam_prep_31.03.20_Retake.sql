CREATE DATABASE instd;
USE instd;

#1
CREATE TABLE users(
id INT PRIMARY KEY,
username VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
gender CHAR(1) NOT NULL,
age INT NOT NULL,
job_title VARCHAR(40) NOT NULL,
ip VARCHAR(30) NOT NULL
);

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT, 
address VARCHAR(30) NOT NULL, 
town VARCHAR(30) NOT NULL, 
country VARCHAR(30) NOT NULL, 
user_id INT NOT NULL,
CONSTRAINT fk_addresses_users
FOREIGN KEY (user_id)
REFERENCES users(id)
);

CREATE TABLE photos(
id INT PRIMARY KEY AUTO_INCREMENT,
description TEXT NOT NULL,
date DATETIME NOT NULL,
views INT NOT NULL DEFAULT 0
);

CREATE TABLE comments(
id INT PRIMARY KEY AUTO_INCREMENT, 
comment VARCHAR(255) NOT NULL,
date DATETIME NOT NULL, 
photo_id INT NOT NULL,
CONSTRAINT fk_comments_photos
FOREIGN KEY(photo_id)
REFERENCES photos(id)
);

CREATE TABLE users_photos(
user_id INT NOT NULL ,
photo_id INT NOT NULL,
CONSTRAINT fk_up_users
FOREIGN KEY (user_id)
REFERENCES users(id),
CONSTRAINT fk_up_photos
FOREIGN KEY (photo_id)
REFERENCES photos(id)
);
CREATE TABLE likes(
id INT PRIMARY KEY AUTO_INCREMENT,
photo_id INT,
user_id INT,
CONSTRAINT fk_likes_photos
FOREIGN KEY(photo_id)
REFERENCES photos(id),
CONSTRAINT fk_likes_users
FOREIGN KEY (user_id)
REFERENCES users(id)
);

#2
INSERT INTO addresses (address, town, country, user_id) 
	SELECT 
    u.username,
    u.password,
    u.ip,
    u.age
FROM users AS u
WHERE u.gender = 'M';

#3
UPDATE addresses AS a
	SET country = (
CASE
			WHEN country LIKE 'B%' THEN 'Blocked'
            WHEN country LIKE 'T%' THEN 'Test'
            WHEN country LIKE 'P%' THEN 'In Progress'
			ELSE country
END
);
    
       
#4
DELETE FROM addresses
WHERE id % 3 = 0;

#5
SELECT 
	username,
    gender,
    age
FROM users
ORDER BY age DESC, username;


#6
SELECT 
	p.id, 
	p.date AS 'date_and_time',
	p.description,
	COUNT(c.id) AS 'commentsCount'
FROM photos AS p
JOIN comments AS c ON p.id = c.photo_id
GROUP BY p.id
ORDER BY commentsCount DESC, p.id
LIMIT 5;

#7
SELECT 
	CONCAT(u.id, ' ', u.username) AS id_username,
    u.email
FROM users AS u
	JOIN users_photos AS up ON u.id = up.user_id
	JOIN photos AS p ON p.id = up.photo_id
WHERE u.id = p.id
ORDER BY u.id;

#8
SELECT 
	p.id, 
    COUNT(DISTINCT l.id) AS 'likes_count',
    COUNT(DISTINCT c.id) AS 'comments_count' 
FROM photos AS p
	LEFT JOIN likes AS l ON l.photo_id = p.id
    LEFT JOIN comments AS c ON c.photo_id = p.id
GROUP BY p.id
ORDER BY likes_count DESC, comments_count DESC, p.id;

#9
SELECT 
	CONCAT(LEFT(p.description, 30), '...') AS 'summary',
	p.date
    FROM photos AS p
    WHERE DAY(p.date) = 10
    ORDER BY p.date DESC;
    
#10
DELIMITER $$
CREATE FUNCTION udf_users_photos_count(username VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN(
		SELECT COUNT(*)
        FROM users AS u
        JOIN users_photos AS up ON u.id = up.user_id
        WHERE u.username = username);
    END$$

#11
DELIMITER $$
CREATE PROCEDURE udp_modify_user (address VARCHAR(30), town VARCHAR(30))
BEGIN 
	IF((SELECT a.address FROM addresses AS a
		WHERE a.address = address) IS NOT NULL)
	THEN UPDATE users AS u
    JOIN addresses as adr ON u.id = adr.user_id
    SET u.age = u.age + 10
    WHERE adr.address = address AND adr.town = town;
    END IF;    

END$$


