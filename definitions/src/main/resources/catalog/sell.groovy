import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    // Sell
    "/sell"(platform: "/", isAbstract: true) {}
    "/sell/list"(platform: "/", isAbstract: true){ }
    "/sell/change_listing_type"(platform: "/web", isAbstract: true) {
        source(required: true, description: "Source could be differents types of email, my account, etc.", type: PropertyType.String)
        seller_experience(required: true, description: "Seller experience: newbie, intermediate or advanced")
    }
    "/sell/landing"(platform: "/", isAbstract: true){ }
    "/sell/landing/free_listing"(platform: "/", type: TrackType.View){
        referer(required:false , description: "Notification ID")
    }

    "/sell/change_listing_type/single"(platform: "/", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: true, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: true, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: true, description: "Item condition: used/new/not_specified")
        price(required: true, description: "Item price")
        view_type(required:true, description: "Type of the view. Upgrade / Upgrade full screen / single option, ect...")
    }

    "/sell/change_listing_type/massive"(platform: "/", type: TrackType.View){
        items_amount(required: true, description: "Amount of items affected")
        view_type(required:true, description: "Type of the view. Upgrade / Upgrade full screen / single option, ect...")
    }

    "/sell/quick_relist"(platform: "/web/desktop", isAbstract: true){}
    "/sell/quick_relist/single"(platform: "/web/desktop", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        quantity(required: false, description: "Item quantity")
    }

    "/sell/quick_relist/massive"(platform: "/web/desktop", type: TrackType.View){
        items_amount(required: true, description: "Amount of items affected")
    }

    "/sell/modify_and_relist"(platform: "/web", isAbstract: true){}
    "/sell/modify_and_relist/single"(platform: "/web", isAbstract: true){
        item_id(required: true, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        quantity(required: false, description: "Item quantity")
    }

    "/sell/modify_and_relist/single/row"(platform: "/web", type: TrackType.View){}
    "/sell/modify_and_relist/single/cards"(platform: "/web", type: TrackType.View){}

    "/sell/modify_and_relist/massive"(platform: "/web", isAbstract: true){
        items_amount(required: true, description: "Amount of items affected")
    }
    "/sell/modify_and_relist/massive/row"(platform: "/web", type: TrackType.View){}

    // Tambien se utiliza para Apps
    "/sell/list/congrats"(platform: "/", type: TrackType.View){
        item_id(required: false, description: "Item id")
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }
    // Upgrade Off = El upgrade de clasificados
    "/sell/upgradeOff"(platform:"/", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
        referer(required:false , description: "Referer link from where the request came")
    }
    // Upgrade On = El upgrade que se ofrece en la congrats del flujo de publicar
    "/sell/upgrade_on"(platform: "/web/desktop", type: TrackType.View){
        item_id(required: true, description: "Item id")
        listing_type_id(required: true, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }

    // Apps
    "/sell/list/drafts"(platform: "/", type: TrackType.View) {}
    "/sell/list/hub"(platform: "/", type: TrackType.View) {}
    "/sell/list/walkthrough"(platform: "/", type: TrackType.View) {}
    "/sell/list/hub_old"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_sugestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_navigation"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/description"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core/similar_products"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/price_core_review/similar_products"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_zip_code"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_core"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_core_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_options_me"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_options_me_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/registration_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/registration_zip_code_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_price_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update"(platform: "/", isAbstract: true) {}
    "/sell/update/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/update/listing_types_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/update/congrats_upgrade"(platform: "/", type: TrackType.View) {}


}
