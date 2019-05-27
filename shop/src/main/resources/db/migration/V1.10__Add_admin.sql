CREATE EXTENSION IF NOT EXISTS pgcrypto;
INSERT INTO users (id, first_name, last_name, login, hash_password) values (1, 'ivan', 'abramov', 'ivan', '123');
UPDATE users SET hash_password = crypt(hash_password, gen_salt('bf'));
SELECT setval('users_seq', 1);