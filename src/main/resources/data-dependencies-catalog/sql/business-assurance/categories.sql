select  substr(id, 1, 3) as site, 
        id as id,
        name as name, 
        split(path_from_root,'->')[0] as L1, 
        split(full_name,'->')[0] as L1_name, 
        split(path_from_root,'->')[1] as L2,
        split(full_name,'->')[1] as L2_name,
        split(path_from_root,'->')[2] as L3, 
        split(full_name,'->')[2] as L3_name, 
        split(path_from_root,'->')[3] as L4,
        split(full_name,'->')[3] as L4_name
from categories