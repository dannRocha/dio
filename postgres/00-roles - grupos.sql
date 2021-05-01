-- Criar um grupo/papel com N permisões (por padrão as não há permissões)
CREATE ROLE teacher NOCREATEDB NOCREATEROLE INHERIT NOLOGIN NOBYPASSRLS CONNECTION LIMIT 10;
-- Criar um grupo/papel com permissões de login
CREATE ROLE daniel LOGIN PASSWORD '123';
-- Remove a role daniel;
DROP ROLE daniel;
-- Recriar a role daniel, mas como um membro da role teacher
CREATE ROLE daniel LOGIN PASSWORD '123' IN ROLE teacher;
-- Remove daniel do role teacher
REVOKE teacher FROM daniel;
-- Adiciona daniel do role teacher
GRANT teacher TO daniel;
