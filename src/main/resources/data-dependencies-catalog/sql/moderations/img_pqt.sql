SELECT  
count(distinct i.cus_cust_id_sel) as seller,
count(distinct i.ite_item_id) as publicaciones,
i.sit_site_id as site,
i.ite_domain_id as domain,
pic_tagged_date as datepic,
case when app.mapp_is_public =  0 then 'NOINTEGRADO' else 'INTEGRADO' end as Integracion,
 t.ite_condition_id as proveedores,
 app.mapp_name as App
FROM melilake.lk_pic_quality_tagger t
left join melilake.lk_ite_items i
on (i.ite_item_id = t.ite_item_id and i.sit_site_id = t.sit_site_id)
left join melilake.lk_app_applications app
on (app.mapp_app_id = i.mapp_app_id)
inner join melilake.lk_indexer_operation iop on (cast(iop.iop_element_id as decimal(10,0)) = t.ite_item_id and iop.iop_site_id = t.sit_site_id)
where  ite_pic_quality = 'poor'
and pic_tagged_date >= '2020-01-01'
and pic_tagged_date < '2020-04-27'
and ite_condition_passed_flag = false
group by i.sit_site_id,i.ite_domain_id,pic_tagged_date,case when app.mapp_is_public = 0 then 'NOINTEGRADO' else 'INTEGRADO' end,
 t.ite_condition_id, app.mapp_name 