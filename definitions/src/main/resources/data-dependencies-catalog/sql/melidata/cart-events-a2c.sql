SELECT application.site_id as site,
device.platform AS device,
path as path,
COUNT(DISTINCT(usr.user_id)) AS cant_event,
substr(ds, 1 , 10) AS sent_date
FROM tracks
WHERE ds >= '@param01'
  AND ds < '@param02'
  AND path IN
    ('/vip/add_to_cart',
     '/vip/cart/add_to_cart',
     '/vip/combo/add_to_cart',
     '/recommendations/add_to_cart',
     '/vip/sellers_carousel/add_to_cart',
     '/bookmarks/add_to_cart',
     '/cart/my_cart/delete_item',
     'cart/my_cart/delete_item',
     '/cart/my_cart/more_seller_items'
     '/cart/change_list',
     '/cart/my_cart/save_for_later',
     'cart/my_cart/save_for_later',
     '/cart/save_for_later',
     '/cart/saved_for_later/add_to_cart',
     'cart/saved_for_later/add_to_cart',
     '/cart/add_to_cart',
     '/cart/my_cart/change_quantity',
     'cart/my_cart/change_quantity',
     '/change_quantity/cart',
     '/add_to_cart',
     '/cart/my_cart/free_shipping_lost_warning',
     '/cart/my_cart/free_shipping_lost_warning/dismiss',
     '/cart/my_cart/free_shipping_lost_warning/confirm',
     '/cart/saved_for_later/cant_add_to_cart')
GROUP BY application.site_id, device.platform, path, substr(ds, 1, 10)
