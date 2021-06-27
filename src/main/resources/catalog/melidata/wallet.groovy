package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1125"
    defaultBusiness = "mercadopago"

    /**
    * Wallet screen tracks
    */

    "/wallet"(platform: "/mobile", isAbstract: true) {}
    "/wallet/cards"(platform: "/mobile", isAbstract: true) {}
    
    "/wallet/cards/listing"(platform: "/mobile", type: TrackType.View) {
        version (required:true, type: PropertyType.String, description: "Card listing version")
    }

    "/wallet/cards/listing/error"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        screen (required: true, type: PropertyType.String, description: "The screen that showed error")
    }

    // Card detail
    "/wallet/cards/detail"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.View) {
        version (required:false, type: PropertyType.String, description: "Card listing version")
    }
    
    // Add card Events
    "/wallet/cards/add_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        id_banner (required:true, type: PropertyType.String, description: "Prepaid/Debit banner id")
        other_cards (required:true, type: PropertyType.Boolean, description: "It's true when there are other bankings cards added")
    }
    "/wallet/cards/add_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/add_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Delete card Events
    "/wallet/cards/detail/delete_card"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/success"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}
    "/wallet/cards/detail/delete_card/failed"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    //inner properties definitions
    def action_definition = objectSchemaDefinitions {
        title (required:false, type: PropertyType.String, description: "Action title")
        icon (required:false, type: PropertyType.String, description: "Action image key")
        type (required:false, type: PropertyType.String, description: "Action type")
        link (required:true, type: PropertyType.String, description: "Banner destination link")
    }

    // Banner card Events
    "/wallet/cards/banner_print"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        id (required:true, type: PropertyType.String, description: "Banner id")
        type (required:true, type: PropertyType.String, values: ["primary", "empty", "card"], description: "Banner type")
        title (required:false, type: PropertyType.String, description: "Banner title")
        description (required:false, type: PropertyType.String, description: "Banner description or subtitle")
        image (required:false, type: PropertyType.String, description: "Banner image key")
        secondary_image (required:false, type: PropertyType.String, description: "Secondary image")
        background (required:false, type: PropertyType.String, description: "Background")
        chevron_color (required:false, type: PropertyType.String, description: "Chevron color")
        action (required:false, type: PropertyType.Map(action_definition), description: "Banner action")
    }
    "/wallet/cards/banner_tap"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {
        id (required:true, type: PropertyType.String, description: "Banner id")
        type (required:true, type: PropertyType.String, values: ["primary", "empty", "card"], description: "Banner type")
        title (required:false, type: PropertyType.String, description: "Banner title")
        description (required:false, type: PropertyType.String, description: "Banner description or subtitle")
        image (required:false, type: PropertyType.String, description: "Banner image key")
        secondary_image (required:false, type: PropertyType.String, description: "Secondary image")
        background (required:false, type: PropertyType.String, description: "Background")
        chevron_color (required:false, type: PropertyType.String, description: "Chevron color")
        action (required:false, type: PropertyType.Map(action_definition), description: "Banner action")
    }
    
    // Add card button
    "/wallet/cards/add_card_header"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    // Back button
    "/wallet/cards/back"(platform: "/mobile", parentPropertiesInherited: false, type: TrackType.Event) {}

    /**
     * Wallet Connect tracks
     */

    "/wallet/connect" (platform: "/web", isAbstract: true) {}

    "/wallet/connect/home" (platform: "/web", type: TrackType.View) {}

    "/wallet/connect/return_tokenizer" (platform: "/web", type: TrackType.View) {}
     
    "/wallet/connect/error" (platform: "/web", isAbstract: true) {}

    "/wallet/connect/error/reject_card" (platform: "/web", type: TrackType.View) {}
    
    "/wallet/connect/error/default" (platform: "/web", type: TrackType.View) {}

    "/wallet/connect/close_tokenizer" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/open_tokenizer" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/deny_button" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/confirm_payment" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/empty_card" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/tokenizer_express" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/on_retry" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/skip_card_payment" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/on_change_card" (platform: "/web", type: TrackType.Event) {}

    "/wallet/connect/confirm_success" (platform: "/web", type: TrackType.Event) {}
}
