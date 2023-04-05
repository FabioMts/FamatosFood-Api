insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Japonesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into forma_pagamento (id, descricao) values (1, 'Cartao');
insert into forma_pagamento (id, descricao) values (2, 'Pix');

insert into permissao (nome, descricao) values ('OK', 'DONE');
insert into permissao (nome, descricao) values ('BLOCK', 'UNDONE');

insert into estado (id, nome) values (1, 'Sao Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');

insert into cidade (nome, estado_id) values ('Hortolandia', 1)
insert into cidade (nome, estado_id) values ('Campinas', 1)
insert into cidade (nome, estado_id) values ('Gondor', 2)