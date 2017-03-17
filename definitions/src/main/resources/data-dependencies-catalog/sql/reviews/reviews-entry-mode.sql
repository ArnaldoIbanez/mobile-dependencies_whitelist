select substr(ds,1,10) as fecha,
    application.site_id as site,
    jest(others['fragment'],'entry') as entry,
    count(1) as cant
from tracks
where ds >= '@param01'
    and ds < '@param02'
    and application.site_id in ('MLA', 'MLB', 'MLC', 'MLM', 'MCO', 'MLV', 'MPE', 'MLU')
    and path = '/reviews/form' and json2txt(jet(event_data, 'flow')) = '"open"'
group by 1, 2, 3
