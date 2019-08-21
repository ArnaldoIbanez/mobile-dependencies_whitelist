import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * MultiPlayer MoneyTransfer Screen Tracks
    */

    "/mplayer"(platform: "/mobile", isAbstract: true) {}

    // Send Money
    "/mplayer/send_money"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/friend_invite"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/send_money/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of contact selected, select from list or manually typed")
        source(required: true, PropertyType.String, description: "the source of the contact")
        is_recent(required: true, PropertyType.Boolean, description: "if the seleted contact is a recent contact")
    }
    "/mplayer/send_money/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        has_reason(required: false, PropertyType.Boolean, description: "if the transaction have a reason message")
    }
    "/mplayer/send_money/friend_invite/invite_pressed"(platform: "/mobile", type: TrackType.Event) {
        source(required: true, PropertyType.String, description: "the source of the contact")
        destination(required: true, PropertyType.String, description: "the destination of the invitation")
    }
    "/mplayer/send_money/friend_invite/back_to_home"(platform: "/mobile", type: TrackType.Event) {}

    "/mplayer/send_money/result"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/result/success"(platform: "/mobile", type: TrackType.View) {
        is_contact(required: false, PropertyType.Boolean, description: "if the collector is a contact")
        source(required: false, PropertyType.String, description: "the source of the contact")
        payment_method_id(required: true, PropertyType.String, description: "the payment method id")
        transaction_amount(required: true, PropertyType.Numeric, description: "the transaction amount")
        fee_info(required: true, PropertyType.String, description: "the info of the fee")
    }
    "/mplayer/send_money/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: true, PropertyType.String, description: "the transaction error")
        is_contact(required: false, PropertyType.Boolean, description: "if the collector is a contact")
        source(required: false, PropertyType.String, description: "the source of the contact")
    }

    // Money Request
    "/mplayer/money_request"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/money_request/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_request/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/money_request/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/money_request/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: true, PropertyType.String, description: "the input type of contact selected, select from list or manually typed")
        source(required: true, PropertyType.String, description: "the source of the contact")
        is_recent(required: true, PropertyType.Boolean, description: "if the seleted contact is a recent contact")
    }
}
