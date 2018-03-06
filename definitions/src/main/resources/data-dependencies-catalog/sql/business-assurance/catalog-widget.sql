SELECT 
       substr(ds,1,10) as fecha, 
       application.site_id as site, 
       device.platform AS platform, 
       tracks.path as Path,
       jest(event_data, 'page') AS Page,
       jest(event_data, 'seller_id') AS Seller_Id,
       jest(event_data, 'item_id') AS Item_Id, 
       jest(event_data, 'domain_id') AS Domain_Id, 
       jest(event_data, 'category_id') AS Category_Id,
       jest(event_data, 'officialstore') AS Official_Store,
       jest(event_data, 'items_left') AS Items_Left,
       jest(event_data, 'completeness_level') AS Completeness_level,
       jest(event_data, 'motive') AS Motive,
       jest(event_data, 'pi') AS PI_Field,
       jest(event_data, 'attribute_id') AS Attr_Id,
       jest(event_data, 'hierarchy') AS Hierarchy,
       jest(event_data, 'option_selected') AS Option_Selected,
       jest(event_data, 'value') AS Value,
       if(tracks.path like '/catalogwidget/showitem',1,0) as Show_Item,
       if(tracks.path like '/catalogwidget/minimize',1,0) as Minimize,
       if(tracks.path like '/catalogwidget/maximize',1,0) as Maximize,
       if(tracks.path like '/catalogwidget/cancel',1,0) as Cancel,
       if(tracks.path like '/catalogwidget/save',1,0) as Save,
       if(tracks.path like '/catalogwidget/final_congrats',1,0) as Final_Congrats,
       if(tracks.path like '/catalogwidget/omit',1,0) as Omit,
       if(tracks.path like '/catalogwidget/omit_save',1,0) as Omit_Save,
       if(tracks.path like '/catalogwidget/pi',1,0) as PI,
       if(tracks.path like '/catalogwidget/next',1,0) as Next,
       if(tracks.path like '/catalogwidget/redo',1,0) as ReDo,
       if(tracks.path like '/catalogwidget/pi_save',1,0) as PI_Save,
       if(tracks.path like '/catalogwidget/pi_cancel',1,0) as PI_Cancel,
       if(tracks.path like '/catalogwidget/discover',1,0) as Discover,
       if(tracks.path like '/catalogwidget/save_again',1,0) as Save_Again,
       if(tracks.path like '/catalogwidget/coachmark',1,0) as CoachMark,
       if(tracks.path like '/%omit_attributes/submit%',1,0) as Omit_Atrr_Submit
FROM tracks
where  tracks.path like '%widget%' 
and application.business='mercadolibre'
and type='event'
and tracks.path not like '/catalogwidget/show'
AND ds >= '@param01 02' AND ds < '@param02 02' 
