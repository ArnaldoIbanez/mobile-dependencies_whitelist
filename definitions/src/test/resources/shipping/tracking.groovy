package src.test.resources.shipping

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "shipping"

    test("Tracking test path") {

        "/"(platform: "/api") {}

        "/notifications"(platform: "/api") {
            shipment_id = 27752190312
            notification = [
                    origin: "carrier-pull",
                    tracking_number: "OG357465336BR",
                    payload: [
                            agency_id: "58051970",
                            location: [
                                    state_id: "PB",
                                    city_name: "JOAO PESSOA",
                                    geolocation: null,
                                    country_id: "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id: "100008",
                            comment: "Destinatário não retirou objeto na Unidade dos Correios",
                            date: "2019-01-07T11:42:00Z",
                            carrier_id: "100008"
                    ],
                    shipment_id: 27752190312,
                    code: "0621"
            ]
        }

        "/notifications/received"(platform: "/api") {
            shipment_id = 27752190312
            notification_id = "1550919708135-27866910716-4bd030ab-0d9f-421f-84b6-7a8af74c1fca"
            notification = [
                    origin: "carrier-pull",
                    tracking_number: "OG357465336BR",
                    payload: [
                            agency_id: "58051970",
                            location: [
                                    state_id: "PB",
                                    city_name: "JOAO PESSOA",
                                    geolocation: null,
                                    country_id: "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id: "100008",
                            comment: "Destinatário não retirou objeto na Unidade dos Correios",
                            date: "2019-01-07T11:42:00Z",
                            carrier_id: "100008"
                    ],
                    shipment_id: 27752190312,
                    code: "0621"
            ]
            status = 200
        }

        "/notifications/error"(platform: "/api") {
            notification = [
                    origin: "carrier-pull",
                    tracking_number: "OG357465336BR",
                    payload: [
                            agency_id: "58051970",
                            location: [
                                    state_id: "PB",
                                    city_name: "JOAO PESSOA",
                                    geolocation: null,
                                    country_id: "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id: "100008",
                            comment: "Destinatário não retirou objeto na Unidade dos Correios",
                            date: "2019-01-07T11:42:00Z",
                            carrier_id: "100008"
                    ],
                    shipment_id: 27752190312,
                    code: "0621"
            ]
            shipment_id = 27752190312
            response = "ERROR com.mercadolibre.clients.ShipmentRestClient - Shipment 27752190312 not found"
            status = 404
        }

        "/notifications/validated"(platform: "/api") {
            shipment_id = 27752190312
            notification = [
                origin: "carrier-pull",
                tracking_number: "OG357465336BR",
                id: "1550919708135-27866910716-4bd030ab-0d9f-421f-84b6-7a8af74c1fca",
                payload: [
                    agency_id: "58051970",
                    location: [
                        state_id: "PB",
                        city_name: "JOAO PESSOA",
                        geolocation: null,
                        country_id: "BR",
                        neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                    ],
                    client_id: "100008",
                    comment: "Destinatário não retirou objeto na Unidade dos Correios",
                    date: "2019-01-07T11:42:00Z",
                    carrier_id: "100008"
                ],
                shipment_id: 27752190312,
                code: "0621"
            ]
        }

        "/notifications/event_processing"(platform: "/api") {
            stage_type = "DELAY"
            notification = [
                    origin: "carrier-pull",
                    tracking_number: "OG357465336BR",
                    payload: [
                            agency_id: "58051970",
                            location: [
                                    state_id: "PB",
                                    city_name: "JOAO PESSOA",
                                    geolocation: null,
                                    country_id: "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id: "100008",
                            comment: "Destinatário não retirou objeto na Unidade dos Correios",
                            date: "2019-01-07T11:42:00Z",
                            carrier_id: "100008"
                    ],
                    shipment_id: 27752190312,
                    code: "0621"
            ]
            notification_after = [
                delay_date: "2019-01-16T19:00:15.975Z",
                origin: "carrier-pull",
                tracking_number: "OG357465336BR",
                payload: [
                    agency_id: "58051970",
                    location: [
                        state_id: "PB",
                        city_name: "JOAO PESSOA",
                        geolocation: null,
                        country_id: "BR",
                        neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                    ],
                    client_id: "100008",
                    comment: "Destinatário não retirou objeto na Unidade dos Correios",
                    date: "2019-01-07T11:42:00Z",
                    carrier_id: "100008"
                ],
                shipment_id: 27752190312,
                code: "0621"
            ]
            configuration_filters = [
                [
                    values: [
                        codes: ["0621"]
                    ],
                    filter: "CODES_ARE"
                ],
                [
                    values: [
                        types: ["drop_off"]
                    ],
                    filter:"LOGISTIC_TYPES_ARE"
                ]
            ]
            shipment_id = 27752190312
            action_params = [
                delay_time_hours: "48"
            ]
            stage_id = "CORREIOS_DELAY"
            carrier_id = 100008
        }

        "/notifications/ssm"(platform: "/api") {
            cause = "invalid code"
            notification = [
                    origin: "carrier-pull",
                    tracking_number: "OG357465336BR",
                    payload: [
                            agency_id: "58051970",
                            location: [
                                    state_id: "PB",
                                    city_name: "JOAO PESSOA",
                                    geolocation: null,
                                    country_id: "BR",
                                    neighborhood_name: "AC CIDADE UNIVERS JOAO PESSOA"
                            ],
                            client_id: "100008",
                            comment: "Destinatário não retirou objeto na Unidade dos Correios",
                            date: "2019-01-07T11:42:00Z",
                            carrier_id: "100008"
                    ],
                    shipment_id: 27752190312,
                    code: "0621"
            ]
            shipment_id = 27752190312
        }
    }
}
