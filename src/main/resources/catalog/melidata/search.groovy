package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1171"

    //def categoryRegex = /(ROOT|[a-zA-Z]{1,3}[0-9]+)/
    //def categoryPathRegex = /\[([a-zA-Z]{1,3}[0-9]+(, )?)*\]/
    //todo dejar los originales en septiembre
    def categoryRegex = /(\S*)/
    def categoryPathRegex = /\[(\S*(, )?)*\]/

    def seo_item_definition = objectSchemaDefinitions {
        is_whitelisted(type: PropertyType.Boolean, required: true)
        check_mode(type: PropertyType.ArrayList(PropertyType.String), required: true)
        gmv_value(type: PropertyType.ArrayList(PropertyType.Numeric), required: true)
        vip_clicks(type: PropertyType.ArrayList(PropertyType.Numeric), required: true)
        is_on_seo_whitelist_experiment(type: PropertyType.Boolean, required: true)
    }

    def location_info_definition = objectSchemaDefinitions {
        zipcode(type: PropertyType.String, required: false, description: "zipcode of the user; can be missing if user is not logged or never registered an address")
        default_zipcode(type: PropertyType.Boolean, required: false, description: "indicates if the zipcode was assumed; this happens in MLA when no zipcode is found for the user. The default is 1430")
        city_id(type: PropertyType.String, required: false, description: "as MLB has too many zipcode, we translate the zipcode to the city of the user's address")
        user_zone(required: false, description: "the user zone registered", type: PropertyType.String)
    }

    def sparkle_info_object = objectSchemaDefinitions {
        intervention_id(type: PropertyType.String, required: true)
        intervention_type(type: PropertyType.String, required: true, values: ["REDIRECT", "INLINE"])
        config_value(type: PropertyType.String, required: true)
        url(type: PropertyType.String, required: true)
    }

    def category_definition = objectSchemaDefinitions {
        carousel_id(type: PropertyType.String, required: true)
        selected(type: PropertyType.Map(selected_definition), required: false)
    }

    def selected_definition = objectSchemaDefinitions {
        name(required:true, PropertyType.String)
        selected_id(required:true, PropertyType.String)
    }

    def action_definition = objectSchemaDefinitions {
        action_id(type: PropertyType.String, required: true)
        filter_id(type: PropertyType.String, required: true)
    }

    def promise_item_definition = objectSchemaDefinitions{
        sameday(type: PropertyType.ArrayList(PropertyType.String), required: false)
        nextday(type: PropertyType.ArrayList(PropertyType.String), required: false)
    }

    //SEARCH FLOW
    
    "/search"(platform: "/") {
        query(required: false, description: "the words used to make a search", type: PropertyType.String)
        limit(required: true, description: "the max number of items returned", type: PropertyType.Numeric)
        offset(required: true, description: "the number of items skipped on the search", type: PropertyType.Numeric)
        total(required: true, description: "amount of search items returned", type: PropertyType.Numeric)
        category_id(required: false, regex: categoryRegex)
        category_path(required: false, description: "path from root category", regex: categoryPathRegex, type: PropertyType.ArrayList)
        sort_id(required: true, description: "relevance, price_asc, price_desc, publication_begins_desc, publication_begins_asc, manually_selected", values: ["relevance", "price_asc", "price_desc", "publication_begins_desc", "manually_selected", "publication_begins_asc"])
        filters(required: true, description: "filters applied")
        autoselected_filters(required: false, description: "filters not applied by the user (category from canonical or adults)", PropertyType.ArrayList)
        view_mode(required: true, description: "MOSAIC, LIST or GALLERY on WM and apps and STACK or GRID on desktop", values:["STACK","GRID","LIST","MOSAIC","GALLERY"])
        results(required: true, description: "item ids from search result", PropertyType.ArrayList)
        promise_items(required: false, description:  "items with shipping promise", type: PropertyType.Map(promise_item_definition))

        billboards(required: false, description: "items ids from billboard results", PropertyType.ArrayList)
        pads(required: false, description: "item_id from the pads returned for listings")
        pads_info(required: false, description: "Info from the pads returned for listings")
        catalog_product_id(required: false, description: "Id of the product, only if the product header is showna", PropertyType.String)
        show_supermarket_carousel(required: false, description: "search with supermarket carousel", type: PropertyType.Boolean)
        show_apparel_carousel(required: false, description: "search with apparel carousel", type: PropertyType.Boolean)
        tracking_id(required: false, description: "UUID for each page print", PropertyType.String)
        sparkle_info(required: false, description: 'sparkle tracking info', type: PropertyType.Map(sparkle_info_object))


        //Tracks from Search Backend:
        backend_data(required: false)
        official_stores_carousel_shown(required: false, description: 'which TOs are in the carousel', PropertyType.ArrayList)
        items_with_logos(required: false, description: 'items ids that show the brand logo', PropertyType.ArrayList)
        pdp_grouped_search(required: false, description: 'indicates whether the product rows are result of grouping or not', PropertyType.Boolean)
        pdp_info(required: false, description: "info about status and scoring of the product offered by search backend", type: PropertyType.ArrayList)
        promoted_items(required: false, description: 'ids of offer of the day items', type: PropertyType.ArrayList(PropertyType.String))
        location_info(required: false, description: "contains info about the users, for example, shipping info", type: PropertyType.Map(location_info_definition))
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
        related_searches(required: false, description:'indicates whether clicked search related')
        related_searches_info(required: false, description: 'Tracks related searches coverage')
        canonical(required: false, description: 'url: canonical URL for the request; no_follow_tag: if the link rel="canonical" has no follow parameter; if the canonical URL has a mirror category configured')
        autosuggest(required: false, description:'indicates whether clicked autosuggest')
        landing(required:false, description:'indicates landing base, premium, etc', values: ["base","premium","official_store","deal", "cpg","officialStore","marketplace"])
        upper_funnel(required: false, description: 'indicates if advertising query was considered upper funnel')
        geolocation(required: false, description:'geolocation')
        layout_forced(required: false, description:'true if layout is changed by the user')
        shown_as_product(required: false, description: 'item ids shown with product link')
        has_logos(required: false, description: "indicates if there is an item with logos", PropertyType.Boolean)
        geo_search(required: false, description: "search with geolocation", type: PropertyType.Boolean)
        available_filters(required: true, description: "available filters, sameday and nextday")
        user_zone(required: true, description: "the user zone registered", type: PropertyType.String)
        is_googlebot(required: false, description: 'is google bot request', PropertyType.Boolean)
        pdp_rows(required: true, description: 'lists the pdp rows added to the results', type: PropertyType.ArrayList)
        carousel_filters(required: true, description: 'carousel filter ids shown in search', PropertyType.ArrayList)
        pdp_highlight_enabled(required: true, description: 'tracks if we are highlighting PDP rows to the user', PropertyType.Boolean)
        seo(required: true, description: 'seo tracking info', type: PropertyType.Map(seo_item_definition))
        user_profile_type(required: true, values: ['SELLER', 'BUYER', 'UNDEFINED'], description: 'profile type for the current user', type: PropertyType.String)
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
        geo_search(required: false, description: "search with geolocation", type: PropertyType.String)
        filter_tags(required: false, description: "these are tags that aren't very important", type: PropertyType.String)
        breadcrumb_refined(required: false, description: 'if user used breadcrumb to refine their search',PropertyType.Boolean)
        error_message(required: false, PropertyType.String)

        //todo remover estas cosas que son de apps viejas
        sort(required: false)
        sort_id(required: false)
        view_mode(required: false)
        layout(required: false)
        context(required: false)
        filters(required: false)
        results(required: false)
        billboard_shown(required: false)
        available_filters(required: false, description: "available filters, sameday and nextday")
        user_zone(required: false, description: "the user zone registered", type: PropertyType.String)
        pdp_rows(required: false, description: 'lists the pdp rows added to the results', type: PropertyType.ArrayList)
        carousel_filters(required: false, description: 'carousel filter ids shown in search', PropertyType.ArrayList)
        carousel_categories_shown(required: false, description: 'category carousel is shown when user makes a search', PropertyType.Boolean)
    }

    "/search/failure"(platform: "/mobile", type: TrackType.Event) {
        error_message()
        limit(required: false, description: "override required property")
        offset(required: false, description: "override required property")
        total(required: false, description: "override required property")
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

    "/search/filters/action"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false) {
        multiple_values_qty(required: false, description: 'qty of multiple values selected before the request is made', PropertyType.Numeric)
        action(required: false, description: 'the action made, if any', PropertyType.Map(action_definition))
    }
    
    "/search/breadcrumb"(platform: "/mobile", isAbstract: true) {}
    
    "/search/breadcrumb/open"(platform: "/mobile", type: TrackType.Event) {
        limit(required: false, description: "the max number of items returned", type: PropertyType.Numeric)
        offset(required: false, description: "the number of items skipped on the search", type: PropertyType.Numeric)
        total(required: false, description: "amount of search items returned", type: PropertyType.Numeric)
    }
    
    "/search/breadcrumb/apply"(platform: "/mobile", type: TrackType.Event) {
        filter_id()
        limit(required: false, description: "the max number of items returned", type: PropertyType.Numeric)
        offset(required: false, description: "the number of items skipped on the search", type: PropertyType.Numeric)
        total(required: false, description: "amount of search items returned", type: PropertyType.Numeric)
    }

    "/search/filters_carousel"(platform: "/web", isAbstract: true) {}
    "/search/filters_carousel/click"(platform: "/web", type: TrackType.Event) {
        filter_name(required: true, description: "the name of the filter", type: PropertyType.String)
        position(required: true, description: "the position of the filter in the carousel", type: PropertyType.Numeric)
        filter(required: false, description: "carousel filter id", type: PropertyType.String)
    }

    "/search/color_picker"(platform: "/web") {
        
        item_id(required: true, description: "the item id shown for the product", type: PropertyType.String)
        previous_product_id(required: true, "the product shown before using the picker", type: PropertyType.String)
        product_id(required: true, description: "the product shown after using the picker", type: PropertyType.String)
    }

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

    "/search/change_view"(platform: "/",  isAbstract: true) {}
    
    "/search/change_view/apply"(platform: "/", type: TrackType.Event) {
        list_mode()
    }

    "/search/official_stores_carousel"(platform: "/", isAbstract: true) {}

    "/search/official_stores_carousel/click"(platform: "/", type: TrackType.Event) {
        to_name(required: true, description: 'the name of the official store selected', PropertyType.String)
        to_position(required: true, description: 'the position of the official store in the carousel', PropertyType.Numeric)
    }

    "/search/input"(platform: "/mobile", parentPropertiesInherited: false) {

    }

    "/search/category_carousel"(platform: "/mobile", type: TrackType.Event, parentPropertiesInherited: false){
        carousels(required:true, PropertyType.ArrayList(PropertyType.Map(category_definition)))
    }

    "/search/input/back"(platform: "/mobile") {}

    "/search/promoted_items/"(platform: "/web", isAbstract: true) {}

    "/search/promoted_items/show"(platform: "/web", type: TrackType.View) {
        item_type(required: true, values: ["properties", "projects"])
    }

    "/search/billboard"(platform: "/", type: TrackType.Event) {
        item_id(required: false, type: PropertyType.String)
        is_new_billboard(required: false, type: PropertyType.Boolean)
        position_shown(required: false, type: PropertyType.Numeric)
        move(required: false, values: ["forward","backward"])
    }

    "/search/billboard/click"(platform: "/", type: TrackType.Event){
        item_id(required: false, type: PropertyType.String)
        is_new_billboard(required: false, type: PropertyType.Boolean)
        position(required: true, description: "the position of the selected billboard in the carousel", type: PropertyType.Numeric)
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

    "/search/category_recommendations"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false){
        item_id(required: true, description: "the item for which the recommendations are shown", type: PropertyType.String)
        category_id(required: true, description: "the item category_id", type: PropertyType.String)
        category_path(required: true, description: "the path from root of the category_ud", type: PropertyType.ArrayList)
        recommended_categories(required: true, description: "the recommended categories for the item", type: PropertyType.ArrayList)
    }

    "/search/finite_navigation"(platform: "/mobile/android", type: TrackType.Control, parentPropertiesInherited:false) {
    }
    "/search/finite_navigation_os_filter"(platform: "/mobile/android", type: TrackType.Control, parentPropertiesInherited:false) {
    }

    "/search/banner"(platform: "/web", isAbstract: true){}

    "/search/banner/click"(platform: "/web", type: TrackType.Event){
    }

    "/search/sparkle"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        query(required: true, description: "the words used to make a search", type: PropertyType.String)
        sparkle_info(required: true, description: 'sparkle tracking info', type: PropertyType.Map(sparkle_info_object))
    }

}
