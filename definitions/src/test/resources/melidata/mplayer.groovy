package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    /**
        MultiPlayer MoneyTransfer tracks
    **/

    test("MoneyTransfer") {

        // Send Money
        "/mplayer/send_money/contact_picker"(platform: "/mobile") {}
        "/mplayer/send_money/manual_amount"(platform: "/mobile") {}
        "/mplayer/send_money/friend_invite"(platform: "/mobile") {}

        "/mplayer/send_money/contact_picker/invalid_nickname"(platform: "/mobile") {}

        "/mplayer/send_money/contact_picker/select_contact"(platform: "/mobile") {
            input_type = "manual"
            source = "phone"
            is_recent = false
        }

         "/mplayer/send_money/manual_amount/continue"(platform: "/mobile") {
            transaction_amount = 100
            has_reason = true
        }

        "/mplayer/send_money/friend_invite/invite_pressed"(platform: "/mobile") {
            source = "phone"
            destination = "whatsapp"
        }

        "/mplayer/send_money/friend_invite/back_to_home"(platform: "/mobile") {}

        "/mplayer/send_money/result/success"(platform: "/mobile") {
            is_contact = true
            source = "email"    
            payment_method_id = "1"
            transaction_amount = 100.5
            fee_info = "2"
        }

        "/mplayer/send_money/result/error"(platform: "/mobile") {
            error = "Algo salio mal"
            is_contact = false
            source = "phone"
        }

        // Money Request
        "/mplayer/money_request/contact_picker"(platform: "/mobile") {}
        "/mplayer/money_request/manual_amount"(platform: "/mobile") {}

        "/mplayer/money_request/contact_picker/invalid_nickname"(platform: "/mobile") {}

        "/mplayer/money_request/contact_picker/select_contact"(platform: "/mobile") {
            input_type = "manual"
            source = "phone"
            is_recent = false
        }

    }
}

