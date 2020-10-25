--liquibase formatted sql
--changeset Shipilov:DAEMON-208-1

ALTER TABLE users
ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY;