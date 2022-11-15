insert into tb_cliente (id, nome, cpf, email, telefone) values (1, 'Elon Twitter Never Ends', '123.123.123-12', 'elon@twitter.com', '(84)1234-1324');
insert into tb_cliente (id, nome, cpf, email, telefone) values (2, 'Jeff Tesus', '234.234.243-23', 'jeff@gmail.com', '(84)2222-3333');

insert into tb_moto (id, cilindrada, placa, quilometragem, modelo) values (1, 150, 'asd-1234', 38000, 'mirage');
insert into tb_moto (id, cilindrada, placa, quilometragem, modelo) values (2, 250, 'qwe-4566', 25800, 'lander');

insert into tb_servicos (id, data_fim, data_inicio, valor, cliente_id, moto_id, status_servico, descricao, tipo_servico) 
values (1, '20210215 15:05:06' , '20210215 08:00:00', 80, 1, 1, 'PENDENTE', 'Limpeza e ajusta do carburador', 'MANUNTENCAO');

insert into tb_servicos (id, data_fim, data_inicio, valor, cliente_id, moto_id, status_servico, descricao, tipo_servico) 
values (2, '20210215 09:05:06' , '20210215 08:00:00', 225, 2, 2, 'PENDENTE', 'Moto fará revisão dos 25.000km', 'REVISAO');