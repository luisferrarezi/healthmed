INSERT INTO healthmed.medico (crm, nome, especializacao, id_autenticacao)
SELECT 'CRM/SP 123456', 'medico 123456', 0, 1
UNION ALL
SELECT 'CRM/DF 654321', 'medico 654321', 1, 2;