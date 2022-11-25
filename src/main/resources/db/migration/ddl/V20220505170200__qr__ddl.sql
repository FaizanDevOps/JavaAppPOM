CREATE SEQUENCE IF NOT EXISTS public.track_campaign_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.track_campaign_id_seq
    OWNER TO qritrim;


CREATE TABLE IF NOT EXISTS public.track_campaign
(
    id integer NOT NULL DEFAULT nextval('track_campaign_id_seq'::regclass),
    campaign_name character varying(255) COLLATE pg_catalog."default",
    brand_name character varying(255) COLLATE pg_catalog."default",
    company_name character varying(255) COLLATE pg_catalog."default",
    objective_id integer,
    obj_kpi character varying(255) COLLATE pg_catalog."default",
    links character varying(255) COLLATE pg_catalog."default"
)