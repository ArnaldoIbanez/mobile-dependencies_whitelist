SELECT  
i.cus_cust_id_sel as seller,
i.ite_item_id as publicaciones,
i.sit_site_id as site,
i.ite_domain_id as domain,
case when app.mapp_is_public =  0 then 'NOINTEGRADO' else 'INTEGRADO' end as integracion,
 t.ite_condition_id as proveedores,
 app.mapp_name as app,
 t.ite_picture_id as pictureId,
 pic_tagged_date as datepic
from melilake.lk_pic_quality_tagger t
left join melilake.lk_ite_items i
on (i.ite_item_id = t.ite_item_id and i.sit_site_id = t.sit_site_id)
left join melilake.lk_app_applications app
on (app.mapp_app_id = i.mapp_app_id)
inner join melilake.lk_indexer_operation iop on (cast(iop.iop_element_id as decimal(10,0)) = t.ite_item_id and iop.iop_site_id = t.sit_site_id)
where  ite_pic_quality = 'poor'
and pic_tagged_date >= '@param01'
and pic_tagged_date < '@param02'
and ite_condition_passed_flag = false