--liquibase formatted sql
--changeset aarouf:1
INSERT INTO public.roles (name) VALUES ('ROLE_BASIC');
INSERT INTO public.roles (name) VALUES ('ADMIN');
INSERT INTO public.roles (name) VALUES ('EDITOR');
INSERT INTO public.roles (name) VALUES ('READER');


