SELECT tracks_flows_total.platform, 
       tracks_flows_total.ds_date as creation_date,
       tracks_flows_total.collector_nickname, 
       tracks_flows_total.collector_id,
       tracks_flows_total.site_id, 
       tracks_flows_total.flows_total,
       tracks_flow_collections_total.flow_collections_total,
       replace(CAST(COALESCE(ROUND(((tracks_flow_collections_total.flow_collections_total * 100) / CAST(tracks_flows_total.flows_total as DOUBLE)), 2), 0) as VARCHAR), '.', ',')  as conversion,
       tracks_1.flow_v0_count as flow_v0_count,
       tracks_2.flow_collection_v0_count as flow_collection_v0_count,
       COALESCE(replace(CAST(ROUND(((tracks_2.flow_collection_v0_count * 100) / CAST(tracks_1.flow_v0_count as DOUBLE)), 2) as VARCHAR), '.', ','), '0')  as v0_conversion,
       tracks_3.flow_v1_count as flow_v1_count,
       tracks_4.flow_collection_v1_count as flow_collection_v1_count,
       COALESCE(replace(CAST(ROUND(((tracks_4.flow_collection_v1_count * 100) / CAST(tracks_3.flow_v1_count as DOUBLE)), 2) as VARCHAR), '.', ','), '0')  as v1_conversion
    FROM 
    (
        SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
               jest(event_data, 'collector_id') as collector_id, application.site_id, 
               count(DISTINCT jest(event_data, 'checkout_flow_id')) as flows_total
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/init' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
      ) tracks_flows_total
  LEFT JOIN
    (
      SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
             jest(event_data, 'collector_id') as collector_id, application.site_id, 
             count(DISTINCT jest(event_data, 'checkout_flow_id')) as flow_collections_total
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/congrats' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
      ) tracks_flow_collections_total
    ON tracks_flows_total.platform = tracks_flow_collections_total.platform and tracks_flows_total.site_id = tracks_flow_collections_total.site_id and 
       tracks_flows_total.ds_date = tracks_flow_collections_total.ds_date and tracks_flows_total.collector_nickname = tracks_flow_collections_total.collector_nickname and
       tracks_flows_total.collector_id = tracks_flow_collections_total.collector_id
    LEFT JOIN
      (
      SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
                       jest(event_data, 'collector_id') as collector_id, application.site_id, 
                       count(DISTINCT jest(event_data, 'checkout_flow_id')) as flow_v0_count
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/init' and 
                              application.version = 'v0' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
    ) tracks_1
    ON tracks_flows_total.platform = tracks_1.platform and tracks_flows_total.site_id = tracks_1.site_id and tracks_flows_total.ds_date = tracks_1.ds_date and
       tracks_flows_total.collector_nickname = tracks_1.collector_nickname and tracks_flows_total.collector_id = tracks_1.collector_id
    LEFT JOIN
            (
              SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
                       jest(event_data, 'collector_id') as collector_id, application.site_id, 
                     count(DISTINCT jest(event_data, 'checkout_flow_id')) as flow_collection_v0_count
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/congrats' and 
                              application.version = 'v0' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
            ) tracks_2
    ON tracks_flows_total.platform = tracks_2.platform and tracks_flows_total.site_id = tracks_2.site_id and tracks_flows_total.ds_date = tracks_2.ds_date and
       tracks_flows_total.collector_nickname = tracks_2.collector_nickname and tracks_flows_total.collector_id = tracks_2.collector_id
    LEFT JOIN
    (
                SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
                       jest(event_data, 'collector_id') as collector_id, application.site_id, 
                       count(DISTINCT jest(event_data, 'checkout_flow_id')) as flow_v1_count
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/init' and 
                              application.version = 'v1' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
            ) tracks_3
     ON tracks_flows_total.platform = tracks_3.platform and tracks_flows_total.site_id = tracks_3.site_id and tracks_flows_total.ds_date = tracks_3.ds_date and
        tracks_flows_total.collector_nickname = tracks_3.collector_nickname and tracks_flows_total.collector_id = tracks_3.collector_id
     LEFT JOIN
     (
      SELECT device.platform, substr(ds, 1, 10) as ds_date, jest(event_data, 'collector_nickname') as collector_nickname, 
                       jest(event_data, 'collector_id') as collector_id, application.site_id, 
                     count(DISTINCT jest(event_data, 'checkout_flow_id')) as flow_collection_v1_count
                    FROM tracks
                        WHERE type = 'view' and
                              ds>='@param01' and 
                              ds<'@param02' and 
                              path = '/checkout_off/congrats' and 
                              application.version = 'v1' and
                              jest(event_data, 'scope') != 'beta' and
                              jest(event_data, 'scope') IS NOT NULL and
                              catalog_data.is_valid = true and
                              (application.site_id <> 'MLA' or jest(event_data, 'collector_id') IN ('99635234', '99696162', '152667538', '192113402', '118966385', '109458301', '138185050', '177944835', '177928883', '127725750', '149532342', '144300544', '16496382', '62615447', '73314351', '137131218', '161489845', '154550560', '175655856', '147419035', '205060854', '153906449', '149974837', '47642517', '122909634', '115825462'))
                            GROUP BY device.platform, substr(ds, 1, 10), jest(event_data, 'collector_nickname'),
                                     jest(event_data, 'collector_id'), application.site_id
     ) tracks_4
     ON tracks_flows_total.platform = tracks_4.platform and tracks_flows_total.site_id = tracks_4.site_id and tracks_flows_total.ds_date = tracks_4.ds_date and
        tracks_flows_total.collector_nickname = tracks_4.collector_nickname and tracks_flows_total.collector_id = tracks_4.collector_id






