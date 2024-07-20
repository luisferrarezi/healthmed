INSERT INTO healthmed.paciente (cpf, email, nome, id_autenticacao)
SELECT '10987654321', 'teste@teste.com', 'paciente email', 3
UNION ALL
SELECT '12345678901', 'email@email.com', 'paciente cpf', 4;