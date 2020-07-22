package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1130"

    /*************************
    *      ACTIVITY WEB      *
    *************************/

    def sub_item_definition = objectSchemaDefinitions {
        sub_item_id(type: PropertyType.String)
    }
    def item_definition = objectSchemaDefinitions {
        item_id(type: PropertyType.String)
        sub_items(type: PropertyType.Map(sub_item_definition), required: false)
    }
    def section_definition = objectSchemaDefinitions {
        section_id(type: PropertyType.String)
        items(type: PropertyType.Map(item_definition))
    }

    // MP Home
    "/mp_home"(platform: "/", type: TrackType.View) {
        userProfile (
            type: PropertyType.String,
            required: false,
            description: "User profile type",
            values: ['newbie', 'collector', 'payer'],
        )
    }

    // MP Home
    "/profile"(platform: "/", type: TrackType.View) {}

    // MP Activities
    "/listing"(platform: "/", isAbstract: true) {}
    "/listing/activities"(platform: "/web", type: TrackType.View) {}
    "/listing/gateway"(platform: "/web", type: TrackType.View) {}

    // MP details
    "/activity"(platform: "/web", isAbstract: true) {}
    "/activity/detail"(platform: "/web", type: TrackType.View) {}
    "/activity/detail/shipping"(platform: "/web", type: TrackType.View) {}

    // MP Balance/Advances
    "/activities"(platform: "/web", isAbstract: true) {}
    "/activities/balance"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances/congrats"(platform: "/web", type: TrackType.View) {}

    // MP Activities Export
    "/activities/export"(platform: "/web", type: TrackType.View) {}

    // MP Shields
    "/shield"(platform: "/", type: TrackType.View) {}

    // MP Panel Layout
    "/panel_layout"(platform: "/") {
        navigationSections(
            description:"The sections that the user is receiving from the api.",
            type: PropertyType.ArrayList(PropertyType.Map(section_definition))
        )
    }

    "/charts"(platform: "/web", isAbstract: true){}
    "/charts/show"(platform: "/web", type: TrackType.View){}

    /*************************
    *        MP PUBLIC       *
    *************************/

    /**
     * Digital Wallet Screen Tracks
     */
    "/digital_wallet"(platform: "/", type: TrackType.View) {}

    /**
     * Digital Wallet Events Tracks
     */
    "/digital_wallet/click_show_video"(platform: "/", type: TrackType.Event) {
        section(required: true, description: "Section from which the event comes", type: PropertyType.String)
    }

    "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
        section_store(required: true, description: "Section from which the event comes and Store (Google Play or App Store)", type: PropertyType.String)
    }

    /**
     * Bsuiness Site Screen Tracks
     */
    "/business_site"(platform: "/", type: TrackType.View) {}

    /**
     * Business Site Events Tracks
     */
    "/business_site/click"(platform: "/", type: TrackType.Event) {
        action(required: true, description: "What action user's do (shortcut, know_more, new_account)", type: PropertyType.String)
        section(required: true, description: "Section where the event comes (physical, digital)", type: PropertyType.String)
        item(required: false, description: "Item where the event comes (checkout, qr, point)", type: PropertyType.String)
    }

    // MP Landings Scope
    "/landing"(platform: "/", isAbstract: true) {}

    // MP Home
    "/landing/home"(platform: "/web"){}

    // MP Sellers
    "/landing/sellers"(platform: "/"){}

    // MP Sellers Websites
    "/landing/sellers/websites"(platform: "/web"){}

    // MP Sellers Social
    "/landing/sellers/social"(platform: "/web"){}

    // MP Sellers Merchant Services
    "/landing/sellers/mss"(platform: "/"){
        page_name (type: PropertyType.String, required: true, description: "Landing page unique name")
    }

    "/landing/sellers/mss/click"(platform:"/", type: TrackType.Event) {
        id (type: PropertyType.String, required: false, description: "ID from clicked element")
        label (type: PropertyType.String, required: false, description: "Element text")
        page_name (type: PropertyType.String, required: true, description: "Landing page unique name")
        fixed_fee (type: PropertyType.String, required: false, description: "Fixed Fee")
        advance (type: PropertyType.String, required: false, description: "Advance days")
        advance_fee (type: PropertyType.String, required: false, description: "Advance days fee")
        advance_value (type: PropertyType.String, required: false, description: "Advance fee final value")
        installments (type: PropertyType.String, required: false, description: "Total installments")
        installments_fee (type: PropertyType.String, required: false, description: "Installments fee")
        installments_value (type: PropertyType.String, required: false, description: "Installments final value")
        initial_sale_value (type: PropertyType.String, required: false, description: "Initial sale value")
        final_sale_value (type: PropertyType.String, required: false, description: "Final sale value (with fees)")
    }

    // MP Buyers
    "/landing/buyers"(platform: "/web"){}

    // MP Promotions
    "/landing/promotions"(platform: "/web"){}

    "/landing/formcomercial"(platform: "/", type: TrackType.View) {}

    "/landing/formcomercial/send_email"(platform:"/", type: TrackType.Event) {
        email (type: PropertyType.String, required: true, description: "Email from user")
    }

    // Splinter MP Landings
    "/landing/marketing"(platform: "/", type: TrackType.View) {
      key (type: PropertyType.String, required: true, description: "ID from a landing")
      startTime (type: PropertyType.String, required: true, description: "Configured start time from a landing")
      endTime (type: PropertyType.String, required: true, description: "Configured end time from a landing")
    }

    //MP Webview COVID
    "/mp_covid"(platform: "/", type: TrackType.View) {}
    "/mp_covid/congrats"(platform: "/", type: TrackType.View) {}
    "/mp_covid/donation"(platform: "/", type: TrackType.View) {}
    "/mp_covid/custom_amount"(platform: "/", type: TrackType.View) {}

    /*************************
    *        MP BANKING       *
    *************************/

    // MP Banking abstract track
    "/banking"(platform: "/", isAbstract: true) {}

    // MP Banking Balance (web, webmobile and webview)
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}

    // MP Banking PNF (web, webmobile and webview)
    "/banking/pnf"(platform: "/", type: TrackType.View) {}
}
