package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {
    defaultBusiness = "mercadopago"

    test("Billpayments") {
        "/single_player/billpayments/permissions_rationale"(platform: "/mobile") {}
        "/single_player/billpayments/help"(platform: "/mobile") {}
        "/single_player/billpayments/no_money"(platform: "/mobile") {}
        "/single_player/billpayments/manual_barcode"(platform: "/mobile") {
            barcode_valid = false
        }
        "/single_player/billpayments/barcode_reader"(platform: "/mobile") {}
        "/single_player/billpayments/additional_info"(platform: "/mobile") {
            required_additional_info = "{\"suggested_amount\":-1,\"description\":\"Fecha Venc. DDMMAAAA\",\"min_amount\":0,\"type\":\"literal\",\"max_amount\":0}"
        }
        "/single_player/billpayments/expired_amount"(platform: "/mobile") {}
        "/single_player/billpayments/manual_barcode/read"(platform: "/mobile") {
            barcode = "4471001207281810220357354000000000000000000515005681827"
        }
        "/single_player/billpayments/barcode_reader/read"(platform: "/mobile") {
            barcode = "4471001207281810220357354000000000000000000515005681827"
            uuid = "the uuid"
            elapsed_time = 3914
            barcode_format = "I25"
            multiscanner = false
        }
        "/single_player/billpayments/additional_info/send"(platform: "/mobile") {
            additional_info = "{\"parameters\":[\"9999\"],\"payment_id\":23766434}"
        }
        "/single_player/billpayments/additional_info/error"(platform: "/mobile") {
            utility_response = "{\"message\":\"No puedes pagar esta factura\",\"status\":\"rejected\",\"type\":\"screen\"}"
        }
        "/single_player/billpayments/barcode_reader/read/success"(platform: "/mobile") {
            is_manual_input = false
            barcode = "50131382801300117000180151"
            utility_response = "{\"id\":23766490, \"status\":\"require_additional_info\", \"show_expired_amount\":false,\"change_payment_method\":false}"
            multiscanner = false
            from_clipboard = false
        }
        "/single_player/billpayments/barcode_reader/read/error"(platform: "/mobile") {
            is_manual_input = false
            barcode = "50131382801300117000180151"
            utility_response = "{\"message\":\"La factura está vencida.\",\"http_status\":400,\"status\":\"rejected\",\"type\":\"toast\"}"
            from_clipboard = false
        }
        "/single_player/billpayments/checkout_px/start"(platform: "/mobile") {}
        "/single_player/billpayments/generic_screen_info"(platform: "/mobile") {
            utility_error = "{\"concept\":\"invalid_barcode\",\"deeplink\":\"mercadopago://single_player/billpayments/screen_info\",\"icon\":\"paybills_invoice_error\"}"
        }
    }

    test("Antenna") {
        "/single_player/antenna/manual_input"(platform: "/mobile") {
            company = "directv"
        }
        "/single_player/antenna/topup_helper" (platform: "/mobile") {}
    }
}

