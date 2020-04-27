SELECT COUNT(*) as conteo, B.seller as seller, B.publicaciones as publicaciones, B.proveedores as proveedores, 
      B.Integracion as integracion, B.site as site, B.pictureId as pictureId,
       case when B.datepic >= '2020-01-01' and B.datepic < '2020-02-01' then 'ENERO' 
      when  B.datepic >= '2020-02-01' and B.datepic < '2020-03-01' then 'FEBRERO' 
      when  B.datepic >= '2020-03-01' and B.datepic < '2020-04-01' then 'MARZO'
      when  B.datepic >= '2020-04-01' and B.datepic < '2020-05-01' then 'ABRIL' 
      when  B.datepic >= '2020-05-01' and B.datepic < '2020-06-01' then 'MAYO'
      when  B.datepic >= '2020-06-01' and B.datepic < '2020-07-01' then 'JUNIO'
      when  B.datepic >= '2020-07-01' and B.datepic < '2020-08-01' then 'JULIO'
      when  B.datepic >= '2020-08-01' and B.datepic < '2020-09-01' then 'AGOSTO'
      when  B.datepic >= '2020-09-01' and B.datepic < '2020-10-01' then 'SEPTIEMBRE'
      when  B.datepic >= '2020-10-01' and B.datepic < '2020-11-01' then 'OCTUBRE'
      when  B.datepic >= '2020-11-01' and B.datepic < '2020-12-01' then 'NOVIEMBRE'
      when  B.datepic >= '2020-12-01' and B.datepic < '2021-01-01' then 'DICIEMBRE'
      end AS mes, 
    from
    (SELECT 
    distinct i.cus_cust_id_sel as seller,
    i.ite_item_id as publicaciones, 
    t.ite_picture_id as pictureId,
    i.sit_site_id as site, 
    pic_tagged_date as datepic, 
    case when app.mapp_is_public = 0 then 'NOINTEGRADO' else 'INTEGRADO' end as Integracion, 
     t.ite_condition_id as proveedores
    FROM melilake.lk_pic_quality_tagger t 
    left join melilake.lk_ite_items i on (i.ite_item_id = t.ite_item_id and i.sit_site_id = t.sit_site_id)
    left join melilake.lk_app_applications app
    on (app.mapp_app_id = i.mapp_app_id)
    inner join melilake.lk_indexer_operation iop on (cast(iop.iop_element_id as decimal(10,0)) = t.ite_item_id and iop.iop_site_id = t.sit_site_id)
    where  ite_pic_quality = 'poor'
    and pic_tagged_date >= '2020-01-01'
    and pic_tagged_date < '2020-04-27'
    and ite_condition_passed_flag = false
    )B
    group by B.seller, B.publicaciones, B.proveedores, case when B.datepic >= '2020-01-01' and B.datepic < '2020-02-01' then 'ENERO' 
      when  B.datepic >= '2020-02-01' and B.datepic < '2020-03-01' then 'FEBRERO' 
      when  B.datepic >= '2020-03-01' and B.datepic < '2020-04-01' then 'MARZO'
      when  B.datepic >= '2020-04-01' and B.datepic < '2020-05-01' then 'ABRIL' 
      when  B.datepic >= '2020-05-01' and B.datepic < '2020-06-01' then 'MAYO'
      when  B.datepic >= '2020-06-01' and B.datepic < '2020-07-01' then 'JUNIO'
      when  B.datepic >= '2020-07-01' and B.datepic < '2020-08-01' then 'JULIO'
      when  B.datepic >= '2020-08-01' and B.datepic < '2020-09-01' then 'AGOSTO'
      when  B.datepic >= '2020-09-01' and B.datepic < '2020-10-01' then 'SEPTIEMBRE'
      when  B.datepic >= '2020-10-01' and B.datepic < '2020-11-01' then 'OCTUBRE'
      when  B.datepic >= '2020-11-01' and B.datepic < '2020-12-01' then 'NOVIEMBRE'
      when  B.datepic >= '2020-12-01' and B.datepic < '2021-01-01' then 'DICIEMBRE' END, B.Integracion, B.site, B.pictureId