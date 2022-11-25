CREATE SEQUENCE IF NOT EXISTS public.campaign_campaign_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.campaign_campaign_id_seq
    OWNER TO qritrim;


CREATE TABLE IF NOT EXISTS public.campaign
(
    campaign_id integer NOT NULL DEFAULT nextval('campaign_campaign_id_seq'::regclass),
    campaign_name text COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    updated_by character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    category_id integer,
    company_id integer,
    brand_id integer,
    objective_id integer,
    campaign_type_id integer,
    region_id integer,
    time_line json,
    age_group integer[],
    gender_preference_id integer,
    status_id integer,
    user_id integer,
    influencers_invited integer[],
    network_id integer[],
    saved_list integer[],
    CONSTRAINT campaign_pkey PRIMARY KEY (campaign_id),
    CONSTRAINT fk_campaign_brand_id FOREIGN KEY (brand_id)
        REFERENCES public.brand (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id)
        REFERENCES public.company (company_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.campaign
    OWNER to qritrim;