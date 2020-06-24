package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    //HOME FLOW

    initiative = "1171"

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

    "/home/navigation_history"(platform: "/mobile"){

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
        from(required: false,  description: "Who is redirecting")
    }

    "/home/category"(platform: "/", type: TrackType.View) {
        category_id(required: true,  description: "Home's category")
        category_path(required: true, description: "Category path of this category home")
    }

    // Real estate page view
    "/home/category/real-estate"(platform: "/", type: TrackType.View) {
        filters(required: false, description: "Filter applied in the last search")
        carousels(required: false, description: "Carousels in the home page to the properties")
    }

    // Motors page view
    "/home/category/motors"(platform: "/", type: TrackType.View) {}

    "/home/navigation"(platform: "/", type: TrackType.View) {}

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
}
