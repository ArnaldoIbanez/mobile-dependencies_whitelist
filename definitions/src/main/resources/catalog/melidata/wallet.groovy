import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Wallet screen tracks
    */

    "/wallet"(platform: "/mobile", isAbstract: true) {}
    
    "/wallet/cards/listing"(platform: "/mobile", type: TrackType.View) { }

    // Card detail
    "/wallet/cards/detail"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {}
    
    // Add card Events
    "/wallet/cards/detail/add_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/add_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/add_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Delete card Events
    "/wallet/cards/detail/delete_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Add card button
    "/wallet/cards/add_card_header"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Back button
    "/wallet/cards/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
}
