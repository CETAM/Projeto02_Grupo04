CREATE DATABASE IF NOT EXISTS loja_virtual_roupas;
USE loja_virtual_roupas;

-- 2. Tabela de Pessoas (Clientes / Funcionários / Fornecedores)
CREATE TABLE pessoa (
    id_pessoa INT AUTO_INCREMENT PRIMARY KEY,
    tipo_pessoa ENUM('Cliente', 'Funcionario', 'Fornecedor') NOT NULL DEFAULT 'Cliente',
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    cpf_cnpj VARCHAR(18) UNIQUE, -- Suporta CPF (ex: 000.000.000-00) ou CNPJ (ex: 00.000.000/0001-00)
    telefone VARCHAR(20),
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- 3. Tabela de Endereços
CREATE TABLE endereco (
    id_endereco INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT NOT NULL,
    cep VARCHAR(9) NOT NULL,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 4. Tabela de Categorias
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao TEXT
) ENGINE=InnoDB;

-- 5. Tabela de Produtos
CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    tamanho ENUM('PP', 'P', 'M', 'G', 'GG', 'XG') NOT NULL,
    cor VARCHAR(30) NOT NULL,
    estoque INT NOT NULL DEFAULT 0,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
) ENGINE=InnoDB;

-- 6. Tabela de Carrinho de Compras
CREATE TABLE carrinho (
    id_carrinho INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT NOT NULL UNIQUE, -- Cada cliente possui apenas 1 carrinho ativo
    data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa) ON DELETE CASCADE
) ENGINE=InnoDB;

-- 7. Tabela de Itens do Carrinho
CREATE TABLE item_carrinho (
    id_item_carrinho INT AUTO_INCREMENT PRIMARY KEY,
    id_carrinho INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL DEFAULT 1,
    FOREIGN KEY (id_carrinho) REFERENCES carrinho(id_carrinho) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
) ENGINE=InnoDB;

-- 8. Tabela de Pedidos
CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_pessoa INT NOT NULL,
    id_endereco INT NOT NULL,
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_pedido ENUM('Pendente', 'Pago', 'Enviado', 'Entregue', 'Cancelado') DEFAULT 'Pendente',
    valor_total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa),
    FOREIGN KEY (id_endereco) REFERENCES endereco(id_endereco)
) ENGINE=InnoDB;

-- 9. Tabela de Itens do Pedido
CREATE TABLE item_pedido (
    id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
) ENGINE=InnoDB;

-- 10. Tabela de Pagamentos
CREATE TABLE pagamento (
    id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL UNIQUE,
    forma_pagamento ENUM('Cartao_Credito', 'Pix', 'Boleto') NOT NULL,
    status_pagamento ENUM('Aprovado', 'Pendente', 'Recusado') DEFAULT 'Pendente',
    data_pagamento DATETIME DEFAULT CURRENT_TIMESTAMP,
    valor_pago DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido) ON DELETE CASCADE
) ENGINE=InnoDB; 

