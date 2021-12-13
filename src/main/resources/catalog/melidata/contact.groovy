package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = '1075'

    //Contact
    "/contact"(platform: "/", isAbstract: true) {}

    //Contact :: Congrats
    "/contact/congrats"(platform: "/") {
        // ITEM FIELDS
        item_id(required: true, type: PropertyType.String, description: "Item ID")
        category_id(required: true, type: PropertyType.String, description: "Item's category id")
        buying_mode(required: true, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_path(required: true, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: true, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: true, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")
        item_status(required: true, type: PropertyType.String, values: ["pending", "active", "closed", "paused", "under_review", "not_yet_active", "payment_required"],
                description: "Whenever the items is active, closed or paused")

        //SELLER FIELDS
        seller_id(required: true, type: PropertyType.Numeric)

        //VIS FIELDS
        has_good_price(required: false, type: PropertyType.Boolean,
                description: "Indicates if the item has tagged as good price according to price comparison")

        deal_ids(required: false, type: PropertyType.ArrayList, description: "IDs of applied discounts")

        //classified's fields
        contract_available(required: false, type: PropertyType.Boolean)
        comparator_available(required: false, type: PropertyType.Boolean,
                 description: "Indicates if clasi item has model comparator available")

        gallery_pattern(required: false, type: PropertyType.String,
                         description: "String in which each char indicates if the image's maxSize is bigger than the " +
                                 "double of the gallery size ('X'), smaller than the double but bigger than de gallery size ('Y'), " +
                                 "or smaller than the gallery size ('Z')")

        description_type(required: false, description: "Description type: plain text, html, both, none",
                        values: ["plain_text", "html", "both", "none"])

        price_comparison_available(required: false, type: PropertyType.Boolean,
          description: "Indicates if classified item has model price comparator available")
    }

}
