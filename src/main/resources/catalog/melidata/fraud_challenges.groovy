package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType

tracks {

    initiative = '1100'

    "/auth/card"(platform: "/", isAbstract: true) {}
    "/auth/card/validation"(platform: "/", isAbstract: true) {}
    "/auth/card/validation/random-charge"(platform: "/", type: TrackType.Event) {
        status(type: PropertyType.String, required: true, description: "The status of the challenge")
        marketplace(type: PropertyType.String, required: true, description: "Marketplace on/off of the payment")
        bank(type: PropertyType.String, required: true, description: "The bank of the card")
        payment_method_id(type: PropertyType.String, required: true, description: "The payment method. i.e visa, master, etc")
    }

    "/auth/card/landing"(platform: "/", type: TrackType.View) {}
}