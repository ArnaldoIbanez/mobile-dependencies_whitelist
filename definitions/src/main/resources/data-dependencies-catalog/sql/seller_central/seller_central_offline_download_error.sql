select type, path, count(1) as cant
from tracks
where ds >= '@param01 02' 
	and ds < '@param02 02'
    and path like '/seller_central/bulk/offline/download/error'
