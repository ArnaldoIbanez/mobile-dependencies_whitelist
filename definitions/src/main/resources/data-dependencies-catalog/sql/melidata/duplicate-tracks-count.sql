select processed.ds, processed.processed_total, raw_count.raw_total
from (
    select ds, count(1) as processed_total
    from (
        select raw.id as id, raw.ds as ds
        from (
            select jest(data, 'id') as id, substr(ds,1,10) as ds
            from raw
            where ds >= '@param01' and ds < '@param02'
        ) raw
        inner join (
            select id, substr(ds,1,10) as ds
            from tracks
            where ds >= '@param01' and ds < '@param02'
            union
            select id, ds
            from tracks_part
            where ds >= '@param01' and ds < '@param02'
        ) complete_part
        on raw.id = complete_part.id
        group by raw.id, raw.ds
    ) raw_complete_part
    group by ds
) processed
left join (
    select substr(ds,1,10) as ds, count(1) as raw_total
    from raw
    where ds >= '@param01' and ds < '@param02'
    group by ds
) raw_count
on raw_count.ds = processed.ds

