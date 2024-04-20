CREATE SEQUENCE proyecto_id_seq START 1;
CREATE SEQUENCE seccion_id_seq START 1;
CREATE SEQUENCE tarea_basica_id_seq START 1;
CREATE SEQUENCE tarea_de_proyecto_id_seq START 1;
CREATE SEQUENCE subtarea_id_seq START 1;
CREATE SEQUENCE notificacion_basica_id_seq START 1;
CREATE SEQUENCE notificacion_de_proyecto_id_seq START 1;
CREATE SEQUENCE foro_id_seq START 1;
CREATE SEQUENCE publicacion_id_seq START 1;


create table Usuario (
   id_usuario varchar(100) primary key,
   nombre varchar(100),
   email varchar(100),
   direccion varchar(255),
   contraseña varchar(100)
);
create table Administrador (
   id_administrador varchar(100) primary key,
   nombre varchar(100),
   contraseña varchar(100)
);
create table Usuario_gestor (
	id_gestor varchar(100) primary key,
	nombre varchar(100),
   email varchar(100),
   direccion varchar(255),
   contraseña varchar(100)
);
create table Categoria (
	nombre varchar(100) primary key
);
create table Gestionar_usuario (
   id_administrador varchar(100),
   id_usuario varchar(100),
   primary key (id_administrador, id_usuario),
   foreign key (id_administrador) references Administrador(id_administrador) on delete cascade,
   foreign key (id_usuario) references Usuario(id_usuario) on delete cascade
);
create table Gestionar_categoria(
	id_administrador varchar(100),
	categoria varchar(100),
	primary key (id_administrador, categoria),
	foreign key (id_administrador) references Administrador(id_administrador) on delete cascade,
	foreign key (categoria) references Categoria(nombre) on delete cascade
);
create table Proyecto(
	id_proyecto int,
	nombre varchar(100),
	id_gestor varchar (100),
	primary key (id_proyecto),
	foreign key (id_gestor) references Usuario_gestor(id_gestor) on delete cascade
);
create table Seccion(
	id_seccion int,
	nombre varchar(100),
	id_proyecto int,
	primary key (id_seccion),
	foreign key (id_proyecto) references Proyecto(id_proyecto) on delete cascade
);
create table Tarea_basica(
	id_tarea int,
	id_usuario varchar (100),
	nombre varchar(100),
	completada bool,
	fecha_fin date,
	primary key (id_tarea)
	foreign key (id_usuario) references Tarea_basica(id_usuario) on delete cascade
);
create table Tarea_de_proyecto(
	id_tarea int,
	nombre varchar(100),
	completada bool,
	fecha_fin date,
	id_seccion int,
	primary key (id_tarea),
	foreign key (id_seccion) references Seccion(id_seccion) on delete cascade
);
create table Subtarea(
	id_subtarea int,
	descripcion varchar(255),
	id_tarea_proyecto int,
	primary key (id_subtarea),
	foreign key (id_tarea_proyecto) references Tarea_de_proyecto(id_tarea) on delete cascade
);
create table Notificacion_basica(
	id_notificacion int,
	mensaje varchar(255),
	leida bool,
	id_tarea int,
	primary key (id_notificacion),
	foreign key (id_tarea) references Tarea_basica(id_tarea) on delete cascade
);
create table Notificacion_de_proyecto(
	id_notificacion int,
	mensaje varchar(255),
	leida bool,
	id_tarea int,
	primary key (id_notificacion),
	foreign key (id_tarea) references Tarea_de_proyecto(id_tarea) on delete cascade
);
create table Foro(
	id_foro int,
	titulo varchar(100),
	id_proyecto int,
	primary key (id_foro),
	foreign key (id_proyecto) references Proyecto(id_proyecto) on delete cascade
);
create table Participar(
	id_usuario varchar(100),
	id_proyecto int,
	primary key (id_usuario, id_proyecto),
	foreign key (id_usuario) references Usuario(id_usuario) on delete cascade,
	foreign key (id_proyecto) references Proyecto(id_proyecto) on delete cascade
);
create table Publicacion(
	id_publicacion int,
	mensaje varchar(255),
	id_foro int,
	id_usuario varchar(100),
	primary key (id_publicacion),
	foreign key (id_foro) references Foro(id_foro) on delete cascade,
	foreign key (id_usuario) references Usuario(id_usuario) on delete cascade
);
create table Categoria_tarea_basica(
	categoria varchar(100),
	tarea_basica int,
	primary key (categoria, tarea_basica),
	foreign key (categoria) references Categoria(nombre) on delete cascade on update cascade,
	foreign key (tarea_basica) references Tarea_basica(id_tarea) on delete cascade on update cascade
);
create table Tener_notificacion_de_proyecto(
	usuario varchar(100),
	notificacion int,
	primary key (usuario, notificacion),
	foreign key (usuario) references Usuario(id_usuario),
	foreign key (notificacion) references Notificacion_de_proyecto(id_notificacion)
);


-- Trigger para la tabla Proyecto
CREATE OR REPLACE FUNCTION proyecto_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_proyecto := nextval('proyecto_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER proyecto_auto_id_trigger
BEFORE INSERT ON Proyecto
FOR EACH ROW
EXECUTE FUNCTION proyecto_auto_id();

-- Trigger para la tabla Seccion
CREATE OR REPLACE FUNCTION seccion_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_seccion := nextval('seccion_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER seccion_auto_id_trigger
BEFORE INSERT ON Seccion
FOR EACH ROW
EXECUTE FUNCTION seccion_auto_id();

-- Trigger para la tabla Tarea_basica
CREATE OR REPLACE FUNCTION tarea_basica_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_tarea := nextval('tarea_basica_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tarea_basica_auto_id_trigger
BEFORE INSERT ON Tarea_basica
FOR EACH ROW
EXECUTE FUNCTION tarea_basica_auto_id();

-- Trigger para la tabla Tarea_de_proyecto
CREATE OR REPLACE FUNCTION tarea_de_proyecto_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_tarea := nextval('tarea_de_proyecto_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER tarea_de_proyecto_auto_id_trigger
BEFORE INSERT ON Tarea_de_proyecto
FOR EACH ROW
EXECUTE FUNCTION tarea_de_proyecto_auto_id();

-- Trigger para la tabla Subtarea
CREATE OR REPLACE FUNCTION subtarea_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_subtarea := nextval('subtarea_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER subtarea_auto_id_trigger
BEFORE INSERT ON Subtarea
FOR EACH ROW
EXECUTE FUNCTION subtarea_auto_id();

-- Trigger para la tabla Notificacion_basica
CREATE OR REPLACE FUNCTION notificacion_basica_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_notificacion := nextval('notificacion_basica_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER notificacion_basica_auto_id_trigger
BEFORE INSERT ON Notificacion_basica
FOR EACH ROW
EXECUTE FUNCTION notificacion_basica_auto_id();

-- Trigger para la tabla Notificacion_de_proyecto
CREATE OR REPLACE FUNCTION notificacion_de_proyecto_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_notificacion := nextval('notificacion_de_proyecto_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER notificacion_de_proyecto_auto_id_trigger
BEFORE INSERT ON Notificacion_de_proyecto
FOR EACH ROW
EXECUTE FUNCTION notificacion_de_proyecto_auto_id();

-- Trigger para la tabla Foro
CREATE OR REPLACE FUNCTION foro_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_foro := nextval('foro_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER foro_auto_id_trigger
BEFORE INSERT ON Foro
FOR EACH ROW
EXECUTE FUNCTION foro_auto_id();

-- Trigger para la tabla Publicacion
CREATE OR REPLACE FUNCTION publicacion_auto_id()
RETURNS TRIGGER AS $$
BEGIN
    NEW.id_publicacion := nextval('publicacion_id_seq');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER publicacion_auto_id_trigger
BEFORE INSERT ON Publicacion
FOR EACH ROW
EXECUTE FUNCTION publicacion_auto_id();
