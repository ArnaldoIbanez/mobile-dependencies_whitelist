package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //HOME FLOW

    initiative = "1171"

    def realestatedata = objectSchemaDefinitions {
        audience(type: PropertyType.String, required: false, description: "audience for the content")
        bu(type: PropertyType.String, required: false, description: "business unit for the content")
        bu_line(type: PropertyType.String, required: false, description: "vertical for the content")
        component_id(type: PropertyType.String, required: false,  description: "realestate id")
        content_id(type: PropertyType.String, required: false, description: "content id")
        flow(type: PropertyType.String, required: false, description: "flow for the content")
        logic(type: PropertyType.String, required: false, description: "logic of the content")
        position(type: PropertyType.Numeric, required: false, description: "position in array of the content")
    }

    def realestate = objectSchemaDefinitions {
        discovery(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestatedata)))
        main_slider(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestatedata)))
        collections(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestatedata)))
    }

    "/home"(platform: "/mobile") {
        retry_after_error(required: false)
        component_count(required: false, type: PropertyType.Numeric)
        newbie(required: false, type: PropertyType.Boolean)
        home_version(required: false, type: PropertyType.String)
        is_logged(required: false, type: PropertyType.Boolean)
        should_hide_onboarding_close(required: false, type: PropertyType.Boolean)
        should_hide_onboarding_close_date(required: false, type: PropertyType.String)
        mp_installed(required: false, type: PropertyType.Boolean)
    }

    "/home/failure"(platform: "/mobile", type: TrackType.Event) {
          error_message(required: false)
    }

    // long_press y contextual_menu son la misma acción, se preservan por temas de compatibilidad.
    "/home/long_press"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    // share y contextual_menu/share son la misma acción, se preservan por temas de compatibilidad.
    "/home/share"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/contextual_menu/share"(platform: "/mobile", type: TrackType.Event) {
        item_id()
    }

    "/home/back"(platform: "/mobile") {
    }

    "/home/navigation_history"(platform: "/") {
        privacy_config_state(required: false, type: PropertyType.Boolean)
    }

    "/home/navigation_history/admin"(platform: "/", type: TrackType.View) {}

    "/home/navigation_history/privacy_config_on"(platform: "/", type: TrackType.Event) {
    }

    "/home/navigation_history/privacy_config_off"(platform: "/", type: TrackType.Event) {
    }

    "/home/navigation_history/remove_all"(platform: "/", type: TrackType.Event) {
    }

    "/home/navigation_history/remove"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String)
        product_id(required: false, type: PropertyType.String)
        parent_product_id(required: false, type: PropertyType.String)
    }

    "/home/pulltorefresh"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/pulltorefresh/failure"(platform: "/mobile", type:TrackType.Event) {
    }

    "/home/pulltorefresh/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/page"(platform: "/mobile", type: TrackType.Event) {
        page_number(required: true, type: PropertyType.Numeric)
    }

    "/home/scroll"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/failure"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/scroll/abort"(platform: "/mobile", type: TrackType.Event) {
    }

    "/home/abort"(platform: "/mobile") {
    }

    "/home/tap"(platform: "/mobile") {
        position(type: PropertyType.Numeric)
        section()
        tag_id()
        is_modal(required: false, type: PropertyType.Boolean)
    }

    "/home/carousel"(platform: "/mobile", isAbstract: true) {
    }

    "/home/carousel/firstto"(platform: "/mobile") {
    }

    "/home/carousel/lastcard"(platform: "/mobile") {
    }

    "/home/categories"(platform: "/", type: TrackType.View) {}

    "/home"(platform: "/", type: TrackType.View) {
        realestates(required: false, type: PropertyType.ArrayList(PropertyType.Map(realestate)))
        from(required: false,  description: "Who is redirecting")
    }

    "/home/category"(platform: "/", type: TrackType.View) {
        category_id(required: true,  description: "Home's category")
        category_path(required: true, description: "Category path of this category home")
        last_modified(required: false, description: "Date of last modification")
    }

    // Real estate page view
    "/home/category/real-estate"(platform: "/", type: TrackType.View) {
        filters(required: false, description: "Filter applied in the last search")
        carousels(required: false, description: "Carousels in the home page to the properties")
    }

    // Motors page view
    "/home/category/motors"(platform: "/", type: TrackType.View) {}

    "/home/navigation"(platform: "/", type: TrackType.View) {}

    // Motors popup view
    "/home/category/motors/popup_meli"(platform: "/", type: TrackType.View, parentPropertiesInherited:false) {}
    "/home/category/motors/popup_meli/accept"(platform: "/", type: TrackType.Event) {}
    "/home/category/motors/popup_meli/deny"(platform: "/", type: TrackType.Event) {}

     // RealEstate Portal Inmobiliario Sections
    "/home/category/real_estate"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/bookmarks"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/bookmarks/recommendation"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/help"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/tyc"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/about"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/pricing"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/pricing/fsbo"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/pricing/professional"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/pricing/development"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/property"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/property/recommendation"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/development"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/development/recommendation"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/landing"(platform: "/", type: TrackType.View){
       id(required: true, type:PropertyType.String, description: "Landing's id" )
    }

    "/home/category/real_estate/navigation"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/navigation/recommendation"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/map"(platform: "/", type: TrackType.View) {}

    "/home/category/real_estate/official_store"(platform: "/", isAbstract: true) {}

    "/home/category/real_estate/official_store/developer"(platform: "/", isAbstract: true) {}

    "/home/category/real_estate/official_store/developer/action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        official_store_name(required: true, type:PropertyType.String, description: "Official store name" )
        official_store_id(required: true, type:PropertyType.Numeric, description: "Official store id" )
    }

    "/home/category/real_estate/official_store/developer/print"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        official_store_name(required: true, type:PropertyType.String, description: "Official store name" )
        official_store_id(required: true, type:PropertyType.Numeric, description: "Official store id" )
    }

    "/home/category/real_estate/official_store/developer/all_brands"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){}

    "/home/category/real_estate/official_store/realtor"(platform: "/", isAbstract: true) {}

    "/home/category/real_estate/official_store/realtor/action"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        official_store_name(required: true, type:PropertyType.String, description: "Official store name" )
        official_store_id(required: true, type:PropertyType.Numeric, description: "Official store id" )
    }

    "/home/category/real_estate/official_store/realtor/print"(platform: "/", type: TrackType.View, parentPropertiesInherited: false) {
        official_store_name(required: true, type:PropertyType.String, description: "Official store name" )
        official_store_id(required: true, type:PropertyType.Numeric, description: "Official store id" )
    }

    "/home/category/real_estate/official_store/realtor/all_brands"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){}

    // Apparel
    "/home/category/apparel"(platform: "/", isAbstract: true) {
        gender(required: true, type: PropertyType.String, values: ["male", "female", "boys", "girls", "none"])
    }

    "/home/category/apparel"(platform: "/", type: TrackType.View) {}
    "/home/category/apparel/stores"(platform: "/", type: TrackType.View) {}

    "/home/category/apparel/tabs"(platform: "/", type: TrackType.Event) {}

    "/home/category/apparel/slider"(platform: "/", type: TrackType.Event) {
        link(required: true, type: PropertyType.String)
        title(type: PropertyType.String)
    }

    "/home/category/apparel/category"(platform: "/", type: TrackType.Event) {
        category_id(required: true, type: PropertyType.String)
        link(required: true, type: PropertyType.String)
    }

    "/home/category/apparel/more_categories"(platform: "/", type: TrackType.Event) {}

    "/home/category/apparel/official_store"(platform: "/", type: TrackType.Event) {
        link(required: true, type: PropertyType.String)
        context(required: true, type: PropertyType.String, values: ["home", "stores"])
    }

    "/home/category/apparel/items"(platform: "/", type: TrackType.Event) {
        item_id(required: true, type: PropertyType.String)
        section(required: true, type: PropertyType.String)
    }

    "/home/category/apparel/images"(platform: "/", type: TrackType.Event) {
        image(required: true, type: PropertyType.String)
        link(required: true, type: PropertyType.String)
    }

    // Supermarket
    "/home/supermarket"(platform: "/", type: TrackType.View) {}

    //Server Side
    "/backend"(platform: "/", type: TrackType.Event, isAbstract : true) {}

    "/backend/home"(platform: "/", type: TrackType.Event) {
        component_count(required: true, type: PropertyType.Numeric)
        newbie(required: true, type: PropertyType.Boolean)
        home_version(required: true, type: PropertyType.String)
        is_logged(required: true, type: PropertyType.Boolean)
    }

    "/korriban"(platform:"/", type: TrackType.Event){
        component_count(required: true, type: PropertyType.Numeric)
    }

    "/home/backend"(platform: "/", type: TrackType.Event, isAbstract : true) {}

    "/home/backend/take_over"(platform: "/web", type: TrackType.Event) {}

    "/home_com"(platform: "/", type: TrackType.View) {}

    "/home_com/site_click"(platform: "/", type: TrackType.Event) {
        site_click(required: true, type: PropertyType.String)
    }

    "/home/category/real_estate/request_contract"(platform: "/", type: TrackType.View) {}

    "/home/advertising"(platform: "/", type: TrackType.Event) {}

    "/home/advertising/billboard"(platform: "/", type: TrackType.Event) {}

    "/home/motors"(platform: "/web/mobile", type: TrackType.Event, isAbstract : true) {}

    "/home/motors/sell"(platform: "/web/mobile", type: TrackType.Event) {}

    "/home/social"(platform: "/", type: TrackType.Event) {
        social_network(type: PropertyType.String, required: true, description: "Social network")
    }

}
