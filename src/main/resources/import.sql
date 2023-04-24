insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Japonesa');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (nome, estado_id) values ('Uberlândia', 1)
insert into cidade (nome, estado_id) values ('Belo Horizonte', 1)
insert into cidade (nome, estado_id) values ('São Paulo', 2)
insert into cidade (nome, estado_id) values ('Campinas', 2)
insert into cidade (nome, estado_id) values ('Fortaleza', 3)

insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1, 'Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (2, 'Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values (3, 'Tuk Tuk Comida Indiana', 15, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (id, descricao) values (1, 'Cartao de crédito');
insert into forma_pagamento (id, descricao) values (2, 'Cartao de débito');
insert into forma_pagamento (id, descricao) values (3, 'Pix');

insert into permissao (nome, descricao) values ('OK', 'DONE');
insert into permissao (nome, descricao) values ('BLOCK', 'UNDONE');

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);