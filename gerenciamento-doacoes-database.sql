CREATE DATABASE gerenciamentoDoacoes;
USE gerenciamentoDoacoes;

CREATE TABLE doador (
id_doador INT AUTO_INCREMENT PRIMARY KEY,
RG VARCHAR(9) UNIQUE NOT NULL,
nome VARCHAR(255) NOT NULL,
telefone VARCHAR (18) NOT NULL,
email VARCHAR (50) NOT NULL
);



CREATE TABLE doação ( 
id_doacao INT AUTO_INCREMENT PRIMARY KEY,
id_instituicao INT,
id_doador INT,
id_beneficiario INT,
descricao VARCHAR (100) NOT NULL,
categoria VARCHAR (50) NOT NULL
);

CREATE TABLE instituição (
id_instituicao INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255) NOT NULL,
cnpj VARCHAR(18) NOT NULL
);

CREATE TABLE rastreio (
id_rastreio INT AUTO_INCREMENT PRIMARY KEY,
id_doacao INT,
status VARCHAR (50) NOT NULL,
date_status DATE NOT NULL
);

CREATE TABLE instituição_beneficiada (
id_beneficiario INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR (255) NOT NULL,
endereco VARCHAR (200) NOT NULL,
email VARCHAR (50) NOT NULL,
telefone VARCHAR(18) NOT NULL
);




