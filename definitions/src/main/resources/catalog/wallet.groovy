import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Wallet screen tracks
    */

    "/wallet"(platform: "/mobile", isAbstract: true) {}
    
    "/wallet/cards"(platform: "/mobile", type: TrackType.View) {
        cards_quantity(required: true, type: PropertyType.Numeric, description: "Amount of cards the user has associated")
        saved_cards(required: true, type: PropertyType.ArrayList , description:  "Cards info")
        //card_id
        //payment_method_name
        //last_four_digits
    }

    // Card detail
    "/wallet/card_detail"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {}
    
    // Add card button
    "/wallet/cards/add_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Back button
    "/wallet/cards/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
}
