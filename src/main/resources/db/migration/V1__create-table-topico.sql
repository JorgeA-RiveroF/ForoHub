CREATE TABLE topico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(800) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status ENUM('ABIERTO', 'CERRADO') NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(20) NOT NULL,
    respuestas VARCHAR(800),

    PRIMARY KEY (id)
);