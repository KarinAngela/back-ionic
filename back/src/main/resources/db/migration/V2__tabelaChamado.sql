create table chamados(
    id INT AUTO_INCREMENT NOT NULL,
    foto_problema VARCHAR (220),
    descricao_problema VARCHAR (500) NOT NULL,
    prioridade ENUM('BAIXA','MEDIA','ALTA') NOT NULL,
    titulo_chamado VARCHAR(150) NOT NULL,
    status_chamado ENUM('PENDENTE','RESOLVIDO') NOT NULL,
    lat DECIMAL(10, 8) NOT NULL,
    lng DECIMAL(11, 8) NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);