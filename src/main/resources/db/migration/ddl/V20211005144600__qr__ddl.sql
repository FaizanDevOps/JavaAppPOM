CREATE SEQUENCE IF NOT EXISTS public.localization_msg_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.message
(
    id integer NOT NULL DEFAULT nextval('localization_msg_id_seq'::regclass),
    locale character varying(255) COLLATE pg_catalog."default",
    code character varying(255) COLLATE pg_catalog."default",
    message text COLLATE pg_catalog."default",
    tenantid character varying(255) COLLATE pg_catalog."default",
    module character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT localization_msg_id_pkey PRIMARY KEY (id)
);




delete from message where locale = 'UK_EN' and code = 'keyword' ;

delete from message where locale = 'UK_EN' and code = 'attribute' ;

INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'keyword', 'The audience score combines the target audience''s usage of given keywords/hashtags with AI-powered audience analysis.'||E'\n'||'More use of given keywords/hashtags indicates a higher audience score out of 100 and an opportunity to deepen audience connections via an influencer marketing campaign.', 
	'default', 'qivr');
	
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'attribute', 'The attribute is the influencer''s personality on social media, calculated by AI-powered analysis of influencer''s posts and audience responses.'||E'\n'||'Attribute score indicates how better influencer''s content matches with selected attribute. A higher score out of 100 means the influencer''s social media personality matches better with given attributes than those with a lower score.', 
	'default', 'qivr');	