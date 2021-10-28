import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    ["mercadolibre", "mercadopago"].each { business ->

        defaultBusiness = business

        test("Reauthentication event ") {
            "/reauthentication"(platform: "/", type: TrackType.Event) {
                operation_id = "change_password"
                reauth_id = "a4f835e5-27ee-47a7-af74-e5f01afc0a72"
                reauth_type = "DEFAULT"
                flow_type = "OTHER"
                reauth_status = "OPEN"
                reauth_risk = "LOW"
                user_ato_risk = "LOW"
                recently_logged_in = true
            }

            "/reauthentication"(platform: "/", type: TrackType.Event) {
                operation_id = "payment-operation"
                reauth_id = "a4f835e5-27ee-47a7-af74-e5f01afc0a72"
                reauth_type = "DEFAULT"
                flow_type = "PAYMENT"
                reauth_status = "CLOSED"
                reauth_risk = "HIGH"
                elapsed_time = "1234567899"
                user_ato_risk = "LOW"
                amount = "500"
                recently_logged_in = false
                requested_factors = "ENTER_PASSWORD/TOTP"
            }
        }
    }
}