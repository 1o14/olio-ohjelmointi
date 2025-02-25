-- Poistetaan vanha tietokanta, jos se on olemassa
DROP DATABASE IF EXISTS CurrencyDB;

-- Luodaan uusi tietokanta nimeltä CurrencyDB
CREATE DATABASE CurrencyDB;

-- Käytetään tätä tietokantaa
USE CurrencyDB;

-- Poistetaan vanha käyttäjä, jos se on olemassa
DROP USER IF EXISTS 'appuser'@'localhost';

-- Luodaan uusi käyttäjä nimeltä appuser ja annetaan sille salasana
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'app_password';

-- Poistetaan vanha taulu, jos se on olemassa
DROP TABLE IF EXISTS Currency;

-- Luodaan uusi taulu nimeltä Currency, jossa säilytetään valuuttatiedot
CREATE TABLE Currency (
                          id INT AUTO_INCREMENT PRIMARY KEY,  -- Automaattinen ID jokaiselle valuutalle
                          abbreviation VARCHAR(3) NOT NULL UNIQUE,  -- Valuuttakoodi, esim. USD, EUR
                          name VARCHAR(50) NOT NULL,  -- Valuutan nimi, esim. "Euro"
                          rate_to_usd DECIMAL(10,6) NOT NULL  -- Vaihtokurssi suhteessa USD:hen
);

-- Lisätään valuuttoja tauluun
INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
                                                           ('USD', 'United States Dollar', 1.000000),  -- USD on perusvaluutta (1:1)
                                                           ('EUR', 'Euro', 0.920000),  -- 1 USD = 0.92 EUR
                                                           ('GBP', 'British Pound', 0.780000),  -- 1 USD = 0.78 GBP
                                                           ('JPY', 'Japanese Yen', 130.500000),  -- 1 USD = 130.5 JPY
                                                           ('CAD', 'Canadian Dollar', 1.340000),  -- 1 USD = 1.34 CAD
                                                           ('AUD', 'Australian Dollar', 1.520000),  -- 1 USD = 1.52 AUD
                                                           ('CHF', 'Swiss Franc', 0.910000),  -- 1 USD = 0.91 CHF
                                                           ('CNY', 'Chinese Yuan', 6.920000);  -- 1 USD = 6.92 CNY

-- Annetaan käyttäjälle 'appuser' oikeudet lukea, lisätä, päivittää ja poistaa tietoja
GRANT SELECT, INSERT, UPDATE, DELETE ON CurrencyDB.* TO 'appuser'@'localhost';

-- Päivitetään käyttäjäoikeudet, jotta ne tulevat voimaan
FLUSH PRIVILEGES;
