package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"
    /**
        MultiPlayer MoneyTransfer tracks
    **/

    test("MoneyTransfer") {

        // Send Money
        "/mplayer/send_money/onboarding"(platform: "/mobile") {}
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

        "/mplayer/send_money/friend_invite/invite_back"(platform: "/mobile") {}

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

        "/mplayer/send_money/result/in_process"(platform: "/mobile") {}

        "/mplayer/send_money/redirector/manual_amount"(platform: "/mobile") {
            flow = "flow"
            contact_type = "user_id"
        }

 
        "/mplayer/send_money/contact_picker/search"(platform: "/mobile") {}
        "/mplayer/send_money/contact_picker/add_new_contact"(platform: "/mobile") {}

        "/mplayer/send_money/bottom_sheet"(platform: "/mobile") {}
        "/mplayer/send_money/bottom_sheet/new_contact_email"(platform: "/mobile") {}
        "/mplayer/send_money/bottom_sheet/new_contact_phone"(platform: "/mobile") {}
        "/mplayer/send_money/bottom_sheet/continue"(platform: "/mobile") {}



        // Money Request
        "/mplayer/closed_request/onboarding"(platform: "/mobile") {}
        "/mplayer/closed_request/contact_picker"(platform: "/mobile") {}
        "/mplayer/closed_request/manual_amount"(platform: "/mobile") {}
        "/mplayer/closed_request/mandatory_reason"(platform: "/mobile") {}
        "/mplayer/closed_request/congrats_request"(platform: "/mobile") {}
        "/mplayer/closed_request/reject"(platform: "/mobile") {}
        "/mplayer/closed_request/congrats_request/exit"(platform: "/mobile") {
            button = "main_button"
        }

        "/mplayer/closed_request/congrats_request/detail"(platform: "/mobile") {}
        "/mplayer/closed_request/congrats_request/home"(platform: "/mobile") {}

        "/mplayer/closed_request/status"(platform: "/mobile") {
            request_status = "pending"
        }

        "/mplayer/closed_request/contact_picker/select_contact"(platform: "/mobile") {
            input_type = "manual"
            source = "phone"
            is_recent = false
        }

        "/mplayer/closed_request/contact_picker/invalid_nickname"(platform: "/mobile") {}

        "/mplayer/closed_request/contact_picker/continue"(platform: "/mobile") {
            quantity = 5
        }

        "/mplayer/closed_request/manual_amount/continue"(platform: "/mobile") {
            transaction_amount = 100
            has_reason = true
        }

        "/mplayer/closed_request/mandatory_reason/continue"(platform: "/mobile") {}
        "/mplayer/closed_request/mandatory_reason/emoji_selected"(platform: "/mobile") {}

        "/mplayer/closed_request/status/pay"(platform: "/mobile") {}

        "/mplayer/closed_request/status/reject"(platform: "/mobile") {}

        "/mplayer/closed_request/reject/reject"(platform: "/mobile") {}

        "/mplayer/closed_request/reject/back"(platform: "/mobile") {}

        "/mplayer/closed_request/result/success"(platform: "/mobile") {
            payment_method_id = "1"
            transaction_amount = 100.5
            fee_info = "2"
        }

        "/mplayer/closed_request/result/error"(platform: "/mobile") {
            error = "Algo salio mal"
        }

        "/mplayer/closed_request/result/in_process"(platform: "/mobile") {}

        "/mplayer/closed_request/contact_picker/search"(platform: "/mobile") {}
        "/mplayer/closed_request/contact_picker/add_new_contact"(platform: "/mobile") {}

        "/mplayer/closed_request/bottom_sheet"(platform: "/mobile") {}
        "/mplayer/closed_request/bottom_sheet/new_contact_email"(platform: "/mobile") {}
        "/mplayer/closed_request/bottom_sheet/new_contact_phone"(platform: "/mobile") {}
        "/mplayer/closed_request/bottom_sheet/continue"(platform: "/mobile") {}


        // Open Request
        "/mplayer/open_request/manual_amount"(platform: "/mobile") {}
        "/mplayer/open_request/mandatory_reason"(platform: "/mobile") {}
        "/mplayer/open_request/share_request"(platform: "/mobile") {}
        "/mplayer/open_request/status"(platform: "/mobile") {
            request_status = "pending"
        }

        "/mplayer/open_request/manual_amount/continue"(platform: "/mobile") {
            transaction_amount = 100
            has_reason = true
        }

        "/mplayer/open_request/mandatory_reason/continue"(platform: "/mobile") {}
        "/mplayer/open_request/mandatory_reason/emoji_selected"(platform: "/mobile") {}

        "/mplayer/open_request/share_request/whatsapp"(platform: "/mobile") {}

        "/mplayer/open_request/share_request/native"(platform: "/mobile") {}

        "/mplayer/open_request/result/success"(platform: "/mobile") {
            payment_method_id = "1"
            transaction_amount = 100.5
            fee_info = "2"
        }

        "/mplayer/open_request/result/error"(platform: "/mobile") {
            error = "Algo salio mal"
        }

        "/mplayer/open_request/result/in_process"(platform: "/mobile") {}

         // Money Split
        "/mplayer/money_split/onboarding"(platform: "/mobile") {}
        "/mplayer/money_split/activities_selection"(platform: "/mobile") {}
        "/mplayer/money_split/activities_selection/activity_selected"(platform: "/mobile") {
            input_type = "manual"
            position_list = 2
        }
        "/mplayer/money_split/activities_selection/continue"(platform: "/mobile") {
            quantity = 3
            reason_flow = "forced"
        }

        "/mplayer/money_split/new_activity"(platform: "/mobile") {}

        "/mplayer/money_split/reason"(platform: "/mobile") {}
        "/mplayer/money_split/reason/emoji_selected"(platform: "/mobile") {}
        "/mplayer/money_split/reason/continue"(platform: "/mobile") {}

        "/mplayer/money_split/contact_picker"(platform: "/mobile") {}
        "/mplayer/money_split/contact_picker/select_contact"(platform: "/mobile") {
            input_type = "manual"
            is_recent = false
        }
        "/mplayer/money_split/contact_picker/invalid_nickname"(platform: "/mobile") {}

        "/mplayer/money_split/contact_picker/continue"(platform: "/mobile") {
            quantity = 5
        }

        "/mplayer/money_split/review_and_confirm"(platform: "/mobile") {}
        "/mplayer/money_split/review_and_confirm/continue"(platform: "/mobile") {
            has_open_detail = false
        }

        "/mplayer/money_split/review_and_confirm/back"(platform: "/mobile") {}

        "/mplayer/money_split/split_detail"(platform: "/mobile") {}

        "/mplayer/money_split/split_created"(platform: "/mobile") {}
        "/mplayer/money_split/split_created/exit"(platform: "/mobile") {
            button = "main_button"
        }

        "/mplayer/money_split/split_created/detail"(platform: "/mobile") {}
        "/mplayer/money_split/split_created/home"(platform: "/mobile") {}

        "/mplayer/money_split/result/success"(platform: "/mobile") {
            payment_method_id = "1"
            transaction_amount = 100.5
        }
        "/mplayer/money_split/result/error"(platform: "/mobile") {
            error = "Algo salio mal"
        }
        "/mplayer/money_split/result/in_process"(platform: "/mobile") {}

        "/mplayer/money_split/contact_picker/search"(platform: "/mobile") {}
        "/mplayer/money_split/contact_picker/add_new_contact"(platform: "/mobile") {}

        "/mplayer/money_split/bottom_sheet"(platform: "/mobile") {}
        "/mplayer/money_split/bottom_sheet/new_contact_email"(platform: "/mobile") {}
        "/mplayer/money_split/bottom_sheet/new_contact_phone"(platform: "/mobile") {}
        "/mplayer/money_split/bottom_sheet/continue"(platform: "/mobile") {}


        // Tracing
        "/mplayer/tracing/onboarding"(platform: "/mobile") {}
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

        "/mplayer/tracing/social_hub"(platform: "/mobile") {}
        "/mplayer/tracing/social_hub/money_split"(platform: "/mobile") {}
        "/mplayer/tracing/social_hub/send_money"(platform: "/mobile") {}
        "/mplayer/tracing/social_hub/money_request"(platform: "/mobile") {}

        //Request Landing

        "/mplayer/request_landing"(platform: "/web") {
            request_status = "pending"
        }

        "/mplayer/request_landing/success"(platform: "/web") {
            transaction_amount = 100
            has_reason = true
        }

        "/mplayer/download_app"(platform: "/web") {}
        "/mplayer/download_app/appstore"(platform: "/web") {}
        "/mplayer/download_app/playstore"(platform: "/web") {}

        // Multiplayer/Friends Marketing Landing
        "/mplayer/mkt_landing"(platform: "/web"){
            campaign = "generic"
        } 
        "/mplayer/mkt_landing"(platform: "/web"){
            campaign = "sube"
        } 
        "/mplayer/mkt_landing/sms"(platform: "/web"){
            campaign = "sube"
        } 
        "/mplayer/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = "sube"
            position = "coupon"
        } 
        "/mplayer/mkt_landing/copy-clipboard"(platform: "/web"){
            campaign = "sube"
            position = "steps"
        } 
        "/mplayer/mkt_landing/button"(platform: "/web"){
            campaign = "sube"
            position = "hero"
        } 
        "/mplayer/mkt_landing/button"(platform: "/web"){
            campaign = "sube"
            position = "fixed"
        } 
        "/mplayer/mkt_landing/button"(platform: "/web"){
            campaign = "sube"
            position = "footer"
        }

        // Contacts
        "/mplayer/contacts/massive_upload/start"(platform: "/mobile") {}
        "/mplayer/contacts/massive_upload/successful_end"(platform: "/mobile") {}
        "/mplayer/contacts/search/start"(platform: "/mobile") {}
        "/mplayer/contacts/search/end"(platform: "/mobile") {}

        //Interaction Screen
        "/mplayer/interaction_screen"(platform: "/mobile") {
            type = "modal"
            cause = "warning"
            message_id = "error-01"
        }
        "/mplayer/interaction_screen/event"(platform: "/mobile") {
            type = "modal"
            cause = "warning"
            message_id = "error-01"
        }
    }
}

