CREATE TABLE objetivo(
    objetivo_id SERIAL PRIMARY KEY,
    descricao TEXT NOT NULL,
    valor NUMERIC NOT NULL,
    gestor_id uuid NOT NULL,

	CONSTRAINT fk_gestor_id
	FOREIGN KEY(gestor_id) REFERENCES gestor(gestor_id)
	ON DELETE CASCADE
);
