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
        reason(required: true, description: 'The claim creation reason.', values: ['delivered', 'undelivered'])
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
}