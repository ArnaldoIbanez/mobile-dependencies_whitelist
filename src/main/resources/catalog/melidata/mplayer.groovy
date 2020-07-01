package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1161"

    /**
    * MultiPlayer MoneyTransfer Screen Tracks
    */

    "/mplayer"(platform: "/mobile", isAbstract: true) {}

    // Send Money
    "/mplayer/send_money"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/friend_invite"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/send_money/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of contact selected, select from list or manually typed")
        source(required: false, PropertyType.String, description: "the source of the contact")
        is_recent(required: true, PropertyType.Boolean, description: "if the seleted contact is a recent contact")
    }
    "/mplayer/send_money/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "if the transaction have a reason message")
    }
    "/mplayer/send_money/friend_invite/invite_pressed"(platform: "/mobile", type: TrackType.Event) {
        is_contact(required: false, PropertyType.Boolean, description: "if the collector is a contact")
        source(required: true, PropertyType.String, description: "the source of the contact")
        destination(required: true, PropertyType.String, description: "the destination of the invitation")
    }

    "/mplayer/send_money/friend_invite/invite_back"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/send_money/result"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/result/success"(platform: "/mobile", type: TrackType.View) {
        is_contact(required: false, PropertyType.Boolean, description: "if the collector is a contact")
        source(required: false, PropertyType.String, description: "the source of the contact")
        payment_method_id(required: true, PropertyType.String, description: "the payment method id")
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        fee_info(required: false, PropertyType.String, description: "the info of the fee")
    }

    "/mplayer/send_money/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: true, PropertyType.String, description: "the transaction error")
        is_contact(required: false, PropertyType.Boolean, description: "if the collector is a contact")
        source(required: false, PropertyType.String, description: "the source of the contact")
    }

    "/mplayer/send_money/result/in_process"(platform: "/mobile", type: TrackType.View) {
    }

    // Closed Request
    "/mplayer/closed_request"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/closed_request/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/mandatory_reason"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/congrats_request"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/reject"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/closed_request/status"(platform: "/mobile", type: TrackType.View) {
        request_status(required: false, PropertyType.String, description: "the status of the request")
    }

    "/mplayer/closed_request/congrats_request/exit"(platform: "/mobile", type: TrackType.Event) {
        button(required: true, PropertyType.String, description: "the button selected to exit")
    }

    "/mplayer/closed_request/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of contact selected, select from list or manually typed")
        source(required: false, PropertyType.String, description: "the source of the contact")
        is_recent(required: true, PropertyType.Boolean, description: "if the seleted contact is a recent contact")
    }

    "/mplayer/closed_request/contact_picker/continue"(platform: "/mobile", type: TrackType.Event) {
        quantity(required: true, PropertyType.Numeric, description: "the number of selected contacts")
    }

    "/mplayer/closed_request/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/closed_request/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "if the transaction have a reason message")
    }
    "/mplayer/closed_request/mandatory_reason/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/closed_request/mandatory_reason/emoji_selected"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/closed_request/status/pay"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/closed_request/status/reject"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/closed_request/reject/reject"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/closed_request/reject/back"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/closed_request/result"(platform: "/mobile", isAbstract: true) {}

    "/mplayer/closed_request/result/success"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, PropertyType.String, description: "the payment method id")
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        fee_info(required: false, PropertyType.String, description: "the info of the fee")
    }

    "/mplayer/closed_request/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: false, PropertyType.String, description: "the transaction error")
    }

    "/mplayer/closed_request/result/in_process"(platform: "/mobile", type: TrackType.View) {}

    // Open Request
    "/mplayer/open_request"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/open_request/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/open_request/mandatory_reason"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/open_request/share_request"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/open_request/status"(platform: "/mobile", type: TrackType.View) {
        request_status(required: true, PropertyType.String, description: "the status of the request")
    }
    "/mplayer/open_request/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "if the transaction have a reason message")
    }
    "/mplayer/open_request/mandatory_reason/continue"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/open_request/mandatory_reason/emoji_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/open_request/share_request/whatsapp"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/open_request/share_request/native"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/open_request/result"(platform: "/mobile", isAbstract: true) {}

    "/mplayer/open_request/result/success"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, PropertyType.String, description: "the payment method id")
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        fee_info(required: false, PropertyType.String, description: "the info of the fee")
    }

    "/mplayer/open_request/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: false, PropertyType.String, description: "the transaction error")
    }

    "/mplayer/open_request/result/in_process"(platform: "/mobile", type: TrackType.View) {}

    // Money Split
    "/mplayer/money_split"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/money_split/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/activities_selection"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/activities_selection/activity_selected"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of the activity selected, select from list or manually typed")
        position_list(required: false, PropertyType.Numeric, description: "the position in the list of the activity selected")
    }
    "/mplayer/money_split/activities_selection/continue"(platform: "/mobile", type: TrackType.Event) {
        quantity(required: true, PropertyType.Numeric, description: "the number of selected activities to split")
        reason_flow(required: true, PropertyType.String, description: "the way to access mandatory reason")
    }

    "/mplayer/money_split/new_activity"(platform: "/mobile", type: TrackType.View) {}

    "/mplayer/money_split/reason"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/reason/emoji_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/money_split/reason/continue"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/money_split/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of contact selected, select from list or manually typed")
        is_recent(required: true, PropertyType.Boolean, description: "the contact is recently used or not")
    }
    "/mplayer/money_split/contact_picker/continue"(platform: "/mobile", type: TrackType.Event) {
        quantity(required: true, PropertyType.Numeric, description: "the number of selected contacts")
    }

    "/mplayer/money_split/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}
    
    "/mplayer/money_split/review_and_confirm"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/review_and_confirm/continue"(platform: "/mobile", type: TrackType.Event) {
        has_open_detail(required: true, PropertyType.Boolean, description: "the detail was opened or not")
    }

    "/mplayer/money_split/review_and_confirm/back"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/money_split/split_detail"(platform: "/mobile", type: TrackType.View) {}

    "/mplayer/money_split/split_created"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_split/split_created/exit"(platform: "/mobile", type: TrackType.Event) {
        button(required: true, PropertyType.String, description: "the button selected to exit")
    }

    "/mplayer/money_split/result"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/money_split/result/success"(platform: "/mobile", type: TrackType.View) {
        payment_method_id(required: true, PropertyType.String, description: "the payment method id")
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        fee_info(required: false, PropertyType.String, description: "the info of the fee")
    }
    "/mplayer/money_split/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: false, PropertyType.String, description: "the transaction error")
    }
    
    "/mplayer/money_split/result/in_process"(platform: "/mobile", type: TrackType.View) {}

    // Tracing
    "/mplayer/tracing"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/tracing/onboarding"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/event_list"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/event_list/select_event"(platform: "/mobile", type: TrackType.Event) {
        source(required: true, PropertyType.String, description: "the list of the activity selected")
    }
    "/mplayer/tracing/event_list/go_to_history"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/tracing/history"(platform: "/mobile", type: TrackType.View) {}

    "/mplayer/tracing/collector_detail"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/collector_detail/see_more"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/collector_detail/close_menu"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/collector_detail/remember_button"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/collector_detail/see_detail"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/tracing/member_detail"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/member_detail/see_more"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/member_detail/send_money"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/member_detail/reject_event"(platform: "/mobile", type: TrackType.Event) {
    }

    "/mplayer/tracing/close_event"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/close_event/exit"(platform: "/mobile", type: TrackType.Event) {
        button(required: true, PropertyType.String, description: "the button selected to exit")
    }

    "/mplayer/tracing/reject_event"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/tracing/reject_event/exit"(platform: "/mobile", type: TrackType.Event) {
        button(required: true, PropertyType.String, description: "the button selected to exit")
    }

    "/mplayer/tracing/social_hub/"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/tracing/social_hub/money_split"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/social_hub/send_money"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/tracing/social_hub/money_request"(platform: "/mobile", type: TrackType.Event) {}

    "/money_request"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/money_request/picker"(platform: "/mobile") {}
    "/money_request/fill_transaction_data"(platform: "/mobile") {}
    "/money_request/social_share"(platform: "/mobile") {}
    "/money_request/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/money_request/confirm"(platform: "/web", type: TrackType.Event){}
    "/money_request/congrats"(platform: "/web"){}

    "/send_money"(platform: "/", isAbstract: true) {
        flow (required:true, type: PropertyType.String, description: "Use case that has been executed")
        from (required:false, type: PropertyType.String, description: "Where the flow start")
    }
    "/send_money/fill_transaction_data"(platform: "/mobile") {}
    "/send_money/pay"(platform: "/mobile") {}
    "/send_money/deals"(platform: "/mobile") {}
    "/send_money/deals/terms"(platform: "/mobile") {}
    "/send_money/payment_methods"(platform: "/mobile") {}
    "/send_money/other_payment_methods"(platform: "/mobile") {}
    "/send_money/cards"(platform: "/mobile") {}
    "/send_money/add_card"(platform: "/mobile") {}
    "/send_money/issuers"(platform: "/mobile") {}
    "/send_money/my_cards"(platform: "/mobile") {}
    "/send_money/result"(platform: "/mobile") {
        result_status (required:true, type: PropertyType.String, description: "Operation result status")
        status_detail (required:false, type: PropertyType.String, description: "Operation result status detail")
    }
    "/send_money/bacen"(platform: "/mobile", isAbstract: true) {}
    "/send_money/bacen/ok"(platform: "/mobile") {}
    "/send_money/bacen/cancel"(platform: "/mobile") {}
    "/send_money/bacen/error"(platform: "/mobile") {}
    "/send_money/bacen/open"(platform: "/mobile") {}
    "/send_money/bacen/close"(platform: "/mobile") {}
    "/send_money/confirm"(platform: "/web", type: TrackType.Event){}

    // Request Landing

    "/mplayer/request_landing"(platform: "/web", type: TrackType.View){
        request_status(required: false, PropertyType.String, description: "the status of the request")
    }

    "/mplayer/request_landing/success"(platform: "/web", type: TrackType.Event){
        transaction_amount(required: false, PropertyType.Numeric, description: "the transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "if the transaction have a reason message")
    }

    "/mplayer/download_app"(platform: "/web", type: TrackType.View){}

    "/mplayer/download_app/appstore"(platform: "/web", type: TrackType.Event){}

    "/mplayer/download_app/playstore"(platform: "/web", type: TrackType.Event){}

    // Multiplayer/Friends Marketing Performance Landing
    "/mplayer/mkt_landing"(platform: "/web", type: TrackType.View, initiative: "1176") {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/mplayer/mkt_landing/sms"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
    }
    "/mplayer/mkt_landing/copy-clipboard"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["coupon", "steps"], description: "Indicates position of copy button")
    }
    "/mplayer/mkt_landing/button"(platform: "/web", type: TrackType.Event) {
        campaign (require: true, type: PropertyType.String, description: "Indicates de campaign of landing")
        position (require: true, type: PropertyType.String, values: ["hero", "fixed", "footer"], description: "Indicates position of button in landing")
    }

    // Contacts
    "/mplayer/contacts"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/contacts/massive_upload"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/contacts/search"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/contacts/massive_upload/start"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/contacts/massive_upload/successful_end"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/contacts/search/start"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/contacts/search/end"(platform: "/mobile", type: TrackType.Event) {}

}
