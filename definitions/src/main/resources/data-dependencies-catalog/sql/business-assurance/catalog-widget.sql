select  substr(ds,1,10) as fecha, 
       application.site_id as site, 
       device.platform AS platform, 
tracks.path as Path,
Page, Seller_Id, Item_Id, Domain_id,Category_Id, Official_Store, Itmes_Left, 
Completeness_level,Motive, PI_Field, Attr_Id, Hierarchy,Option_Selected,Value,
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
from tracks
lateral view json_tuple(event_data, 'page', 'seller_id' , 'item_id', 'domain_id','category_id', 'officialstore' , 'item_left', 'completeness_level',
'motive', 'pi' , 'attribute_id', 'hierarchy','option_selected', 'value') t1 
as Page, Seller_Id, Item_Id, Domain_id, Category_Id, Official_Store, Itmes_Left,Completeness_level, Motive, PI_Field, Attr_Id, Hierarchy, Option_Selected,Value 
where  tracks.path like '%widget%' and application.business='mercadolibre'and type='event'and tracks.path not like '/catalogwidget/show'
AND ds >= '@param01 02' AND ds < '@param02 02' 
