create database agencia;

CREATE TABLE Pacote (
id_pac INTEGER PRIMARY KEY auto_increment,
cpf_cli VARCHAR(14),
total double
);

CREATE TABLE Reserva (
id_res INTEGER PRIMARY KEY auto_increment,
id_pac INTEGER,
cnpj_hos VARCHAR(20),
hospedes INTEGER,
quartos INTEGER,
data_entrada VARCHAR(10),
data_saida VARCHAR(10),
diaria INTEGER,
sub_total double,
FOREIGN KEY(id_pac) REFERENCES Pacote (id_pac)
);

CREATE TABLE Aeroporto (
cnpj_aer VARCHAR(20) PRIMARY KEY,
nome VARCHAR(100),
cidade VARCHAR(100),
uf VARCHAR(2)
);

CREATE TABLE Destino (
id_des INTEGER PRIMARY KEY auto_increment,
cidade VARCHAR(50),
uf VARCHAR(2)
);

CREATE TABLE Passagem (
id_pas INTEGER PRIMARY KEY auto_increment,
id_pac INTEGER,
id_des INTEGER,
cnpj_con VARCHAR(20),
cnpj_aer VARCHAR(20),
cpf_pas VARCHAR(14),
classe VARCHAR(20),
data VARCHAR(10),
preco double,
FOREIGN KEY(id_pac) REFERENCES Pacote (id_pac),
FOREIGN KEY(id_des) REFERENCES Destino (id_des),
FOREIGN KEY(cnpj_aer) REFERENCES Aeroporto (cnpj_aer)
);

CREATE TABLE Hospedagem (
cnpj_hos VARCHAR(20) PRIMARY KEY,
nome VARCHAR(100),
tipo VARCHAR(20),
preco_dia double,
cidade VARCHAR(100),
uf VARCHAR(2)
);

CREATE TABLE Cliente (
cpf_cli VARCHAR(14) PRIMARY KEY,
nome VARCHAR(100),
data_nasc VARCHAR(10),
genero VARCHAR(1),
telefone VARCHAR(20),
endereco VARCHAR(100),
uf VARCHAR(2),
email VARCHAR(100),
senha VARCHAR(20)
);

CREATE TABLE Concessionaria (
cnpj_con VARCHAR(20) PRIMARY KEY,
nome VARCHAR(100)
);

ALTER TABLE Pacote ADD FOREIGN KEY(cpf_cli) REFERENCES Cliente (cpf_cli);
ALTER TABLE Reserva ADD FOREIGN KEY(cnpj_hos) REFERENCES Hospedagem (cnpj_hos);
ALTER TABLE Passagem ADD FOREIGN KEY(cnpj_con) REFERENCES Concessionaria (cnpj_con);

