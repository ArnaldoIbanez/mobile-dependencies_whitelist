import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    propertyDefinitions {
        reason(required: false, type: PropertyType.String)
    }

    "/claims"(platform: "/", isAbstract: true) { }

    /**
     * Claim creation steps.
     */
    "/claims/create_claim"(platform: "/", isAbstract: true) { }

    "/claims/create_claim/form"(platform: "/", isAbstract: true) { 
        vertical(required: false, type: PropertyType.String)
        order_id(required: false, type: PropertyType.Numeric,  description: "order id related to the claim")
        item_id(required: false, type: PropertyType.String,  description: "item id related to the claim")
        seller_id(required: false, type: PropertyType.Numeric,  description: "seller id related to the order")
        buyer_id(required: false, type: PropertyType.Numeric,  description: "buyer id related to the order")
        reason(required: false, description: 'The claim creation reason.', values: ['delivered', 'undelivered'])
        reason_detail(required: false, type: PropertyType.String,  description: "reason detail related to the claim [respondent_unanswered|undelivered_repentant_buyer|undelivered_other]")
    }

    "/claims/create_claim/allow"(platform: "/", type: TrackType.View)  {
        ref(required: false, type: PropertyType.String)
        returns_loyalty_level(required: false, type: PropertyType.Numeric)
        returns_date_delivered(required: false, type: PropertyType.String)
        returns_cart_order(required: false, type: PropertyType.Boolean)
        returns_item_category(required: false, type: PropertyType.String)
        returns_item_category_l1(required: false, type: PropertyType.String)
        returns_refund_account_money(required: false, type: PropertyType.Boolean)
        returns_authorized(required: false, type: PropertyType.Boolean)
    }

    "/claims/create_claim/denied"(platform: "/", type: TrackType.View) {
        reason(description: 'Claim denied reason.')
    }

    "/claims/create_claim/creation"(platform: "/", type: TrackType.Event)  {
        vertical(required: false, type: PropertyType.String)
        order_id(required: false, type: PropertyType.Numeric,  description: "order id related to the claim")
        item_id(required: false, type: PropertyType.String,  description: "item id related to the claim")
        seller_id(required: false, type: PropertyType.Numeric,  description: "seller id related to the order")
        buyer_id(required: false, type: PropertyType.Numeric,  description: "buyer id related to the order")
        reason(required: false, description: 'The claim creation reason.', values: ['delivered', 'undelivered'])
        reason_detail(required: false, type: PropertyType.String,  description: "reason detail related to the claim")
    }

    /**
     * Generic error views group by type.
     */
    "/claims/error"(platform: "/", type: TrackType.View) {
        type(required: false, type: PropertyType.String)
    }

    /**
     * Stale flow.
     */
    "/claims/stale"(platform: "/", type: TrackType.View) {
        reason(description: 'The reason that the user gets a stale view.')
        expected_resolution(required: false, description: 'The complaint expected resolution', values: ['refund', 'product'])
    }

    /**
     * Claim detail views and actions.
     */
    "/claims/detail"(platform: "/", type: TrackType.View) {
        status(required: false, type: PropertyType.String, description: 'The current claim status.')
    }

    /**
     * Claims view when the payment is already refunded.
     */
    "/claims/refunded"(platform: "/", type: TrackType.View) {
        expected_resolution(required: false, type: PropertyType.String, description: 'The complaint expected resolution', values: ['refund', 'product'])
    }
}
