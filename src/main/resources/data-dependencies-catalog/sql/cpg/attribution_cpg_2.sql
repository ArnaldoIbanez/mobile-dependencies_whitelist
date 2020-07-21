select 
   a11.SIT_SITE_ID  SIT_SITE_ID,
   a11.ite_item_id item_id,
   a11.cus_cust_id_buy buyer,
   USRS.user_id navegation_user,
   USRS.platform platform,
   sum((a11.BID_BASE_CURRENT_PRICE * a11.BID_QUANTITY_OK))  GMVE,
   sum(a11.BID_QUANTITY_OK)  SI,
   cast(a11.tim_day_winning_date as string)  track_date
from melilake.bt_bids a11
 LEFT JOIN (
         SELECT usr.user_id as user_id,
           device.platform as platform,
           substr(ds,1,10) AS track_date
         FROM
           melidata.tracks_ml
         WHERE
           ds >= '@param01'
           AND ds < '@param02'
           AND bu = 'mercadolibre'
           AND site = 'MLM'
           AND ( (path = '/home/supermarket') OR  (path = '/search' AND get_json_object(event_data, '$.filters.deal') = 'MLM525') )
         group by 
           substr(ds,1,10),
           usr.user_id,
           device.platform
 ) AS USRS ON a11.cus_cust_id_buy  = USRS.user_id AND USRS.track_date = cast(a11.tim_day_winning_date as string)
where a11.is_test = 'false'
and a11.ite_supermarket_flag = 1
AND cast(a11.tim_day_winning_date as string) >= '@param01'
AND cast(a11.tim_day_winning_date as string) < '@param02'
and a11.ite_gmv_flag = 1
and a11.sit_site_id= 'MLM'
and a11.MKT_MARKETPLACE_ID = 'TM'
group by    
   cast(a11.tim_day_winning_date as string),
   a11.SIT_SITE_ID,
   a11.ite_item_id,
   a11.cus_cust_id_buy,
   USRS.user_id,
   USRS.platform