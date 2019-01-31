import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/claims"(platform: "/", isAbstract: true) { }

    /**
     * Init claim steps.
     */
    "/claims/init"(platform: "/") {
        pageName(required: true, type: PropertyType.String, description: 'The page name.', values: ['create_claim', 'cancel_purchase', 'creation_denied', 'contention', 'congrats', 'mp_contention', 'error-view'])
    }

    /**
     * Claim creation steps.
     */
    "/claims/create_claim"(platform: "/", isAbstract: true) { }

    "/claims/create_claim/form"(platform: "/", isAbstract: true) {
        vertical(required: true, type: PropertyType.String)
        order_id(required: true, type: PropertyType.Numeric,  description: "order id related to the claim")
        item_id(required: true, type: PropertyType.String,  description: "item id related to the claim")
        seller_id(required: true, type: PropertyType.Numeric,  description: "seller id related to the order")
        reason(required: true, description: "The claim creation reason.", values: ['delivered', 'undelivered'])
        reason_detail(required: true, type: PropertyType.String,  description: "reason detail related to the claim.", values: ['respondent_unanswered', 'undelivered_repentant_buyer', 'undelivered_other'])
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

    //TODO @paltorres @nacho-ml please update this track in mediations repo so we can mark all these as required
    "/claims/create_claim/creation"(platform: "/", type: TrackType.Event)  {
        vertical(required: false, type: PropertyType.String)
        order_id(required: false, type: PropertyType.Numeric,  description: "order id related to the claim")
        item_id(required: false, type: PropertyType.String,  description: "item id related to the claim")
        seller_id(required: false, type: PropertyType.Numeric,  description: "seller id related to the order")
        reason(required: true, description: "The claim creation reason.", values: ['delivered', 'undelivered'])
        reason_detail(required: false, type: PropertyType.String,  description: "reason detail related to the claim")
    }

    /**
     * Generic error views group by type.
     */
    "/claims/error"(platform: "/", type: TrackType.View) {
        type(required: false, type: PropertyType.String)
    }

    /**
     * Claim detail views and actions.
     */
    "/claims/detail"(platform: "/", type: TrackType.View) {
        status(required: false, type: PropertyType.String, description: 'The current claim status.')
    }
}
