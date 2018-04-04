SELECT json_extract_scalar(event_data, '$.email_id') as email_id, 
		substr(ds,1,10) as fecha, 
		path, 
		json_extract_scalar(event_data, '$.email_template') as template, 
		json_extract_scalar(event_data, '$.event_type') as event_type, 
		json_extract_scalar(event_data, '$.track_data.milestone') as milestone, 
		json_extract_scalar(event_data, '$.track_data.bucket') as bucket, 
		substr(json_extract_scalar(event_data, '$.sent_date'), 1, 10) sent_date 
FROM tracks
	where type = 'event' 
	and path = '/email/generic' 
	and (ds >= '@param01' and ds <= '@param02')
	and json_extract_scalar(event_data, '$.email_template') = 'CONS_COLLECTION'
	and json_extract_scalar(event_data, '$.event_type') = 'send'
	and application.site_id = 'MLA'

UNION

SELECT distinct json_extract_scalar(event_data, '$.email_id') as email_id, 
		substr(ds,1,10) as fecha, 
		path, 
		json_extract_scalar(event_data, '$.email_template') as template, 
		json_extract_scalar(event_data, '$.event_type') as event_type, 
		milestone, 
		bucket, 
		substr(json_extract_scalar(event_data, '$.sent_date'), 1, 10) sent_date  
FROM tracks 
	LEFT JOIN 
		(SELECT json_extract_scalar(event_data, '$.email_id') as email_id, 
				json_extract_scalar(event_data, '$.track_data.milestone') as milestone, 
				json_extract_scalar(event_data, '$.track_data.bucket') as bucket 
		FROM tracks
		WHERE 
				type = 'event' 
				and path = '/email/generic' 
				and (ds >= '2018-03-20' and ds <= '@param02') 
				and json_extract_scalar(event_data, '$.email_template') = 'CONS_COLLECTION'
				and json_extract_scalar(event_data, '$.event_type') = 'send' 
				and application.site_id = 'MLA' ) TRACKDATA 
	ON json_extract_scalar(event_data, '$.email_id') = TRACKDATA.email_id
WHERE 
		type = 'event' 
		and path = '/email/generic' 
		and (ds >= '@param01' and ds <= '@param02')
		and json_extract_scalar(event_data, '$.email_template') = 'CONS_COLLECTION'
		and json_extract_scalar(event_data, '$.event_type') = 'open' 
		and application.site_id = 'MLA'