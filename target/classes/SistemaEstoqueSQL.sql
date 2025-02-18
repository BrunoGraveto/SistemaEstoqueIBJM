drop database sistema_estoque;

create database sistema_estoque;

use sistema_estoque;

create table endereco (
	id_endereco int primary key not null auto_increment,
    rua_endereco varchar(255),
    bairro_endereco varchar(255),
    num_endereco int,
    cep_endereco varchar(255),
    cidade_endereco varchar(255),
    estado_endereco varchar(255)
);

create table fornecedor (
	id_fornecedor int primary key not null auto_increment,
    status_fornecedor boolean,
    nome_fornecedor varchar(255),
    cnpj_fornecedor varchar(255),
    inscricao_estadual_fornecedor varchar(255),
    cnae_fornecedor varchar(255),
    email_fornecedor varchar(255),
    telefone_fornecedor varchar(255),
    data_cadastro_fornecedor date
);

create table cliente (
	id_cliente int primary key not null auto_increment,
    status_cliente boolean,
    nome_cliente varchar(255),
    cpf_cliente varchar(255) not null,
    rg_cliente varchar(255),
    email_cliente varchar(255),
    telefone_cliente varchar(255),
    data_cadastro_cliente date
);

create table produto (
    id_produto int primary key not null auto_increment,
    status_produto boolean,
    marca_produto varchar(255),
    descricao_produto text,
    valor_compra_produto double not null,
    valor_venda_produto double not null,
    categoria_produto varchar(255),
    qtd_minima_produto int,
    qtd_atual_produto int,
    qtd_maxima_produto int,
    unidade_medida_produto varchar(50),
    peso_produto double,
    data_fabricacao_produto date,
    data_validade_produto date,
    data_cadastro_produto date,
    id_fornecedor int,
    foreign key (id_fornecedor) references fornecedor (id_fornecedor)
);

create table pagamento (
	id_pagamento int primary key not null auto_increment,
    descricao_pagamento varchar(255),
    forma_pagamento varchar(255),
    valor_pagamento double
);

create table nota_fiscal (
	num_nf int primary key not null auto_increment,
    status_nf varchar(255),
    observacao_nf varchar(255),
    valor_total_nf double,
    forma_pagamento_nf varchar(255),
    data_cadastro_nf date,
    data_saida_nf date,
    id_cliente int,
    foreign key (id_cliente) references cliente (id_cliente)
);

/*
	Has
*/

create table cliente_has_endereco (
	id_cliente int,
    id_endereco int,
    foreign key (id_cliente) references cliente (id_cliente),
    foreign key (id_endereco) references endereco (id_endereco)
);

create table fornecedor_has_endereco (
	id_fornecedor int,
    id_endereco int,
    foreign key (id_fornecedor) references fornecedor (id_fornecedor),
    foreign key (id_endereco) references endereco (id_endereco)
);

create table produto_has_fornecedor (
	id_produto int,
    id_fornecedor int,
    foreign key (id_produto) references produto (id_produto),
    foreign key (id_fornecedor) references fornecedor (id_fornecedor)
);

create table cliente_has_nf (
	id_cliente int,
    num_nf int,
    foreign key (id_cliente) references cliente (id_cliente),
    foreign key (num_nf) references nota_fiscal (num_nf)
);

create table nf_has_produto (
	num_nf int,
    id_produto int,
    qtd_produto int,
    status_nf boolean,
    foreign key (num_nf) references nota_fiscal (num_nf),
    foreign key (id_produto) references produto (id_produto)
);

/*
	Inserts
*/
-- Inserindo 20 endereços
insert into endereco (rua_endereco, bairro_endereco, num_endereco, cep_endereco, cidade_endereco, estado_endereco) values
('Rua das Flores', 'Centro', 101, '01001-000', 'São Paulo', 'SP'),
('Av. Paulista', 'Bela Vista', 1500, '01310-000', 'São Paulo', 'SP'),
('Rua Amazonas', 'Vila Nova', 222, '88015-400', 'Florianópolis', 'SC'),
('Rua Bahia', 'Centro', 300, '40020-000', 'Salvador', 'BA'),
('Av. Brasil', 'Copacabana', 777, '22010-000', 'Rio de Janeiro', 'RJ'),
('Rua XV de Novembro', 'Centro', 999, '80020-310', 'Curitiba', 'PR'),
('Rua das Acácias', 'Jardins', 456, '01423-040', 'São Paulo', 'SP'),
('Rua das Palmeiras', 'Centro', 111, '11013-100', 'Santos', 'SP'),
('Av. Beira-Mar', 'Praia de Iracema', 888, '60165-120', 'Fortaleza', 'CE'),
('Rua das Laranjeiras', 'Glória', 121, '22240-000', 'Rio de Janeiro', 'RJ'),
('Rua Dom Pedro II', 'Boa Viagem', 50, '51020-390', 'Recife', 'PE'),
('Rua João Pessoa', 'Centro', 350, '97015-000', 'Santa Maria', 'RS'),
('Av. das Torres', 'Chapada', 789, '78048-000', 'Cuiabá', 'MT'),
('Rua Independência', 'Centro', 910, '96200-000', 'Rio Grande', 'RS'),
('Av. Goiás', 'Setor Oeste', 640, '74120-110', 'Goiânia', 'GO'),
('Rua São Jorge', 'Centro', 520, '69900-000', 'Rio Branco', 'AC'),
('Av. Amazonas', 'Centro', 430, '30180-001', 'Belo Horizonte', 'MG'),
('Rua das Hortênsias', 'Gramado', 202, '95670-000', 'Gramado', 'RS'),
('Rua Sete de Setembro', 'Centro', 175, '69005-141', 'Manaus', 'AM'),
('Av. dos Holandeses', 'Calhau', 315, '65071-380', 'São Luís', 'MA');

-- Inserindo 20 clientes
INSERT INTO cliente (status_cliente, nome_cliente, cpf_cliente, rg_cliente, email_cliente, telefone_cliente, data_cadastro_cliente) VALUES
(1, 'João Silva', '123.456.789-00', '12.345.678-9', 'joao@email.com', '(11) 98765-4321', '2025-02-16'),
(1, 'Maria Oliveira', '987.654.321-00', '98.765.432-1', 'maria@email.com', '(21) 97654-3210', '2025-02-16'),
(1, 'Carlos Souza', '456.789.123-00', '45.678.912-3', 'carlos@email.com', '(31) 96543-2109', '2025-02-16'),
(1, 'Ana Pereira', '789.123.456-00', '78.912.345-6', 'ana@email.com', '(41) 95432-1098', '2025-02-16'),
(1, 'Pedro Santos', '321.654.987-00', '32.165.498-7', 'pedro@email.com', '(51) 94321-0987', '2025-02-16'),
(1, 'Fernanda Lima', '159.357.486-00', '15.935.748-2', 'fernanda@email.com', '(61) 93210-9876', '2025-02-16'),
(1, 'Ricardo Alves', '753.951.852-00', '75.395.185-4', 'ricardo@email.com', '(71) 92109-8765', '2025-02-16'),
(1, 'Juliana Costa', '852.741.963-00', '85.274.196-8', 'juliana@email.com', '(81) 91098-7654', '2025-02-16'),
(1, 'Gustavo Rocha', '369.258.147-00', '36.925.814-5', 'gustavo@email.com', '(91) 90987-6543', '2025-02-16'),
(1, 'Patrícia Mendes', '258.147.369-00', '25.814.736-9', 'patricia@email.com', '(31) 89876-5432', '2025-02-16'),
(1, 'Leonardo Batista', '741.852.963-00', '74.185.296-3', 'leonardo@email.com', '(48) 88765-4321', '2025-02-16'),
(1, 'Camila Nunes', '951.753.852-00', '95.175.385-6', 'camila@email.com', '(47) 87654-3210', '2025-02-16'),
(1, 'Eduardo Ferreira', '753.159.852-00', '75.315.985-2', 'eduardo@email.com', '(46) 86543-2109', '2025-02-16'),
(1, 'Tatiane Lopes', '456.123.789-00', '45.612.378-7', 'tatiane@email.com', '(45) 85432-1098', '2025-02-16'),
(1, 'Rodrigo Martins', '852.369.147-00', '85.236.914-1', 'rodrigo@email.com', '(44) 84321-0987', '2025-02-16'),
(1, 'Beatriz Faria', '159.753.456-00', '15.975.345-9', 'beatriz@email.com', '(43) 83210-9876', '2025-02-16'),
(1, 'Vinícius Moreira', '357.852.159-00', '35.785.215-4', 'vinicius@email.com', '(42) 82109-8765', '2025-02-16'),
(1, 'Larissa Couto', '258.963.741-00', '25.896.374-5', 'larissa@email.com', '(41) 81098-7654', '2025-02-16'),
(1, 'Bruno Mendes', '369.741.258-00', '36.974.125-7', 'bruno@email.com', '(40) 80987-6543', '2025-02-16'),
(1, 'Nathalia Ribeiro', '147.258.369-00', '14.725.836-8', 'nathalia@email.com', '(39) 79876-5432', '2025-02-16');

-- Associando os clientes aos endereços
insert into cliente_has_endereco (id_cliente, id_endereco) values
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
(11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
(16, 16), (17, 17), (18, 18), (19, 19), (20, 20);

-- Inserindo 20 fornecedores
insert into fornecedor (status_fornecedor, nome_fornecedor, cnpj_fornecedor, inscricao_estadual_fornecedor, cnae_fornecedor, email_fornecedor, telefone_fornecedor, data_cadastro_fornecedor) values
(1, 'Petrobras Distribuidora', '00.000.000/0001-91', '123456789', '4731-8/00', 'contato@petrobras.com', '(21) 99999-1001', '2024-01-10'),
(1, 'Ipiranga Combustíveis', '11.111.111/0001-82', '234567890', '4731-8/00', 'contato@ipiranga.com', '(11) 98888-1002', '2024-01-11'),
(1, 'Shell Brasil', '22.222.222/0001-73', '345678901', '4731-8/00', 'contato@shell.com', '(31) 97777-1003', '2024-01-12'),
(1, 'Texaco Lubrificantes', '33.333.333/0001-64', '456789012', '4731-8/00', 'contato@texaco.com', '(41) 96666-1004', '2024-01-13'),
(1, 'ALE Combustíveis', '44.444.444/0001-55', '567890123', '4731-8/00', 'contato@ale.com', '(51) 95555-1005', '2024-01-14'),
(1, 'BR Lubrificantes', '55.555.555/0001-46', '678901234', '4731-8/00', 'contato@brlub.com', '(61) 94444-1006', '2024-01-15'),
(1, 'TotalEnergies', '66.666.666/0001-37', '789012345', '4731-8/00', 'contato@total.com', '(71) 93333-1007', '2024-01-16'),
(1, 'Raízen', '77.777.777/0001-28', '890123456', '4731-8/00', 'contato@raizen.com', '(81) 92222-1008', '2024-01-17'),
(1, 'Vibra Energia', '88.888.888/0001-19', '901234567', '4731-8/00', 'contato@vibra.com', '(91) 91111-1009', '2024-01-18'),
(1, 'Cosan', '99.999.999/0001-00', '012345678', '4731-8/00', 'contato@cosan.com', '(12) 90000-1010', '2024-01-19'),
(1, 'Acelen', '10.101.010/0001-11', '112345679', '4731-8/00', 'contato@acelen.com', '(13) 99999-1011', '2024-01-20'),
(1, 'Chevron Brasil', '20.202.020/0001-22', '212345679', '4731-8/00', 'contato@chevron.com', '(14) 98888-1012', '2024-01-21'),
(1, 'Esso Brasil', '30.303.030/0001-33', '312345679', '4731-8/00', 'contato@esso.com', '(15) 97777-1013', '2024-01-22'),
(1, 'Supergasbras', '40.404.040/0001-44', '412345679', '4731-8/00', 'contato@supergasbras.com', '(16) 96666-1014', '2024-01-23'),
(1, 'Liquigás', '50.505.050/0001-55', '512345679', '4731-8/00', 'contato@liquigas.com', '(17) 95555-1015', '2024-01-24'),
(1, 'Ultragaz', '60.606.060/0001-66', '612345679', '4731-8/00', 'contato@ultragaz.com', '(18) 94444-1016', '2024-01-25'),
(1, 'Copagaz', '70.707.070/0001-77', '712345679', '4731-8/00', 'contato@copagaz.com', '(19) 93333-1017', '2024-01-26'),
(1, 'Comgás', '80.808.080/0001-88', '812345679', '4731-8/00', 'contato@comgas.com', '(20) 92222-1018', '2024-01-27'),
(1, 'Gasmig', '90.909.090/0001-99', '912345679', '4731-8/00', 'contato@gasmig.com', '(21) 91111-1019', '2024-01-28'),
(1, 'Scania Brasil', '12.121.212/0001-10', '013456789', '4731-8/00', 'contato@scania.com', '(22) 90000-1020', '2024-01-29');

-- Inserindo 20 endereços
insert into endereco (rua_endereco, bairro_endereco, num_endereco, cep_endereco, cidade_endereco, estado_endereco) values
('Av. dos Estados', 'Centro', 101, '01020-000', 'São Paulo', 'SP'),
('Rua do Comércio', 'Vila Industrial', 200, '02030-000', 'São Paulo', 'SP'),
('Rua das Palmeiras', 'Jardim Paulista', 250, '03040-000', 'São Paulo', 'SP'),
('Av. Brasil', 'Vila Progredior', 350, '04050-000', 'São Paulo', 'SP'),
('Rua dos Três Irmãos', 'Parque Novo Mundo', 400, '05060-000', 'São Paulo', 'SP'),
('Rua da Paz', 'Bela Vista', 550, '06070-000', 'São Paulo', 'SP'),
('Av. Paulista', 'Consolação', 1000, '08080-000', 'São Paulo', 'SP'),
('Rua Sete de Setembro', 'Bairro da Luz', 1230, '09090-000', 'São Paulo', 'SP'),
('Rua dos Trabalhadores', 'Vila Andrade', 2000, '10000-000', 'São Paulo', 'SP'),
('Rua Dona Luísa', 'Centro', 3000, '11010-000', 'São Paulo', 'SP'),
('Rua Alexandre Dumas', 'Vila Sonia', 150, '12020-000', 'São Paulo', 'SP'),
('Av. dos Autonomistas', 'Vila Luzita', 200, '13030-000', 'Osasco', 'SP'),
('Rua do Parque', 'Jardim Bela Vista', 250, '14040-000', 'Santo André', 'SP'),
('Rua Nova Era', 'Centro', 300, '15050-000', 'Santo André', 'SP'),
('Rua da Indústria', 'Jardim São João', 350, '16060-000', 'Santo André', 'SP'),
('Av. Rio Branco', 'Vila Itapegica', 400, '17070-000', 'São Bernardo do Campo', 'SP'),
('Rua do Sol', 'Vila Sônia', 450, '18080-000', 'São Bernardo do Campo', 'SP'),
('Rua Albino Francoso', 'Vila Metalúrgica', 500, '19090-000', 'São Bernardo do Campo', 'SP'),
('Rua das Acácias', 'Parque Imperial', 550, '20000-000', 'Diadema', 'SP'),
('Rua dos Lírios', 'Vila Nossa Senhora', 600, '21010-000', 'Diadema', 'SP');


-- Associando os fornecedores aos endereços (começando pelo ID 21)
insert into fornecedor_has_endereco (id_fornecedor, id_endereco) values
(1, 21), (2, 22), (3, 23), (4, 24), (5, 25),
(6, 26), (7, 27), (8, 28), (9, 29), (10, 30),
(11, 31), (12, 32), (13, 33), (14, 34), (15, 35),
(16, 36), (17, 37), (18, 38), (19, 39), (20, 40);	

insert into produto (status_produto, marca_produto, descricao_produto, valor_compra_produto, valor_venda_produto, categoria_produto, qtd_minima_produto, qtd_atual_produto, qtd_maxima_produto, unidade_medida_produto, peso_produto, data_fabricacao_produto, data_validade_produto, data_cadastro_produto, id_fornecedor) values
(1, 'petrobras', 'gasolina comum', 4.50, 5.50, 'combustível', 500, 1000, 2000, 'litros', 0.0, '2024-01-01', '2025-01-01', '2024-02-01', 1),
(1, 'ipiranga', 'gasolina aditivada', 4.70, 5.70, 'combustível', 400, 800, 1600, 'litros', 0.0, '2024-01-02', '2025-01-02', '2024-02-02', 2),
(1, 'shell', 'gasolina premium', 5.00, 6.00, 'combustível', 300, 600, 1200, 'litros', 0.0, '2024-01-03', '2025-01-03', '2024-02-03', 3),
(1, 'texaco', 'óleo diesel s10', 4.20, 5.20, 'combustível', 600, 1200, 2400, 'litros', 0.0, '2024-01-04', '2025-01-04', '2024-02-04', 4),
(1, 'ale', 'óleo diesel comum', 4.00, 5.00, 'combustível', 700, 1400, 2800, 'litros', 0.0, '2024-01-05', '2025-01-05', '2024-02-05', 5),
(1, 'br', 'etanol', 3.50, 4.50, 'combustível', 500, 1000, 2000, 'litros', 0.0, '2024-01-06', '2025-01-06', '2024-02-06', 6),
(1, 'totalenergies', 'óleo lubrificante 1l', 15.00, 25.00, 'lubrificante', 50, 100, 200, 'litros', 1.0, '2024-01-07', '2025-01-07', '2024-02-07', 7),
(1, 'raízen', 'fluido de freio', 10.00, 18.00, 'lubrificante', 30, 60, 120, 'litros', 0.5, '2024-01-08', '2025-01-08', '2024-02-08', 8),
(1, 'vibra', 'graxa automotiva', 8.00, 15.00, 'lubrificante', 40, 80, 160, 'quilos', 0.3, '2024-01-09', '2025-01-09', '2024-02-09', 9),
(1, 'cosan', 'aditivo para radiador', 12.00, 20.00, 'aditivo', 20, 40, 80, 'litros', 0.6, '2024-01-10', '2025-01-10', '2024-02-10', 10),
(1, 'acelen', 'óleo de motor 5w30', 20.00, 35.00, 'lubrificante', 25, 50, 100, 'litros', 1.2, '2024-01-11', '2025-01-11', '2024-02-11', 11),
(1, 'chevron', 'óleo de motor 10w40', 18.00, 32.00, 'lubrificante', 30, 60, 120, 'litros', 1.1, '2024-01-12', '2025-01-12', '2024-02-12', 12),
(1, 'esso', 'aditivo para diesel', 14.00, 22.00, 'aditivo', 35, 70, 140, 'litros', 0.8, '2024-01-13', '2025-01-13', '2024-02-13', 13),
(1, 'supergasbras', 'gás glp', 100.00, 130.00, 'gás', 10, 20, 40, 'quilos', 13.0, '2024-01-14', '2025-01-14', '2024-02-14', 14),
(1, 'liquigás', 'gás natural', 80.00, 110.00, 'gás', 15, 30, 60, 'quilos', 10.0, '2024-01-15', '2025-01-15', '2024-02-15', 15),
(1, 'ultragaz', 'glp residencial', 90.00, 120.00, 'gás', 12, 24, 48, 'quilos', 11.0, '2024-01-16', '2025-01-16', '2024-02-16', 16),
(1, 'copagaz', 'glp industrial', 110.00, 140.00, 'gás', 8, 16, 32, 'quilos', 15.0, '2024-01-17', '2025-01-17', '2024-02-17', 17),
(1, 'comgás', 'gnv', 60.00, 85.00, 'gás', 20, 40, 80, 'quilos', 9.0, '2024-01-18', '2025-01-18', '2024-02-18', 18),
(1, 'gasmig', 'glp veicular', 70.00, 95.00, 'gás', 18, 36, 72, 'quilos', 10.5, '2024-01-19', '2025-01-19', '2024-02-19', 19),
(1, 'scania', 'lubrificante industrial', 50.00, 75.00, 'lubrificante', 5, 10, 20, 'litros', 2.0, '2024-01-20', '2025-01-20', '2024-02-20', 20);

-- associação de produtos com fornecedores
insert into produto_has_fornecedor (id_produto, id_fornecedor) values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20);

-- Inserindo 20 notas fiscais
INSERT INTO nota_fiscal (status_nf, observacao_nf, valor_total_nf, forma_pagamento_nf, data_cadastro_nf, data_saida_nf, id_cliente) VALUES
('Ativo', 'Compra de combustíveis', 150.00, 'Cartão de Crédito', '2025-02-16', '2025-02-16', 1),
('Inativo', 'Lubrificantes automotivos', 300.00, 'Boleto', '2025-02-16', '2025-02-16', 2),
('Ativo', 'Compra de diesel', 500.00, 'PIX', '2025-02-16', '2025-02-16', 3),
('Finalizado', 'Óleo e aditivos', 250.00, 'Dinheiro', '2025-02-16', '2025-02-16', 4),
('Ativo', 'Troca de óleo', 180.00, 'Cartão de Débito', '2025-02-16', '2025-02-16', 5),
('Ativo', 'Compra de gasolina', 400.00, 'Cartão de Crédito', '2025-02-16', '2025-02-16', 6),
('Inativo', 'Aditivos especiais', 220.00, 'PIX', '2025-02-16', '2025-02-16', 7),
('Ativo', 'Diesel S10', 600.00, 'Dinheiro', '2025-02-16', '2025-02-16', 8),
('Finalizado', 'Gasolina aditivada', 450.00, 'Cartão de Débito', '2025-02-16', '2025-02-16', 9),
('Ativo', 'Lubrificantes sintéticos', 320.00, 'Boleto', '2025-02-16', '2025-02-16', 10),
('Ativo', 'Compra de querosene', 280.00, 'Cartão de Crédito', '2025-02-16', '2025-02-16', 11),
('Inativo', 'Óleo de motor', 190.00, 'PIX', '2025-02-16', '2025-02-16', 12),
('Ativo', 'Kit de manutenção', 360.00, 'Dinheiro', '2025-02-16', '2025-02-16', 13),
('Finalizado', 'Compra de etanol', 310.00, 'Boleto', '2025-02-16', '2025-02-16', 14),
('Ativo', 'Produtos automotivos', 500.00, 'Cartão de Crédito', '2025-02-16', '2025-02-16', 15),
('Ativo', 'Gasolina comum', 290.00, 'PIX', '2025-02-16', '2025-02-16', 16),
('Inativo', 'Óleo sintético', 275.00, 'Dinheiro', '2025-02-16', '2025-02-16', 17),
('Ativo', 'Combustível premium', 620.00, 'Cartão de Débito', '2025-02-16', '2025-02-16', 18),
('Finalizado', 'Diesel comum', 510.00, 'Boleto', '2025-02-16', '2025-02-16', 19),
('Ativo', 'Aditivos e fluidos', 200.00, 'PIX', '2025-02-16', '2025-02-16', 20);

-- Inserindo produtos nas notas fiscais
INSERT INTO nf_has_produto (num_nf, id_produto, qtd_produto, status_nf) VALUES
(1, 1, 2, true), (1, 2, 1, true),
(2, 3, 3, false), (2, 4, 2, false),
(3, 5, 1, true), (3, 6, 4, true),
(4, 7, 2, true), (4, 8, 1, true),
(5, 9, 2, true), (5, 10, 3, true),
(6, 11, 1, true), (6, 12, 2, true),
(7, 13, 3, false), (7, 14, 1, false),
(8, 15, 2, true), (8, 16, 4, true),
(9, 17, 1, true), (9, 18, 3, true),
(10, 19, 2, true), (10, 20, 1, true),
(11, 1, 4, true), (11, 3, 2, true),
(12, 5, 3, false), (12, 7, 1, false),
(13, 9, 2, true), (13, 11, 2, true),
(14, 13, 1, true), (14, 15, 3, true),
(15, 17, 2, true), (15, 19, 1, true),
(16, 2, 4, false), (16, 4, 3, false),
(17, 6, 2, true), (17, 8, 1, true),
(18, 10, 3, true), (18, 12, 2, true),
(19, 14, 2, true), (19, 16, 1, true),
(20, 18, 4, true), (20, 20, 3, true);



    