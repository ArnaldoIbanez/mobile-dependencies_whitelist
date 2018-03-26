SELECT substr(ds,1,10) as fecha, 
		jest(event_data, 'email_id') as email_id, 
		path, 
		jest(event_data, 'email_template') as template, 
		jest(event_data, 'event_type') as event_type, 
		jest(event_data, 'track_data.milestone') as milestone, 
		jest(event_data, 'track_data.bucket') as bucket, 
		substr(jest(event_data, 'sent_date'), 1, 10) sent_date 
FROM tracks
	where type = 'event' 
	and path = '/email/generic' 
	and (ds >= '@param01' and ds <= '@param02')
	and jest(event_data, 'email_template') IN ('@param03')
	and jest(event_data, 'event_type') = 'send'
	and application.site_id IN ('MLA')

UNION

SELECT substr(ds,1,10) as fecha, 
		jest(event_data, 'email_id') as email_id, 
		path, 
		jest(event_data, 'email_template') as template, 
		jest(event_data, 'event_type') as event_type, 
		milestone, 
		bucket, 
		substr(jest(event_data, 'sent_date'), 1, 10) sent_date  
FROM tracks 
	LEFT JOIN 
		(SELECT jest(event_data, 'email_id') as email_id, 
				jest(event_data, 'track_data.milestone') as milestone, 
				jest(event_data, 'track_data.bucket') as bucket 
		FROM tracks
		WHERE 
				type = 'event' 
				and path = '/email/generic' 
				and (ds >= '@param01' and ds <= '@param02') 
				and jest(event_data, 'email_template') IN ('@param03') 
				and jest(event_data, 'event_type') = 'send' 
				and application.site_id IN ('MLA')) TRACKDATA 
	ON jest(event_data, 'email_id') = TRACKDATA.email_id
WHERE 
		type = 'event' 
		and path = '/email/generic' 
		and (ds >= '@param1' and ds <= '@param02')
		and jest(event_data, 'email_template') IN ('@param03') 
		and jest(event_data, 'event_type') = 'open' 
		and application.site_id IN ('MLA')
