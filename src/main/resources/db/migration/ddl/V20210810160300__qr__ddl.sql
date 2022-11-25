CREATE SEQUENCE IF NOT EXISTS public.networks_network_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.networks
(
    network_id integer NOT NULL DEFAULT nextval('networks_network_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    "networkImageUrl" character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    CONSTRAINT networks_pkey PRIMARY KEY (network_id)
);

CREATE SEQUENCE IF NOT EXISTS public.agencies_agency_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.agencies
(
    agency_id integer NOT NULL DEFAULT nextval('agencies_agency_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    email character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT agencies_pkey PRIMARY KEY (agency_id)
);

CREATE TABLE IF NOT EXISTS public.qritrim_filestore_schema_version
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT qritrim_filestore_schema_version_pk PRIMARY KEY (installed_rank)
);

CREATE SEQUENCE IF NOT EXISTS public.user_user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
	
	
CREATE TABLE IF NOT EXISTS public."user"
(
    user_id integer NOT NULL DEFAULT nextval('user_user_id_seq'::regclass),
    "firstName" character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "lastName" character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    designation character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    agency_id integer,
    brand_id integer,
    CONSTRAINT user_pkey PRIMARY KEY (user_id)
);

CREATE SEQUENCE IF NOT EXISTS public.status_status_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.status
(
    status_id integer NOT NULL DEFAULT nextval('status_status_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    CONSTRAINT status_pkey PRIMARY KEY (status_id)
);


CREATE SEQUENCE IF NOT EXISTS public.engage_engage_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.engage
(
    engage_id integer NOT NULL DEFAULT nextval('engage_engage_id_seq'::regclass),
    "engageTo" integer,
    "engageFrom" integer,
    "projectId" integer,
    "engageStatus" integer,
    venue character varying(255) COLLATE pg_catalog."default",
    purpose character varying(255) COLLATE pg_catalog."default",
    "otherInvites" character varying(255) COLLATE pg_catalog."default",
    "time" character varying(255) COLLATE pg_catalog."default",
    date character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    agency_id integer,
    brand_id integer,
    CONSTRAINT engage_pkey PRIMARY KEY (engage_id),
    CONSTRAINT "engage_engageStatus_fkey" FOREIGN KEY ("engageStatus")
        REFERENCES public.status (status_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);



CREATE TABLE IF NOT EXISTS public.public55
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT public55_pk PRIMARY KEY (installed_rank)
);

CREATE SEQUENCE IF NOT EXISTS public.qritrim_influencer_qritrim_influencer_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.qritrim_influencer
(
    qritrim_influencer_id integer NOT NULL DEFAULT nextval('qritrim_influencer_qritrim_influencer_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    dob timestamp with time zone,
    email character varying(255) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    is_tracking boolean DEFAULT true,
    source_inf_id integer,
    CONSTRAINT qritrim_influencer_pkey PRIMARY KEY (qritrim_influencer_id)
);

CREATE SEQUENCE IF NOT EXISTS public.qritrim_influencer_platforms_qriteim_influencer_platforms_i_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.qritrim_influencer_platforms
(
    qriteim_influencer_platforms_id integer NOT NULL DEFAULT nextval('qritrim_influencer_platforms_qriteim_influencer_platforms_i_seq'::regclass),
    qritrim_inf_id integer,
    platforms json[],
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    CONSTRAINT qritrim_influencer_platforms_pkey PRIMARY KEY (qriteim_influencer_platforms_id),
    CONSTRAINT qritrim_influencer_platforms_qritrim_inf_id_fkey FOREIGN KEY (qritrim_inf_id)
        REFERENCES public.qritrim_influencer (qritrim_influencer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


CREATE SEQUENCE IF NOT EXISTS public.company_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.company
(
    company_id integer NOT NULL DEFAULT nextval('company_id_seq'::regclass),
    company_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    agency_id integer,
    created timestamp with time zone DEFAULT now(),
    logo_path character varying(500) COLLATE pg_catalog."default",
    company_logo_url character varying COLLATE pg_catalog."default",
    CONSTRAINT company_pkey PRIMARY KEY (company_id),
    CONSTRAINT agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.brand_brand_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.brand
(
    brand_id integer NOT NULL DEFAULT nextval('brand_brand_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    poc text COLLATE pg_catalog."default",
    web_link text COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    agency_id integer,
    company_id integer,
    poc_num character varying COLLATE pg_catalog."default",
    poc_email character varying COLLATE pg_catalog."default",
    logo_path text COLLATE pg_catalog."default",
    facebook_path text COLLATE pg_catalog."default",
    twitter_path text COLLATE pg_catalog."default",
    youtube_path text COLLATE pg_catalog."default",
    instagram_path text COLLATE pg_catalog."default",
    snapchat_path text COLLATE pg_catalog."default",
    pinterest_path text COLLATE pg_catalog."default",
    line_path text COLLATE pg_catalog."default",
    reddit_path text COLLATE pg_catalog."default",
    qq_path text COLLATE pg_catalog."default",
    tiktok_path text COLLATE pg_catalog."default",
    brand_logo_url text COLLATE pg_catalog."default",
    CONSTRAINT brand_pkey PRIMARY KEY (brand_id),
    CONSTRAINT "brand_agencyId_fkey" FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id)
        REFERENCES public.company (company_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.project_project_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.project
(
    project_id integer NOT NULL DEFAULT nextval('project_project_id_seq'::regclass),
    "userId" integer,
    "includedNetwork" integer[],
    "campaignName" character varying(255) COLLATE pg_catalog."default",
    objective integer,
    "timeLine" json,
    "targetRegions" integer[],
    category integer[],
    "projectStatus" integer,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone NOT NULL DEFAULT now(),
    updated timestamp with time zone,
    agency_id integer,
    brand_id integer,
    keywords text[] COLLATE pg_catalog."default",
    budget json,
    company_id integer,
    "isTemplateSaved" boolean,
    sowid character varying COLLATE pg_catalog."default",
    sow_created_on timestamp without time zone,
    CONSTRAINT project_pkey PRIMARY KEY (project_id),
    CONSTRAINT fk_company_id FOREIGN KEY (company_id)
        REFERENCES public.company (company_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "project_projectStatus_fkey" FOREIGN KEY ("projectStatus")
        REFERENCES public.status (status_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "project_userId_fkey" FOREIGN KEY ("userId")
        REFERENCES public."user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.campaign_clauses_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.campaign_clauses
(
    id integer NOT NULL DEFAULT nextval('campaign_clauses_id_seq'::regclass),
    source_inf_id integer,
    qritrim_inf_id integer,
    brand_user_id integer,
    brand_id integer,
    agency_id integer,
    campaign_id integer,
    clauses json[],
    custom_clauses json[],
    activity_log json[],
    brand_agreed timestamp with time zone,
    influencer_agreed timestamp with time zone,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    CONSTRAINT campaign_clauses_pkey PRIMARY KEY (id),
    CONSTRAINT campaign_clauses_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT campaign_clauses_brand_id_fkey FOREIGN KEY (brand_id)
        REFERENCES public.brand (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT campaign_clauses_brand_user_id_fkey FOREIGN KEY (brand_user_id)
        REFERENCES public."user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT campaign_clauses_campaign_id_fkey FOREIGN KEY (campaign_id)
        REFERENCES public.project (project_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT campaign_clauses_qritrim_inf_id_fkey FOREIGN KEY (qritrim_inf_id)
        REFERENCES public.qritrim_influencer (qritrim_influencer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.q_filestoremap
(
    id bigint NOT NULL,
    filestoreid character varying(36) COLLATE pg_catalog."default" NOT NULL,
    filename character varying(256) COLLATE pg_catalog."default" NOT NULL,
    contenttype character varying(100) COLLATE pg_catalog."default",
    module character varying(256) COLLATE pg_catalog."default",
    tag character varying(256) COLLATE pg_catalog."default",
    tenantid character varying(256) COLLATE pg_catalog."default" NOT NULL,
    version bigint,
    filesource character varying(64) COLLATE pg_catalog."default",
    createdby character varying(64) COLLATE pg_catalog."default",
    lastmodifiedby character varying(64) COLLATE pg_catalog."default",
    createdtime bigint,
    lastmodifiedtime bigint,
    CONSTRAINT pk_filestoremap PRIMARY KEY (id),
    CONSTRAINT uk_filestoremap_filestoreid UNIQUE (filestoreid),
    CONSTRAINT uk_filestoremap_fsid_tenant UNIQUE (filestoreid, tenantid)
);

CREATE TABLE IF NOT EXISTS public.qr_url_shortener
(
    id character varying(128) COLLATE pg_catalog."default" NOT NULL,
    validfrom bigint,
    validto bigint,
    url character varying(1024) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT qr_url_shortener_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.inf_signup_request_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.inf_signup_request
(
    id integer NOT NULL DEFAULT nextval('inf_signup_request_id_seq'::regclass),
    source_inf_id integer,
    token character varying(200) COLLATE pg_catalog."default",
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    sent_on timestamp without time zone DEFAULT now(),
    CONSTRAINT inf_signup_request_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.clauses_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.clauses
(
    id integer NOT NULL DEFAULT nextval('clauses_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    campaign_clause_type_id integer,
    budget integer,
    agency_id integer,
    brand_id integer,
    user_id integer,
    property character varying COLLATE pg_catalog."default",
    created time without time zone DEFAULT now(),
    end_date date,
    objective_kpi_id integer,
    kpi_target integer,
    CONSTRAINT clause_id_pkey PRIMARY KEY (id),
    CONSTRAINT agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_id_fkey FOREIGN KEY (brand_id)
        REFERENCES public.brand (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.inf_campaign_clauses_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.inf_campaign_clause
(
    inf_campaign_clause_id integer NOT NULL DEFAULT nextval('inf_campaign_clauses_id_seq'::regclass),
    campaign_id integer,
    source_inf_id integer,
    qritrim_inf_id integer,
    user_id integer,
    agency_id integer,
    brand_id integer,
    clause_id integer,
    property character varying COLLATE pg_catalog."default",
    is_user_accepted boolean DEFAULT false,
    is_inf_accepted boolean DEFAULT false,
    created time without time zone DEFAULT now(),
    is_user_confirms boolean NOT NULL DEFAULT false,
    is_inf_confirms boolean NOT NULL DEFAULT false,
    user_confirms_at timestamp without time zone,
    inf_confirms_at timestamp without time zone,
    clause_end_date date,
    influencer_solution text COLLATE pg_catalog."default",
    reviewed boolean DEFAULT false,
    user_accepted_date character varying COLLATE pg_catalog."default",
    inf_accepted_date character varying COLLATE pg_catalog."default",
    CONSTRAINT inf_campaign_clause_id_pkey PRIMARY KEY (inf_campaign_clause_id),
    CONSTRAINT agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_id_fkey FOREIGN KEY (brand_id)
        REFERENCES public.brand (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT clause_id_fkey FOREIGN KEY (clause_id)
        REFERENCES public.clauses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.brand_product_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.brand_product
(
    id integer NOT NULL DEFAULT nextval('brand_product_id_seq'::regclass),
    brand_user_id integer,
    qritrim_inf_id integer,
    source_inf_id integer,
    campaign_id integer,
    brand_id integer,
    agency_id integer,
    product json[],
    CONSTRAINT brand_product_pkey PRIMARY KEY (id),
    CONSTRAINT brand_product_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_product_brand_user_id_fkey FOREIGN KEY (brand_user_id)
        REFERENCES public."user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.inf_brand_email_thread_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.inf_brand_email_thread
(
    id integer NOT NULL DEFAULT nextval('inf_brand_email_thread_id_seq'::regclass),
    source_inf_id integer,
    qritrim_inf_id integer,
    brand_id integer,
    agency_id integer,
    campaign_id integer,
    thread json[],
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone,
    user_id integer,
    sent_by character varying COLLATE pg_catalog."default",
    CONSTRAINT inf_brand_email_thread_pkey PRIMARY KEY (id),
    CONSTRAINT inf_brand_email_thread_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT inf_brand_email_thread_qritrim_inf_id_fkey FOREIGN KEY (qritrim_inf_id)
        REFERENCES public.qritrim_influencer (qritrim_influencer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.company_social_media_count_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.company_social_media_count
(
    id integer NOT NULL DEFAULT nextval('company_social_media_count_id_seq'::regclass),
    company_id integer,
    youtube_count integer,
    instagram_count integer,
    tiktok_count integer,
    facebook_count integer,
    twitter_count integer,
    line_count integer,
    pinterest_count integer,
    snapchat_count integer,
    reddit_count integer,
    qq_count integer,
    CONSTRAINT count_id_pkey PRIMARY KEY (id),
    CONSTRAINT company_id_fkey FOREIGN KEY (company_id)
        REFERENCES public.company (company_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.public51
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT public51_pk PRIMARY KEY (installed_rank)
);

CREATE SEQUENCE IF NOT EXISTS public.brand_uploads_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.brand_uploads
(
    id integer NOT NULL DEFAULT nextval('brand_uploads_id_seq'::regclass),
    brand_user_id integer,
    qritrim_inf_id integer,
    source_inf_id integer,
    campaign_id integer,
    brand_id integer,
    agency_id integer,
    uploads json[],
    CONSTRAINT brand_uploads_pkey PRIMARY KEY (id),
    CONSTRAINT brand_uploads_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_uploads_brand_user_id_fkey FOREIGN KEY (brand_user_id)
        REFERENCES public."user" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

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
    type character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    url text COLLATE pg_catalog."default",
    is_new boolean DEFAULT true,
    redirection_param json,
    CONSTRAINT notifications_pkey PRIMARY KEY (notification_id)
);

CREATE TABLE IF NOT EXISTS public.public50
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT public50_pk PRIMARY KEY (installed_rank)
);

CREATE SEQUENCE IF NOT EXISTS public.campaign_asserts_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.campaign_asserts
(
    id integer NOT NULL DEFAULT nextval('campaign_asserts_id_seq'::regclass),
    campaign_id integer,
    user_id integer,
    source_inf_id integer,
    uploaded_by character varying COLLATE pg_catalog."default",
    assert_name character varying COLLATE pg_catalog."default",
    assert_id character varying COLLATE pg_catalog."default",
    assert_url character varying COLLATE pg_catalog."default",
    status_id integer,
    assert_created_at timestamp with time zone,
    assert_type character varying COLLATE pg_catalog."default",
    revision_comments character varying COLLATE pg_catalog."default",
    approval_comments character varying COLLATE pg_catalog."default",
    CONSTRAINT campaign_asserts_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.audience_profile_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
	
CREATE TABLE IF NOT EXISTS public.audience_profile
(
    id integer NOT NULL DEFAULT nextval('audience_profile_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    age_preference_id integer[],
    annual_income_id integer[],
    brand_affinity_id integer[],
    ethnical_preference_id integer[],
    category_id integer[],
    region_id integer[],
    brand_id integer,
    agency_id integer,
    can_share boolean DEFAULT false,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone,
    updated timestamp with time zone,
    gender_preference_id integer,
    CONSTRAINT audience_profile_pkey PRIMARY KEY (id),
    CONSTRAINT audience_profile_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.campaign_links_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.campaign_links
(
    id integer NOT NULL DEFAULT nextval('campaign_links_id_seq'::regclass),
    campaign_id integer,
    source_inf_id integer,
    user_id integer,
    uploaded_by character varying COLLATE pg_catalog."default",
    network_id integer,
    campaign_links character varying COLLATE pg_catalog."default",
    CONSTRAINT campaign_links_pkey PRIMARY KEY (id)
);
	
CREATE SEQUENCE IF NOT EXISTS public.campaign_inf_profile_campaign_inf_profile_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.campaign_inf_profile
(
    campaign_inf_profile_id integer NOT NULL DEFAULT nextval('campaign_inf_profile_campaign_inf_profile_id_seq'::regclass),
    campaign_id integer,
    campaign_type_id integer,
    audience_profile_id integer,
    related_influencers character varying(255)[] COLLATE pg_catalog."default",
    brand_id integer,
    agency_id integer,
    created_by integer,
    updated_by integer,
    created_on timestamp with time zone,
    updated_on timestamp with time zone,
    attributes integer[],
    brand_competitor character varying[] COLLATE pg_catalog."default",
    sow_path character varying(255) COLLATE pg_catalog."default",
    keywords_tags character varying[] COLLATE pg_catalog."default",
    inf_type_id integer,
    age_preference_id integer[],
    brand_affinity_id integer[],
    ethnical_preference_id integer[],
    gender_preference_id integer,
    CONSTRAINT campaign_inf_profile_pkey PRIMARY KEY (campaign_inf_profile_id),
    CONSTRAINT campaign_inf_profile_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.audit_log_audit_log_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.audit_log
(
    audit_log_id integer NOT NULL DEFAULT nextval('audit_log_audit_log_id_seq'::regclass),
    user_id integer,
    property character varying(255) COLLATE pg_catalog."default",
    action character varying(255) COLLATE pg_catalog."default",
    comments text COLLATE pg_catalog."default",
    is_complete boolean DEFAULT true,
    redirection_params json,
    url text COLLATE pg_catalog."default",
    error text COLLATE pg_catalog."default",
    created timestamp with time zone NOT NULL DEFAULT now(),
    CONSTRAINT audit_log_pkey PRIMARY KEY (audit_log_id)
);

CREATE TABLE IF NOT EXISTS public.eg_filestoremap
(
    id bigint NOT NULL,
    version bigint,
    contenttype character varying(255) COLLATE pg_catalog."default",
    createdby character varying(255) COLLATE pg_catalog."default",
    createdtime bigint,
    filename character varying(255) COLLATE pg_catalog."default" NOT NULL,
    filesource character varying(255) COLLATE pg_catalog."default",
    filestoreid character varying(36) COLLATE pg_catalog."default" NOT NULL,
    lastmodifiedby character varying(255) COLLATE pg_catalog."default",
    lastmodifiedtime bigint,
    module character varying(255) COLLATE pg_catalog."default",
    tag character varying(255) COLLATE pg_catalog."default",
    tenantid character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT eg_filestoremap_pkey PRIMARY KEY (id),
    CONSTRAINT uk_n6v7wldv3rloat64lau99qqy9 UNIQUE (filestoreid)
);



CREATE TABLE IF NOT EXISTS public.flyway_scripts
(
    installed_rank integer NOT NULL,
    version character varying(50) COLLATE pg_catalog."default",
    description character varying(200) COLLATE pg_catalog."default" NOT NULL,
    type character varying(20) COLLATE pg_catalog."default" NOT NULL,
    script character varying(1000) COLLATE pg_catalog."default" NOT NULL,
    checksum integer,
    installed_by character varying(100) COLLATE pg_catalog."default" NOT NULL,
    installed_on timestamp without time zone NOT NULL DEFAULT now(),
    execution_time integer NOT NULL,
    success boolean NOT NULL,
    CONSTRAINT flyway_scripts_pk PRIMARY KEY (installed_rank)
);

CREATE SEQUENCE IF NOT EXISTS public.campaign_clause_template_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.campaign_clause_template
(
    temp_id integer NOT NULL DEFAULT nextval('campaign_clause_template_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default",
    clause_ids integer[],
    created_by integer,
    created date DEFAULT now(),
    agency_id integer,
    brand_id integer,
    CONSTRAINT temp_id_pkey PRIMARY KEY (temp_id)
);

CREATE SEQUENCE IF NOT EXISTS public.influencer_engagement_inf_eng_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.influencer_engagement
(
    inf_eng_id integer NOT NULL DEFAULT nextval('influencer_engagement_inf_eng_id_seq'::regclass),
    source_inf_id integer,
    qritrim_inf_id integer,
    brand_id integer,
    agency_id integer,
    campaign_id integer,
    status_id integer,
    is_accdetails_requested boolean,
    "createdBy" character varying(255) COLLATE pg_catalog."default",
    "updatedBy" character varying(255) COLLATE pg_catalog."default",
    created timestamp with time zone DEFAULT now(),
    updated timestamp with time zone,
    is_obj_defined boolean DEFAULT false,
    is_payment_terms_defined boolean DEFAULT false,
    is_inf_acccout_details_given boolean DEFAULT false,
    is_inf_seal_accepted boolean DEFAULT false,
    inf_sealed_at timestamp without time zone,
    is_u_seal_accepted boolean DEFAULT false,
    u_sealed_at timestamp without time zone,
    user_id integer,
    sent_by character varying COLLATE pg_catalog."default",
    is_u_terms_accepted boolean NOT NULL DEFAULT false,
    is_inf_terms_accepted boolean NOT NULL DEFAULT false,
    u_terms_accepted_at timestamp with time zone,
    inf_terms_accepted_at timestamp with time zone,
    inf_invitation_accepted boolean NOT NULL DEFAULT false,
    inf_invitation_declined boolean NOT NULL DEFAULT false,
    preamble_id character varying COLLATE pg_catalog."default",
    preamble_url character varying COLLATE pg_catalog."default",
    preamble_uploaded_at timestamp with time zone,
    status_updated_at timestamp with time zone,
    CONSTRAINT influencer_engagement_pkey PRIMARY KEY (inf_eng_id),
    CONSTRAINT influencer_engagement_agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT influencer_engagement_qritrim_inf_id_fkey FOREIGN KEY (qritrim_inf_id)
        REFERENCES public.qritrim_influencer (qritrim_influencer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT influencer_engagement_status_id_fkey FOREIGN KEY (status_id)
        REFERENCES public.status (status_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.inf_campaign_clause_activity_log_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
	
CREATE TABLE IF NOT EXISTS public.inf_campaign_clause_activity_log
(
    log_id integer NOT NULL DEFAULT nextval('inf_campaign_clause_activity_log_id_seq'::regclass),
    property character varying COLLATE pg_catalog."default",
    comments text COLLATE pg_catalog."default",
    from_id character varying COLLATE pg_catalog."default",
    to_id character varying COLLATE pg_catalog."default",
    agency_id integer,
    brand_id integer,
    created timestamp with time zone,
    inf_campaign_clause_id integer,
    CONSTRAINT log_id_pkey PRIMARY KEY (log_id),
    CONSTRAINT agency_id_fkey FOREIGN KEY (agency_id)
        REFERENCES public.agencies (agency_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT brand_id_fkey FOREIGN KEY (brand_id)
        REFERENCES public.brand (brand_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.comments_id_seq INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; ALTER SEQUENCE public.comments_id_seq OWNER TO qritrim;

CREATE TABLE IF NOT EXISTS public.campaign_inf_assert_comments ( comments_id integer NOT NULL DEFAULT nextval('comments_id_seq'::regclass), property character varying COLLATE pg_catalog."default" NOT NULL, comments text COLLATE pg_catalog."default", from_id character varying COLLATE pg_catalog."default", to_id character varying COLLATE pg_catalog."default", agency_id integer, brand_id integer, created timestamp with time zone DEFAULT now(), share_collateral_id integer, CONSTRAINT comments_id_pkey PRIMARY KEY (comments_id), CONSTRAINT agency_id_fkey FOREIGN KEY (agency_id) REFERENCES public.agencies (agency_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION, CONSTRAINT brand_id_fkey FOREIGN KEY (brand_id) REFERENCES public.brand (brand_id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION ) WITH ( OIDS = FALSE ) TABLESPACE pg_default; ALTER TABLE public.campaign_inf_assert_comments OWNER to qritrim;