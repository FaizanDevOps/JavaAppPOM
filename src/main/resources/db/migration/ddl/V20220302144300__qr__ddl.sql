alter table influencer_engagement 
drop column if exists brand_id,
drop column if exists agency_id,
drop column if exists is_accdetails_requested,
drop column if exists is_obj_defined,
drop column if exists is_payment_terms_defined,
drop column if exists is_inf_acccout_details_given,
drop column if exists is_inf_seal_accepted,
drop column if exists inf_sealed_at,
drop column if exists is_u_seal_accepted,
drop column if exists u_sealed_at,
drop column if exists sent_by,
drop column if exists is_u_terms_accepted,
drop column if exists is_inf_terms_accepted,
drop column if exists u_terms_accepted_at,
drop column if exists inf_terms_accepted_at,
drop column if exists inf_invitation_accepted,
drop column if exists inf_invitation_declined,
drop column if exists status_updated_at,
drop column if exists qritrim_inf_id,
add column if not exists kpi integer,
add column if not exists target integer,
add column if not exists budget integer,
add column if not exists sow_id character varying,
add column if not exists sow_url character varying,
add column if not exists is_kpi_accepted boolean default false,
add column if not exists is_preamble_accepted boolean default false,
add column if not exists is_sow_accepted boolean default false,
DROP CONSTRAINT IF EXISTS influencer_engagement_status_id_fkey;

ALTER TABLE "user" 
DROP COLUMN IF EXISTS agency_id,
DROP COLUMN IF EXISTS brand_id,
ADD COLUMN IF NOT EXISTS source_inf_id integer,
ADD COLUMN IF NOT EXISTS is_tracking Boolean default false;

DROP TABLE IF EXISTS qritrim_influencer CASCADE;