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
        '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',
        0,
        'luciano@senacsp.edu.br'),
       ('273.660.930-17',
        1,
        'Stevart O Velho',
        '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',
        0,
        'stevart@senacsp.edu.br'),
       ('128.960.250-65',
        1,
        'Vitor',
        '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',
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

INSERT INTO ENDERECO_ENTREGA(
    LOGRADOURO,
    NUMERO,
    COMPLEMENTO,
    CIDADE,
    BAIRRO,
    UF,
    CEP,
    TIPO_ENDERECO
)
VALUES (
           'Rua teste 1',
           1,
           'Bloco 1',
           'Teste 1',
           'Teste 1',
           'TS1',
           'Cep 11111-111',
           0
       ),
       (
           'Rua teste 2',
           2,
           'Bloco 2',
           'Teste 2',
           'Teste 2',
           'TS2',
           'Cep 22222-222',
           1
       ),
       (
           'Rua teste 3',
           3,
           'Bloco 3',
           'Teste 3',
           'Teste 3',
           'TS3',
           'Cep 33333-333',
           1
       );

INSERT INTO ENDERECO_FATURAMENTO (
    LOGRADOURO,
    NUMERO,
    COMPLEMENTO,
    CIDADE,
    BAIRRO,
    UF,
    CEP
)
VALUES (
        'Rua teste 1',
        1,
        'Bloco 1',
        'Teste 1',
        'Teste 1',
        'TS1',
        'Cep 11111-111'
       );

INSERT INTO CLIENTE (
    CPF,
    DATA_NASCIMENTO,
    GENERO,
    NOME,
    SENHA,
    USUARIO,
    ENDERECO_FATURAMENTO_ID
)
VALUES (
           '777.777.777-77',
           '1994-01-11 18:47:52.069',
           'Masculino',
           'Igor',
           '3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2',
           'igor@gmail.com',
           1
       );

INSERT INTO CLIENTE_ENDERECO_ENTREGA (
    CLIENTE_ID,
    ENDERECO_ENTREGA_ID
)
VALUES(1,1),
      (1,2),
      (1,3);