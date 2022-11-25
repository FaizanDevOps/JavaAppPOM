CREATE SEQUENCE IF NOT EXISTS public.notifications_notification_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.notifications
(
    notification_id integer NOT NULL DEFAULT nextval('notifications_notification_id_seq'::regclass),
    "from" integer,
    "to" integer,
    title text COLLATE pg_catalog."default",
    message text COLLATE pg_catalog."default",
    is_read boolean DEFAULT false,
    property character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    is_new boolean DEFAULT true,
    redirection_param text COLLATE pg_catalog."default",
    CONSTRAINT notifications_pkey PRIMARY KEY (notification_id)
);