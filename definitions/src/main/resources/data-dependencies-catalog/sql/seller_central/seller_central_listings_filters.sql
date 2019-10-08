select  filters,
        substr(ds,1,10) as ds,
        device.platform as plataforma,
        count(1) as cantidad
from tracks
lateral view explode(json_to_array(jet(event_data, 'checkedFilters'))) tf as filters
WHERE ds >= '@param01'
AND ds < '@param02'
and path = '/seller_central/listings/filters/applied'
GROUP BY substr(ds,1,10),
          device.platform,
          filters;