CREATE DATABASE IF NOT EXISTS linda_moda_db; 
USE linda_moda_db; -- 1. Tabela Clientes 
CREATE TABLE IF NOT EXISTS clientes ( 
   id BIGINT AUTO_INCREMENT PRIMARY KEY, 
   nome VARCHAR(150) NOT NULL, 
   cpf VARCHAR(14) UNIQUE NOT NULL, 
   email VARCHAR(100), 
   telefone VARCHAR(20) 
); -- 2. Tabela Categorias 
CREATE TABLE IF NOT EXISTS categorias ( 
   id BIGINT AUTO_INCREMENT PRIMARY KEY, 
   nome VARCHAR(100) NOT NULL produtos
); -- 3. Tabela Produtos 
CREATE TABLE IF NOT EXISTS produtos ( 
   id BIGINT AUTO_INCREMENT PRIMARY KEY, 
   nome VARCHAR(150) NOT NULL, 
   preco DECIMAL(10,2) NOT NULL, 
   quantidade_estoque INT NOT NULL DEFAULT 0, 
   categoria_id BIGINT, 
   FOREIGN KEY (categoria_id) REFERENCES categorias(id) 
); 
ALTER TABLE produtos 
ADD COLUMN  tamanho varchar (5) ;
select * from produtos;