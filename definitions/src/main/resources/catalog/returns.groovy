import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/returns"(platform: "/", isAbstract: true) {
    }

    "/returns/typification"(platform:"/", type: TrackType.View)  {
    }

    "/returns/money_refund"(platform:"/", type: TrackType.View) {
    }

    "/returns/pick_up_option"(platform:"/", type: TrackType.View) {
    }

    "/returns/collection_step"(platform:"/", type: TrackType.View) {
    }

    "/returns/carrier_step"(platform:"/", type: TrackType.View) {
    }

    "/returns/congrats"(platform:"/", type: TrackType.View) {
    }

    "/returns/congrats/print_label"(platform:"/", type: TrackType.Event) {
        print_url(required:true, type:PropertyType.String)
    }
}
