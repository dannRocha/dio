-- VIEW

-- Exemplo 1
CREATE OR REPLACE VIEW vw_bancos_1 AS (
  SELECT 
    banco.nome,
    banco.numero,
    banco.ativo
  FROM banco
);

SELECT nome, numero FROM vw_bancos_1;

-- Exemplo 2
CREATE OR REPLACE VIEW vw_bancos_2 (banco_nome, banco_numero, banco_ativo) AS (
  SELECT 
    banco.nome,
    banco.numero,
    banco.ativo
  FROM banco
);

SELECT banco_nome, banco_numero, banco_ativo FROM vw_bancos_2;

INSERT INTO vw_bancos_2 (banco_nome, banco_numero, banco_ativo) 
  VALUES ('Banco Feliz', 51, TRUE) 
  ON CONFLICT 
  DO NOTHING;
  
SELECT * FROM vw_bancos_2 WHERE banco_numero = 51;

-- Exemplo 3

CREATE OR REPLACE VIEW vw_banco_3 AS (
  SELECT 
    banco.nome,
    banco.numero,
    banco.ativo
  FROM banco
  WHERE banco.ativo IS TRUE -- Ou qualquer condição
) WITH LOCAL CHECK OPTION; -- Ou WITH CASCADED LOCAL CHECK OPTION : onde outras condições de View devem ser validas;

INSERT INTO vw_banco_3 (nome, numero, ativo) VALUES ('Banco Triste', 52,FALSE);
  -- ERROR: new row violates check option for view "vw_banco_3"

