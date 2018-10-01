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
    "/sell/list/draft/location_suggestion"(platform:"/mobile", type: TrackType.View){}
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
    "/sell/list/draft/free_shipping"(platform:"/mobile", type: TrackType.View){}

    "/sell/list/hub"(platform: "/", type: TrackType.View) {}
    "/sell/list/walkthrough"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/hub_old"(platform: "/", type: TrackType.View) {}
    "/sell/list/attribute"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/picture_preview_landing"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/picture_uploader"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/picture_uploader/mode"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/picture_uploader/mode/camera"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/pictures/crop"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/pictures/crop"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/pictures/crop/crop_accepted"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/pictures/crop/crop_canceled"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/manufacturing_time"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/free_shipping"(platform:"/mobile", type: TrackType.View){}


    "/sell/list/sip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/publish"(platform: "/mobile", isAbstract: true) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/publish/publish_cancel"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/publish/back_selected"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/publish/pictures_fail"(platform: "/mobile", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
    }
    "/sell/list/sip/publish/fail"(platform: "/mobile", type: TrackType.Event) {
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }
    "/sell/list/sip/publish/abandonment"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/section"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update/listing_types_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/listing_type" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/description_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/pictures_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/description" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/pictures" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/price_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/price" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/shipping_options_me_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/title" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/shipping_options" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/payment_methods_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/payment_options" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/shipping_options" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/payment_methods_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/payment_options" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/color_selection_review" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update/condition_review" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update/condition" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update/include_description" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/manufacturing_time_review" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/manufacturing_time" (platform: "/mobile", type: TrackType.Event){}
    "/sell/list/sip/update/location" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/update/size_selection_review" (platform: "/mobile", type: TrackType.Event){
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }

    "/sell/list/sip/notification"(platform: "/mobile", isAbstract: true) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/list/sip/notification/view_item"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/notification/upgrade"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/sip/notification/congrats"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/congrats/payment_pending"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/location"(platform: "/", type: TrackType.View) {}
    "/sell/list/location_suggestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/location_street"(platform: "/mobile", type: TrackType.View){}
    "/sell/list/category_suggestion"(platform: "/", type: TrackType.View) {}
    "/sell/list/category_navigation"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        session_id(required: true, description: "Session Id of the list flow, that dies when the flow ends", type: PropertyType.String)
        category_domain(required: false, description: "Category Domain", type: PropertyType.String)
        category_id(required: true, description: "Category Id", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/list/phone_suggestion"(platform:"/mobile", type:TrackType.View){}
    "/sell/list/condition"(platform: "/", type: TrackType.View) {}
    "/sell/list/condition_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/description"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/description_not_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/sip/update/extra_description"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/description_additional_information_review"(platform: "/mobile", type: TrackType.View) {}
    "/sell/list/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/list/payment_methods_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/list/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        album_name(required: false, description: "Album name", type: PropertyType.String)
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
    "/sell/list/manufacturing_time"(platform: "/", type: TrackType.View) {}
    "/sell/list/phone"(platform: "/", type: TrackType.View) {}
    "/sell/list/picture_editor"(platform: "/mobile",isAbstract:true){}
    "/sell/list/picture_editor/function"(platform: "/mobile",isAbstract:true){}
    "/sell/list/picture_editor/function/crop"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/picture_editor/function/rotate"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category"(platform: "/mobile", isAbstract:true){}
    "/sell/list/category/selection"(platform: "/mobile", isAbstract:true){}
    "/sell/list/category/selection/confirm_suggested"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/wrong_suggested"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l1"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l2"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l3"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l4"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/category/selection/l5"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/price_modality"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/modal"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/modal/close"(platform: "/mobile", isAbstract: true) {}
    "/sell/list/modal/close/onboarding"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/list/shipping_flat_cost"(platform: "/mobile", type: TrackType.View) {}

    "/sell/list/size_selection"(platform: "/", type: TrackType.View) {}
    "/sell/list/size_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/list/title"(platform: "/", type: TrackType.View) {}
    "/sell/list/title_review"(platform: "/", type: TrackType.View) {}
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
    "/sell/list/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/list/listing_types_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/list/congrats_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/list/item_description"(platform: "/", type: TrackType.View){
        listing_type_id(required: false, description: "Item listing type id")
        vertical(required: false, description: "Item Vertical: core/service/motor/real_estate/etc...")
        buying_mode(required: false, description: "Item buying mode: buy_it_now/auction/classified")
        condition(required: false, description: "Item condition: used/new/not_specified")
        price(required: false, description: "Item price")
    }
    "/sell/list/sale_condition"(platform: "/", type: TrackType.View){}
    "/sell/list/item_description/title_prediction"(platform: "/", type: TrackType.View){
        category_id(required: true, description: "Category id", type: PropertyType.String)
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        attributes(required: true, description: "Attributes", type: PropertyType.ArrayList)
    }

    "/sell/list/item_description/final_attributes"(platform: "/", type: TrackType.View){
        category_id(required: true, description: "Category id", type: PropertyType.String)
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        attributes(required: true, description: "Attributes", type: PropertyType.ArrayList)
    }

//update flow
    "/sell/update" (platform: "/", isAbstract: true){
        item_id(required: true, description: "Item id", type: PropertyType.String)
    }
    "/sell/update/autocomplete"(platform: "/", isAbstract: true){}
    "/sell/update/autocomplete/update"(platform: "/", isAbstract: true){}
    "/sell/update/autocomplete/update/suggested_attr_selected"(platform: "/mobile", type: TrackType.Event) {
        attribute_id(required: true, "ID from attribute that was suggested", type: PropertyType.String)
    }
    "/sell/update/description_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/description_not_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/manufacturing_time"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/closed_sip"(platform: "/mobile", isAbstract: true){}
    "/sell/update/closed_sip/section"(platform: "/mobile", isAbstract: true){}
    "/sell/update/closed_sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/update/sip/section"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/section/disabled"(platform: "/mobile", type: TrackType.Event) {
        section_id(required:true, description: "Section of the SIP that is disabled and trigger the event.", type: PropertyType.String)
    }
    "/sell/update/sip/update/price"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/statistics"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/pictures"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/list_closed_step"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/list_paused_step"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/list_activate_step"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/relist"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/listing_types"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/description"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/modify_variations"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/quantity"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/condition"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/technical_specifications"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/update/add_stock"(platform: "/mobile", type: TrackType.Event) {}

    "/sell/update/quantity_maximum_free_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/location"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/picture_preview_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/quantity"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/technical_specifications"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/shipping_landing"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/variations"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures_variations/editor"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/sip/publish"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/publish/pictures_fail"(platform: "/mobile", type: TrackType.Event) {
        total_pictures(required: true, description: "Total pictures", type: PropertyType.Numeric)
        fail_pictures(required: true, description: "Failed pictures", type: PropertyType.Numeric)
        pictures_errors(required: false, description: "Failed pictures", type: PropertyType.ArrayList)
    }
    "/sell/update/sip/publish/fail"(platform: "/mobile", type: TrackType.Event) {
        error_message(required: false, description: "Error message", type: PropertyType.String)
    }

    "/sell/update/sip/notification"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/sip/notification/view_item"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/notification/upgrade"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/sip/notification/congrats"(platform: "/mobile", type: TrackType.Event) {}

    "/sell/update/category_suggestion"(platform: "/", type: TrackType.View) {}
    "/sell/update/category_navigation"(platform: "/", type: TrackType.View) {}
    "/sell/update/color_selection"(platform: "/", type: TrackType.View) {}
    "/sell/update/color_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/color_selection/custom_color"(platform: "/web", type: TrackType.Event) {
        session_id(required: true, description: "Session Id of the update flow, that dies when the flow ends", type: PropertyType.String)
        category_domain(required: false, description: "Category Domain", type: PropertyType.String)
        category_id(required: true, description: "Category Id", type: PropertyType.String)
        is_custom_name(required: true, description: "True:The user changed the color´s name", type: PropertyType.Boolean)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/update/condition"(platform: "/", type: TrackType.View) {}
    "/sell/update/condition_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/description"(platform: "/", type: TrackType.View) {}
    "/sell/update/description_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/payment_methods"(platform: "/", type: TrackType.View) {}
    "/sell/update/payment_methods_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/updateing_types"(platform: "/", type: TrackType.View) {}
    "/sell/update/updateing_types_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/editor"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures/crop"(platform: "/", type: TrackType.View) {}
    "/sell/update/variations_pi"(platform: "/mobile", type: TrackType.View) {}
    "/sell/update/pictures/crop/crop_accepted"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures/crop/crop_canceled"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures/album_selected"(platform: "/mobile", type: TrackType.Event) {
        album_name(required: true, description: "Album name", type: PropertyType.String)
    }
    "/sell/update/picture_editor"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/picture_editor/function"(platform: "/mobile", isAbstract: true) {}
    "/sell/update/picture_editor/function/crop"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/picture_editor/function/delete"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/picture_editor/function/rotate"(platform: "/mobile", type: TrackType.Event) {}
    "/sell/update/pictures_uploader"(platform: "/", isAbstract: true) {}
    "/sell/update/pictures_uploader/crop"(platform: "/", isAbstract: true) {}
    "/sell/update/pictures_uploader/crop/crop_canceled"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures_uploader/crop/crop_acepted"(platform: "/", type: TrackType.Event) {}
    "/sell/update/pictures_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures_review/gallery"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures_review/editor"(platform: "/", type: TrackType.View) {}
    "/sell/update/pictures_review/crop"(platform: "/", type: TrackType.View) {}
    "/sell/update/price"(platform: "/", type: TrackType.View) {}
    "/sell/update/price/similar_products"(platform: "/", isAbstract: true) {}
    "/sell/update/price/similar_products/similar_item_selected"(platform: "/", type: TrackType.Event) {}
    "/sell/update/price/similar_products/similar_item_shown"(platform: "/", type: TrackType.Event) {}
    "/sell/update/price_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/price_review/similar_products"(platform: "/", type: TrackType.View) {}
    "/sell/update/size_selection"(platform: "/", type: TrackType.View) {}
    "/sell/update/size_selection_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/title"(platform: "/", type: TrackType.View) {}
    "/sell/update/title_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/shipping_options_me"(platform: "/", type: TrackType.View) {}
    "/sell/update/shipping_options_me_review"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_price_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_shipping_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_condition_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_condition_lt_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/sip_condition_listing_type_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update/title_landing"(platform: "/", type: TrackType.View) {}
    "/sell/update"(platform: "/", isAbstract: true) {}
    "/sell/update/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/update/listing_types_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/update/congrats_upgrade"(platform: "/", type: TrackType.View) {}
    "/sell/update/free_shipping"(platform: "/", type: TrackType.View) {}
    "/sell/update/statistics"(platform: "/", type: TrackType.View) {}


    "/sell/list/pictures_uploader"(platform: "/web/desktop", isAbstract: true){}
    "/sell/list/pictures_uploader/validations"(platform: "/web/desktop", type: TrackType.Event){
        error_key(required: true, description: "Error raised after picture validation", type: PropertyType.String)
    }
    "/sell/list/modal_attributes"(platform: "/web", type: TrackType.View) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        condition(required: false, description: "Item condition", type: PropertyType.String)
        na_attrs_not_pk(required: false, description: "Quantity of attributes not PK with N/A", type: PropertyType.Numeric)
        na_attrs_pk(required: false, description: "Quantity of attributes PK with N/A", type: PropertyType.Numeric)
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/list/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: false, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required:true, description: "Value for attribute or feedback", type: PropertyType.String)
    }

    "/sell/update/modal_attributes"(platform: "/web", isAbstract: true){
        domain_id(required: true, description: "Domain id", type: PropertyType.String)
        session_id(required: false, description: "Session id for a specific user flow", type: PropertyType.String)
        category_id(required: false, description: "Category Id", type: PropertyType.String)
        category_path(required: true, description: "Category path", type: PropertyType.ArrayList)
    }
    "/sell/update/modal_attributes"(platform: "/web", type: TrackType.View) {
        condition(required: false, description: "Item condition", type: PropertyType.String, values:["new", "used", "not_specified", "refurbished"])
        empty_attrs_pk(required: false, description: "Quantity of attributes PK", type: PropertyType.Numeric)
        empty_attrs_not_pk(required: false, description: "Quantity of attributes not PK", type: PropertyType.Numeric)
        na_attrs_not_pk(required: false, description: "Quantity of attributes not PK with N/A", type: PropertyType.Numeric)
        na_attrs_pk(required: false, description: "Quantity of attributes PK with N/A", type: PropertyType.Numeric)
    }
    "/sell/update/modal_attributes/submit"(platform: "/web", type: TrackType.Event) {
        attribute_id(required: true, description: "Attribute id submitted", PropertyType.String)
        hierarchy(required: true, description: "Hierarchy attribute", values:["CHILD_DEPENDENT", "CHILD_PK", "FAMILY", "ITEM", "PARENT_PK", "PRODUCT_IDENTIFIER"], PropertyType.String)
        option_selected(required: true, description: "Radio option selected", values:["completed", "no_data", "not_possible", "other"], PropertyType.String)
        value(required:true, description: "Value for attribute or feedback", type: PropertyType.String)
    }
    "/sell/upgrade/"(platform: "/", isAbstract: true){
        item_id (required: true, type: PropertyType.String)
        session_id (required: false, type: PropertyType.String)
    }
    "/sell/upgrade/listing_types"(platform: "/mobile", type: TrackType.View){}
    "/sell/upgrade/congrats"(platform: "/mobile", type: TrackType.View){}
    "/sell/upgrade/congrats/payment_pending"(platform: "/mobile", type: TrackType.View){}

    // Relist flow
    "/sell/relist"(platform: "/", isAbstract: true) {
        item_id (required: true, type: PropertyType.String)
    }
    "/sell/relist/csip"(platform: "/mobile", type: TrackType.View) {
        has_selected_pictures(required: false, description: "boolean - true if the user has selected pictures", type: PropertyType.Boolean)
    }
    "/sell/relist/congrats"(platform: "/web/desktop", type: TrackType.View) {
        can_complete_attributes(required: true, description: "Field to identify if link to update was offered.", type: PropertyType.Boolean)
    }
    "/sell/relist/congrats"(platform: "/mobile", type: TrackType.View) {}
    "/sell/relist/congrats/payment_pending"(platform: "/", type: TrackType.View) {
    }
    "/sell/relist/relist_congrats"(platform: "/mobile", type: TrackType.View) {}
    "/sell/relist/listing_types"(platform: "/", type: TrackType.View) {}
    "/sell/relist/description_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/relist/description_not_included"(platform: "/mobile", type: TrackType.View) {}
    "/sell/relist/description_additional_information"(platform: "/mobile", type: TrackType.View) {}
    "/sell/relist/update_data_landing"(platform: "/mobile", type: TrackType.View) {}

    // QR tracking
    "/sell/qr"(platform: "/", isAbstract: true) {}
    
    "/sell/qr/print_intention"(platform: "/web", type: TrackType.View){
        item_id(required: true)
        user_type(required: true, description: "The type of User that opened the QR code", values: ["car_dealer", "normal", "unknown"])
        listing_type_id(required: true)
        vertical(required: true)
        referrer(required: true, description: "From where the QR code was opened", values: ["email", "myml"])
    }

    // Tracks for Web mobile removed
    "/sell/landing_download_app"(platform: "/web/mobile", type: TrackType.View){}
    "/sell/landing_download_app/download_intention"(platform: "/web/mobile", type: TrackType.Event){}

    // Mobile flow - Push notification complete technical specifications
    "/sell/complete_technical_specifications"(platform: "/mobile", isAbstract: true) {
        item_id (required: true, type: PropertyType.String)
    }
    "/sell/complete_technical_specifications/technical_specifications"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_finish_no_complete"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_continue"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_no_items"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/congrats_finish"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/landing_intro"(platform: "/mobile", type: TrackType.View){}
    "/sell/complete_technical_specifications/congrats_has_more"(platform: "/mobile", type: TrackType.View){}

}
