-- TRANSAÇÕES

SELECT numero, nome, ativo FROM banco ORDER BY numero;

-- Exemplo 1
/* 
  As linhas 6, 7, 8 podem ser executados separadamente
  Para realizar ROLLBACK a transação deve ter sido iniciada BEGIN
*/
BEGIN;
  UPDATE banco SET ativo = FALSE WHERE banco.numero = 0;
ROLLBACK;

-- Exemplo 2

BEGIN;
  SAVEPOINT ponto_salvamento_0;
  UPDATE banco SET ativo = FALSE WHERE banco.numero = 0;
ROLLBACK TO ponto_salvamento_0;
  UPDATE banco SET ativo = FALSE WHERE banco.numero = 0;
COMMIT;