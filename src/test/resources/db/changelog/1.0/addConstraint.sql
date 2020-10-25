--liquibase formatted sql
--changeset Shipilov:DAEMON-208-1

ALTER TABLE users
ALTER COLUMN id int GENERATED ALWAYS AS IDENTITY;