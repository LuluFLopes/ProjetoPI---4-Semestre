-- Usuarios Core

INSERT INTO USUARIO
(CPF,
 GRUPO,
 NOME,
 SENHA,
 STATUS,
 USUARIO)
VALUES ('013.656.400-35',
        0,
        'Luciano',
        '30226b752d6e29785387c9a5ec496e3f2a238c7f72091f19eed8e05b1bb52eab9ca0b19bec16b32eb35de593043665739c81ecf9de1787c8745cecdc57efca00',
        0,
        'luciano@senacsp.edu.br'),
       ('273.660.930-17',
        0,
        'Stevart O Velho',
        'b012e956a68a2098c4127fe6ff87d5a27088445cd67ef1cf4cca131bddaf52e0319af8d2fb5fc0dfe9710f793adb6ad0c9f7dd015fe8c20adb8b65ceae7164a7',
        0,
        'stevart@senacsp.edu.br'),
       ('128.960.250-65',
        1,
        'Vitor',
        'f1bde22e97b2e3d4e454001aec2dfb827f2eed8996d2a6ac7e747b84974e6dd59bf499c19ef12f19b5ffa358dc2e378a7d5f7b7b1439b61dc3fd031cf90cce56',
        0,
        'frenchboy@senacsp.edu.br');


-- Produtos Core
INSERT INTO PRODUTO
(AVALIACAO,
 DETALHES,
 NOME,
 PRECO,
 QUANTIDADE,
 STATUS)
VALUES (7,
        'Descrição do jogo',
        'Resident Evil 1',
        250.00,
        50,
        1),
       (7,
        'Descrição do jogo',
        'Resident Evil 2',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 3',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 4',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 5',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 6',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 7',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 8',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 9',
        250.00,
        50,
        0),
       (7,
        'Descrição do jogo',
        'Resident Evil 10',
        250.00,
        50,
        0);

-- Imagens produtos core

INSERT INTO PRODUTO_URL_IMG
VALUES (1, 'link'),
       (1, 'link'),
       (1, 'link'),
       (1, 'link'),
       (1, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (2, 'link'),
       (2, 'link'),
       (2, 'link'),
       (2, 'link'),
       (2, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (3, 'link'),
       (3, 'link'),
       (3, 'link'),
       (3, 'link'),
       (3, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (4, 'link'),
       (4, 'link'),
       (4, 'link'),
       (4, 'link'),
       (4, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (5, 'link'),
       (5, 'link'),
       (5, 'link'),
       (5, 'link'),
       (5, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (6, 'link'),
       (6, 'link'),
       (6, 'link'),
       (6, 'link'),
       (6, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (7, 'link'),
       (7, 'link'),
       (7, 'link'),
       (7, 'link'),
       (7, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (8, 'link'),
       (8, 'link'),
       (8, 'link'),
       (8, 'link'),
       (8, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (9, 'link'),
       (9, 'link'),
       (9, 'link'),
       (9, 'link'),
       (9, 'link');

INSERT INTO PRODUTO_URL_IMG
VALUES (10, 'link'),
       (10, 'link'),
       (10, 'link'),
       (10, 'link'),
       (10, 'link');