insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into formapagamento (descricao) values ('Cartao');
insert into formapagamento (descricao) values ('Pix');

insert into permissao (nome, descricao) values ('OK', 'DONE');
insert into permissao (nome, descricao) values ('BLOCK', 'UNDONE');

insert into estado (id, nome) values (1, 'Sao Paulo');
insert into estado (id, nome) values (2, 'Minas Tirith');

insert into cidade (nome, estado_id) values ('Hortolandia', 1)
insert into cidade (nome, estado_id) values ('Campinas', 1)
insert into cidade (nome, estado_id) values ('Gondor', 2)