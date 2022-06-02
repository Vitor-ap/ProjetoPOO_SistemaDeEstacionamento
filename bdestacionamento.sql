create table estacionamento(
    placa char(7),
    modelo char(20),
    cor char(10),
    data date,
    horaentrada char(02),
    minentrada char(02),
    horasaida char(02),
    minsaida char(02)
    );
    
    create table clientes(
    nome char(30),
    cpf char(11),
    plano char(9),
    adesao date,
    status char(7)
    );
    
    alter table estacionamento modify column placa char(7);
    alter table clientes modify column cpf char(14);