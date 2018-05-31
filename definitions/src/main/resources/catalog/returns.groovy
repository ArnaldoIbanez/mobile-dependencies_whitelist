import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      category_id(required: false, type: PropertyType.String)
      officialstore(required: false, type: PropertyType.String)
      item_id(required: false, type: PropertyType.String)
      action(required: false, type: PropertyType.String)
      loyalty_level(required: false, type: PropertyType.Numeric)
      date_delivered(required: false, type: PropertyType.String)
      cart_order(required: false, type: PropertyType.Boolean)
      item_category(required: false, type: PropertyType.String)
      item_category_l1(required: false, type: PropertyType.String)
      refund_account_money(required: false, type: PropertyType.Boolean)
      ref(required: false, type: PropertyType.String)
      buyer_scoring(required: false, type: PropertyType.String)
      seller_scoring(required: false, type: PropertyType.String)
      showed_payment_methods(required: false, type: PropertyType.String)
      order_id(required: false, type: PropertyType.Numeric)
      showed_payment_methods(required: false, type: PropertyType.String)
      category_path(required: false, type: PropertyType.ArrayList)
    }

    // STEP 01
    "/return/typifications"(platform: "/", type: TrackType.View) { }
    "/return/typifications"(platform: "/", type: TrackType.Event) {
      typification(required: false, type: PropertyType.String)
    }

    // STEP 02
    "/return/conditions"(platform: "/", type: TrackType.View) { }
    "/return/conditions"(platform: "/", type: TrackType.Event) {
        action(required: false, type: PropertyType.String)
        selection(required: false, type: PropertyType.String)
    }

    // STEP 03
    "/return/payments"(platform: "/", type: TrackType.View) { }
    "/return/payments"(platform: "/", type: TrackType.Event) {
      payment(required: false, type: PropertyType.String)
      continueButton(required: false, type: PropertyType.Boolean)
    }

    // STEP 04
    "/return/shipping"(platform: "/", type: TrackType.View) { }
    "/return/shipping"(platform: "/", type: TrackType.Event) {
      shipping(required: false, type: PropertyType.String)
    }

    // STEP 05.a
    "/return/pickup"(platform: "/", type: TrackType.View) { }
    "/return/pickup"(platform: "/", type: TrackType.Event) {
      pickup_time(required: false, type: PropertyType.String)
    }

    // STEP 05.b
    "/return/delivery"(platform: "/", type: TrackType.View) { }

    // STEP 05.c
    "/return/review"(platform: "/", type: TrackType.View) { }
    "/return/review"(platform: "/", type: TrackType.Event) {
      continueButton(required: false, type: PropertyType.Boolean)
      type(required: false, type: PropertyType.String)
    }

    // STEP 06
    "/return/congrats"(platform: "/", type: TrackType.View) {
      typification(required: false, type: PropertyType.String)
      payment(required: false, type: PropertyType.String)
      shipping(required: false, type: PropertyType.String)
      pickup_time(required: false, type: PropertyType.String)
    }

    // STEP 06.cta.a
    "/return/congrats/print_label"(platform: "/", type: TrackType.Event) {
        print_url(required: false, type: PropertyType.String)
    }

    // STEP 06.cta.b
    "/return/congrats/remedy_label"(platform: "/", type: TrackType.Event) { }

    "/return/modal"(platform: "/", type: TrackType.Event) {
      action(required: false, type: PropertyType.String)
      id(required: false, type: PropertyType.String)
      modal_data(required: false, type: PropertyType.Map)
    }

    "/return/external"(platform: "/", type: TrackType.Event) {
      id(required: false, type: PropertyType.String)
      data(required: false, type: PropertyType.Map)
    }

    "/return/error"(platform: "/", type: TrackType.View) {
      previous_step(required: false, type: PropertyType.String)
    }
}
