ALTER TABLE track_campaign
DROP COLUMN time_line;

ALTER TABLE track_campaign
ADD time_line character varying;

ALTER TABLE track_campaign
ADD to_track character varying;
