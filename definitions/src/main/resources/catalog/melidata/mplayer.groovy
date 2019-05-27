import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * MultiPlayer MoneyTransfer Screen Tracks
    */

    "/mplayer"(platform: "/mobile", isAbstract: true) {}

    "/mplayer/send_money"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/contact_picker"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/manual_amount"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/friend_invite"(platform: "/mobile", type: TrackType.View) {}
    "/mplayer/send_money/contact_picker/invalid_nickname"(platform: "/mobile", type: TrackType.Event) {}
    "/mplayer/send_money/contact_picker/select_contact"(platform: "/mobile", type: TrackType.Event) {
        input_type(required: false, PropertyType.String)
        source(required: false, PropertyType.String)
        is_recent(required: false, PropertyType.Boolean)
    }
    "/mplayer/send_money/manual_amount/continue"(platform: "/mobile", type: TrackType.Event) {
        transaction_amount(required: false, PropertyType.Numeric)
        reason(required: false, PropertyType.String)
    }
    "/mplayer/send_money/friend_invite/invite_pressed"(platform: "/mobile", type: TrackType.Event) {
        is_contact(required: false, PropertyType.Boolean)
        source(required: false, PropertyType.String)
        destination(required: false, PropertyType.String)
    }

    // PX
    "/mplayer/send_money/result"(platform: "/mobile", isAbstract: true) {}
    "/mplayer/send_money/result/success"(platform: "/mobile", type: TrackType.View) {
        is_contact(required: false, PropertyType.Boolean)
        source(required: false, PropertyType.String)
        payment_method_id(required: false, PropertyType.String)
        transaction_amount(required: false, PropertyType.Numeric)
        fee_info(required: false, PropertyType.String)
    }
    "/mplayer/send_money/result/error"(platform: "/mobile", type: TrackType.View) {
        error(required: false, PropertyType.String)
        is_contact(required: false, PropertyType.Boolean)
        source(required: false, PropertyType.String)
    }
}
