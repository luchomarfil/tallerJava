/* SQL para poblar la bd de pruebas de la aplicación Hermes */

-- Insertamos las categorías 

INSERT INTO 'hermes.categorias'
VALUES (null,'Predeterminada');

INSERT INTO 'hermes.categorias'
VALUES (null,'Emociones');

INSERT INTO 'hermes.categorias'
VALUES (null,'Alimentos');

INSERT INTO 'hermes.categorias'
VALUES (null,'Actividades');

INSERT INTO 'hermes.categorias'
VALUES (null,'Paseos');


--Insertamos los contextos

INSERT INTO 'hermes.contextos'
VALUES (null,'Establo-Terapia','Establo donde se realizan las terapias');

INSERT INTO 'hermes.contextos'
VALUES (null,'Pista',null);

INSERT INTO 'hermes.contextos'
VALUES (null,'Hogar',null);

/* Insertamos las resticciones conextos-categorías */

--Emociones está en todos los contextos

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Establo-Terapia')  , (select id from 'hermes.categorias' where  nombre = 'Emociones'));

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Hogar')  , (select id from 'hermes.categorias' where  nombre = 'Emociones'));

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Pista')  , (select id from 'hermes.categorias' where  nombre = 'Emociones'));

--Predeterminada está en todos los contextos

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Establo-Terapia')  , (select id from 'hermes.categorias' where  nombre = 'Predeterminada'));

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Hogar')  , (select id from 'hermes.categorias' where  nombre = 'Predeterminada'));

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Pista')  , (select id from 'hermes.categorias' where  nombre = 'Predeterminada'));

--Alimentos está sólo en Hogar

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Hogar')  , (select id from 'hermes.categorias' where  nombre = 'Actividades'));

--Actividades está sólo en Hogar

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Hogar')  , (select id from 'hermes.categorias' where  nombre = 'Alimentos'));

--Paseos está sólo en Hogar

insert into 'hermes.categorias.contextos' VALUES (null,(select id from 'hermes.contextos' where  nombre = 'Hogar')  , (select id from 'hermes.categorias' where  nombre = 'Paseos'));

--Insertamos algunas etiquetas

INSERT INTO 'hermes.etiquetas'
VALUES (null,'charlarConPadre','Charlar con los padres',0);

INSERT INTO 'hermes.etiquetas'
VALUES (null,'importante','Es importante',0);

--Insertamos algunos ninios

INSERT INTO 'hermes.ninios'
VALUES (null,'Luis','Napolitano');

INSERT INTO 'hermes.ninios'
VALUES (null,'Mariela','Pane');

INSERT INTO 'hermes.ninios'
VALUES (null,'Juan','Domingo');

--Insertamos algunos mensajes

INSERT INTO 'hermes.mensajes'
VALUES (null,'Entusiasmado','Entusiasmado','entusiasmado.jpg');

INSERT INTO 'hermes.mensajes'
VALUES (null,'Alegre','Alegre','alegre.jpg');

INSERT INTO 'hermes.mensajes'
VALUES (null,'Molesto','Molesto','molesto.jpg');

--Insertamos algunas notas

INSERT INTO 'hermes.notificaciones' VALUES (null,'1','1','1','1','2013-02-01 03:13:49' ,'2013-02-01 03:13:49','2013-02-01 03:13:49');

--Insertamos algunas etiquetas para los notas

INSERT INTO 'hermes.notificaciones.etiquetas'
VALUES (null,'1','1');