CREATE SEQUENCE IF NOT EXISTS public.campaigns_filter_count_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;




CREATE TABLE IF NOT EXISTS public.campaigns_filter_count
(
    id integer NOT NULL DEFAULT nextval('campaigns_filter_count_id_seq'::regclass),
    campaign_id integer,
	engagement_min integer,
	engagement_max integer,
	ats_min integer,
	ats_max integer,
	ams_min integer,
	ams_max integer,
	follower_min integer,
	follower_max integer,
	updated boolean,
    CONSTRAINT campaigns_filter_count_id_pkey PRIMARY KEY (id),
    CONSTRAINT campaign_id_fkey FOREIGN KEY (campaign_id)
        REFERENCES public.project (project_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);