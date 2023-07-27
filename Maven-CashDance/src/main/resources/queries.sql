DROP VIEW cbQuery;

CREATE VIEW cbQuery AS

SELECT cbChances.name_chance, cbChances.id_card,cbChances.from_date,
cbChances.to_date,cbChances.id_category,cbChances.rate, 
cards.name_card, categories.name_category FROM cbChances

JOIN cards ON cbChances.id_card = cards.id_card
JOIN categories ON cbChances.id_category = categories.id_category
WHERE (from_date >= '01-07-2023' and to_date <='31-07-2023') or
(from_date <= '01-07-2023' and to_date >='31-07-2023');

SELECT * FROM cbQuery;