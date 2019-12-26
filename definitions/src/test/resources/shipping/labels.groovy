package src.test.resources.shipping

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "shipping"

    test("Labels test path") {

        "/"(platform: "/api") {}

        "/shipping"(platform: "/api") {}

        "/shipping/labels"(platform: "/api") {}

        "/shipping/labels/labels_api"(platform: "/api") {}

        "/shipping/labels/labels_api/requested"(platform: "/api") {
            shipment_ids = [27752190312, 27752190313]
            uri = "/shipping/labels?shipment_ids=27238138231,27752190313"
            response = [
                    error_code: "notifications is down for some reason",
                    status    : 500
            ]
            client_id = 123
            caller_id = 456
            response_type = "pdf"
            download_file = true
            generated_label_link = "/shipment_labels/20191218_2045-43586eb51381f0459da5985120a56260aed1d7d220b66ca2f639c9d2177812e0"
        }

        "/shipping/labels/labels_api/notified"(platform: "/api"){
            code = "1005"
            shipment_id = 27752190312
            response = [
                    status: 200,
                    notification_id: "ec5c54823b3ccbe7b7052cc2d3ceaf16ec4b93b5a4d1293a38110bd265b5ad"
            ]
            notifier = "primary"
        }
    }
}
