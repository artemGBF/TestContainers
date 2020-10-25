--liquibase formatted sql
--changeset Shipilov:DAEMON-208

create table users(
    id integer primary key,
    username text,
    password text
);

