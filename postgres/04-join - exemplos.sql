-- JOINs exemplos

-- JOIN or INNER JOIN
/*
  Selectionar dados da interseção das tabela
*/
SELECT nome, numero, SUM(valor) AS total_transacao FROM cliente
  JOIN cliente_transacoes ON cliente_transacoes.cliente_numero = cliente.numero
  GROUP BY nome, numero
  ORDER BY total_transacao;
-- ou
SELECT nome, numero, SUM(valor) AS total_transacao FROM cliente
  INNER JOIN cliente_transacoes ON cliente_transacoes.cliente_numero = cliente.numero
  GROUP BY nome, numero
  ORDER BY total_transacao;



-- LEFT JOIN or LEFT OUTER JOIN
/* 
  Selectionar dados da tabela a esquerda com interseção, se não houver relacionamento retorna NULL
*/
SELECT nome, numero, SUM(valor) AS total_transacao FROM cliente
  LEFT JOIN cliente_transacoes ON cliente_transacoes.cliente_numero = cliente.numero
  GROUP BY nome, numero
  ORDER BY total_transacao;
  
-- RIGHT JOIN or RIGHT OUTER JOIN
/* 
  Selectionar dados da tabela a direita com interseção, se não houver relacionamento retorna NULL
*/
SELECT nome, numero, SUM(valor) AS total_transacao FROM cliente
  RIGHT JOIN cliente_transacoes ON cliente_transacoes.cliente_numero = cliente.numero
  GROUP BY nome, numero
  ORDER BY total_transacao;
  


-- FULL JOIN or FULL OUTER JOIN
/*
  Retorna todas as relações possiveis, (não recomendado - desperdicio de recurso)
*/
SELECT nome, numero, SUM(valor) AS total_transacao FROM cliente
  FULL JOIN cliente_transacoes ON cliente_transacoes.cliente_numero = cliente.numero
   GROUP BY nome, numero
  ORDER BY total_transacao;
  
-- CROS JOIN or 
/*
  Todos os dados de uma tabela serão cruzados com todos os dados da tabela referente criando
  uma matriz.
*/
SELECT nome, numero, valor FROM cliente
  CROSS JOIN cliente_transacoes
  ORDER BY valor;



-- Exemplo

SELECT
  banco.nome AS nome_banco, 
  agencia.nome AS nome_agencia, 
  ccorrente.numero, 
  ccorrente.digito,
  cliente.nome,
  SUM(cliente_transacoes.valor) AS soma_das_transacao
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
ORDER BY soma_das_transacao;
