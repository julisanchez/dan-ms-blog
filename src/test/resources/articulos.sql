
INSERT INTO articulo (titulo, descripcion, autor, fecha_publicacion)
VALUES ('titulo', 'descripcion', 'autor', '2008-01-01 00:00:01');

INSERT INTO seccion (titulo, texto, articulo_id) VALUES ('titulo', 'texto', 1);

INSERT INTO seccion (titulo, texto, articulo_id) VALUES ('titulo 2', 'texto', 1)

INSERT INTO seccion (titulo, texto, articulo_id) VALUES ('titulo 3', 'text', 1);

INSERT INTO calificacion (valor, comentario, articulo_id) VALUES (3, null, 1);

INSERT INTO calificacion (valor, comentario, articulo_id) VALUES (4, 'muy bueno', 1);

INSERT INTO calificacion (valor, comentario, articulo_id) VALUES (1, 'pesimo', 1);


INSERT INTO articulo (titulo, descripcion, autor, fecha_publicacion)
VALUES ('articulo 2', 'descripcion 2', 'autor 2', '2008-01-01 00:00:01');

INSERT INTO seccion (titulo, texto, articulo_id) VALUES ('subtitulo', 'hello', 2);

INSERT INTO seccion (titulo, texto, articulo_id) VALUES ('subtitulo 2', 'hola', 2);

