
-- Exemplo de SELECTs - Limitado a 3 Dados;

-- Verificar Schema do banco
SELECT * FROM information_schema.columns;

--- Verificar Campos da tabela
SELECT column_name, data_type FROM information_schema.columns WHERE table_name = 'cliente_transacoes';

-- SELECT
SELECT numero, nome, email FROM cliente LIMIT 3;

-- SELECT com WHERE
SELECT numero, nome, email FROM cliente WHERE ativo is TRUE LIMIT 3;

/*
Condições WHERE / AND / OR
  WHERE (coluna/condicao):
    * =
    * > | >=
    * < | <=
    * <> | !=
    * LIKE
    * ILIKE
    * IN
*/

-- SELECT com LIKE com case Sensitive
SELECT numero, nome, email FROM cliente WHERE email LIKE '%gmail.com' LIMIT 3;


-- SELECT com LIKE sem case Sensitive
SELECT numero, nome, email FROM cliente WHERE email ILIKE '%gmail.com' LIMIT 3;


-- SELECT com mais condições
SELECT nome, email FROM cliente 
  WHERE numero IN (SELECT numero FROM banco WHERE nome ILIKE '%Bradesco%' LIMIT 3);


/*
  FUNÇÕES AGREGADAS 

  AVG - Media
  COUNT
  MAX
  MIN
  SUM

  EXTRA:
    * ORDER BY
    * HAVING
  
  EX:
    SELECT AVG(campo) FROM db;

  
*/

-- AVG
  SELECT AVG(valor) FROM cliente_transacoes;


-- COUNT
  SELECT COUNT(valor) FROM cliente_transacoes;
  
  SELECT COUNT(numero), email FROM cliente
    WHERE email ILIKE '%gmail.com'
    GROUP BY email;

  SELECT COUNT(valor), cliente_numero FROM cliente_transacoes
    GROUP BY cliente_numero
    HAVING COUNT(valor) > 5;
  
  SELECT COUNT(valor), cliente_numero FROM cliente_transacoes
    GROUP BY cliente_numero
    HAVING COUNT(valor) > 5
    ORDER BY cliente_numero ASC;


  SELECT COUNT(valor), cliente_numero FROM cliente_transacoes
    GROUP BY cliente_numero
    HAVING COUNT(valor) > 5
    ORDER BY  cliente_numero DESC;


-- MAX
  SELECT MAX(valor) FROM cliente_transacoes;
  
  SELECT MAX(valor), cliente_numero FROM cliente_transacoes
    GROUP BY cliente_numero LIMIT 3;


-- MIN
  SELECT MIN(valor) FROM cliente_transacoes;
  
  SELECT MIN(valor), cliente_numero FROM cliente_transacoes
    GROUP BY cliente_numero LIMIT 3;


-- SUM
  SELECT SUM(valor) FROM cliente_transacoes;


-- SELECT com PAGINAÇÃO

/*
Sintaxe
SELECT  
  tabela.campo1, tabela.campo2, tabela.campo3
FROM tabela  
  LIMIT {quantidade maxima de registros } 
  OFFSET {quantidade maxima de registros }  * ( {numero da pagina} - 1);
*/

-- Exemplo 1
SELECT  
  cliente.numero, cliente.nome, cliente.data_criacao
FROM cliente  
  LIMIT 2 
  OFFSET 2 * (3 - 1);


-- Exemplo 2 - Com ordernação
SELECT  
  cliente.numero, cliente.nome, cliente.data_criacao
FROM cliente 
  ORDER BY cliente.numero DESC 
  LIMIT 2 
  OFFSET 2 * (3 - 1);
  
