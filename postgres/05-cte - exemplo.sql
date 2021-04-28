
-- CTE - Common Table Expression

/*
  Utilizando o exemplo do arquivo 04-join - exemplos.sql
*/

WITH armazenamento AS ( 
  SELECT
    banco.nome AS nome_banco, 
    agencia.nome AS nome_agencia, 
    ccorrente.numero, 
    ccorrente.digito,
    cliente.nome,	
    SUM(cliente_transacoes.valor) AS soma_das_transacoes
  FROM banco
  JOIN agencia 
    ON agencia.banco_numero = banco.numero
  JOIN ccorrente 
    ON ccorrente.banco_numero = banco.numero
    AND ccorrente.agencia_numero = agencia.numero
  JOIN cliente
    ON cliente.numero = ccorrente.cliente_numero
  JOIN cliente_transacoes
    ON cliente_transacoes.cliente_numero = cliente.numero
  GROUP BY
    nome_banco, 
    nome_agencia, 
    ccorrente.numero, 
    ccorrente.digito,
    cliente.nome
  ORDER BY soma_das_transacoes
)

SELECT nome, soma_das_transacoes FROM armazenamento;
