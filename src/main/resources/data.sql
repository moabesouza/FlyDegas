--------------------------TABELA AEROPORTO----------------------------
INSERT INTO AEROPORTO (nome, cidade, pais)
VALUES
('Aeroporto de Guarulhos', 'São Paulo', 'Brasil'),
('Aeroporto de Congonhas', 'São Paulo', 'Brasil'),
('Aeroporto Internacional do Rio de Janeiro', 'Rio de Janeiro', 'Brasil'),
('Aeroporto Internacional de Nova Iorque', 'Nova Iorque', 'Estados Unidos'),
('Aeroporto de Frankfurt', 'Frankfurt', 'Alemanha'),
('Aeroporto Internacional de Dubai', 'Dubai', 'Emirados Árabes Unidos');

--------------------------TABELA AVIÃO----------------------------
INSERT INTO AVIAO (prefixo, modelo, ano, autonomia, num_Passageiros)
VALUES
('AA001', 'Boeing 747', 2021, 9000, 500),
('BB002', 'Airbus A320', 2020, 5500, 200),
('CC003', 'Boeing 737', 2019, 6000, 180),
('DD004', 'Embraer E195-E2', 2021, 3500, 120),
('EE005', 'Airbus A350', 2022, 8000, 450),
('FF006', 'Boeing 787 Dreamliner', 2021, 10000, 350);

--------------------------TABELA PILOTO----------------------------
INSERT INTO PILOTO (nome, numero_licenca, idade, ano_experiencia)
VALUES
('Lucas Silva', '123456', 30, 8),
('Ana Souza', '654321', 28, 6),
('Fernando Torres', '987654', 35, 12),
('Camila Oliveira', '456789', 29, 5),
('João Paulo', '456123', 33, 10),
('Mariana Silva', '789456', 27, 3);

--------------------------TABELA AGENDA----------------------------
INSERT INTO AGENDA (data, piloto_id)
VALUES
    ('2023-03-01', 1),
    ('2023-03-02', 1),
    ('2023-03-03', 2),
    ('2023-03-04', 2),
    ('2023-03-05', 3),
    ('2023-03-06', 3);

--------------------------TABELA VOO----------------------------
INSERT INTO VOO (aviao_id, aeroporto_saida_id, aeroporto_chegada_id, data, hora_saida, hora_chegada)
VALUES
(1, 1, 2, '2023-02-20', '10:30:00', '15:45:00'),
(2, 3, 4, '2023-02-22', '08:20:00', '11:10:00'),
(3, 2, 1, '2023-02-24', '15:30:00', '19:10:00'),
(4, 4, 3, '2023-02-26', '11:40:00', '13:25:00'),
(5, 2, 4, '2023-03-01', '13:10:00', '19:55:00'),
(6, 3, 1, '2023-03-03', '06:50:00', '09:30:00');

--------------------------TABELA PASSAGEIRO----------------------------
INSERT INTO PASSAGEIRO (nome)
VALUES
('João Silva'),
('Maria Souza'),
('Carlos Santos'),
('Ana Oliveira'),
('Pedro Almeida'),
('Luciana Pereira');

--------------------------TABELA VIAGEM----------------------------
INSERT INTO VIAGEM (agenda_id, voo_id, passageiro_id)
VALUES
    (1, 1, 1),
    (1, 1, 2),
    (1, 2, 3),
    (2, 2, 4),
    (2, 3, 5),
    (3, 4, 6);
