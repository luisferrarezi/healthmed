CREATE TABLE healthmed.agendamento(
	id_agendamento bigint(20) NOT NULL AUTO_INCREMENT,
	id_agenda bigint(20) NOT NULL,
	id_paciente  bigint(20) NOT NULL,
	confimado_medico tinyint NOT NULL DEFAULT 0,
	confimado_paciente tinyint NOT NULL DEFAULT 0,
	PRIMARY KEY (id_agendamento)
);