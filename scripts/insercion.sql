insert into Usuario (id_usuario, nombre, email, direccion, contraseña)
values
('', 'Ez', 'correo@correo.com', 'direccion', ''), -- PARA ACCEDER A LA APLICACIÓN SIN TENER QUE ESCRIBIR USUARIO NI CONTRASEÑA
('Garcigongz', 'Iván', 'garcigong@gmail.com', 'c\ De la buena vida nº42 4ºK', 'grz'),
('pedroeldestroyer', 'Pedro', 'pedro@yahoo.com', 'c\ Carmen Amaya', 'pass');


insert into Administrador (id_administrador, nombre, contraseña)
values
('mosquera','Antonio Mosquera','mosqui'),
('sebas','Sebastián Villarroya','seb');


insert into Usuario_gestor (id_gestor, nombre, email, direccion, contraseña)
values
('gabrigg','Gabriel Gil','gabrigg@gmail.com','c\ Málaga nº135','ggg'),
('lois','Lois Fraga','lois@gmail.com','c\Guadalajara nº32','lf');

insert into Categoria (nombre)
values
('Informática'),
('Diseño'),
('Experimentación');


insert into Gestionar_usuario (id_administrador, id_usuario)
values
('mosquera','Garcigongz'),
('mosquera','pedroeldestroyer'),
('sebas','pedroeldestroyer');


insert into Gestionar_categoria (id_administrador, categoria)
values
('mosquera','Informática'),
('mosquera','Experimentación');

insert into Proyecto (nombre, id_gestor)
values
('Proyecto 1','gabrigg'),
('Proyecto 2','lois');

insert into Seccion (id_seccion, nombre, id_proyecto)
values
(1,'Implementación',1),
(2,'Análisis de datos',1),
(3,'Planteamiento del problema',2);

insert into Tarea_basica (id_usuario, nombre, completada, fecha_fin)
values
('', 'Tarea 1', false, '2024-04-20'),
('', 'Tarea 2', false, '2024-04-21'),
('', 'Tarea 3', false, '2024-04-22'),
('Garcigongz', 'Tarea 4', false, '2025-06-01'),
('Garcigongz', 'Tarea 5', false, '2025-01-01'),
('pedroeldestroyer', 'Tarea 6', false, '205-05-24');
