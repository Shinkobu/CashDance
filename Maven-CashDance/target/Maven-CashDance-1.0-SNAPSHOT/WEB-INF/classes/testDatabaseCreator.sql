-- 
DROP TABLE IF EXISTS cbChances CASCADE;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS categories;

-- ПОЛЬЗОВАТЕЛИ

CREATE TABLE users(
id serial PRIMARY KEY,
name VARCHAR(100) NOT NULL,
phoneNumber VARCHAR(20) NOT NULL);

INSERT INTO users (name, phoneNumber)
VALUES
('Иванов Иван Иванович', '89215554422'),
('Смирнов Иван Иванович', '89215577421'),
('Кузнецов Олег Петрович', '89561214422'),
('Пчёлкин Фёдор Емельянович', '89218884451');

SELECT * FROM users;

-- КАРТЫ 

CREATE TABLE cards(
id_card serial PRIMARY KEY,
name_card VARCHAR(100) NOT NULL,
bank_name VARCHAR(100) NOT NULL
);

INSERT INTO cards (name_card, bank_name)
VALUES
('Карта Сбера', 'Сбербанк'),
('Карта Альфы', 'Альфа-банк'),
('Карта Тинькофф', 'Тинькофф'),
('Карта Сбера вирт', 'Сбербанк');

SELECT * FROM cards;

-- КАТЕГОРИИ

CREATE TABLE categories(
id_category serial PRIMARY KEY,
name_category VARCHAR(100) NOT NULL
);

INSERT INTO categories (name_category)
VALUES
('Аптеки'),
('АЗС'),
('Путешествия'),
('Продукты'),
('Бытовая техника');

SELECT * FROM categories;

-- КЕШБЕК ШАНСЫ

CREATE TABLE cbChances(
id_chance serial PRIMARY KEY,
name_chance VARCHAR(100) NOT NULL,
id_card INTEGER REFERENCES cards(id_card) 
	ON UPDATE CASCADE  
	ON DELETE NO ACTION
	NOT NULL,
from_date DATE NOT NULL,
to_date DATE NOT NULL,
id_category INTEGER REFERENCES categories(id_category) 
	ON UPDATE CASCADE  
	ON DELETE NO ACTION
	NOT NULL,
rate REAL NOT NULL
);

INSERT INTO cbChances (name_chance,id_card,from_date,to_date,id_category,rate)
VALUES
('тест июль', 1, '01-07-2023', '31-07-2023',1,0.01),
('тест июль', 2, '01-07-2023', '31-07-2023',2,0.1),
('тест июнь', 3, '01-06-2023', '30-06-2023',3,0.15),
('тест год', 1, '01-01-2023', '31-12-2023',4,0.005),
('тест август', 4, '01-08-2023', '31-08-2023',5,0.30),
('тест август', 2, '01-08-2023', '31-08-2023',5,0.30)
;

