CREATE TABLE healthmed.agenda(
	id_agenda bigint(20) NOT NULL AUTO_INCREMENT,
	id_medico bigint(20) NOT NULL,
	data varchar(10) NOT NULL,
	hora varchar(5) NOT NULL,
	PRIMARY KEY (id_agenda)
);