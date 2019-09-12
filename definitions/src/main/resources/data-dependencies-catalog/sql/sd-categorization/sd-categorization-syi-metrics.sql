SELECT application.site_id AS site_id,
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
get_json_object(event_data, '$.attributes_ids_predicted[0]') AS attributes_ids_predicted_1,
get_json_object(event_data, '$.attributes_ids_predicted[1]') AS attributes_ids_predicted_2,
get_json_object(event_data, '$.attributes_ids_predicted[2]') AS attributes_ids_predicted_3,
get_json_object(event_data, '$.attributes_ids_predicted[3]') AS attributes_ids_predicted_4,
get_json_object(event_data, '$.attributes_ids_predicted[4]') AS attributes_ids_predicted_5,
get_json_object(event_data, '$.attributes_values_predicted[0]') AS attributes_values_predicted_1,
get_json_object(event_data, '$.attributes_values_predicted[1]') AS attributes_values_predicted_2,
get_json_object(event_data, '$.attributes_values_predicted[2]') AS attributes_values_predicted_3,
get_json_object(event_data, '$.attributes_values_predicted[3]') AS attributes_values_predicted_4,
get_json_object(event_data, '$.attributes_values_predicted[4]') AS attributes_values_predicted_5,
get_json_object(event_data, '$.attributes_selected_in_tree[0]') AS attributes_selected_in_tree_1,
get_json_object(event_data, '$.attributes_selected_in_tree[1]') AS attributes_selected_in_tree_2,
get_json_object(event_data, '$.attributes_selected_in_tree[2]') AS attributes_selected_in_tree_3,
get_json_object(event_data, '$.attributes_selected_in_tree[3]') AS attributes_selected_in_tree_4,
get_json_object(event_data, '$.attributes_selected_in_tree[4]') AS attributes_selected_in_tree_5,
substr(ds,1,10) AS ds
FROM tracks
WHERE ds >= '@param01'
AND ds < '@param02'
AND path in ('/sell/list/congrats','/sell/congrats')
AND device.platform = '/web/desktop'
AND (get_json_object(event_data, '$.vertical') = 'CORE' OR get_json_object(event_data, '$.vertical') IS NULL)
AND length(get_json_object(event_data, '$.title_predicted')) > 1
AND application.site_id in ('MLA','MLB','MLM')
AND get_json_object(event_data, '$.predictor_chosen') = 'ZORDON'
AND get_json_object(event_data, '$.category_prediction_zordon_score') IS NOT NULL
