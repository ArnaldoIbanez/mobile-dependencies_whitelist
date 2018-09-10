select 
  path,
  application.site_id as site,
  usr.user_id as usuario,
  device.platform as platform,
  if (path in ('/flex/error'), 'Error de Pantalla', 
    if (path = '/flex/error/session_expired','Error_Session_Expired', 
        if (path = '/flex/package/list/map_too_many_packages', 'Error_TooMany_Package',
            if (path = '/flex/error/snackbar', 'Error_SnackBar','Otro')))) as tipo_error,
  jest(event_data, 'error_type') as error_type,
  substr(ds,1,10) as ds
from tracks 
where  ds>='@param01' AND ds<'@param02'
  and application.business='mercadoenvios'
  and path in('/flex/error','/flex/error/session_expired','/flex/package/list/map_too_many_packages','/flex/error/snackbar')
  
