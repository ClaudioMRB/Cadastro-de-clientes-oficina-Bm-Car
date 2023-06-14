INSERT INTO tb_cliente(nome, cpf, email, senha) VALUES ('Claudio', '12245636590', 'claudiomarcio4062@hotmail.com', '4569856');
INSERT INTO tb_cliente(nome, cpf, email, senha) VALUES ('Pablo', '18746985680', 'pablo@gmail.com', '82541236');

INSERT INTO tb_endereco(rua, numero, bairro, cidade, uf, pais, cliente_id)VALUES ('Av. dos Expedicionarios', 250, 'Jardim Camburi', 'Vitória', 'ES', 'Brasil', 1);
INSERT INTO tb_endereco(rua, numero, bairro, cidade, uf, pais, cliente_id)VALUES ('Rua Paulo de Vasconcelos', 469, 'Jabour', 'Vitória', 'ES', 'Brasil', 2);

INSERT INTO tb_veiculo(carro, cor, cc, ano, fabricante, cliente_id) values ('Corsa Wind EFI', 'Prata', 1000, '1995', 'Opel', 1);
INSERT INTO tb_veiculo(carro, cor, cc, ano, fabricante, cliente_id) values ('Escort Hobby', 'Preto', 1600, '1997', 'Ford', 2);