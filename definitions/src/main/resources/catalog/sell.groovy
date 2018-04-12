import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    // Sell
    "/sell"(platform: "/", isAbstract: true) {}
    "/sell/list"(platform: "/", isAbstract: true){
        session_id(required: false, description: "Session id for a specific user flow", type: PropertyType.String)
    }
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
        session_id(required: false, description: "The listing session id")
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
    "/sell/list/drafts"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/drafts/draft_action"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/drafts/draft_action/draft_deleted"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/drafts/draft_action/draft_resumed"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/draft"(platform:"/mobile", type: TrackType.View, isAbstract: true){}
    "/sell/list/draft/sip"(platform:"/mobile", type: TrackType.View){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/draft/congrats"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/sip_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/seller_registration"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_options_me"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/listing_types"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/picture_preview_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures_review/editor"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/listing_types_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_options_me_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/attribute"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/phone_suggestion"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/payment_methods"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/condition"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/congrats/payment_pending"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/color_selection"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/description_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/seller_registration_zip_code"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/category_navigation"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/pictures"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/category_suggestion"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/title"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/title_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/registration_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/size_selection"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/description_included"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/location"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/size_selection_review"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_landing"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/shipping_flat_cost"(platform:"/mobile", type: TrackType.View){}
    "/sell/list/draft/price_modality"(platform:"/mobile", type: TrackType.View){}

    "/sell/list/hub"(platform: "/", type: TrackType.View) {}
    "/sell/list/walkthrough"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/hub_old"(platform: "/", type: TrackType.View) {}

    "/sell/list/sip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/publish"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/publish/pictures_fail"(platform: "/mobile", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
    }
    "/sell/list/sip/publish/fail"(platform: "/mobile", type: TrackType.Event) {
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }
    "/sell/list/sip/publish/abandonment"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/notification"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/notification/view_item"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/notification/upgrade"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/notification/congrats"(platform: "/mobile", type: TrackType.Event) {}

    "/sell/list/category_suggestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_navigation"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        category_domain(required: true, description: "Category Domain", type: PropertyType.String)
        category_id(required: true, description: "Category Id", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
    }
    "/sell/list/phone_suggestion"(platform:"/mobile", type:TrackType.View){}
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
    "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        album_name(required: false, description: "Album name", type: PropertyType.String)
    }
    "/sell/list/pictures_uploader"(platform: "/", isAbstract: true) {}
     "/sell/list/pictures_uploader/crop"(platform: "/", isAbstract: true) {}
    "/sell/list/pictures_uploader/crop/crop_canceled"(platform: "/", type: TrackType.Event) {}
    "/sell/list/pictures_uploader/crop/crop_acepted"(platform: "/", type: TrackType.Event) {}
    //Este path recibira las keys de los errores en las validaciones del images_uploader
    "/sell/list/pictures_uploader/validations"(platform: "/web", type: TrackType.Event) {
        error_key(required: true, description: "error key", type: PropertyType.String)
    }
    "/sell/list/pictures_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures_review/crop"(platform: "/", type: TrackType.View) {}
    "/sell/list/price"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/price/similar_products"(platform: "/mobile") {}
    "/sell/list/price/similar_products/similar_item_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/price/similar_products/similar_item_shown"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/price_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/price_review/similar_products"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/seller_registration"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/seller_registration_zip_code"(platform: "/", type: TrackType.View) {}
    "/sell/list/zip_code"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/sell/list/zip_code/zip_code"(platform: "/", type: TrackType.Event, isAbstract: true) {}
    "/sell/list/zip_code/zip_code/search_zip_code"(platform: "/", type: TrackType.Event) {}

    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/title"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/title_review"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/shipping_options_me"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/shipping_options_me_review"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/pictures_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/registration_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/registration_zip_code_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/shipping_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_price_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_shipping_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_condition_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/title_landing"(platform: "/", type: TrackType.View) {

    }
   "/sell/list/listing_types"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/listing_types_upgrade"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/congrats_upgrade"(platform: "/", type: TrackType.View) {

    }
    "/sell/list/item_description"(platform: "/", type: TrackType.View){

        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }
    "/sell/list/sale_condition"(platform: "/", type: TrackType.View){

    }
    "/sell/list/item_description/title_prediction"(platform: "/", type: TrackType.View){

        category_id(required: false, description: "Category id", type: PropertyType.String)
        user_id(required: false, description: "User id", type: PropertyType.String)
        domain_id(required: false, description: "Domain id", type: PropertyType.String)
        attributes(required: false, description: "Attributes", type: PropertyType.ArrayList)
    }

    "/sell/list/item_description/final_attributes"(platform: "/", type: TrackType.View){

        category_id(required: false, description: "Category id", type: PropertyType.String)
        user_id(required: false, description: "User id", type: PropertyType.String)
        domain_id(required: false, description: "Domain id", type: PropertyType.String)
        attributes(required: false, description: "Attributes", type: PropertyType.ArrayList)
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

    "/sell/update/category_suggestion"(platform: "/", type: TrackType.View) {
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
    "/sell/update/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        session_id(required: true, description: "Session Id", type: PropertyType.String)
        category_domain(required: true, description: "Category Domain", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
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
        item_id(required: true, description: "Item id", type: PropertyType.String)
        album_name(required: true, description: "Album name", type: PropertyType.String)
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
    "/sell/update/price"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
     "/sell/update/price/similar_products"(platform: "/", isAbstract: true) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price/similar_products/similar_item_selected"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price/similar_products/similar_item_shown"(platform: "/", type: TrackType.Event) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/price_review/similar_products"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/size_selection"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/size_selection_review"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/title"(platform: "/", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/title_review"(platform: "/", type: TrackType.View) {
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
        condition(required: false, description: "Item condition", type: PropertyType.String)
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
    }
    "/sell/list/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: true, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required:true, description: "Value for attribute or feedback", type: PropertyType.String)
    }

    "/sell/update/modal_attributes"(platform: "/web", type: TrackType.View) {
        item_id(required: false, description: "Item id", type: PropertyType.String)
        condition(required: false, description: "Item condition", type: PropertyType.String, values:["new", "used", "not_specified", "refurbished"])
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
    }
    "/sell/update/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: true, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
    }
    
    "/sell/qr"(platform: "/", isAbstract: true) {}
    
    "/sell/qr/print_intention"(platform: "/web", type: TrackType.View){
        item_id(required: true)
        qr_type(required: true)
        listing_type_id(required: true)
        vertical(required: true)
    }

}
