SELECT fecha,
       item_id,
       domain_id,
       site as Site_id,
       get_json_object(single_json_table.single_json, '$.id') AS id,
       get_json_object(single_json_table.single_json, '$.new_value') AS new_value,
       get_json_object(single_json_table.single_json, '$.old_value') AS old_value,
       get_json_object(single_json_table.single_json, '$.success') AS success
FROM ( 
  SELECT fecha,site,domain_id,item_id,single_json 
  FROM (
        
          SELECT 
            substr(ds,1,10) as fecha,
            application.site_id as site, 
            GET_JSON_OBJECT(tracks.event_data, '$.domain_id') as domain_id,
            GET_JSON_OBJECT(tracks.event_data, '$.item_id') as item_id,
            GET_JSON_OBJECT(tracks.event_data, '$.inferred_attributes') as inferred_attributes
          FROM tracks
          where tracks.path in('/catalogwidget/save') 
          AND ds >= '@param01 02' AND ds < '@param02 02' 
          and application.business='mercadolibre'
          and type='event'
          and tracks.path not like'/catalogwidget/show'
        
  ) as source LATERAL VIEW explode (
    split(regexp_replace(substr(inferred_attributes, 2, length(inferred_attributes)-2),
              '"}","', '"}",,,,"'), ',,,,')
        ) adTable as single_json 
) single_json_table
WHERE
get_json_object(single_json_table.single_json, '$.id') IS NOT NULL

