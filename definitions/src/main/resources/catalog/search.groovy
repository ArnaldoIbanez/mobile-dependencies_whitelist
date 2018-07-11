import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    def categoryRegex = /(ROOT|[a-zA-Z]{1,3}[0-9]+)/
    def categoryPathRegex = /\[([a-zA-Z]{1,3}[0-9]+(, )?)*\]/


    //SEARCH FLOW

    "/search"(platform: "/") {
        query(required: false, description: "the words used to make a search", type: PropertyType.String)
        limit(required: true, description: "the max number of items returned", type: PropertyType.Numeric)
        offset(required: true, description: "the number of items skipped on the search", type: PropertyType.Numeric)
        total(required: true, description: "amount of search items returned", type: PropertyType.Numeric)
        category_id(required: false, regex: categoryRegex)
        category_path(required: false, description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList)
        sort_id(required: true, description: "relevance, price_asc or price_desc", values: ["relevance", "price_asc", "price_desc"])
        filters(required: true, description: "filters applied")
        autoselected_filters(required: false, description: "filters not applied by the user (category from canonical or adults)", PropertyType.ArrayList) //todo hablar con laura para ver si se pueden sacar
        view_mode(required: true, description: "MOSAIC, LIST or GALLERY on WM and apps and STACK or GRID on desktop", values:["STACK","GRID","LIST","MOSAIC","GALLERY"])
        results(required: true, description: "item ids from search result", PropertyType.ArrayList)

        billboards(required: false, description: "items ids from billboard results", PropertyType.ArrayList)
        pads(required: false, description: "item_id from the pads returned for listings")
        catalog_product_id(required: false, description: "Id of the product, only if the product header is showna", PropertyType.String)

        //Tracks from Search Backend:
        backend_data(required: false)
        official_stores_carousel_shown(required: false, description: 'which TOs are in the carousel', PropertyType.ArrayList)
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
        only_in_type(required: false)
        click_banner(required: false, description:'Indicates that this listing has apppeared after clicking on a banner')
        banner(required: false, description:'Banner showed in this listing info, if showed')
        related_searches(required: false, description:'indicates whether clicked search related') // TODO, change to anchor
        related_searches_info(required: false, description: 'Tracks related searches coverage')
        canonical(required: false, description: 'url: canonical URL for the request; no_follow_tag: if the link rel="canonical" has no follow parameter; if the canonical URL has a mirror category configured') // TODO: Lo mantenemos
        autosuggest(required: false, description:'indicates whether clicked autosuggest') // TODO, move to anchor
        landing(required:false, description:'indicates landing base, premium, etc', values: ["base","premium","offical_store","deal"])
        upper_funnel(required: false, description: 'indicates if advertising query was considered upper funnel')
        geolocation(required: false, description:'geolocation')
        layout_forced(required: false, description:'true if layout is changed by the user')
        shown_as_product(required: false, description: 'item ids shown with product link')
        has_logos(required: false, description: "indicates if there is an item with logos", PropertyType.Boolean)
        promise_items(required: false, description:  "items with shipping promise", PropertyType.ArrayList)
    }

    "/search"(platform: "/mobile") {
        //limit y offset parecen ser las unicas que no se cambian
        //limit(required: true, description: "the max number of items returned", type: PropertyType.Numeric)
        //offset(required: true, description: "the number of items skipped on the search", type: PropertyType.Numeric)
        /*total(required: false, description: "override required property")
        sort_id(required: false, description: "override required property")
        filters(required: false, description: "override required property")
        view_mode(required: false, description: "override required property")
        results(required: false, description: "override required property")
        billboards(required: false, description: "override required property")
        pads(required: false, description: "override required property") //esto estaba solo para web antes*/

        breadcrumb_refined(required: false, description: 'if user used breadcrumb to refine their search',PropertyType.Boolean)
        error_message(required: false, PropertyType.String) // TODO: no podemos remover?

        //todo remover estas cosas que son de apps viejas
        sort(required: false)
        sort_id(required: false)

    }

    "/search/failure"(platform: "/mobile", type: TrackType.Event) {
        error_message()
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
        filters(required: false, description: "override required property")
        billboards(required: false, description: "override required property")
    }

    "/search/long_press" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        item_id()
    }

    "/search/share" (platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false){
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

    "/search/official_stores_carousel"(platform: "/", isAbstract: true) {}

    "/search/official_stores_carousel/click"(platform: "/", type: TrackType.Event) {
        to_name(required: true, description: 'the name of the official store selected', PropertyType.String)
        to_position(required: true, description: 'the position of the official store in the carousel', PropertyType.Numeric)
    }

    "/search/official_stores_carousel"(platform: "/", isAbstract: true) {}

    "/search/official_stores_carousel/click"(platform: "/", type: TrackType.Event) {
        to_name(required: true, description: 'the name of the official store selected', PropertyType.String)
        to_position(required: true, description: 'the position of the official store in the carousel', PropertyType.Numeric)
    }

    "/search/input"(platform: "/mobile", parentPropertiesInherited: false) {

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

    "/search/golocal"(platform: "/") {}

    "/search/save"(platform: "/", type: TrackType.Event) {
    }

}