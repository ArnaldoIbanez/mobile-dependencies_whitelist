select substr(ds,1,10) as fecha,
    application.site_id as site,
    path,
    count_if(json2txt(jet(event_data, 'flow')) = '"open"') as open,
    count_if(json2txt(jet(event_data, 'flow')) = '"click_star"') as click_star,
    count_if(json2txt(jet(event_data, 'flow')) = '"description_keyup"') as add_desc,
    count_if(json2txt(jet(event_data, 'flow')) = '"title_keyup"') as add_title
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form'
group by 1, 2, 3
