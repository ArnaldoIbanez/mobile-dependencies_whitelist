package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

tracks {

    initiative = '1075'

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// This tracks will be representing the user intention to sell an item  (to list). ( Meaning clicking in one button that links with SYI)
// For now it will be only use from the Congrats view in post contact in classifieds items
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    "/listing_intention"(platform: "/web",  type: TrackType.Event) {

        from(required: true, type: PropertyType.String, description: "Indicates from which view the listing_intention was initiated", values: ["congrats"])
        context(required:true, description: "Indicates from which app the listing_intention was initiated", values: ["vip"])

        go_to(required: true, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services", "hub"],
                description: "go to list in core, motors, realEstate, services or to the hub")

        // ITEM FIELDS
        item_id(required: false, type: PropertyType.String, description: "Item ID")
        category_id(required: false, type: PropertyType.String, description: "Item's category id")
        buying_mode(required: false, type: PropertyType.String, values: ["buy_it_now", "auction","classified"],
                description: "Indicates if it's an auction, buy_it_now or classified")
        category_path(required: false, type: PropertyType.ArrayList , description:  "Category path of the the item")
        vertical(required: false, type: PropertyType.String,
                values: ["core", "motors", "realEstate", "services"], description: "Vertical of the item")
        item_condition(required: false, type: PropertyType.String, values: ["new", "used", "refurbished", "not_specified"],
                description: "Whether the item is new, used or refurbished")
        listing_type_id(required: false, type: PropertyType.String,
                values: ["free", "bronze", "silver", "gold", "gold_special", "gold_premium", "gold_pro"],
                description: "Listing type of the item")

    }

}
