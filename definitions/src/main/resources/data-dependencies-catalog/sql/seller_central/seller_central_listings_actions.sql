select CASE
        WHEN path = '/seller_central/listings/filters/applied' then 'filters'
        WHEN  path = '/seller_central/listings/action' then 'action'
        WHEN path = '/seller_central/listings/list/health' then 'health'
  end as type,
  CASE
        WHEN path = '/seller_central/listings/filters/applied' then filters
        WHEN  path = '/seller_central/listings/action' then jest(event_data,'action_id')
        WHEN path = '/seller_central/listings/list/health' then jest(event_data,'health_id')
  end as event_id,
      device.platform as plataforma,
      count(1) as cantidad,
      substr(ds,1,10) as ds
from tracks
lateral view explode(json_to_array(jet(event_data, 'checkedFilters'))) tf as filters
WHERE ds >= '@param01'
AND ds < '@param02'
AND (path = '/seller_central/listings/filters/applied' or path = '/seller_central/listings/action' or path = '/seller_central/listings/list/health')
GROUP BY substr(ds,1,10),
        device.platform,
        CASE
        WHEN path = '/seller_central/listings/filters/applied' then 'filters'
        WHEN  path = '/seller_central/listings/action' then 'action'
        WHEN path = '/seller_central/listings/list/health' then 'health'
  end,
  CASE
        WHEN path = '/seller_central/listings/filters/applied' then filters
        WHEN  path = '/seller_central/listings/action' then jest(event_data,'action_id')
        WHEN path = '/seller_central/listings/list/health' then jest(event_data,'health_id')
  end;  