SELECT
  count(1) as cantidad,
  filters,
  application.site_id as site_id,
  substr(ds,1,10) as ds
FROM 
      default.tracks
      lateral view explode(json_to_array(jet(event_data, 'filters'))) tf as filters
WHERE 
      ds >= '@param01'
    AND 
      ds < '@param02'
    AND 
      path in ('/seller_central/listings/filters/applied')
    AND 
      event_data != '{"checkedFilters":[]}'
    AND 
    application.site_id IN ('MLM', 'MLA', 'MLB')
GROUP BY
  2,
  3,
  4