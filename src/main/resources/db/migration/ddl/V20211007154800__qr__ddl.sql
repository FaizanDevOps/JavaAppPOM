delete from message where locale = 'JP_JA' and code = 'keywordp1' ;

delete from message where locale = 'JP_JA' and code = 'keywordp2' ;

delete from message where locale = 'JP_JA' and code = 'attributep1' ;

delete from message where locale = 'JP_JA' and code = 'attributep2' ;



INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'attributep1', 'アトリビュートとは、インフルエンサーの投稿とオーディエンスの反応を AI を使って分析することで算出される、ソーシャルメディア上のインフルエンサーのパーソナリティです。', 
	'default', 'qivr');		
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'attributep2', 'アトリビュートスコアとは、インフルエンサーのコンテンツが選択されたアトリビュートとどの程度マッチングしているかを示します。100 点満点中、スコアが高いほど、インフルエンサーのソーシャルメディア上の個性が、低いスコアのものよりも特定のアトリビュートにマッチングしていることを意味します。', 
	'default', 'qivr');
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'keywordp1', 'オーディエンススコアとは、対象となるオーディエンスが特定のキーワードやハッシュタグを使用しているか使用状況と、AI を利用したオーディエンス分析を組み合わせたものです。', 
	'default', 'qivr');
	
INSERT INTO public.message(
	locale, code, message, tenantid, module)
	VALUES ('JP_JA', 'keywordp2', '特定のキーワードやハッシュタグの使用率が高いほど、100 点満点中のオーディエンススコアが高く、インフルエンサーマーケティングキャンペーンを通じてオーディエンスとのつながりを深める機会があることを示しています。', 
	'default', 'qivr');