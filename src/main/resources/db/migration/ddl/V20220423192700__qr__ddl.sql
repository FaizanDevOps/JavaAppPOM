CREATE SEQUENCE IF NOT EXISTS public.discover_influencer_discover_inf_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;



CREATE TABLE IF NOT EXISTS public.discover_influencer
(
    discover_inf_id integer NOT NULL DEFAULT nextval('discover_influencer_discover_inf_id_seq'::regclass),
    list_name character varying(255) COLLATE pg_catalog."default",
    influecner_count integer,
    created timestamp with time zone,
    user_id integer,
    influencer_ids integer[],
    category_id integer,
    region_id integer,
    brand integer[],
    age_group integer[],
    gender integer,
    attribute integer[],
    ethinicity integer[],
    key character varying[] COLLATE pg_catalog."default",
    CONSTRAINT discover_influencer_pkey PRIMARY KEY (discover_inf_id)
);


ALTER TABLE discover_influencer
ADD COLUMN IF NOT EXISTS category_id integer;