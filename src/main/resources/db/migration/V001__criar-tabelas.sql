CREATE TABLE gestor(
	gestor_id UUID PRIMARY KEY NOT NULL,
	nome TEXT NOT NULL,
	email TEXT NOT NULL,
	senha TEXT NOT NULL
);

CREATE TABLE categoria(
    categoria_id SERIAL PRIMARY KEY,
    nome_categoria TEXT NOT NULL,
    porcentagem_limite NUMERIC(3, 2) NOT NULL
);

CREATE TABLE despesa(
    despesa_id SERIAL PRIMARY KEY,
    nome_despesa TEXT NOT NULL,
    definir_lembrete BOOLEAN NOT NULL,
    gestor_id uuid NOT NULL,
    categoria_id INTEGER NOT NULL,

	CONSTRAINT fk_gestor_id
	FOREIGN KEY(gestor_id) REFERENCES gestor(gestor_id)
	ON DELETE CASCADE,

	CONSTRAINT fk_categoria_id
	FOREIGN KEY(categoria_id) REFERENCES categoria(categoria_id)
	ON DELETE NO ACTION
);

CREATE TABLE recorrencia_despesa(
	despesa_id INTEGER PRIMARY KEY,
	frequencia TEXT NOT NULL,
	quantidade INTEGER NOT NULL,

	CONSTRAINT fk_despesa_id
	FOREIGN KEY(despesa_id) REFERENCES despesa(despesa_id)
	ON DELETE CASCADE
);

CREATE TABLE registro_despesa(
	registro_despesa_id SERIAL PRIMARY KEY,
	valor NUMERIC NOT NULL,
	data DATE NOT NULL,
	despesa_id INTEGER NOT NULL,

	CONSTRAINT fk_despesa_id
	FOREIGN KEY(despesa_id) REFERENCES despesa(despesa_id)
	ON DELETE CASCADE
);
