CREATE TABLE healthmed.medico(
    id_medico bigint(20) NOT NULL AUTO_INCREMENT,
	crm varchar(13) NOT NULL,
	nome varchar(60) NOT NULL,
	avaliacao tinyint NOT NULL DEFAULT 0,
	especializacao tinyint NOT NULL DEFAULT 0,	
	id_autenticacao bigint(20) NOT NULL,	
	PRIMARY KEY (id_medico)		
);