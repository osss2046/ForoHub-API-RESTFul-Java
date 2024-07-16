create table topicos(
    id bigint not null auto_increment,
    mensaje varchar(100) not null,
    nombre_curso varchar(100) not null ,
    titulo varchar(100) not null,
    activo tinyint,

    primary key(id)
);