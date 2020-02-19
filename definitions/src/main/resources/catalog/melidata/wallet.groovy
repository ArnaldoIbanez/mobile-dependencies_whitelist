import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    /**
    * Wallet screen tracks
    */

    "/wallet"(platform: "/mobile", isAbstract: true) {}
    "/wallet/cards"(platform: "/mobile", isAbstract: true) {}
    
    "/wallet/cards/listing"(platform: "/mobile", type: TrackType.View) {}

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

    /**
     * New Digital Wallet Tracks - Ukraine Lab
     */
    "/new_digital_wallet"(platform: "/", type: TrackType.View) {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
    }
    "/new_digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
        landing_id (required: true, type: PropertyType.String, description: "Indicate landing id")
        section_store (required: true, type: PropertyType.String, values: ["hero_appstore", "hero_googleplay", "fixed_appstore", "fixed_googleplay", "footer_appstore", "footer_googleplay"], description: "Section from which the event comes and Store (Google Play or App Store)")
    }
}
