import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    "/return"(platform: "/", isAbstract: true) {
      loyalty_level(required: true, type: PropertyType.Numeric, description: 'buyer level loyalty')
      order_id(required: true, type: PropertyType.Numeric, description: 'order identifier')
      buyer_scoring(required: false, type: PropertyType.String, description: 'buyer reputation level')
      seller_scoring(required: false, type: PropertyType.String, description: 'seller reputation level')
      category_id(required: false, type: PropertyType.String, description: 'category identifier')
      category_l1_id(required: false, type: PropertyType.String, description: 'main category of item')
      category_path(required: false, type: PropertyType.ArrayList, description: 'the path of the category')
      request_type(required: false, type: PropertyType.String, description: 'request type of the operation', values:['RETURN', 'REPURCHASE', 'CHANGE'])
    }

    // STEP 01
    "/return/potential_resolutions"(platform: "/", type: TrackType.View) {
        ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }
    "/return/potential_resolutions/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        request_type(required: true, type: PropertyType.String, description: 'kind of operation (repurchase, return or change)')
    }

    // STEP 02
    "/return/typifications"(platform: "/", type: TrackType.View) {
      ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }
    "/return/typifications/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
    }

    // STEP 03
    "/return/conditions"(platform: "/", type: TrackType.View) {
      ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
    }
    "/return/conditions/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      selection(required: true, values:['accepted', 'rejected'], type: PropertyType.String, description: 'selected option button')
    }

    // STEP 04
    "/return/payments"(platform: "/", type: TrackType.View) {
      ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
      showed_payment_methods(required: true, type: PropertyType.String, description: 'what payment refund methods are shown to the buyer')
    }
    "/return/payments/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      payment_refund_method(required: true, type: PropertyType.String, description: 'payment refund method selected by the user')
    }

    // STEP 05
    "/return/shipping"(platform: "/", type: TrackType.View) { }
    "/return/shipping/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      shipment_type(required: true, values:['delivery', 'pickup'], type: PropertyType.String, description: 'selected shipment type')
    }

    // STEP 06.a
    "/return/pickup"(platform: "/", type: TrackType.View) { }
    "/return/pickup/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      pickup_time(required: true, type: PropertyType.String, description: 'when will the carrier arrive to buyer address')
    }

    // STEP 06.b
    "/return/delivery"(platform: "/", type: TrackType.View) { }

    // STEP 06.c
    "/return/review"(platform: "/", type: TrackType.View) { }
    "/return/review/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      review_return_method(required: true, type: PropertyType.String, description: 'type of review', values: ['review_code', 'review_label'] )
    }

    // STEP 07
    "/return/congrats"(platform: "/", type: TrackType.View) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
      payment_refund_method(required: false, type: PropertyType.String, description: 'payment refund method selected by the user')
      shipment_type(required: true, type: PropertyType.String, description: 'shipment type')
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
      showed_payment_methods(required: false, type: PropertyType.String, description: 'origin of the payment method')
      refund_account_money(required: true, type: PropertyType.Boolean, description: 'refund money in the buyers account')
      ref(required: false, type: PropertyType.String, description: 'reference of the beginning of the flow')
      cart_order(required: true, type: PropertyType.Boolean, description: 'order created by cart')
      payment_refund_at(required: true, type: PropertyType.String, description: 'when will the buyer be refunded', values:['shipped', 'delivered'])
    }

    "/return/congrats/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
      selection(required: true, type: PropertyType.String, description: 'selected option button')
    }

    // Bloqueo Scoring High
    "/return/congrats_error"(platform: "/", type: TrackType.View) {
      typification(required: true, type: PropertyType.String, description: 'reason why the product is returned')
      payment_refund_method(required: false, type: PropertyType.String, description: 'origin of payment')
      shipment_type(required: true, type: PropertyType.String, description: 'shipment type')
      pickup_time(required: false, type: PropertyType.String, description: 'pickup time product to seller')
      showed_payment_methods(required: false, type: PropertyType.String, description: 'origin of the payment method')
      cart_order(required: true, type: PropertyType.Boolean, description: 'order created by cart')
      payment_refund_at(required: true, type: PropertyType.String, description: 'when will the buyer be refunded', values:['shipped', 'delivered_3'])
    }

    "/return/congrats_error/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        selection(required: true, type: PropertyType.String, description: 'selected option button')
    }

    "/return/external"(platform: "/", type: TrackType.View) {
        id(required: false, type: PropertyType.String, description: 'name of the page to redirect')
        data(required: false, type: PropertyType.Map, description: 'context information to send')
    }

    "/return/warning"(platform: "/", type: TrackType.View) {
        type(required: true, type: PropertyType.String, description: 'if this order had a return or a claim', values: ['return_created', 'claim_created'])
    }
    "/return/warning/selection"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {
        selection(required: true, type: PropertyType.String, description: 'button selected by the user', values: ['go_to_purchases', 'view_details'])
    }

    "/return/error"(platform: "/", type: TrackType.View) {
        previous_step(required: false, type: PropertyType.String, description: 'step before the error')
    }
}
