SELECT
  A.review_id as review_id,
  A.review_version as review_version,
  A.review_status as review_status,
  A.domain_id as domain_id,
  A.publication_id as publication_id,
  A.sheet_id as sheet_id,
  A.time as time,
  A.user_initials as user_initials,
  A.action_tag as action_tag,
  A.error_desc as error_desc,
  A.error_value as error_value,
  A.comments_desc as comments_desc,
  A.comments_value as comments_value,
  substr(A.ds,1,10) as ds
FROM (
  SELECT
    ds,
    get_json_object(event_data,'$.review_id') as review_id,
    get_json_object(event_data,'$.review_version') as review_version,
    get_json_object(event_data,'$.review_status') as review_status,
    get_json_object(event_data,'$.domain_id') as domain_id,
    get_json_object(event_data,'$.publication_id') as publication_id,
    get_json_object(event_data,'$.sheet_id') as sheet_id,
    get_json_object(event_data,'$.time') as time,
    get_json_object(event_data,'$.user_initials') as user_initials,
    get_json_object(event_data,'$.action_tag') as action_tag,
    errors_codes,
    sections_comments,
    regexp_extract(regexp_extract(errors_codes,'"(.*?)"',1),'(^[a-z,A-Z]+-*[a-z,A-Z]+)',1) as error_desc,
    regexp_extract(errors_codes,'([0-9]+)',1) as error_value,
    regexp_extract(regexp_extract(sections_comments,'"(.*?)"',1),'(^[a-z,A-Z]+-*[a-z,A-Z]+)',1) as comments_desc,
    regexp_extract(sections_comments,'([0-9]+)',1) as comments_value
  FROM default.tracks
  LATERAL VIEW explode( split(get_json_object(event_data,'$.errors_codes'),',')) tf as errors_codes
  LATERAL VIEW explode( split(get_json_object(event_data,'$.sections_comments'),',')) tf2 as sections_comments
  WHERE ds > '@param01' AND ds < '@param02'  AND path = '/structure_data/product_reviewer/review'
) as A
INNER JOIN (
  SELECT
  get_json_object(event_data,'$.review_id') as review_id,
   MAX(get_json_object(event_data,'$.review_version')) as review_version
  FROM default.tracks
  WHERE ds > '@param01' AND ds < '@param02' AND path = '/structure_data/product_reviewer/review'
  GROUP BY get_json_object(event_data,'$.review_id')
) as B ON  (A.review_id = B.review_id and A.review_version = B.review_version)