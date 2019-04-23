select site,platform, coalesce( path, 'no_track'), count(1) as counter, date_created
  from (
    select o.id as id , substr(o.date_created,1,10) as date_created, o.site as site ,o.platform as platform, o.status as status, t.path as path
      from orders o
    left join (
      select distinct get_json_object(event_data, '$.order_id') as order_id, path
        from tracks where ds >= '@param01'
          and ds < '@param02'
          and path='/orders/ordercreated'
        ) t
    on (o.id = t.order_id)
  where substr(o.date_created,1,10)='@param03' ) a
  group by a.date_created, a.site,a.platform, a.path