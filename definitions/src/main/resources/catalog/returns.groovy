import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      category_id(required: false, type: PropertyType.String)
      officialstore(required: false, type: PropertyType.String)
      item_id(required: false, type: PropertyType.String)
      action(required: false, type: PropertyType.String)
    }

    // STEP 01
    "/return/typifications"(platform: "/", type: TrackType.View) { }
    "/return/typifications"(platform: "/", type: TrackType.Event) {
      typification(required: true, type: PropertyType.String)
    }

    // STEP 02
    "/return/payments"(platform: "/", type: TrackType.View) { }
    "/return/payments"(platform: "/", type: TrackType.Event) {
      payment(required: true, type: PropertyType.String)
    }

    // STEP 03
    "/return/shipping"(platform: "/", type: TrackType.View) { }
    "/return/shipping"(platform: "/", type: TrackType.Event) {
      shipping(required: true, type: PropertyType.String)
    }

    // STEP 04.a
    "/return/pickup"(platform: "/", type: TrackType.View) { }
    "/return/pickup"(platform: "/", type: TrackType.Event) {
      pickup_time(required: true, type: PropertyType.String)
    }

    // STEP 04.b
    "/return/delivery"(platform: "/", type: TrackType.View) { }

    // STEP 05
    "/return/congrats"(platform: "/", type: TrackType.View) { 
      typification(required: false, type: PropertyType.String)
      payment(required: false, type: PropertyType.String)
      shipping(required: false, type: PropertyType.String)
      pickup_time(required: false, type: PropertyType.String)
    }

    // STEP 05.cta.a
    "/return/congrats/print_label"(platform: "/", type: TrackType.Event) {
        print_url(required: true, type: PropertyType.String)
    }

    // STEP 05.cta.b
    "/return/congrats/remedy_label"(platform: "/", type: TrackType.Event) { }

    "/return/modal"(platform: "/", type: TrackType.Event) {
      action(required: true, type: PropertyType.String)
      id(required: true, type: PropertyType.String)
      modal_data(required: false, type: PropertyType.Map)
    }
}
