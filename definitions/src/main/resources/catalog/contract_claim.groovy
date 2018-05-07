import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/contract-claim"(platform: "/", isAbstract: true) {}
    "/contract-claim/add-claim"(platform: "/", type: TrackType.Event) {
        order_id(required: true, type: PropertyType.Numeric,  description: "order id related to the claim")
        item_id(required: true, type: PropertyType.String,  description: "item id related to the claim")
        seller_id(required: true, type: PropertyType.Numeric,  description: "seller id related to the order")
        buyer_id(required: true, type: PropertyType.Numeric,  description: "buyer id related to the order")
        reason_id(required: true, type: PropertyType.String,  description: "reson id related to the claim [undelivered]")
        reason_detail(required: true, type: PropertyType.String,  description: "reason detail related to the claim [respondent_unanswered|undelivered_repentant_buyer|undelivered_other]")
    }
}