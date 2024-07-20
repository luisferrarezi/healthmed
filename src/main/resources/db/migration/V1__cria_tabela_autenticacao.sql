CREATE TABLE healthmed.autenticacao(
    id_autenticacao bigint(20) NOT NULL AUTO_INCREMENT,
	login varchar(30) NOT NULL,
	senha varchar(60) NOT NULL,
    logado tinyint NOT NULL DEFAULT 0,
	PRIMARY KEY (id_autenticacao)		
);