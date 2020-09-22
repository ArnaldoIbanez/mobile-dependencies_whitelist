select casi.category as categoria,
      casi.platform as plataforma,
      casi.filtro as filtro_atributo,
      usages as cantidad_usos,
      ds
from
(select info.category as category,
      info.platform as platform,
      REGEXP_REPLACE(regexp_replace ((attribute_filter),'"',''),'\\{','') as filtro,
      count(1) usages,
      ds
from
(SELECT
 jest(event_data,'filters.category') as category,
 device.platform as platform,
 map_keys(STR_TO_MAP(filters)) as filter,
 json_to_array(autoselected_filters) as autoselects,
 substr(ds,1,10) as ds
FROM default.tracks x
lateral view json_tuple(event_data,'filters') a as filters
lateral view json_tuple(event_data,'autoselected_filters') b as autoselected_filters
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path = '/search'
  AND type = 'view'
  AND device.platform != '/mobile/ios'
  AND NOT is_bot(device.user_agent)
  AND CAST(jest(event_data,'offset') AS DOUBLE) = 0
  AND jest(event_data,'filters.category') IS NOT NULL) info
lateral view explode(info.filter) filters as attribute_filter
WHERE REGEXP_REPLACE(regexp_replace ((attribute_filter),'"',''),'\\{','') not in ('category','notfinalized','blcustomers','condition','city','official_store_id','shipping_cost','state','official_store','seller_type','view_mode','price','neighborhood','installments','power_seller','seller_id','deal','discount_source','adult_content')
AND NOT ARRAY_CONTAINS(info.autoselects, REGEXP_REPLACE(regexp_replace ((attribute_filter),'"',''),'\\{',''))
AND attribute_filter NOT LIKE "%999%" and REGEXP_REPLACE(REGEXP_REPLACE(regexp_replace ((attribute_filter),'"',''),'\\{',''),'([a-z]|[a-z]*_[a-z]*||[a-z]*_[a-z]*_[a-z]*)','') != ''
GROUP BY category, platform, REGEXP_REPLACE(regexp_replace ((attribute_filter),'"',''),'\\{',''), ds) casi
GROUP BY casi.category, casi.platform,casi.filtro, usages, ds