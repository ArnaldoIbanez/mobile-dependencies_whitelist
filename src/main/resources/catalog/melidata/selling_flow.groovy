import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
* Selling-flow tracks
*/
tracks {

    initiative = "1348"

    '/selling-flow'(platform: '/', isAbstract: true) { }
    '/selling-flow/catalog'(platform: '/', isAbstract: true) { }
    
    // CATALOG
    '/selling-flow/catalog/start'(platform: '/', type: TrackType.View) {
        flow_id: (required: true, type: PropertyType.String, description: 'Flow id')
        empty_state: (required: true, type: PropertyType.Boolean, description: 'Show empty state')
    }

    // PRODUCTS
    '/selling-flow/catalog/add_product'(platform: '/', type: TrackType.Event) {}
    '/selling-flow/catalog/edit_products'(platform: '/', type: TrackType.Event) {}

    // SEARCH
    '/selling-flow/catalog/search'(platform: '/', type: TrackType.Event) {}
    '/selling-flow/catalog/exit_search'(platform: '/', type: TrackType.Event) {}

    // ITEMS
    '/selling-flow/catalog/select_section'(platform: '/', type: TrackType.Event) {}
    '/selling-flow/catalog/select_item'(platform: '/', type: TrackType.Event) {}
    '/selling-flow/catalog/deselect_item'(platform: '/', type: TrackType.Event) {}
    '/selling-flow/catalog/continue_flow'(platform: '/', type: TrackType.Event) {}

}
