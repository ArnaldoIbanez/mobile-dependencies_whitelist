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
        "/mplayer/send_money/result/in_process"(platform: "/mobile") {}

        "/mplayer/money_request/contact_picker/invalid_nickname"(platform: "/mobile") {}

        "/mplayer/money_request/contact_picker/select_contact"(platform: "/mobile") {
            input_type = "manual"
            source = "phone"
            is_recent = false
        }

        "/mplayer/money_request/result/success"(platform: "/mobile") {
            payment_method_id = "1"
            transaction_amount = 100.5
            fee_info = "2"
        }

        "/mplayer/money_request/result/error"(platform: "/mobile") {
            error = "Algo salio mal"
        }

        "/mplayer/money_request/result/in_process"(platform: "/mobile") {
        }

         // Money Split
        "/mplayer/money_split/activities_selection"(platform: "/mobile") {}
        "/mplayer/money_split/activities_selection/activity_selected"(platform: "/mobile") {
            source = "manual"
            position_list = 2
        }
        "/mplayer/money_split/activities_selection/continue"(platform: "/mobile") {
            quantity = 3
            reason_flow = "forced"
        }

        "/mplayer/money_split/new_activity"(platform: "/mobile") {}

        "/mplayer/money_split/reason"(platform: "/mobile") {}
        "/mplayer/money_split/reason/emoji_selected"(platform: "/mobile") {}

        "/mplayer/money_split/contact_picker"(platform: "/mobile") {}
        "/mplayer/money_split/contact_picker/select_contact"(platform: "/mobile") {
            source = "manual"
            is_recent = false
        }
        "/mplayer/money_split/contact_picker/continue"(platform: "/mobile") {
            quantity = 5
        }

        "/mplayer/money_split/review_and_confirm"(platform: "/mobile") {}
        "/mplayer/money_split/review_and_confirm/continue"(platform: "/mobile") {
            has_open_detail = false
        }

        "/mplayer/money_split/split_detail"(platform: "/mobile") {}

        "/mplayer/money_split/result"(platform: "/mobile") {}
        "/mplayer/money_split/result/exit"(platform: "/mobile") {
            button = "main_button"
        }

        // Tracing
        "/mplayer/tracing/event_list"(platform: "/mobile") {}
        "/mplayer/tracing/event_list/select_event"(platform: "/mobile") {
            source = "history"
        }
        "/mplayer/tracing/event_list/go_to_history"(platform: "/mobile") {}

        "/mplayer/tracing/history"(platform: "/mobile") {}

        "/mplayer/tracing/collector_detail"(platform: "/mobile") {}
        "/mplayer/tracing/collector_detail/see_more"(platform: "/mobile") {}
        "/mplayer/tracing/collector_detail/close_menu"(platform: "/mobile") {}
        "/mplayer/tracing/collector_detail/remember_button"(platform: "/mobile") {}
        "/mplayer/tracing/collector_detail/see_detail"(platform: "/mobile") {}

        "/mplayer/tracing/member_detail"(platform: "/mobile") {}
        "/mplayer/tracing/member_detail/see_more"(platform: "/mobile") {}
        "/mplayer/tracing/member_detail/send_money"(platform: "/mobile") {}
        "/mplayer/tracing/member_detail/reject_event"(platform: "/mobile") {}

        "/mplayer/tracing/close_event"(platform: "/mobile") {}
        "/mplayer/tracing/close_event/exit"(platform: "/mobile") {
            button = "close_button"
        }

        "/mplayer/tracing/reject_event"(platform: "/mobile") {}
        "/mplayer/tracing/reject_event/exit"(platform: "/mobile") {
            button = "close_button"
        }
    }
}

