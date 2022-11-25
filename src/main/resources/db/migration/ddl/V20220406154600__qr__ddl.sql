CREATE SEQUENCE IF NOT EXISTS public.comments_id_seq INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; ALTER SEQUENCE public.comments_id_seq OWNER TO qritrim;

CREATE TABLE IF NOT EXISTS public.campaign_inf_communication 
(
 comments_id integer NOT NULL DEFAULT nextval('comments_id_seq'::regclass), 
 property character varying COLLATE pg_catalog."default" NOT NULL,
 comments text COLLATE pg_catalog."default", 
 from_id character varying COLLATE pg_catalog."default", 
 to_id character varying COLLATE pg_catalog."default", 
 agency_id integer, 
 created timestamp with time zone DEFAULT now(),
 campaign_id integer,
 CONSTRAINT campaign_id_fkey FOREIGN KEY (campaign_id) REFERENCES public.campaign (campaign_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION ) WITH ( OIDS = FALSE ) TABLESPACE pg_default; ALTER TABLE public.campaign_inf_assert_comments OWNER to qritrim;