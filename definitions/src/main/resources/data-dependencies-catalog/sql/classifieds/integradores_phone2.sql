SELECT count(distinct(it.ite_item_id)), it.sit_site_id, bvitem.vertical, it.mapp_app_id, bvitem.whatsapp, bvitem.ds
FROM melilake.lk_ite_items it,
    melilake.lk_ite_item_address ad,
    (SELECT distinct bv.item as id, bv.vertical, jest(bv.event_data, '$.whatsapp_available') as whatsapp, substr(bv.ds,1,10) as ds
    FROM melilake.bt_vip bv
    WHERE bv.sit_site_id in ('MLA','MLB','MLM','MCO')
        AND bv.device_platform in ('/web/mobile','/web/mobile/static')
        AND bv.ite_item_status = 'active'
        AND bv.vertical in ('realEstate','motors')
        AND bv.ds >= '@param01' and bv.ds < '@param02') as bvitem
WHERE it.sit_site_id in ('MLA','MLB','MLM','MCO')
    AND it.is_test = 'false'
    AND it.ite_item_id = cast(substr(bvitem.id,4,14) as int)
    AND ad.ite_item_id = it.ite_item_id
    AND ad.ite_add_phone2 is not null AND ad.ite_add_phone2 != '' AND ad.ite_add_phone2 != 'null'
    AND it.mapp_app_id in (
'2883142493213268',
'4434508699673146',
'7876341638967960',
'4685986675438440',
'7810940008532',
'6401445433899454',
'3145348869647973',
'5907909896319949',
'8221582745072972',
'3546276286655939',
'616277611120680',
'1059531196595234',
'5350491489384576',
'7104659752379893',
'779856112230830',
'2434607776489969',
'481820403818575',
'6581681856766724',
'8264105382966844',
'6527916401770753',
'15960718270120',
'8616516094441707',
'7247735977125379',
'1954505646029890',
'13420',
'7992507307413290',
'7974724296797993',
'13459',
'5625239023247579',
'8982823205274535',
'4897443113823011',
'5796738075633061',
'4621392395826863',
'8273411734117174',
'854567884600374',
'4008411104474889',
'4709975701260268',
'10050',
'7632835793739921',
'1441378210517427',
'5387223166827464',
'5268846267775305',
'2779895956107272',
'8174457992840116',
'8646306028803863',
'2056273078903889',
'2266840896972062',
'8108606028150436',
'6083469935869223',
'2190371369745109',
'3442883599849852',
'377188858949192',
'5433147362026417',
'1508839375391949',
'7345063022784193',
'6622949946619365',
'2749336099305028',
'8009934598767852',
'8264105382966844',
'2161946831689230',
'3491230934118776',
'1200854793265241',
'1405194154990352',
'2103745665163760',
'1753890889322286',
'4044113243382026',
'7868546015121789',
'1480228765889090',
'3607167744988726',
'4022314083101778',
'3397909440458333',
'2109412159089042',
'416847407736630',
'872287608638709',
'8236505178611511',
'8202440532121384',
'3657794946328286'
)
GROUP BY it.sit_site_id, bvitem.vertical, it.mapp_app_id, bvitem.whatsapp, bvitem.ds