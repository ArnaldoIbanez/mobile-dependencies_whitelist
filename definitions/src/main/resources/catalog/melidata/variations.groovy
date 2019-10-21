import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


/*
items Model:

{
    id: MLA123,
    attributes_variations: [{
                            label: color,
                            quantity_options: 5,
                            custom: false
                            }]
}
*/

tracks {

    "/variations"(platform: "/", isAbstract: true) {
        items(required: true, type: PropertyType.ArrayList, description: "id; attributes_variations:")
        context(required: true, type: PropertyType.String, values: ["vip_combo", "cart", "cart_saved_for_later"], description: "Client Info")
    }

    "/variations/edit"(platform: "/", type: TrackType.View) {
    }

    "/variations/select"(platform: "/", type: TrackType.Event) {
    }

    "/variations/cancel"(platform: "/", type: TrackType.Event) {
    }

    "/variations/cancel"(platform: "/web/desktop", type: TrackType.Event) {
        close_index(required: true, type: PropertyType.Numeric, description: "index of item when picker was closed")
    }
}
