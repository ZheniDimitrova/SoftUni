#1

#CREATE DATABASE online_store; 
#USE online_store;

CREATE TABLE brands(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE reviews(
id INT PRIMARY KEY AUTO_INCREMENT,
content TEXT,
rating DECIMAL(10,2) NOT NULL,
picture_url VARCHAR(80) NOT NULL,
published_at DATETIME NOT NULL
);

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(40) NOT NULL,
price DECIMAL(19,2) NOT NULL,
quantity_in_stock INT,
description TEXT,
brand_id INT NOT NULL,
category_id INT NOT NULL,
review_id INT,
CONSTRAINT fk_products_brands
	FOREIGN KEY(brand_id)
	REFERENCES brands(id),
CONSTRAINT fk_products_categories
	FOREIGN KEY(category_id)
	REFERENCES categories(id),
CONSTRAINT fk_products_reviews
	FOREIGN KEY (review_id)
	REFERENCES reviews(id)
);
CREATE TABLE customers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20) NOT NULL,
phone VARCHAR(30) NOT NULL UNIQUE,
address VARCHAR(60) NOT NULL,
discount_card BIT NOT NULL DEFAULT FALSE
);

CREATE TABLE orders(
id INT PRIMARY KEY AUTO_INCREMENT,
order_datetime DATETIME,
customer_id INT NOT NULL,
CONSTRAINT fk_orders_customers
	FOREIGN KEY (customer_id)
	REFERENCES customers(id)
);

CREATE TABLE orders_products(
order_id INT,
product_id INT,
CONSTRAINT fk_ordersproducts_orders
	FOREIGN KEY(order_id)
	REFERENCES orders(id),
CONSTRAINT fk_ordersproducts_products
	FOREIGN KEY (product_id)
	REFERENCES products(id)
);

#2
INSERT INTO reviews(content, rating, picture_url, published_at)
	SELECT LEFT(p.description, 15),
		   p.price/8,
		   reverse(p.name),
           DATE('2010-10-10')
    FROM products AS p
    WHERE p.id >= 5;

#3
UPDATE products
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;

#4
DELETE c FROM customers AS c
LEFT JOIN orders AS o ON c.id = o.customer_id
WHERE o.customer_id IS NULL;

#5
SELECT id, name
FROM categories
ORDER BY name DESC;
 
#6
SELECT  id, brand_id, name, quantity_in_stock
FROM products
WHERE price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;

#7
SELECT * FROM reviews
WHERE CHAR_LENGTH(content) > 61
AND content LIKE 'My%'
ORDER BY rating DESC;

#8
SELECT 
	CONCAT_WS(' ', first_name, last_name) AS full_name,
    c.address,
    o.order_datetime
FROM customers AS c
JOIN orders AS o ON c.id = o.customer_id
WHERE YEAR(order_datetime) <= 2018
ORDER BY full_name DESC;
 
#9
SELECT COUNT(c.id) AS items_count,
			c.name,
            SUM(p.quantity_in_stock) AS total_quantity
FROM products AS p
		JOIN categories AS c ON c.id = p.category_id
GROUP BY c.id
ORDER BY items_count DESC, total_quantity
LIMIT 5;

#10
DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC

BEGIN
	RETURN(
	SELECT COUNT(c.id)
FROM  customers AS c
	JOIN orders AS o ON c.id = o.customer_id
    JOIN orders_products AS op ON o.id = op.order_id
WHERE c.first_name = name
GROUP BY c.id
);
END$$

#11
DELIMITER $$
CREATE PROCEDURE udp_reduce_price (category_name VARCHAR(50))
BEGIN
	UPDATE products AS p
		JOIN reviews AS r ON p.review_id = r.id
		JOIN categories AS c ON p.category_id = c.id
	SET price = price * 0.7
    WHERE r.rating < 4 AND c.name = category_name;
END$$








