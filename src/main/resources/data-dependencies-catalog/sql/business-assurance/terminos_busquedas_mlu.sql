select  
  platform, 
  ranking_terminos, 
  termino, 
  coalesce(cat.name,'N/A') as L1, 
  cant,
  ds 
from (
  select 
    ds,platform,cat_l1_id,termino, rank() over(partition by ds, platform order by cant desc) ranking_terminos, cant
  from (
    select ds,platform,termino, cat_l1_id, count(*) as cant from (
      select 
        substr(ds,1,10) as ds,
        if(device.platform in ('/web/desktop/forced','/web/desktop/static','/web/desktop/forced/static'), '/web/desktop',
        if(device.platform in ('/web/mobile/forced','/web/mobile/static','/web/mobile/forced/static'),'/web/mobile', device.platform)) as platform,
        if( device.platform = '/mobile/ios', jest(event_data,'query'), jest(event_data,'backend_data.processed_query')) as termino,
        jest(event_data,'category_path[0]') as cat_l1_id
    from melidata.tracks_ml
    where ds >='@param01' and ds <'@param02'
       and bu = 'mercadolibre'
      and site = 'MLU'
      and not is_bot(device.user_agent)
      and path like '/search%'
      and length(jest(event_data,'query')) > 0
    ) todo 
      where platform in ('/web/desktop','/web/mobile','/mobile/android','/mobile/ios')
      group by ds, platform, termino, cat_l1_id
) t1 ) t
left join 
(select id,
        name
  from categories
  where site = 'MLU'
) cat on cat.id = t.cat_l1_id 
where t.ranking_terminos < 200
