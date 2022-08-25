DROP DATABASE IF EXISTS shoppingapplication_db;
CREATE DATABASE shoppingapplication_db;

USE shoppingapplication_db;

DROP TABLE IF EXISTS recipes;
CREATE TABLE IF NOT EXISTS recipes (
	recipe_id 		BIGINT			NOT NULL	AUTO_INCREMENT,
	recipe_name 	VARCHAR(255)	NOT NULL,
	ingredient	 	VARCHAR(255)	NOT NULL,       
	amount			INT(255),   
	units			CHAR(255),        
	PRIMARY KEY(recipe_id)	
);

DROP TABLE IF EXISTS inventory;
CREATE TABLE IF NOT EXISTS inventory (
	item_id		BIGINT			NOT NULL	AUTO_INCREMENT,
    ingredient	VARCHAR(255)	NOT NULL,
    units		CHAR(255)		NOT NULL,
	amount		INT 			NOT NULL,
    PRIMARY KEY(item_id)    
);

INSERT INTO recipes (recipe_name, ingredient, amount, units) VALUES
	('Pancakes', 'Milk', 500, 'mililitres'),
    ('Pancakes', 'Eggs', 2, NULL),
    ('Pancakes', 'Flour', 100, 'grams'),
    ('Pancakes', 'Oil', 1, 'tabelspoon');
