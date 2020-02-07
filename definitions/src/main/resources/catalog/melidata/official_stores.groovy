import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1063"

    "/official_stores"(platform: "/web", isAbstract: true) {}

    "/official_stores/home"(platform: "/web", type: TrackType.View) {
        from(required: false,  description: "Who is redirecting")
    }
    "/official_stores/landing"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
        exit_to_store(type: PropertyType.Boolean, required: false,  description: "Is true only if you continue searching in a OS")
    }
    "/official_stores/checkon"(platform: "/web", type: TrackType.View) {
        is_tool_tip_present(type: PropertyType.Boolean, required: false,  description: "Is true only if the tooltip si displayed")
        uncheck(type: PropertyType.Boolean, required: false,  description: "Is true only if the check is Unchecked")
    }
    "/official_stores/fewItemsPage"(platform: "/web", type: TrackType.View) {
        store(required: false,  description: "Store in the search")
        query(required: false,  description: "Query item looking for")
    }
    "/official_stores/zrp"(platform: "/web", type: TrackType.View) {
        in_store(type: PropertyType.Boolean, required: false,  description: "If the zrp is rendered, and experiment redirects inside the sotre or outside")
        use_link(type: PropertyType.Boolean, required: false,  description: "Is true if the zrp message link is used.")
        check_on_exp(type: PropertyType.Boolean, required: false,  description: "Is true if the checkon experiment mantains the checkon")
        checked(type: PropertyType.Boolean, required: false,  description: "Is true only if the checkon is checked")
        exit_to_store(type: PropertyType.Boolean, required: false,  description: "Is true only if you continue searching in a OS")
    }

    /**
     * OFFICIAL STORES LISTING
     **/
    "/official_stores/"(platform: "/mobile", isAbstract: true) {}

    "/official_stores/search/"(platform: "/mobile", type: TrackType.View) {}

    "/official_stores/search/open"(platform: "/mobile", type: TrackType.Event) {
        query(required: true, description: "Official store name written in search box")
        official_store_id(required: true, description: "Official store id")
        official_store_name(required: true, description: "Official store id")
    }

    "/official_stores/search/abort"(platform: "/mobile", type: TrackType.Event) {
        query(required: false, description: "Official store name written in search box")
    }

    "/official_stores/search/back"(platform: "/mobile", type: TrackType.Event) {
        query(required: false, description: "Official store name written in search box")
    }
}