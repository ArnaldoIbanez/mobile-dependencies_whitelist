import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
    }

    "/return/typification"(platform:"/", type: TrackType.View)  {
    }

    "/return/money_refund"(platform:"/", type: TrackType.View) {
    }

    "/return/pick_up_option"(platform:"/", type: TrackType.View) {
    }

    "/return/collection_step"(platform:"/", type: TrackType.View) {
    }

    "/return/carrier_step"(platform:"/", type: TrackType.View) {
    }

    "/return/congrats"(platform:"/", type: TrackType.View) {
    }

    "/return/congrats/print_label"(platform:"/", type: TrackType.Event) {
        print_url(required:true, type:PropertyType.String)
    }
}
