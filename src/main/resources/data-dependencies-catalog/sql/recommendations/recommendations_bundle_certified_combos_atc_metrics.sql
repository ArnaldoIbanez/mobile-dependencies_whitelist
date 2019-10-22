SELECT '@param01' AS ds,
       atcs.site_id AS site_id,
       prints.certified_prints AS certified_prints,
       atcs.certified_atcs AS certified_atcs, 
       cast(atcs.certified_atcs * 100.00 / prints.certified_prints as double) AS certified_atc_ratio,
       prints.not_certified_prints AS not_certified_prints,
       atcs.not_certified_atcs AS not_certified_atcs,
       cast(atcs.not_certified_atcs * 100.00 / prints.not_certified_prints as double) AS not_certified_atc_ratio
FROM
(
  SELECT atc.application.site_id AS site_id,
         Sum(if(jest(print.event_data, 'recommendations.track_info.combo_type') = 'certified'
           OR jest(print.event_data, 'recommendations.track_info.combo_type') = 'certified_in_fallback', 1, 0)) AS certified_atcs,
         Sum(if(jest(print.event_data, 'recommendations.track_info.combo_type') <> 'certified'
           AND jest(print.event_data, 'recommendations.track_info.combo_type') <> 'certified_in_fallback', 1, 0)) AS not_certified_atcs
  FROM tracks atc
  JOIN tracks print ON jest(atc.event_data, 'recommendation_id') = jest(print.event_data, 'recommendations.recommendation_id') 
  WHERE atc.path = '/recommendations/add_to_cart'
    AND atc.ds >= '@param01'
    AND atc.ds < '@param02'
    AND jest(atc.event_data, 'client') = 'vip_combo'
    AND jet(atc.event_data, 'items') IS NOT NULL
    AND size(json_to_array(jet(atc.event_data, 'items'))) > 1
    AND print.ds >= '@param01'
    AND print.ds < '@param02'
    AND jest(print.event_data, 'recommendations.client') = 'vip_combo'
    AND print.path = '/vip'
  GROUP BY atc.application.site_id
) atcs, 
(
  SELECT print.application.site_id AS site_id, 
         Sum(if(jest(print.event_data, 'recommendations.track_info.combo_type') = 'certified'
           OR jest(print.event_data, 'recommendations.track_info.combo_type') = 'certified_in_fallback', 1, 0)) AS certified_prints,
         Sum(if(jest(print.event_data, 'recommendations.track_info.combo_type') <> 'certified'
           AND jest(print.event_data, 'recommendations.track_info.combo_type') <> 'certified_in_fallback', 1, 0)) AS not_certified_prints
  FROM tracks print
  WHERE jest(print.event_data, 'recommendations.client') = 'vip_combo'
    AND print.ds >= '@param01'
    AND print.ds < '@param02'
    AND print.path = '/vip'
  GROUP BY print.application.site_id
) prints
WHERE atcs.site_id = prints.site_id;