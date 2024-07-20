CREATE TABLE healthmed.notificacao(
	id_notificacao bigint(20) NOT NULL AUTO_INCREMENT,
	id_autenticacao bigint(20) NOT NULL,
	mensagem varchar(100),	
	PRIMARY KEY (id_notificacao)
);