SELECT substr(ds,1,10) AS event_date,
application.site_id AS site_id,
get_json_object(event_data, '$.category_path[0]') AS category_selected_l1,
get_json_object(event_data, '$.category_path[1]') AS category_selected_l2,
get_json_object(event_data, '$.category_path[2]') AS category_selected_l3,
get_json_object(event_data, '$.category_path[3]') AS category_selected_l4,
get_json_object(event_data, '$.category_path[4]') AS category_selected_l5,
get_json_object(event_data, '$.category_path[5]') AS category_selected_l6,
get_json_object(event_data, '$.category_path[6]') AS category_selected_l7,
get_json_object(event_data, '$.category_prediction_zordon[0]') AS category_prediction_l1,
get_json_object(event_data, '$.category_prediction_zordon[1]') AS category_prediction_l2,
get_json_object(event_data, '$.category_prediction_zordon[2]') AS category_prediction_l3,
get_json_object(event_data, '$.category_prediction_zordon[3]') AS category_prediction_l4,
get_json_object(event_data, '$.category_prediction_zordon[4]') AS category_prediction_l5,
get_json_object(event_data, '$.category_prediction_zordon[5]') AS category_prediction_l6,
get_json_object(event_data, '$.category_prediction_zordon[6]') AS category_prediction_l7,
get_json_object(event_data, '$.category_prediction_zordon_score[0]') AS category_prediction_score_l1,
get_json_object(event_data, '$.category_prediction_zordon_score[1]') AS category_prediction_score_l2,
get_json_object(event_data, '$.category_prediction_zordon_score[2]') AS category_prediction_score_l3,
get_json_object(event_data, '$.category_prediction_zordon_score[3]') AS category_prediction_score_l4,
get_json_object(event_data, '$.category_prediction_zordon_score[4]') AS category_prediction_score_l5,
get_json_object(event_data, '$.category_prediction_zordon_score[5]') AS category_prediction_score_l6,
get_json_object(event_data, '$.category_prediction_zordon_score[6]') AS category_prediction_score_l7,
substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path = '/sell/list/congrats'
AND device.platform = '/web/desktop'
AND get_json_object(event_data, '$.vertical') = 'CORE'
AND length(get_json_object(event_data, '$.title_predicted')) > 1
AND application.site_id in ('MLA','MLB','MLM')
AND get_json_object(event_data, '$.predictor_chosen') = 'ZORDON'
AND get_json_object(event_data, '$.category_prediction_zordon_score') IS NOT NULL