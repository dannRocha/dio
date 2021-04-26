-- Criar um grupo/papel com N permisões (por padrão as não há permissões)
create role teacher nocreatedb nocreaterole inherit nologin nobypassrls connection limit 10;
-- Criar um grupo/papel com permissões de login
create role daniel login password '123';
-- Remove a role daniel;
drop role daniel;
-- Recriar a role daniel, mas como um membro da role teacher
create role daniel login password '123' in role teacher;
-- Remove daniel do role teacher
revoke teacher from daniel;
-- Adiciona daniel do role teacher
grant teacher to daniel;

