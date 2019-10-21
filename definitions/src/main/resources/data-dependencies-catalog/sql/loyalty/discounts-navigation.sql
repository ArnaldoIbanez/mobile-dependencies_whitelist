select
  list.site_id,
  count(distinct list.user_id) prints_in_list,
  count(distinct editor.user_id) prints_in_editor,
  count(distinct individual_print.user_id) prints_in_individual,
  count(distinct individual_save.user_id) users_save_in_individual,
  count(distinct massivel_save.user_id) users_save_in_massive,
  count(distinct count_discounts.item_id) count_items_saved_in_individual,
  list.ds
from (
  select distinct(usr.user_id) user_id, usr.user_nick user_nick, application.site_id site_id, substr(ds,1,10) ds
  from tracks
  where path = '/seller_central/listings/list/promos'
  AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) list
left join (
  select distinct(usr.user_id) user_id, usr.user_nick user_nick, application.site_id site_id, substr(ds,1,10) ds
  from tracks
  where path = '/seller_central/bulk/discounts/list'
  AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) editor on list.site_id = editor.site_id
and list.user_id = editor.user_id
and list.ds = editor.ds
and editor.user_id is not NULL
left join (
  select distinct(usr.user_id) user_id, application.site_id site_id, substr(ds,1,10) ds
  from tracks
  where  path = '/myml/loyal_discounts'
   AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) individual_print on list.site_id = individual_print.site_id
and list.user_id = individual_print.user_id
and list.ds = individual_print.ds
and individual_print.user_id is not NULL
left join (
  select distinct(usr.user_id) user_id, application.site_id site_id, substr(ds,1,10) ds
  from tracks
  where  path = '/myml/loyal_discounts/add'
   AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) individual_save on list.site_id = individual_save.site_id
and list.user_id = individual_save.user_id
and list.ds = individual_save.ds
and individual_save.user_id is not NULL
left join (
  select distinct(usr.user_id) user_id, application.site_id site_id, substr(ds,1,10) ds
  from tracks
  where  path = '/seller_central/bulk/discounts/save'
   AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) massivel_save on list.site_id = massivel_save.site_id
and list.user_id = massivel_save.user_id
and list.ds = massivel_save.ds
and massivel_save.user_id is not NULL
left join (
  select distinct(jest(event_data, 'item')) item_id, usr.user_id user_id, application.site_id site_id,  substr(ds,1,10) ds
  from tracks
  where  path = '/myml/loyal_discounts/add'
   AND DS >= '@param01' 
  AND DS < '@param02'
 and not (usr.user_nick RLIKE '^(TETE|TT|TEST)[0-9]*')
) count_discounts on list.site_id = count_discounts.site_id
and list.user_id = count_discounts.user_id
and list.ds = count_discounts.ds
and count_discounts.item_id is not NULL
group by list.site_id, list.ds;
