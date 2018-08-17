import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      loyalty_level(required: true, type: PropertyType.String, description: 'buyer level loyalty')
      order_id(required: true, type: PropertyType.String, description: 'order identifier')
      buyer_scoring(required: false, type: PropertyType.String, description: 'buyer reputation level')
      seller_scoring(required: false, type: PropertyType.String, description: 'seller reputation level')
      category_id(required: true, type: PropertyType.String, description: 'category identifier')
      category_id_l1(required: true, type: PropertyType.String, description: 'main category of item')
    }

    // STEP 01
    "/return/typifications"(platform: "/", type: TrackType.View) {
      ref(required: true, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }
    "/return/typifications/selection"(platform: "/", type: TrackType.Event) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
    }

    // STEP 02
    "/return/conditions"(platform: "/", type: TrackType.View) {
      ref(required: true, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }
    "/return/conditions/selection"(platform: "/", type: TrackType.Event) {
      selection(required: true, values:['accepted', 'rejected'], type: PropertyType.String, description: 'selected option button')
    }

    // STEP 03
    "/return/payments"(platform: "/", type: TrackType.View) {
      ref(required: true, type: PropertyType.String, description: 'reference of the beginning of the flow')
      showed_payment_methods(required: true, type: PropertyType.String, description: 'origin of the payment method')
    }
    "/return/payments/selection"(platform: "/", type: TrackType.Event) {
      payment(required: true, type: PropertyType.String, description: 'origin of payment')
    }

    // STEP 04
    "/return/shipping"(platform: "/", type: TrackType.View) { }
    "/return/shipping/selection"(platform: "/", type: TrackType.Event) {
      shipment_type(required: true, values:['delivery', 'pickup'], type: PropertyType.String, description: 'selected shipping type')
    }

    // STEP 05.a
    "/return/pickup"(platform: "/", type: TrackType.View) { }
    "/return/pickup/selection"(platform: "/", type: TrackType.Event) {
      pickup_time(required: true, type: PropertyType.String, description: 'pickup time product to seller')
    }

    // STEP 05.b
    "/return/delivery"(platform: "/", type: TrackType.View) { }

    // STEP 05.c
    "/return/review"(platform: "/", type: TrackType.View) { }
    "/return/review/selection"(platform: "/", type: TrackType.Event) {
      continue_button(required: true, type: PropertyType.Boolean, description: 'origin from the continue button')
      is_shipping_code(required: true, type: PropertyType.Boolean, description: 'generate return label')
    }

    // STEP 06
    "/return/congrats"(platform: "/", type: TrackType.View) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
      payment(required: true, type: PropertyType.String, description: 'origin of payment')
      shipment_type(required: true, type: PropertyType.String, description: 'shipment type')
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
      showed_payment_methods(required: true, type: PropertyType.String, description: 'origin of the payment method')
      refund_account_money(required: true, type: PropertyType.Boolean, description: 'refound money in the buyers account')
      cart_order(required: true, type: PropertyType.Boolean, description: 'order created by cart')
      payment_refund_at(required: true, type: PropertyType.String, description: 'when will the buyer be refunded', values:['shipped', 'delivered_3'])
    }

    "/return/congrats/selection"(platform: "/", type: TrackType.Event) {
      selection(required: true, type: PropertyType.String, description: 'selected option button')
    }

    // Bloqueo Scoring High
    "/return/congrats_error"(platform: "/", type: TrackType.View) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
      payment(required: true, type: PropertyType.String, description: 'origin of payment')
      shipment_type(required: true, type: PropertyType.String, description: 'shipment type')
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
      showed_payment_methods(required: true, type: PropertyType.String, description: 'origin of the payment method')
      cart_order(required: true, type: PropertyType.Boolean, description: 'order created by cart')
      payment_refund_at(required: true, type: PropertyType.String, description: 'when will the buyer be refunded', values:['shipped', 'delivered_3'])
    }

    "/return/congrats_error/selection"(platform: "/", type: TrackType.Event) {
      selection(required: true, type: PropertyType.String, description: 'selected option button')
    }

    /*
    "/return/external"(platform: "/", type: TrackType.View) {
        id(required: false, type: PropertyType.String, description: 'name of the page to redirect')
        data(required: false, type: PropertyType.Map, description: 'context information to send')
    }

    "/return/error"(platform: "/", type: TrackType.View) {
      //R E V I S A R
      previous_step(required: false, type: PropertyType.String, description: 'step before the error')
    }
    */
}
