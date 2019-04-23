select site, coalesce( path, 'no_track'), count(1) as counter, date_created
from (
  select o.ord_order_id as id , substring(from_unixtime(unix_timestamp(o.ord_created_dt, 'MMM dd, yyyy')),1,10) as date_created, o.sit_site_id as site, t.path as path
  from melilake.bt_odr_purchase_orders o
  left join (
    select distinct get_json_object(event_data, '$.order_id') as order_id, path
      from default.tracks where ds >= '@param1'
        and ds < '@param2'
        and path='/orders/ordercreated'
  ) t on (cast(o.ord_order_id as string) = t.order_id)
  where substring(from_unixtime(unix_timestamp(o.ord_created_dt, 'MMM dd, yyyy')),1,10)='@param3' and o.is_test = 'false'
) a
group by a.date_created, site, a.path