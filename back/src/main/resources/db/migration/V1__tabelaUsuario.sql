create table usuarios(
    id INT AUTO_INCREMENT NOT NULL,
    email VARCHAR (100) UNIQUE,
    senha VARCHAR (20),
    PRIMARY KEY (id)
);