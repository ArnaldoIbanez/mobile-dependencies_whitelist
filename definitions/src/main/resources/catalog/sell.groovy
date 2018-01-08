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

    "/sell/change_listing_type/upgrade_intention"(platform: "/web", type: TrackType.Event){
        item_id(required: true)
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
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
    "/sell/list/drafts"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/drafts/draft_action"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/drafts/draft_action/draft_deleted"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/drafts/draft_action/draft_resumed"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }

    "/sell/list/hub"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/walkthrough"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/hub_old"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/publish"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip/publish/pictures_fail"(platform: "/", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip/publish/fail"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }
    "/sell/list/sip/publish/abandonment"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip/notification"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip/notification/view_item"(platform: "/", type: TrackType.Event) {
        session_id(required: true, description: "Item id", type: PropertyType.String)
    }
    "/sell/list/sip/notification/upgrade"(platform: "/", type: TrackType.Event) {
        session_id(required: true, description: "Item id", type: PropertyType.String)
    }
    "/sell/list/sip/notification/congrats"(platform: "/", type: TrackType.Event) {
        session_id(required: true, description: "Item id", type: PropertyType.String)
    }

    "/sell/list/category_sugestion"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/category_navigation"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/color_selection"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/condition"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/condition_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/description"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/description_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/payment_methods"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/payment_methods_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/listing_types_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures/gallery"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures/editor"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures/crop"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)   
        album_name(required: false, description: "Album name", type: PropertyType.String)   
    }
    "/sell/list/pictures_uploader"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
     "/sell/list/pictures_uploader/crop"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_uploader/crop/crop_canceled"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_uploader/crop/crop_acepted"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    //Este path recibira las keys de los errores en las validaciones del images_uploader
     "/sell/list/pictures_uploader/validations"(platform: "/web", type: TrackType.Event) {
        error_key(required: false, description: "error description", type: PropertyType.String)
    }
    "/sell/list/pictures_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_review/gallery"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_review/editor"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_review/crop"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/price_core"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
     "/sell/list/price_core/similar_products"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/price_core/similar_products/similar_item_selected"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/price_core/similar_products/similar_item_shown"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/price_core_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/price_core_review/similar_products"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/seller_registration"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/seller_registration_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/seller_registration_zip_code"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/zip_code"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/zip_code/zip_code"(platform: "/", isAbstract: true) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/zip_code/zip_code/search_zip_code"(platform: "/", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/title_core"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/title_core_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/shipping_options_me"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/shipping_options_me_review"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/pictures_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/registration_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/registration_zip_code_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/shipping_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_price_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_shipping_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_condition_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/title_landing"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
   "/sell/list/listing_types"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/listing_types_upgrade"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/congrats_upgrade"(platform: "/", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
    }
    "/sell/list/item_description"(platform: "/", type: TrackType.View){
        session_id(required: false, description: "Session id", type: PropertyType.String)
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }

//update flow

    "/sell/update/sip"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/publish"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/publish/pictures_fail"(platform: "/", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/publish/fail"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }
    "/sell/update/sip/publish/abandonment"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/notification"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/notification/view_item"(platform: "/", type: TrackType.Event) {
        item_id(required: true, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/notification/upgrade"(platform: "/", type: TrackType.Event) {
        item_id(required: true, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip/notification/congrats"(platform: "/", type: TrackType.Event) {
        item_id(required: true, description: "Item id", type: PropertyType.String)
    }

    "/sell/update/category_sugestion"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/category_navigation"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/color_selection"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/color_selection_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/condition"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/condition_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/description"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/description_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/payment_methods"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/payment_methods_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/updateing_types"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/updateing_types_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures/gallery"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures/editor"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures/crop"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        session_id(required: false, description: "Session id", type: PropertyType.String)   
        album_name(required: false, description: "Album name", type: PropertyType.String)   
    }
    "/sell/update/pictures_uploader"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
     "/sell/update/pictures_uploader/crop"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_uploader/crop/crop_canceled"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_uploader/crop/crop_acepted"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_review/gallery"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_review/editor"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/pictures_review/crop"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_core"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
     "/sell/update/price_core/similar_products"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_core/similar_products/similar_item_selected"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_core/similar_products/similar_item_shown"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_core_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_core_review/similar_products"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/size_selection"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/size_selection_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/title_core"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/title_core_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/shipping_options_me"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/shipping_options_me_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_price_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_shipping_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_condition_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/title_landing"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/listing_types"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/listing_types_upgrade"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/congrats_upgrade"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }

    "/sell/list/modal_attributes"(platform: "/web", type: TrackType.View) {
        session_id(required: false, description: "Session id", type: PropertyType.String)
        user_id(required: true, description: "User id", type: PropertyType.String)
        condition(required: true, description: "Item condition", type: PropertyType.String)
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
    }
    "/sell/list/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        attribute_id(required: true, description: "Attribute id", type: PropertyType.String)
        option_selected(required: true, description: "Radio option selected", type: PropertyType.String)
    }

    "/sell/update/modal_attributes"(platform: "/web", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
        user_id(required: true, description: "User id", type: PropertyType.String)
        condition(required: true, description: "Item condition", type: PropertyType.String)
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
    }
    "/sell/update/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        attribute_id(required: true, description: "Attribute id", type: PropertyType.String)
        option_selected(required: true, description: "Radio option selected", type: PropertyType.String)
    }

}
