package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadoenvios"

    test("flex optin track returned success view"){

        "/flex/optin"(platform:"/", type: TrackType.View) {}

    }

    test("flex optin congrats event"){

        def defaultTrackInformation = {
            view = "success_flex"
        }

        "/flex/optin/congrats"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex optout track returned success view"){

        "/flex/optout"(platform:"/", type: TrackType.View) {}

    }

    test("flex optout congrats event"){

        def defaultTrackInformation = {
            view = "success_optout"
            message = "Feedback"
        }

        "/flex/optout/congrats"(platform:"/", type: TrackType.Event) {
            defaultTrackInformation()
        }

    }

    test("flex landing view"){
        "/flex/landing"(platform:"/", type: TrackType.View) {}
    }

     test("flex configuration view"){
        "/flex/configuration"(platform: "/", type: TrackType.View) {}
    }

    test("flex configuration events"){
        def deliveryTimeSelected = {
            delivery_time = "SameDay"
        }

        def zonesSelected = {
            zones = [  
                {
                    zone = "CABA"
                    selected = 0
                },
                {
                    zone = "Vicente_Lopez"
                    selected = 1
                }
            ]
        }

        def capacitySelected = {
            capacity = "20"
        }



        "/flex/configuration/select_delivery_time"(platform: "/", type: TrackType.Event) {
            deliveryTimeSelected()
        }

        "/flex/configuration/select_zones"(platform: "/", type: TrackType.Event) {
            zonesSelected()
        }

        "/flex/configuration/select_capacity"(platform: "/", type: TrackType.Event) {
            capacitySelected()
        }

    }


    test("Testing flex"){
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
                        low_precition = true
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
                        low_precition = false
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
                        low_precition = true
                    }
                ]
            }

        //Login view track success
        "/flex/login/name"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Camera tutorial view track success
        "/flex/package/add"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Scanner view track success
        "/flex/package/add"(platform:"/mobile", type: TrackType.View) {
        }

        //QR detected track success
        "/flex/package/add/qr_detected"(platform:"/mobile", type: TrackType.Event) {
            status = "ok"
        }

        //QR detected track invalid
        "/flex/package/add/qr_detected"(platform:"/mobile", type: TrackType.Event) {
            status = "invalid_format"
            json_data = "{ www.google.com }"
        }

        //Start delivery event track success
        "/flex/package/add/start_delivery"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            defaultLocation()
            delivery_id = 123456
        }

        //Scanner list opened event track success
        "/flex/package/add/view_list"(platform:"/mobile", type: TrackType.Event) {
        }

        //Scanner list delete package event track success
        "/flex/package/add/delete_package"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            defaultLocation()
        }

        //Scanner list closed event track success
        "/flex/package/add/close_list"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        //Loading view track success
        "/flex/package/list/loading"(platform:"/mobile", type: TrackType.View) {
            defaultPacksInfo()
            defaultLocation()
        }

        //Too many packages modal page success
        "/flex/package/list/map_too_many_packages"(platform:"/mobile", type: TrackType.View) {
            defaultPacksInfo()
            defaultLocation()
        }

        //List page success
        "/flex/package/list"(platform:"/mobile", type: TrackType.View) {
            delivered_packages = "2-10"
            defaultPacksInfo()
            defaultLocation()
            delivery_id = 123456
        }

        //List page success with badge
        "/flex/package/list"(platform:"/mobile", type: TrackType.View) {
            delivered_packages = "2-10"
            defaultPacksInfo()
            defaultLocation()
            delivery_id = 123456
            show_historical_badge = "true"
        }

        //Start trip event on list success
        "/flex/package/start_trip"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            context = "list"
            delivery_id = 123456
        }
        //See on google maps event on detail success menu
        "/flex/package/see_on_google_maps"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            defaultLocation()
            context = "detail_menu"
            delivery_id = 123456
        }
        //See on google maps event on detail success map
        "/flex/package/see_on_google_maps"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            defaultLocation()
            context = "detail_map"
            delivery_id = 123456
        }

        "/flex/package/start"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        "/flex/package/add_more_packages"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        //QR detected but already registered event in Scanner edition success
        "/flex/package/add_more_packages/qr_detected"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            status = "already_registered"
        }

        //See on google maps event on detail success
        "/flex/package/add_more_packages/add_packages"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Open packages list event in add more packages view success
        "/flex/package/add_more_packages/view_list"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        //Delete package event in list in add more packages view success
        "/flex/package/add_more_packages/delete_package"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
        }

        //Close packages list event in add more packages view success
        "/flex/package/add_more_packages/close_list"(platform:"/mobile", type: TrackType.Event) {
        }

        //Packages with low accuracy modal view success
        "/flex/package/list/map_missing_addresses"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Detail view with status pending success
        "/flex/package/detail"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            pack_status = "pending"
            delivery_id = 123456
        }

        //Retry delivery event in detail success
        "/flex/package/retry_pack"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
            defaultLocation()
            context = "detail"
            delivery_id = 123456
        }


        //Message buyer action event success
        "/flex/package/message_buyer"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
            buyer_info = [
                buyer_id: "34434535"
            ]
            delivery_id = 123456
        }

        //End trip action event success
        "/flex/package/list/end_trip"(platform:"/mobile", type: TrackType.Event) {
            defaultPacksInfo()
            defaultLocation()
            delivery_id = 123456
        }

        //Message buyer action from detail event success
        "/flex/package/detail/message_buyer"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
            buyer_info = [
                buyer_id: "34434535"
            ]
            delivery_id = 123456
        }

        //Call buyer action event success
        "/flex/package/detail/call_buyer"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
            buyer_info = [
                buyer_id: "34434535"
            ]
            delivery_id = 123456
        }

        //Call seller action event success
        "/flex/package/detail/call_seller"(platform:"/mobile", type: TrackType.Event) {
            defaultSinglePack()
            seller_info = {
                seller_id = "34434535"
            }
            delivery_id = 123456
        }

        //Signature page success
        "/flex/package/detail/receipt"(platform:"/mobile", type: TrackType.View) {
            defaultSinglePack()
            defaultLocation()
            delivery_id = 123456
        }

        //Other receiver page success
        "/flex/package/detail/receipt_other_person"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            delivery_id = 123456
        }

        //Congrats page success
        "/flex/package/finish_delivery"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            pack_status = "delivered"
            delivery_id = 123456
        }
        //Camera permission page success
        "/flex/package/start/ask_camera"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Location permission page success
        "/flex/package/start/ask_geolocation"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Can't delete package modal page success
        "/flex/package/list/cant_delete"(platform:"/mobile", type: TrackType.View) {
        }

        //Can't add packages modal page success
        "/flex/package/scan/cant_add"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            invalid_labels = "11111-22222"
            delivery_id = 123456
        }

        //Session expired modal page success
        "/flex/error/session_expired"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()

        }

        "/flex/error/update_app"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Full error view page success
        "/flex/error"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            error_type = "connection"
            error_step_id = "example_step_id"
        }

        //Snackbar error event success
        "/flex/error/snackbar"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            error_type = "delivery_failed"
            error_step_id = "example_step_id"
        }

        "/flex/error/update_app/update_app"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
        }

        //List onboarding page success
        "/flex/onboarding/package/add"(platform:"/mobile", type: TrackType.View) {
        }

        //List onboarding page success
        "/flex/onboarding/package/start_trip"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Detail onboarding page success
        "/flex/onboarding/package/confirm_delivery"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
        }

        //Onboarding action with context success
        "/flex/onboarding/got_it"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            context = "start_trip"
        }
        //Onboarding action with context success
        "/flex/package/detail/receipt/save"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }
        //Onboarding action with context success
        "/flex/notification/open_near_pack_destination"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }
        //Onboarding action with context success
        "/flex/notification/view_near_pack_destination"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Onboarding action with context success
        "/flex/notification/pass_near_pack_destination"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Not delivered event
        "/flex/package/not_delivered_reason/selection"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
            reason_type = "TestReasonType"
        }

        //Not delivered view
        "/flex/package/not_delivered_reason"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Not delivered form event
        "/flex/package/not_delivered_reason/form/other_reason"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
            reason = "TestReason"
        }

        //Not delivered form view
        "/flex/package/not_delivered_reason/form"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Signature Back Modal View
        "/flex/package/detail/receipt/go_back"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Signature Back Modal Event
        "/flex/package/detail/receipt/back"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Country selection View
        "/flex/login/select_country"(platform:"/mobile", type: TrackType.View) {
        }

        //Out of distance View
        "/flex/package/detail/out_of_distance_modal"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            context = "delivered"
            distance = 1234
            delivery_id = 123456
        }

        //Snackbar error event success
        "/flex/package/detail/out_of_distance"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            context = "delivered"
            error_type = "permission_denied"
            error_message = "example_message"
        }

        //Fake GPS enable
        "/flex/package/detail/enable_fake_gps"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            context = "delivered"
            delivery_id = 123456
        }

        //Registration login fail
        "/flex/registration/error"(platform:"/mobile", type: TrackType.Event) {
            context = "login"
        }

        //Option receiver event
        "/flex/package/receiver_options/selection"(platform:"/mobile", type: TrackType.Event) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
            option_type = "receives_another"
        }

        //Not delivered view
        "/flex/package/receiver_options"(platform:"/mobile", type: TrackType.View) {
            defaultLocation()
            defaultPacksInfo()
            delivery_id = 123456
        }

        //Historical summary view
        "/flex/package/record/summary"(platform: "/mobile", type: TrackType.View) {
        }

        //Historical detail view
        "/flex/package/record/detail"(platform: "/mobile", type: TrackType.View) {
        }

    }
}