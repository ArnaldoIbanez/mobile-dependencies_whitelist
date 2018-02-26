select DAY, 
	SITE, 
	PLATFORM, 
	sum(TYPIFICATIONS-other_problem) TYPIFICATIONS_1, 
	sum(payments) PAYMENTS_2, 
	sum(shipping) SHIPPING_3, 
	sum(pickup_delivery) PICKUP_DELIVERY_4, 
	sum(delivery_review) DELIVERY_REVIEW_4, 
	sum(congrats) CONGRATS_5 
from (
	select substr(ds, 1, 10) DAY, application.site_id SITE, device.platform PLATFORM,
	COUNT(DISTINCT case when path = '/return/typifications' then usr.user_id else NULL end) TYPIFICATIONS,
	COUNT(DISTINCT case when (path = '/return/typifications' AND (jest(event_data, 'typification') IN ('go_to_claim', 'gtc_other_problem') OR jest(event_data, 'dictionary_data.typification') IN ('go_to_claim', 'gtc_other_problem'))) then usr.user_id else NULL end) other_problem,
	COUNT(DISTINCT case when path = '/return/payments' then usr.user_id else NULL end) payments,
	COUNT(DISTINCT case when path = '/return/shipping' then usr.user_id else NULL end) shipping,
	COUNT(DISTINCT case when path = '/return/pickup' or path = '/return/delivery' then usr.user_id else NULL end) pickup_delivery,
	COUNT(DISTINCT case when path = '/return/delivery_review' then usr.user_id else NULL end) delivery_review,
	COUNT(DISTINCT case when path = '/return/congrats' then usr.user_id else NULL end) congrats
	from default.tracks 
	 where path IN ('/return/typifications', '/return/payments', '/return/shipping', '/return/pickup', '/return/delivery', '/return/delivery_review', '/return/congrats')
	       and substr(ds,1,10) between '@param01' and '@param02' 
	       and application.site_id IN ('MLM', 'MLB')
group by substr(ds, 1, 10), application.site_id,device.platform, path, event_data) Y
group by DAY, site, PLATFORM 