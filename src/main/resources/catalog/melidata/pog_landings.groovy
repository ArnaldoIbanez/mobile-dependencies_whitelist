package catalog.melidata
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    // Payments - Point - In-person Growth
    initiative = "1175"

    // Payments - Point - Online Growth
    //  initiative = "1262"

    /* ---------------------
    --- Abstract path's ----
    --------------------- */

    "/pog" (platform: "/", isAbstract: true) {
      product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
      bu (type: PropertyType.String, required: false, description: "business unit")
      ch (type: PropertyType.String, required: false, description: "sales channel")
      currency (type: PropertyType.String, required: false, description: "Currency")
      price (type: PropertyType.Numeric, required: false, description: "Price of device")
      has_coupon (type: PropertyType.Boolean, required: false, description: "Flag to detect if a sell has coupon")
      coupon_code (type: PropertyType.String, required: false, description: "MGM CuponCode")
      coupon_type (type: PropertyType.String, required: false, values: ["default", "mgm", "campaign"], description: "Kind of MGM Coupon: default | mgm | campaign")
      discount (type: PropertyType.Numeric, required: false, description: "Discount in price")
      price_with_discount (type: PropertyType.Numeric, required: false, description: "Total price")
      camp (type: PropertyType.String, required: false, description: "campaign")
      strategy (type: PropertyType.String, required: false, description: "strategy")
    }

    /* ---------------------
    ------ Pageviews -------
    --------------------- */

    "/pog/landings"(platform: "/", type: TrackType.View) {}

    "/pog/landings/compare"(platform:"/", type: TrackType.View) {}

    "/pog/landings/multiproduct"(platform:"/", type: TrackType.View) {}

    /* ---------------------
    -------- Events --------
    --------------------- */

    // [Merchants Growth] Landing Buy > Event
    "/pog/landings/buy"(platform:"/", type: TrackType.Event) {}
    
    // [Merchants Growth] Landings Navigation > Event
    "/pog/landings/navigation"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landings Navigation > Calculator link
    "/pog/landings/calculator"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landings Navigation > Security module link
    "/pog/landings/security"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landing compare > Events
    "/pog/landings/compare/buy"(platform:"/", type: TrackType.Event) {}
    "/pog/landings/compare/go"(platform:"/", type: TrackType.Event) {}

    // [Merchants Growth] Landing Multiproduct > Events
    "/pog/landings/multiproduct/buy"(platform:"/", type: TrackType.Event) {}
    "/pog/landings/multiproduct/compare"(platform:"/", type: TrackType.Event) {}
    "/pog/landings/multiproduct/go"(platform:"/", type: TrackType.Event) {}

}