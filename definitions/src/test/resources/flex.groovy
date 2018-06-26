import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadoenvios"

    def defaultLocation =
        {
            latitude = "-36.34443"
            longitude = "-35.34332"
        }

    def defaultPacksInfo =
        {
            packs_info = [
                {
                    shipping_id = "27596585622"
                    origin_info = {
                        addresses_info = "Guevara 533"
                    }
                    destintation_info = {
                        addresses_info = "Suipacha 108"
                        latitude = "-36.434321"
                        longitude = "-35.56065"
                    }
                    status = "shipped"
                },
                {
                    shipping_id = "342994423"
                    origin_info = {
                        addresses_info = "San martin 3223"
                    }
                    destintation_info = {
                        addresses_info = "Uruguay 756"
                    }
                    status = "not_delivered"
                },
                {
                    shipping_id = "645292393"
                    origin_info = {
                        addresses_info = "Navarro 3232"
                    }
                    destintation_info = {
                        addresses_info = "Libertador 250"
                        latitude = "-36.312234"
                        longitude = "-33.645333"
                    }
                    status = "pending"
                }
            ]
        }

    def defaultSinglePack =
        {
            packs_info = [
                {
                    shipping_id = "27596585622"
                    origin_info = {
                        addresses_info = "Guevara 533"
                    }
                    destintation_info = {
                        addresses_info = "Suipacha 108"
                        latitude = "-36.434321"
                        longitude = "-35.56065"
                    }
                    status = "shipped"
                }
            ]
        }


    test("flex optin track returned success view"){

        def defaultTrackInformation = {
            view = "success_flex"
        }

        "/flex/optin"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex optout track returned form view"){

        def defaultTrackInformation = {
            view = "form"
        }

        "/flex/optout"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex landing view"){
        "/flex/landing"(platform:"/", type: TrackType.View) {}
    }

    //FLEX APP TESTS

    test("Login view track success"){

        "/flex/login/name"(platform:"/", type: TrackType.View) {
            defaultLocation()
        }
    }

    test("Camera tutorial view track success"){

        "/flex/package/add"(platform:"/", type: TrackType.View) {
            defaultLocation()
        }
    }

    test("Scanner view track success"){

        "/flex/package/add"(platform:"/", type: TrackType.View) {
        }
    }

    test("QR detected track success"){

        "/flex/package/add/qr_detected"(platform:"/", type: TrackType.Event) {
            status = "ok"
        }
    }

    test("Start delivery event track success"){

        "/flex/package/add/start_delivery"(platform:"/", type: TrackType.Event) {
            defaultPacksInfo
            defaultLocation
        }
    }

    test("Scanner list opened event track success"){

        "/flex/package/add/view_list"(platform:"/", type: TrackType.Event) {
        }
    }

    test("Scanner list delete package event track success"){

        "/flex/package/add/delete_package"(platform:"/", type: TrackType.Event) {
        }
    }

    test("Scanner list closed event track success"){

        "/flex/package/add/close_list"(platform:"/", type: TrackType.Event) {
            defaultLocation
        }
    }

    test("Loading view track success"){

        "/flex/package/list/loading"(platform:"/", type: TrackType.View) {
            defaultPacksInfo
            defaultLocation
        }
    }

    test("Too many packages modal page success"){

        "/flex/package/list/map_too_many_packages"(platform:"/", type: TrackType.View) {
            defaultPacksInfo
            defaultLocation
        }
    }

    test("List page success"){

        "/flex/package/list"(platform:"/", type: TrackType.View) {
            delivered_packages = "2-10"
            defaultPacksInfo
            defaultLocation
        }
    }

    test("Start trip event on list success"){

        "/flex/package/start_trip"(platform:"/", type: TrackType.Event) {
            defaultPacksInfo
            context = "list"
        }
    }

    test("See on google maps event on detail success"){

        "/flex/package/see_on_google_maps"(platform:"/", type: TrackType.Event) {
            defaultPacksInfo
            defaultLocation
            context = "detail"
        }
    }

    test("Add more package to delivery page success"){

        "/flex/package/add_more_packages"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("QR detected but already registered event in Scanner edition success"){

        "/flex/package/add_more_packages/qr_detected"(platform:"/", type: TrackType.Event) {
            defaultLocation
            status = "already_registered"
        }
    }

    test("See on google maps event on detail success"){

        "/flex/package/add_more_packages/add_packages"(platform:"/", type: TrackType.Event) {
            defaultLocation
            defaultPacksInfo
        }
    }

    test("Open packages list event in add more packages view success"){

        "/flex/package/add_more_packages/view_list"(platform:"/", type: TrackType.Event) {
            defaultLocation
        }
    }

    test("Delete package event in list in add more packages view success"){

        "/flex/package/add_more_packages/delete_package"(platform:"/", type: TrackType.Event) {
            defaultSinglePack
        }
    }

    test("Close packages list event in add more packages view success"){

        "/flex/package/add_more_packages/close_list"(platform:"/", type: TrackType.Event) {
        }
    }

    test("Packages with low accuracy modal view success"){

        "/flex/package/list/map_missing_addresses"(platform:"/", type: TrackType.View) {
            defaultLocation
            defaultPacksInfo
        }
    }

    test("Detail view with status pending success"){

        "/flex/package/detail"(platform:"/", type: TrackType.View) {
            defaultLocation
            pack_status = "pending"
        }
    }

    test("Retry delivery event in detail success"){

        "/flex/package/retry_delivery"(platform:"/", type: TrackType.Event) {
            defaultSinglePack
            defaultLocation
            context = "detail"
        }
    }

    test("End trip action event success"){

        "/flex/package/list/end_trip"(platform:"/", type: TrackType.Event) {
            defaultPacksInfo
            defaultLocation
        }
    }

    test("Call buyer action event success"){

        "/flex/package/detail/call_buyer"(platform:"/", type: TrackType.Event) {
            defaultSinglePack
            buyer_info = {
                buyer_id = "34434535"
            }
        }
    }

    test("Call seller action event success"){

        "/flex/package/detail/call_seller"(platform:"/", type: TrackType.Event) {
            defaultSinglePack
            seller_info = {
                seller_id = "34434535"
            }
        }
    }

    test("Signature page success"){

        "/flex/package/detail/receipt"(platform:"/", type: TrackType.View) {
            defaultSinglePack
            defaultLocation
            receiver_info = {
                name = "Sebastian"
                surname = "Pérez"
                doc_number = "33343344"
            }
        }
    }

    test("Other receiver page success"){

        "/flex/package/detail/receipt_other_person"(platform:"/", type: TrackType.View) {
            defaultPacksInfo
            defaultLocation
        }
    }

    test("Congrats page success"){

        "/flex/package/finish_delivery"(platform:"/", type: TrackType.View) {
            defaultSinglePack
            defaultLocation
            pack_status = "delivered"
        }
    }

    test("Camera permission page success"){

        "/flex/package/start/ask_camera"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("Location permission page success"){

        "/flex/package/start/ask_geolocation"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("Can't delete package modal page success"){

        "/flex/package/list/cant_delete"(platform:"/", type: TrackType.View) {
        }
    }

    test("Can't add packages modal page success"){

        "/flex/package/scan/cant_add"(platform:"/", type: TrackType.View) {
            defaultLocation
            invalid_labels = "11111-22222"
        }
    }

    test("Session expired modal page success"){

        "/flex/error/session_expired"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("Full error view page success"){

        "/flex/error"(platform:"/", type: TrackType.View) {
            defaultLocation
            error_type = "connection"
        }
    }

    test("Snackbar error event success"){

        "/flex/error/snackbar"(platform:"/", type: TrackType.Event) {
            defaultLocation
            error_type = "delivery_failed"
        }
    }

    test("Scanner onboarding page success"){

        "/flex/onboarding/package/add"(platform:"/", type: TrackType.View) {
        }
    }

    test("List onboarding page success"){

        "/flex/onboarding/package/start_trip"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("Detail onboarding page success"){

        "/flex/onboarding/package/confirm_delivery"(platform:"/", type: TrackType.View) {
            defaultLocation
        }
    }

    test("Onboarding action with context success"){

        "/flex/onboarding/got_it"(platform:"/", type: TrackType.Event) {
            defaultLocation
            context = "start_trip"
        }
    }
}
