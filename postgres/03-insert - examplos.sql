-- INSERT exemplos

-- INSERT

INSERT INTO agencia (banco_numero, numero, nome) 
	VALUES (51, 1, 'Agência número 51 do banco Banco do Brasil S.A.');
-- OU
INSERT INTO agencia (banco_numero, numero, nome)
	SELECT 51, 1, 'Agência número 51 do banco Banco do Brasil S.A.';


-- INSERT com IDEMPOTÊNCIA
INSERT INTO agencia (banco_numero, numero, nome)
	SELECT 51, 1, 'Agência número 51 do banco Banco do Brasil S.A.'
	WHERE NOT EXISTS (
		SELECT banco_numero, numero, nome FROM agencia
		WHERE banco_numero = 51 AND numero = 1 AND nome = 'Agência número 51 do banco Banco do Brasil S.A.'
	)
	
-- OU
INSERT INTO agencia (banco_numero, numero, nome)
	VALUES (51, 1, 'Agência número 51 do banco Banco do Brasil S.A.')
 	ON CONFLICT (banco_numero, numero) DO NOTHING; 
	
	-- No 'DO NOTHING' Pode ser substituido por uma atualização de dados;

