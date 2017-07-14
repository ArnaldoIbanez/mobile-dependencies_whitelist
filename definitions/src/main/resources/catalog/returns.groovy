import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
    }

    "/return/typification"(platform:"/", type: TrackType.View)  {
    }

    "/return/money_refund"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
    }

    "/return/pick_up_option"(platform:"/", type: TrackType.View) {
      money_refund(required:false, type:PropertyType.String)
    }

    "/return/collection"(platform:"/", type: TrackType.View) {
      pickup_option(required:false, type:PropertyType.String)
    }

    "/return/carrier"(platform:"/", type: TrackType.View) {
      pickup_option(required:false, type:PropertyType.String)
    }

    "/return/congrats"(platform:"/", type: TrackType.View) {
      pickup_option(required:false, type:PropertyType.String)
      pickup_time(required:false, type:PropertyType.String)
      carrier_id(required:false, type:PropertyType.String)
    }

    "/return/congrats/print_label"(platform:"/", type: TrackType.Event) {
        print_url(required:true, type:PropertyType.String)
    }

    "/return/congrats/remedy_label"(platform:"/", type: TrackType.Event) {
    }
}
