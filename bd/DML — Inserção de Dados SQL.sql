-- 1. Inserir Pessoas de diferentes tipos (Cliente, Funcionário, Fornecedor)
INSERT INTO pessoa (tipo_pessoa, nome, email, senha, cpf_cnpj, telefone) VALUES 
('Cliente', 'Ana Silva', 'ana.silva@email.com', 'hash_senha123', '123.456.789-00', '(11) 98765-4321'),
('Funcionario', 'Carlos Oliveira', 'carlos.vendas@loja.com', 'hash_senha456', '987.654.321-11', '(11) 91234-5678'),
('Fornecedor', 'Confecções Tecidos Brasil LTDA', 'contato@tecidosbrasil.com.br', 'hash_senha789', '12.345.678/0001-99', '(11) 3300-4400');

-- 2. Inserir Endereço para a Cliente (id_pessoa = 1)
INSERT INTO endereco (id_pessoa, cep, rua, numero, complemento, bairro, cidade, estado) VALUES 
(1, '01001-000', 'Praça da Sé', '100', 'Apto 42', 'Centro', 'São Paulo', 'SP');

-- 3. Inserir Categorias
INSERT INTO categoria (nome, descricao) VALUES 
('Camisetas', 'Camisetas casuais, regatas e estampadas'),
('Calças', 'Calças jeans, sarja e moletom'),
('Vestidos', 'Vestidos curtos, médios e longos');

-- 4. Inserir Produtos
INSERT INTO produto (id_categoria, nome, descricao, preco, tamanho, cor, estoque) VALUES 
(1, 'Camiseta Algodão Básica', 'Camiseta 100% algodão super confortável', 49.90, 'M', 'Preto', 50),
(1, 'Camiseta Oversized', 'Modelagem ampla e estilo urbano', 79.90, 'G', 'Branco', 30),
(2, 'Calça Jeans Slim', 'Jeans com elastano para maior conforto', 159.90, 'P', 'Azul Escuro', 20),
(3, 'Vestido Floral Verão', 'Vestido leve de viscose estampada', 129.90, 'M', 'Vermelho', 15);

-- 5. Inserir Carrinho para a Cliente (id_pessoa = 1)
INSERT INTO carrinho (id_pessoa) VALUES (1);

-- 6. Inserir Itens no Carrinho
INSERT INTO item_carrinho (id_carrinho, id_produto, quantidade) VALUES 
(1, 1, 2), -- 2x Camiseta Algodão Básica
(1, 3, 1); -- 1x Calça Jeans Slim

-- 7. Criar Pedido referente à compra da Cliente
INSERT INTO pedido (id_pessoa, id_endereco, status_pedido, valor_total) VALUES 
(1, 1, 'Pago', 259.70);

-- 8. Inserir Itens do Pedido (2x R$49,90 + 1x R$159,90 = R$259,70)
INSERT INTO item_pedido (id_pedido, id_produto, quantidade, preco_unitario) VALUES 
(1, 1, 2, 49.90),
(1, 3, 1, 159.90);

-- 9. Registrar o Pagamento do Pedido
INSERT INTO pagamento (id_pedido, forma_pagamento, status_pagamento, valor_pago) VALUES 
(1, 'Pix', 'Aprovado', 259.70);