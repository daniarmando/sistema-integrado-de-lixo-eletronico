CREATE TABLE pessoa(
id_pessoa SERIAL NOT NULL,
tipo_pessoa VARCHAR(8) NOT NULL,
nome_razao_pessoa VARCHAR(80) NOT NULL,
cpf_cnpj_pessoa VARCHAR(18) NOT NULL,
rg_ie_pessoa VARCHAR(15) NOT NULL,
telefone_pessoa CHAR(14) NOT NULL,
rua_pessoa VARCHAR(100) NOT NULL,
numero_pessoa VARCHAR(10) NOT NULL,
complemento_pessoa VARCHAR(100),
bairro_pessoa VARCHAR(80) NOT NULL,
cidade_pessoa VARCHAR(80),
estado_pessoa CHAR(2) NOT NULL,
cep_pessoa VARCHAR(10) NOT NULL,
email_pessoa VARCHAR(50) NOT NULL,
login_pessoa VARCHAR(20) NOT NULL,
senha_pessoa VARCHAR(20) NOT NULL,
ator_pessoa CHAR(1) NOT NULL,
CONSTRAINT pk_pessoa PRIMARY KEY(id_pessoa),
CONSTRAINT ck_pessoa_tipo_pessoa CHECK(tipo_pessoa in ('fisica', 'juridica')),
CONSTRAINT ck_pessoa_ator_pessoa CHECK(ator_pessoa in ('S', 'R', 'B'))
);

CREATE TABLE tipo_coleta(
id_tipo_coleta SERIAL NOT NULL,
nome_tipo_coleta VARCHAR(15) NOT NULL,
CONSTRAINT pk_tipo_coleta PRIMARY KEY(id_tipo_coleta),
CONSTRAINT ck_tipo_coleta_atendimento CHECK(nome_tipo_coleta in ('recebe', 'busca', 'recebe e busca' ))
);

CREATE TABLE receptor(
id_receptor SERIAL NOT NULL,
id_pessoa INTEGER NOT NULL,
site_receptor VARCHAR(60),
id_tipo_coleta INTEGER NOT NULL,
CONSTRAINT pk_receptor PRIMARY KEY(id_receptor),
CONSTRAINT fk_receptor_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa),
CONSTRAINT fk_receptor_tipo_coleta FOREIGN KEY (id_tipo_coleta) REFERENCES tipo_coleta (id_tipo_coleta)
);

CREATE TABLE colaborador(
id_colaborador SERIAL NOT NULL,
nome_colaborador VARCHAR(80) NOT NULL,
funcao_colaborador VARCHAR(60) NOT NULL,
login_colaborador VARCHAR(20) NOT NULL,
senha_colaborador VARCHAR(20) NOT NULL,
id_receptor INTEGER NOT NULL,
ator_colaborador CHAR(1) NOT NULL,
CONSTRAINT pk_colaborador PRIMARY KEY(id_colaborador),
CONSTRAINT fk_colaborador_receptor FOREIGN KEY(id_receptor) REFERENCES receptor (id_receptor),
CONSTRAINT ck_colaborador_ator_colaborador CHECK(ator_colaborador in ('C')),
CONSTRAINT un_colaborador UNIQUE(login_colaborador, senha_colaborador)
);

CREATE TABLE beneficiario(
id_beneficiario SERIAL NOT NULL,
id_pessoa INTEGER NOT NULL,
id_receptor INTEGER NOT NULL,
CONSTRAINT pk_beneficiario PRIMARY KEY(id_beneficiario),
CONSTRAINT fk_beneficiario_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa),
CONSTRAINT fk_beneficiario_receptor FOREIGN KEY(id_receptor) REFERENCES receptor (id_receptor)
);

CREATE TABLE solicitante(
id_solicitante SERIAL NOT NULL,
id_pessoa INTEGER NOT NULL,
CONSTRAINT pk_solicitante PRIMARY KEY(id_solicitante),
CONSTRAINT fk_solicitante_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa)
);

CREATE TABLE pontocoleta(
id_pontocoleta SERIAL NOT NULL,
nome_pontocoleta VARCHAR(80) NOT NULL,
telefone_pontocoleta CHAR(14) NOT NULL,
rua_pontocoleta VARCHAR(100) NOT NULL,
numero_pontocoleta VARCHAR(10) NOT NULL,
bairro_pontocoleta VARCHAR(80) NOT NULL,
complemento_pontocoleta VARCHAR(100),
cidade_pontocoleta VARCHAR(80) NOT NULL,
estado_pontocoleta CHAR(2) NOT NULL,
cep_pontocoleta VARCHAR(10) NOT NULL,
id_receptor INTEGER NOT NULL,
CONSTRAINT pk_pontocoleta PRIMARY KEY(id_pontocoleta),
CONSTRAINT fk_pontocoleta_receptor FOREIGN KEY(id_receptor) REFERENCES receptor (id_receptor),
CONSTRAINT un_pontocoleta UNIQUE(nome_pontocoleta)
);

CREATE TABLE categoria(
id_categoria SERIAL NOT NULL,
nome_categoria VARCHAR(60) NOT NULL,
CONSTRAINT pk_categoria PRIMARY KEY (id_categoria)
);

CREATE TABLE categoria_receptor(
id_categoria_receptor SERIAL NOT NULL,
id_categoria INTEGER NOT NULL,
id_receptor INTEGER NOT NULL,
CONSTRAINT pk_categoria_receptor PRIMARY KEY (id_categoria_receptor),
CONSTRAINT fk_categoria_receptor_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
CONSTRAINT fk_categoria_receptor_receptor FOREIGN KEY (id_receptor) REFERENCES receptor (id_receptor)
);

CREATE TABLE doacao(
numerocontrole_doacao SERIAL NOT NULL,
descricao_doacao VARCHAR(500) NOT NULL,
datasolicitacao_docao DATE NOT NULL,
dataconclusao_doacao DATE,
status_doacao VARCHAR(10) NOT NULL,
id_beneficiario INTEGER NOT NULL,
CONSTRAINT pk_doacao PRIMARY KEY(numerocontrole_doacao),
CONSTRAINT fk_doacao_beneficiario FOREIGN KEY(id_beneficiario) REFERENCES beneficiario (id_beneficiario),
CONSTRAINT ck_status_doacao CHECK(status_doacao in ('espera', 'andamento', 'concelada', 'concluida'))
);


CREATE TABLE coleta(
numerocontrole_coleta SERIAL NOT NULL,
descricao_coleta varchar(500) NOT NULL,
status_coleta varchar(10) NOT NULL,
datasolicitacao_coleta DATE NOT NULL,
dataconclusao_coleta DATE,
status_material_coleta VARCHAR(11),
id_tipo_coleta INTEGER NOT NULL,
id_solicitante INTEGER NOT NULL,
id_receptor INTEGER NOT NULL,
id_pontocoleta INTEGER,
nome_solicitante_coleta VARCHAR(60),
CONSTRAINT pk_coleta PRIMARY KEY(numerocontrole_coleta),
CONSTRAINT fk_coleta_solicitante FOREIGN KEY(id_solicitante) REFERENCES solicitante (id_solicitante),
CONSTRAINT ck_coleta_status_material CHECK (status_material_coleta in('ncadastrado','cadastrado')),
CONSTRAINT fk_coleta_tipo_coleta FOREIGN KEY (id_tipo_coleta) REFERENCES tipo_coleta (id_tipo_coleta),
CONSTRAINT fk_coleta_receptor FOREIGN KEY(id_receptor) REFERENCES receptor (id_receptor),
CONSTRAINT fk_coleta_pontocoleta FOREIGN KEY(id_pontocoleta) REFERENCES pontocoleta (id_pontocoleta),
CONSTRAINT ck_status_coleta CHECK(status_coleta in ('espera', 'andamento', 'cancelado', 'concluido'))
);

CREATE TABLE lista_equipamento(
id_lista_equipamento SERIAL NOT NULL,
nome_lista_equipamento VARCHAR(40) NOT NULL,
id_receptor INTEGER NOT NULL,
CONSTRAINT pk_lista_equipamento PRIMARY KEY (id_lista_equipamento),
CONSTRAINT fk_lista_equipamento_receptor FOREIGN KEY (id_receptor) REFERENCES receptor (id_receptor)
);

CREATE TABLE equipamento(
codigo_equipamento SERIAL NOT NULL,
nome_equipamento VARCHAR(60) NOT NULL,
tipo_equipamento VARCHAR(13) NOT NULL,
status_equipamento VARCHAR(10) NOT NULL,
estado_equipamento VARCHAR(15) NOT NULL,
numerocontrole_coleta INTEGER,
id_categoria INTEGER NOT NULL,
CONSTRAINT pk_equipamento PRIMARY KEY(codigo_equipamento),
CONSTRAINT ck_equipamento_tipo CHECK(tipo_equipamento in('coletado', 'reaproveitado')),
CONSTRAINT ck_equipamento_status CHECK(status_equipamento in('disponivel', 'doado', 'sendo doado')),
CONSTRAINT ck_equipamento_estado CHECK(estado_equipamento in('funcionando', 'nao funcionando')),
CONSTRAINT fk_equipamento_coleta FOREIGN KEY(numerocontrole_coleta) REFERENCES coleta (numerocontrole_coleta),
CONSTRAINT fk_equipamento_categoria FOREIGN KEY(id_categoria) REFERENCES categoria (id_categoria)
);

CREATE TABLE peca(
codigo_peca SERIAL NOT NULL,
nome_peca VARCHAR(60) NOT NULL,
detalhe_peca VARCHAR(80),
status_peca VARCHAR(12) NOT NULL,
numerocontrole_coleta INTEGER,
CONSTRAINT pk_peca PRIMARY KEY(codigo_peca),
CONSTRAINT fk_peca_coleta FOREIGN KEY(numerocontrole_coleta) REFERENCES coleta (numerocontrole_coleta),
CONSTRAINT ck_peca_status CHECK(status_peca in('disponivel','indisponivel'))
);

CREATE TABLE peca_equipamento(
id_peca_equipamento SERIAL NOT NULL,
codigo_equipamento INTEGER NOT NULL,
codigo_peca INTEGER NOT NULL,
CONSTRAINT pk_peca_equipamento PRIMARY KEY (id_peca_equipamento),
CONSTRAINT fk_peca_equipamento_equipamento FOREIGN KEY (codigo_equipamento) REFERENCES equipamento (codigo_equipamento),
CONSTRAINT fk_peca_equipamento_peca FOREIGN KEY (codigo_peca) REFERENCES peca (codigo_peca)
);

CREATE TABLE itens_doacao(
id_itens_doacao SERIAL NOT NULL,
codigo_equipamento INTEGER NOT NULL,
numerocontrole_doacao INTEGER NOT NULL,
CONSTRAINT pk_equipamento_doacao PRIMARY KEY (id_itens_doacao),
CONSTRAINT fk_equipamento_doacao_equipamento_reaproveitado FOREIGN KEY (codigo_equipamento) REFERENCES equipamento (codigo_equipamento),
CONSTRAINT fk_equipamento_doacao_doacao FOREIGN KEY (numerocontrole_doacao) REFERENCES doacao (numerocontrole_doacao)
);

CREATE TABLE lista_peca(
id_lista_peca SERIAL NOT NULL,
nome_lista_peca VARCHAR(60) NOT NULL,
id_lista_equipamento INTEGER NOT NULL,
CONSTRAINT pk_lista_peca PRIMARY KEY (id_lista_peca),
CONSTRAINT fk_lista_peca_lista_equipamento FOREIGN KEY (id_lista_equipamento) REFERENCES lista_equipamento (id_lista_equipamento)
);

--------------------------------------------------------------------------------------------------------------------------------------------------
						INSERÇÃO DAS CATEGORIAS DE EQUIPAMENTOS NA TABELA CATEGORIA

INSERT INTO categoria (nome_categoria) VALUES ('Grandes Equipamentos');
INSERT INTO categoria (nome_categoria) VALUES ('Pequenos Equipamentos');
INSERT INTO categoria (nome_categoria) VALUES ('Equipamentos Informaticos e de Telecomunicacoes');
INSERT INTO categoria (nome_categoria) VALUES ('Equipamentos de Consumo');
INSERT INTO categoria (nome_categoria) VALUES ('Equipamentos de Iluminacao');
INSERT INTO categoria (nome_categoria) VALUES ('Ferramentas Eletricas e Eletronicas');
INSERT INTO categoria (nome_categoria) VALUES ('Brinquedos e Equipamentos de Desporto e Lazer');
INSERT INTO categoria (nome_categoria) VALUES ('Aparelhos Medicos');
INSERT INTO categoria (nome_categoria) VALUES ('Instrumentos de Monitorizacao e Controle');
INSERT INTO categoria (nome_categoria) VALUES ('Distribuidores Automaticos');
--------------------------------------------------------------------------------------------------------------------------------------------------
			
