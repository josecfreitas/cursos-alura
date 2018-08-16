CREATE TABLE back_produtos (
  ID int NOT NULL DEFAULT '0',
  nome text  NOT NULL,
  valor text  DEFAULT NULL,
  descricao text  DEFAULT NULL,
  quantidade int DEFAULT NULL
) ;

INSERT INTO back_produtos VALUES (1,'Geladeira','5900.00','Side by Side com gelo na porta',2),(2,'FogÃ£o','950.00','Painel automÃ¡tico e forno elÃ©trico',5),(3,'Microondas','1520.00','Manda SMS quando termina de esquentar',1);

CREATE TABLE migrations (
  migration text NOT NULL,
  batch int NOT NULL
)  ;

INSERT INTO migrations VALUES ('2014_10_12_000000_create_users_table',1),('2014_10_12_100000_create_password_resets_table',1);

CREATE TABLE password_resets (
  email text NOT NULL,
  token text NOT NULL,
  created_at timestamp(0) NOT NULL
)  ;

CREATE INDEX password_resets_email_index ON password_resets (email);
CREATE INDEX password_resets_token_index ON password_resets (token);

CREATE SEQUENCE produtos_seq;

CREATE TABLE produtos (
  id int NOT NULL DEFAULT NEXTVAL ('produtos_seq'),
  nome text DEFAULT NULL,
  valor text DEFAULT NULL,
  descricao text DEFAULT NULL,
  quantidade int DEFAULT NULL,
  PRIMARY KEY (id)
)   ;

ALTER SEQUENCE produtos_seq RESTART WITH 45;

INSERT INTO produtos VALUES (1,'Geladeira','5900.00','Side by Side com gelo na porta',2),(2,'Fogão','950.00','Painel automático e forno elétrico',5),(3,'Microondas','1520.00','Manda SMS quando termina de esquentar',1);


CREATE SEQUENCE users_seq;

CREATE TABLE users (
  id int check (id > 0) NOT NULL DEFAULT NEXTVAL ('users_seq'),
  name text NOT NULL,
  email text NOT NULL,
  password varchar(60) NOT NULL,
  remember_token varchar(100) DEFAULT NULL,
  created_at timestamp(0) NOT NULL,
  updated_at timestamp(0) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT users_email_unique UNIQUE  (email)
)   ;

ALTER SEQUENCE users_seq RESTART WITH 3;
