alter table company drop column IF EXISTS agency_id;

alter table company drop column IF EXISTS logo_path;

alter table company drop column IF EXISTS company_logo_url;

ALTER TABLE brand add column network text;

ALTER TABLE brand DROP COLUMN IF EXISTS facebook_path,
DROP COLUMN IF EXISTS twitter_path,
DROP COLUMN IF EXISTS youtube_path,
DROP COLUMN IF EXISTS instagram_path,
DROP COLUMN IF EXISTS snapchat_path,
DROP COLUMN IF EXISTS line_path,
DROP COLUMN IF EXISTS reddit_path,
DROP COLUMN IF EXISTS qq_path,
DROP COLUMN IF EXISTS tiktok_path,
DROP COLUMN IF EXISTS poc,
ADD COLUMN IF NOT EXISTS poc_firstname character varying(255),
ADD COLUMN IF NOT EXISTS poc_lastname character varying(255);