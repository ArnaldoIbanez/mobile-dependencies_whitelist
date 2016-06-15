select path as siteid, count(1) as clicks from tracks where ds>YESTERDAY and ds<TODAY group by path
