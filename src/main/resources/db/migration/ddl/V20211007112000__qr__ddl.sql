delete from message where locale = 'UK_EN' and code = 'keyword' ;

delete from message where locale = 'UK_EN' and code = 'attribute' ;


INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'keywordp1', 'The audience score combines the target audience''s usage of given keywords/hashtags with AI-powered audience analysis.', 
	'default', 'qivr');
	
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'keywordp2', 'More use of given keywords/hashtags indicates a higher audience score out of 100 and an opportunity to deepen audience connections via an influencer marketing campaign.', 
	'default', 'qivr');
	
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'attributep1', 'The attribute is the influencer''s personality on social media, calculated by AI-powered analysis of influencer''s posts and audience responses.', 
	'default', 'qivr');	
	
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('UK_EN', 'attributep2', 'Attribute score indicates how better influencer''s content matches with selected attribute. A higher score out of 100 means the influencer''s social media personality matches better with given attributes than those with a lower score.', 
	'default', 'qivr');	
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'attributep1', 'アトリビュートとは、インフルエンサーの投稿とオーディエンスの反応をAIを使って分析することで算出される、ソーシャルメディア上のインフルエンサーのパーソナリティです。', 
	'default', 'qivr');		
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'attributep2', 'アトリビュートスコアとは、インフルエンサーのコンテンツが選択されたアトリビュートとどの程度マッチングしているかを示します。100点満点中、スコアが高いほど、インフルエンサーのソーシャルメディア上の個性が、低いスコアのものよりも特定のアトリビュートにマッチングしていることを意味します。', 
	'default', 'qivr');
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'keywordp1', 'オーディエンススコアとは、対象となるオーディエンスが特定のキーワードやハッシュタグを使用しているか使用状況と、AIを利用したオーディエンス分析を組み合わせたものです。', 
	'default', 'qivr');
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'keywordp2', '特定のキーワードやハッシュタグの使用率が高いほど、100点満点中のオーディエンススコアが高く、インフルエンサーマーケティングキャンペーンを通じてオーディエンスとのつながりを深める機会があることを示しています。', 
	'default', 'qivr');