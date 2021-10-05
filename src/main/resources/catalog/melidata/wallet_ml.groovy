package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
     * Wallet screen tracks for meli
     */

    defaultBusiness = "mercadolibre"

    "/wallet"(platform: "/mobile", isAbstract: true) {}
    "/wallet/cards"(platform: "/mobile", isAbstract: true) {}
    
    "/wallet/cards/listing"(platform: "/mobile", type: TrackType.View) {}

    "/wallet/cards/listing/error"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        screen (required: true, type: PropertyType.String, description: "The screen that showed error")
    }

    // Card detail
    "/wallet/cards/detail"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {}
    
    // Add card Events
    "/wallet/cards/add_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/add_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/add_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Delete card Events
    "/wallet/cards/detail/delete_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Add card button
    "/wallet/cards/add_card_header"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Back button
    "/wallet/cards/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
}
