-- Haetaan kaikki valuutat taulusta
SELECT * FROM Currency;

-- Haetaan valuutta, jonka lyhenne on 'EUR'
SELECT * FROM Currency WHERE abbreviation = 'EUR';

-- Lasketaan, kuinka monta valuuttaa tietokannassa on
SELECT COUNT(*) AS total_currencies FROM Currency;

-- Haetaan valuutta, jolla on korkein vaihtokurssi
SELECT * FROM Currency ORDER BY rate_to_usd DESC LIMIT 1;
