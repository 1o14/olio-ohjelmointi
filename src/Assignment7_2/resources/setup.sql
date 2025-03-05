-- Poistetaan olemassa oleva tietokanta ja luodaan uusi
DROP DATABASE IF EXISTS CurrencyDB;
CREATE DATABASE CurrencyDB;
USE CurrencyDB;

-- Poistetaan käyttäjä ja luodaan uusi
DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'app_password';

-- Poistetaan vanha taulu ja luodaan uusi
DROP TABLE IF EXISTS Currency;
CREATE TABLE Currency (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          abbreviation VARCHAR(3) NOT NULL UNIQUE,
                          name VARCHAR(50) NOT NULL,
                          rate_to_usd DECIMAL(10,6) NOT NULL
);

-- Lisätään valuutat tietokantaan
INSERT INTO Currency (abbreviation, name, rate_to_usd) VALUES
                                                           ('USD', 'United States Dollar', 1.000000),
                                                           ('EUR', 'Euro', 0.920000),
                                                           ('GBP', 'British Pound', 0.780000),
                                                           ('JPY', 'Japanese Yen', 130.500000),
                                                           ('CAD', 'Canadian Dollar', 1.340000),
                                                           ('AUD', 'Australian Dollar', 1.520000),
                                                           ('CHF', 'Swiss Franc', 0.910000),
                                                           ('CNY', 'Chinese Yuan', 6.920000);

-- Myöntää oikeudet käyttäjälle
GRANT SELECT, INSERT, UPDATE, DELETE ON CurrencyDB.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
