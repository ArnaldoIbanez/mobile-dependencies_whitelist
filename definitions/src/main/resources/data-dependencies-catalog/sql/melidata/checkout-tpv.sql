select ds, business, site, platform, experiment, variant, status, count(1) as count
from (
    select tmp.*, orders.status
    from (select distinct substr(ds, 1, 10) ds, usr.user_id, application.business, application.site_id site, device.platform, experiment, variant, get_json_object(event_data, '$.order_id') order_id
          from tracks lateral view explode(experiments) t as experiment, variant
          where ds >= '@param01' and ds < '@param02'
          and get_json_object(event_data, '$.order_id') is not null) tmp
    inner join orders on order_id = orders.id) t
group by ds, business, site, platform, experiment, variant, status