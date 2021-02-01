package src.test.resources.shipping

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "shipping"

    test("SSM test path") {

        "/"(platform: "/api") {}

        "/shipping"(platform: "/api") {}

        "/shipping/ssm"(platform: "/api") {}

        "/shipping/ssm/notifications"(platform: "/api") {}

        "/shipping/ssm/notifications/received"(platform: "/api") {
            id = "ec5c5a863a30cbe4bf0423cdd7ceaf16e94b9ab7a6d3283e3c1103dd66b7a880"
            notification = [
                    origin         : "MELI",
                    id             : "ec5c5a863a30cbe4bf0423cdd7ceaf16e94b9ab7a6d3283e3c1103dd66b7a880",
                    shipment_id    : 28499523232,
                    step_type      : [
                            id         : "first_mile",
                            description: "First mile"
                    ],
                    tracking_number: "339272892",
                    config         : [
                            should_check_duplicate_checkpoint: true,
                            sync                             : false,
                            reprocess                        : false
                    ],
                    code           : "1005",
                    payload        : [
                            date      : "2020-06-18T01:43:38Z",
                            comment   : "Label printed",
                            agency_id : "58051970",
                            location  : [
                                    state_id         : "PB",
                                    city_name        : "JOAO PESSOA",
                                    geolocation      : null,
                                    country_id       : "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id : "8260755013599183",
                            carrier_id: "100008"
                    ],
                    company_name   : "unknown"
            ]
            shipment_snapshot = [
                    id                : 28499523232,
                    status            : "shipped",
                    substatus         : null,
                    logistic_type     : "cross_docking",
                    site_id           : "MLB",
                    date_first_printed: "2020-05-27T11:25:34Z"
            ]
        }

        "/shipping/ssm/notifications/processed"(platform: "/api") {
            id = "ec5c5b843c3ccbebbc0f2bcdd0ceaf16ef4191b7a5d42b393a110bdb62b6a88f"
            notification = [
                    origin         : "carrier-push",
                    id             : "ec5c5b843c3ccbebbc0f2bcdd0ceaf16ef4191b7a5d42b393a110bdb62b6a88f",
                    shipment_id    : 28232514144,
                    tracking_number: "ML09546380",
                    config         : [
                            should_check_duplicate_checkpoint: true,
                            sync                             : false,
                            reprocess                        : false
                    ],
                    code           : "0201",
                    payload        : [
                            date      : "2020-01-29T06:38:05Z",
                            cost      : 0,
                            comment   : "Encomenda recebida na Transfolha e em Processo de Check-in",
                            agency_id : "58051970",
                            client_id : "6001848207092545",
                            carrier_id: "13"
                    ],
                    company_name   : "transfolha"
            ]
            shipment_transition = [
                    status                        : "SHIPPED",
                    substatus                     : null,
                    status_history                : [
                            date_handling     : "2020-01-27T15:50:01Z",
                            date_ready_to_ship: "2020-01-27T15:50:01Z",
                            date_shipped      : "2020-01-29T04:26:27Z",
                            date_first_visit  : null,
                            date_delivered    : null,
                            date_cancelled    : null,
                            date_not_delivered: null,
                            date_returned     : null
                    ],
                    date_first_printed            : null,
                    substatus_history             : [],
                    tracking_number               : null,
                    service_id                    : null,
                    return_tracking_number        : null,
                    need_status_update            : false,
                    need_update_status_history    : false,
                    need_update_substatus_history : false,
                    need_update_date_first_printed: false
            ]
        }

        "/shipping/ssm/notifications/rejected"(platform: "/api") {
            id = "ec5c5b863f35c7eab90529c5d6ceaf16ef4796baa0d52c3b3e1100df6eb3ac8c"
            code = "1005"
            reason = "shipment_invalid_status"
            shipment_snapshot = [
                    id                : 28255845660,
                    status            : "ready_to_ship",
                    substatus         : "printed",
                    logistic_type     : "drop_off",
                    site_id           : "MLB",
                    date_first_printed: "2020-02-19T13:27:58Z"
            ]
        }

        "/shipping/ssm/notifications/feed"(platform: "/api") {
            notification_id = "ec5c5b843f30cfe0be0d22c6d6ceaf16ef4191b7a5d42b393a1101dd62b4ab8f"
            data = [
                    shipment_id: 28255845660,
                    status     : "ready_to_ship",
                    substatus  : "invoice_pending",
                    differences: [
                            [
                                    field: "status",
                                    from : "pending",
                                    to   : "ready_to_ship"
                            ],
                            [
                                    field: "substatus",
                                    from : "creating_route",
                                    to   : "invoice_pending"
                            ]
                    ],
                    delay      : [],
                    origin     : "ssm-core"
            ]
        }

    }
}
