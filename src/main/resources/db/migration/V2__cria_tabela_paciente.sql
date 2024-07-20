CREATE TABLE healthmed.paciente(
    id_paciente bigint(20) NOT NULL AUTO_INCREMENT,
	cpf varchar(11) NOT NULL,
	email varchar(60) NOT NULL,
	nome varchar(60) NOT NULL,
	id_autenticacao bigint(20) NOT NULL,
	PRIMARY KEY (id_paciente)		
);