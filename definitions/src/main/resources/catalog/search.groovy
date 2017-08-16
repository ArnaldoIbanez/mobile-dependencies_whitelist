import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    def categoryRegex = /(ROOT|[a-zA-Z]{1,3}[0-9]+)/
    def categoryPathRegex = /\[([a-zA-Z]{1,3}[0-9]+(, )?)*\]/


    //SEARCH FLOW

    "/search"(platform: "/") {
        query(required: false)
        limit(type: PropertyType.Numeric)
        offset(type: PropertyType.Numeric)
        total(description: "amount of search items returned", type: PropertyType.Numeric, required: false)
        category_id(regex: categoryRegex, required: false)
        category_path(description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList, required: false)
        sort_id(required: false)
        filters(required: false)
        autoselected_filters(required: false, PropertyType.ArrayList)
        view_mode(required: false, description: "MOSAIC, LIST or GALLERY")
        filter_user_applied(deprecated: true, required: false)
        tienda_oficial(deprecated: true, required: false)
        official_store_id(deprecated: true, required: false)
        deal(deprecated: true, required: false)
        filter_tags(required: false, PropertyType.ArrayList)
        results(required: false, PropertyType.ArrayList,description:"item ids from search result")
        billboards(required: false, PropertyType.ArrayList, descriptoion: "items ids from billboard results")
        isRetina(required: false, description: 'Whether the screen is retina display')
        //Tracks from Search Backend:
        backend_data(required: false)
        catalog_product_id(required: false, description: 'Id of the product, only if the product header is shown')
            //ab(required: false, description:'ab testing related. to be deprecated')
            //ab_bucket(required: false, PropertyType.ArrayList, description:'ab testing related. to be doprecated')
            //aa(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Comblinable')
            //ac(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Not Comblinable')
            //ap(required: false, PropertyType.ArrayList, description:'applied search algorithim tag. Combinable with other pages')
            //fsm(required: false, description:'indicates on each result of paged if its full or soft match')
            //qas(required: false, PropertyType.ArrayList, description:'auto selected filters')
            //canonical(required: false, description:'url canonical')
            //cli_rel_qty_configured(required: false, description:'client relationship')
            //cli_rel_qty_link_to_category(required: false, description:'client relationship link to category')
            //corrections(required: false, description:'corrections over query')
            //processed_query(required: false, description:'processed query by backend')
            //stems(required: false, description:'stems list which returns backend to stand out in frontend'
    }

    "/search"(platform: "/web") {
        visual_id(required: false)
        config_version(required: false)
        filters(required: false)
        only_in_type(required: false)
        click_banner(required: false, description:'Indicates that this listing has apppeared after clicking on a banner')
        // exhibitors_id
        banner(required: false, description:'Banner showed in this listing info, if showed')
        //deal_id
        // exhibitors_id
        related_searches(required: false, description:'indicates whether clicked search related')
        //query
        // position
        //quantity
        autosuggest(required: false, description:'indicates whether clicked autosuggest')
        //suggest_position
        //last_search_position
        //block_store_position
        landing(required:false, description:'indicates landing base, premium, etc')
        pads(required: false, description:'item_id from the pads returned for listings')
        layout(required: false, description:'layout of search')
        geolocation(required: false, description:'geolocation')
        landing(required: false, description:'landings: base, premium, etc')
        layout_forced(required: false, description:'true if layout is changed by the user')
        shown_as_product(required: false)
    }

    "/search"(platform: "/mobile") {
        filter_user_applied(deprecated: true, required: false)
        context(required: false)
        breadcrumb_refined(required: false, PropertyType.Boolean)
        billboard_shown(required: false, PropertyType.Boolean)
        error_message(required: false, PropertyType.String)
    }

    "/search/failure"(platform: "/mobile", type: TrackType.Event) {
        error_message()
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
    }

    "/search/long_press" (platform: "/mobile", type: TrackType.Event){
        item_id()
    }

    "/search/share" (platform: "/mobile", type: TrackType.Event){
        item_id()
    }

    "/search/back" (platform: "/mobile", type: TrackType.Event) {}

    "/search/abort"(platform: "/mobile", type: TrackType.Event) {
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
    }

    "/search/filters"(platform: "/mobile") {}

    "/search/refine"(platform: "/mobile") {}

    "/search/refine/apply"(platform: "/mobile", type: TrackType.Event) {}

    "/search/refine/back"(platform: "/mobile", type: TrackType.Event) {}

    "/search/refine/select_filter"(platform: "/mobile") {
        filter_id()
    }

    "/search/refine/select_filter/apply"(platform: "/mobile") {
        filter_value_id()
        filter_value_name()
    }

    "/search/change_view"(platform: "/mobile") {}

    "/search/change_view/apply"(platform: "/mobile", type: TrackType.Event) {
        list_mode()
    }

    "/search/input"(platform: "/mobile", parentPropertiesInherited: false) {
        //TODO. remove this when inhereted from / is solved
        mode(required: false)
        sent_again(required: false)
        from_background(required: false)
    }

    "/search/input/back"(platform: "/mobile") {}

    "/search/promoted_items/"(platform: "/web", isAbstract: true) {}

    "/search/promoted_items/show"(platform: "/web", type: TrackType.View) {
        item_type(required: true, values: ["properties", "projects"])
    }

    "/search/billboard"(platform: "/", type: TrackType.Event) {
        position_shown(required: false, type: PropertyType.Numeric)
        move(required: false, values: ["forward","backward"])
    }

    "/search/billboard/resize"(platform: "/web", type: TrackType.Event) {
        action(required: true, values: ["expand","collapse"])
    }

    "/search/carousel"(platform: "/web", type: TrackType.Event, parentPropertiesInherited: false) {
        carousel_used(required: true, values: ["next","prev","select"])
    }

    "/search/save"(platform: "/", type: TrackType.Event) {
    }

}
