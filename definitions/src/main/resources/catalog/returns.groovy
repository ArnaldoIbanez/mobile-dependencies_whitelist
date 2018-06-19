import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      category_id(required: false, type: PropertyType.String, description: 'category identifier')
      officialstore(required: false, type: PropertyType.String, description: 'official store identifier')
      item_id(required: false, type: PropertyType.String, description: 'item identifier')
      action(required: false, type: PropertyType.String, description: 'action of the event')
      loyalty_level(required: false, type: PropertyType.Numeric, description: 'buyer level loyalty')
      date_delivered(required: false, type: PropertyType.String, description: 'date of order shipment')
      cart_order(required: false, type: PropertyType.Boolean, description: 'order created by cart')
      item_category(required: false, type: PropertyType.String, description: 'category of item')
      item_category_l1(required: false, type: PropertyType.String, description: 'main category of item')
      refund_account_money(required: false, type: PropertyType.Boolean, description: 'refound money in the buyers account')
      ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
      buyer_scoring(required: false, type: PropertyType.String, description: 'buyer reputation level')
      seller_scoring(required: false, type: PropertyType.String, description: 'seller reputation level')
      showed_payment_methods(required: false, type: PropertyType.String, description: 'origin of the payment method')
      order_id(required: false, type: PropertyType.Numeric, description: 'order identifier')
      category_path(required: false, type: PropertyType.ArrayList, description: 'list of categories')
      order_delayed_by_seller(required: false, type: PropertyType.Boolean, description: 'order delayed by seller')
    }

    // STEP 01
    "/return/typifications"(platform: "/", type: TrackType.View) { }
    "/return/typifications"(platform: "/", type: TrackType.Event) {
      typification(required: false, type: PropertyType.String, description: 'reason why the product is returned')
    }

    // STEP 02
    "/return/conditions"(platform: "/", type: TrackType.View) { }
    "/return/conditions"(platform: "/", type: TrackType.Event) {
        action(required: false, values:['selection'], type: PropertyType.String, description: 'action of the event')
        selection(required: false, values:['accepted', 'rejected'], type: PropertyType.String, description: 'selected option button')
    }

    // STEP 03
    "/return/payments"(platform: "/", type: TrackType.View) { }
    "/return/payments"(platform: "/", type: TrackType.Event) {
      payment(required: false, type: PropertyType.String, description: 'origin of payment')
      continue_button(required: false, type: PropertyType.Boolean, description: 'origin from the continue button')
    }

    // STEP 04
    "/return/shipping"(platform: "/", type: TrackType.View) { }
    "/return/shipping"(platform: "/", type: TrackType.Event) {
      shipping(required: false, type: PropertyType.String, description: 'shipping status')
    }

    // STEP 05.a
    "/return/pickup"(platform: "/", type: TrackType.View) { }
    "/return/pickup"(platform: "/", type: TrackType.Event) {
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
    }

    // STEP 05.b
    "/return/delivery"(platform: "/", type: TrackType.View) { }

    // STEP 05.c
    "/return/review"(platform: "/", type: TrackType.View) { }
    "/return/review"(platform: "/", type: TrackType.Event) {
      continue_button(required: false, type: PropertyType.Boolean, description: 'origin from the continue button')
      type(required: false, type: PropertyType.String, description: 'generate return label')
    }

    // STEP 06
    "/return/congrats"(platform: "/", type: TrackType.View) {
      typification(required: false, type: PropertyType.String, description: 'reason why the product is returned')
      payment(required: false, type: PropertyType.String, description: 'origin of payment')
      shipping(required: false, type: PropertyType.String, description: 'shipping status')
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
    }

    // STEP 06.cta.a
    "/return/congrats/print_label"(platform: "/", type: TrackType.Event) {
        print_url(required: false, type: PropertyType.String, description: 'Address to print return label')
    }

    // STEP 06.cta.b
    "/return/congrats/remedy_label"(platform: "/", type: TrackType.Event) { }

    "/return/modal"(platform: "/", type: TrackType.Event) {
      action(required: false, type: PropertyType.String, description: 'event that launched the modal')
      id(required: false, type: PropertyType.String, description: 'item identifier')
      modal_data(required: false, type: PropertyType.Map, description: 'internal data of the modal')
    }

    "/return/external"(platform: "/", type: TrackType.View) {
        id(required: false, type: PropertyType.String, description: 'name of the page to redirect')
        data(required: false, type: PropertyType.Map, description: 'context information to send')
    }
    "/return/external"(platform: "/", type: TrackType.Event) {
        id(required: false, type: PropertyType.String, description: 'name of the page to redirect')
        data(required: false, type: PropertyType.Map, description: 'context information to send')
    }

    "/return/error"(platform: "/", type: TrackType.View) {
      previous_step(required: false, type: PropertyType.String, description: 'step before the error')
    }
}
