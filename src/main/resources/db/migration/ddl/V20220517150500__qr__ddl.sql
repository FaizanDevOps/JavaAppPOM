alter table track_campaign
drop column brand_name;

alter table track_campaign
drop column company_name;

ALTER TABLE track_campaign
ADD company_id integer;

ALTER TABLE track_campaign
ADD brand_id integer;