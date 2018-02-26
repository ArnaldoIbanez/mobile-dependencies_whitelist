import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {

    defaultBusiness = "mercadolibre"

    test("melidata vip track") {

        def defaultTrackInformation = {
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        def trackModals = {
            show = "fae_details"
            item_id = "MLA213512313"
            category_id = "MLA123"
        }

        "/vip/variations"(platform: "/web") {
            defaultTrackInformation()
        }

        "/vip/reviews"(platform: "/", type: TrackType.View) {
            trackModals()
        }

        "/vip/coordinate_availability"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }

        "/vip/contract_intention"(platform: "/mobile", type: TrackType.Event) {
            defaultTrackInformation()
        }
    }

    test("New Shipping calculator"){

        "/vip/shipping/calculator/calculate"(platform: "/mobile/ios") {
            cp_autocomplete = true
        }

        "/vip/shipping/calculator/i_dont_know_my_code"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/calculate_error"(platform: "/mobile/ios") {
            error_type = "error code"
        }

        "/vip/shipping/calculator/agencies/show_agencies_map_for_pickup"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/choose_state"(platform: "/mobile/ios") {
        }

        "/vip/shipping/calculator/choose_city"(platform: "/mobile/ios") {
        }

        def defaultShipping = {
        shipping_type = "delivery"
        shipping_method_id = 123
        shipping_benefit = "loyalty"
        shipping_price = {
            price = 0
            currency_id  = "ARS"
        }
        shipping_days = {
            min = 4
            max = 5
        }
        recommend = true
        }

        def otherShipping = {
        shipping_type = "delivery"
        shipping_method_id = 1234
        shipping_price = {
            price = 100
            currency_id  = "ARS"
        }
        shipping_days = {
            min = 4
            max = 5
        }
        recommend = false
        }

        "/vip/shipping/calculator/go_to_vip"(platform: "/mobile/ios") {
            item_id = "MLA123"
            item_selected_quantity = 1
            item_shipping_quantity = 1
            shipping_default = defaultShipping
            shipping_selected = defaultShipping
            shipping_available_opcion = [
            defaultShipping,
            otherShipping
        ]
        }
    
    }
}
