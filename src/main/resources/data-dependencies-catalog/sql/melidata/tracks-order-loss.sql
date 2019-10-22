select coalesce( path, 'no_track'), count(1) as counter, date_created
  from (
    select o.id as id , substr(o.date_created,1,10) as date_created, t.path as path
      from orders o
    left join (
      select distinct get_json_object(event_data, '$.order_id') as order_id, path
        from tracks where ds < concat('@param01', ' 20')
          and ds >= concat('@param02', ' 20')
          and path='/orders/ordercreated'
        ) t
    on (o.id = t.order_id)
  where substr(o.date_created,1,10)='@param01') a
  group by a.date_created, a.path