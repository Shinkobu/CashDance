-- ИЗМЕНЕНИЕ ПОЛЯ

SELECT * FROM cards;

UPDATE cards
SET name_card = 'Lehman', bank_name = 'Lehman Brothers'
WHERE id_card = 3;

SELECT * FROM cards;

INSERT INTO cards (name_card, bank_name)
VALUES
('Карта Сбера', 'Сбербанк');

SELECT * FROM cards;