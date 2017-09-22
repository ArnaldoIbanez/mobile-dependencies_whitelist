import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      category_l1(required: false, type: PropertyType.String)
      officialstore(required: false, type: PropertyType.String)
      item_id(required: false, type: PropertyType.String)
    }

    // STEP 01
    "/return/typifications"(platform:"/", type: TrackType.View) { }

    // STEP 02
    "/return/payments"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
    }

    // STEP 03
    "/return/shipping"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
      money_refund(required:false, type:PropertyType.String)
    }

    // STEP 04.a
    "/return/pickup"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
      money_refund(required:false, type:PropertyType.String)
      pickup_option(required:false, type:PropertyType.String)
    }

    // STEP 04.b
    "/return/delivery"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
      money_refund(required:false, type:PropertyType.String)
      pickup_option(required:false, type:PropertyType.String)
    }

    // STEP 05
    "/return/congrats"(platform:"/", type: TrackType.View) {
      typification(required:false, type:PropertyType.String)
      money_refund(required:false, type:PropertyType.String)
      pickup_option(required:false, type:PropertyType.String)
      pickup_time(required:false, type:PropertyType.String)
      carrier_id(required:false, type:PropertyType.String)
    }

    // STEP 05.cta.a
    "/return/congrats/print_label"(platform:"/", type: TrackType.Event) {
        print_url(required:true, type:PropertyType.String)
    }

    // STEP 05.cta.b
    "/return/congrats/remedy_label"(platform:"/", type: TrackType.Event) { }
}
