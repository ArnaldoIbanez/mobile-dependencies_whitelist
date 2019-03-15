select 
    a11.SIT_SITE_ID  SIT_SITE_ID,
    a11.ite_item_id item_id,
    a11.cus_cust_id_buy buyer,
    sum((a11.BID_BASE_CURRENT_PRICE * a11.BID_QUANTITY_OK))  GMVE,
    sum(a11.BID_QUANTITY_OK)  SI,
    a11.TIM_DAY_WINNING_DATE  track_date
from melilake.bt_bids a11
  LEFT JOIN (
          SELECT usr.user_id as user_id,
            device.platform as platform,
            substr(ds,1,10) AS track_date
          FROM
            tracks 
          WHERE
            ds >= @param01
            AND ds < @param02
            AND ( (path like '/home/supermarket') OR  (path like '/search' AND jest(event_data, 'filters.deal') = 'MLM525') )
          group by 
            substr(ds,1,10),
            usr.user_id,
            device.platform
  ) AS USRS ON a11.cus_cust_id_buy  = USRS.user_id AND USRS.track_date = a11.tim_day_winning_date
where a11.is_test = 'false'
and a11.ite_supermarket_flag = 1
AND a11.tim_day_winning_date >= @param01
AND a11.tim_day_winning_date < @param02
and a11.ite_gmv_flag = 1
and a11.sit_site_id= 'MLM'
and a11.MKT_MARKETPLACE_ID = 'TM'
group by    
    a11.TIM_DAY_WINNING_DATE,
    a11.SIT_SITE_ID,
    a11.ite_item_id,
    a11.cus_cust_id_buy