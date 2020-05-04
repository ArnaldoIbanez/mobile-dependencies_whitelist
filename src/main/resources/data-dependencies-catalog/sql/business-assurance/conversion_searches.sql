select todo.fecha, todo.site, todo.platform, todo.query, todo.total_buy, todo.total_searchs, cast((todo.total_buy * 100) as DOUBLE) / todo.total_searchs as convertion, todo.categ_L1, todo.name
 from (
 	select * 
 	from (
 		select *
 		from (
 			select substr(ds,1,10) as fecha, 
 			application.site_id as site, 
 			device.platform as platform, 
 			regexp_extract(jet(event_data, 'items[0].item.category_path'),'\\["(.*?)"',1) as categ_L1,
 			regexp_replace(jet(platform.http.cookies, 'LAST_SEARCH'),'-',' ') as query,
 			count(1) as total_buy
 			from tracks 
 			where ds >= '@param01'
 			and ds < '@param02'
 			and path = '/checkout/ordercreated'
 			and jet(event_data, 'first_for_order') = 'true'
 			and (regexp_replace(jet(platform.http.cookies, 'LAST_SEARCH'),'-',' ') is not null and regexp_replace(jet(platform.http.cookies, 'LAST_SEARCH'),'-',' ') != '{}')
 			group by substr(ds,1,10), application.site_id, device.platform, regexp_replace(jet(platform.http.cookies, 'LAST_SEARCH'),'-',' '), regexp_extract(jet(event_data, 'items[0].item.category_path'),'\\["(.*?)"',1)
 		) queries_with_buy
 
 		LEFT JOIN
 
 		(
 			select id, name
 			from categories
 		) categ_names
 
 		ON (queries_with_buy.categ_L1 = categ_names.id)
 	)todo
 
 LEFT JOIN
 
 (
 	select substr(ds,1,10) as fecha2, application.site_id as site2, device.platform as platform3, jet(event_data, 'query') as query4, count(1) total_searchs
 	from tracks
 	where ds >= '@param01'
 	and ds < '@param02'
 	and path = '/search'
 	group by substr(ds,1,10), application.site_id, device.platform, jet(event_data, 'query')
 
 ) total_searchs
 ON (todo.query = total_searchs.query4 and todo.site = total_searchs.site2 and todo.platform = total_searchs.platform3)
 
 )todo
 where todo.total_searchs >= todo.total_buy
