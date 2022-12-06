insert into tb_cliente (nome, cpf, email, telefone) values ('Elon Twitter Never Ends', '123.123.123-12', 'elon@twitter.com', '(84)1234-1324');
insert into tb_cliente (nome, cpf, email, telefone) values ('Jeff Tesus', '234.234.243-23', 'jeff@gmail.com', '(84)2222-3333');

insert into tb_moto (id, cilindrada, placa, quilometragem, marca, modelo, ano, cliente_id, url_img)
values (11, 150, 'asd-1234', 38000, 'kasinski', 'mirage', 2012, 1,'https://novasmotos.com.br/wp-content/uploads/2021/03/versoes-kasinski-mirage-150.jpg');

insert into tb_moto (id, cilindrada, placa, quilometragem, marca, modelo, ano, cliente_id, url_img)
values (12, 250, 'qwe-4566', 25800, 'yamaha', 'lander', 2019, 2,'https://www.litoralcar.com.br/foto-resize/g/958499/168/yamaha-xtz-250-lander-.--2018-12182117.jpg');

insert into tb_servicos (id, data_fim, data_inicio, valor, moto_id, status_servico, descricao, tipo_servico)
values (7, null , '20210215 08:00:00', 80, 11, 'PENDENTE', 'Limpeza e ajusta do carburador', 'MANUNTENCAO');

insert into tb_servicos (id, data_fim, data_inicio, valor, moto_id, status_servico, descricao, tipo_servico) 
values (8, null , '20210215 08:00:00', 225, 12, 'EM_ANDAMENTO', 'Moto fará revisão dos 25.000km', 'REVISAO');

insert into tb_servicos (id, data_fim, data_inicio, valor, moto_id, status_servico, descricao, tipo_servico) 
values (9, '20210215 15:05:06' , '20210215 08:00:00', 80, 11, 'FINALIZADO', 'Revisão dos 35.000km', 'REVISAO');

insert into tb_servicos (id, data_fim, data_inicio, valor, moto_id, status_servico, descricao, tipo_servico) 
values (10, '20210215 09:05:06' , '20210215 08:00:00', 225, 12,'CANCELADO', 'Moto fará revisão dos 25.000km', 'REVISAO');