CREATE TABLE IF NOT EXISTS tb_address (
    id UUID PRIMARY KEY NOT NULL,
    cep VARCHAR(20) NOT NULL,
    logradouro VARCHAR(255),
    complemento VARCHAR(255),
    unidade VARCHAR(100),
    bairro VARCHAR(150),
    localidade VARCHAR(150),
    uf VARCHAR(2),
    estado VARCHAR(100),
    regiao VARCHAR(100),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);