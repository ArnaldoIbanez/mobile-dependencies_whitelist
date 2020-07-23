package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks


tracks {

    initiative = "1130"

    /******************************************
    *              MP FRONT CORE              *
    ******************************************/

    // Definitions

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

    propertyDefinitions {
        section_id(required: false, type: PropertyType.String, description: "Identifier for the realestate to consume")
        component_id(required: true, type: PropertyType.String, description: "Identifier for the component")
        content_id(required: true, type: PropertyType.String, description: "Identifier for the unique content shown")
        audience(required: true, type: PropertyType.String, description: "The audience for which this content was prepared")
        position(required: false, type: PropertyType.Numeric, description: "Position starting at 1 where it was shown")
        logic(required: true, type: PropertyType.String, description: "Origin of the content")
        bu(required: true, type: PropertyType.String, description: "The business unit")
        bu_line(required: true, type: PropertyType.String, description: "The business unit related to the content")
        flow(required: true, type: PropertyType.String, description: "The flow related to the content")
        action_id(required: false, type: PropertyType.String, description: "The action executed")
        link(required: false, type: PropertyType.String, description: "Link to execute")
    }

    propertyGroups {
        eventDataTrack (
           section_id, component_id, content_id, audience, position, logic, bu, bu_line, flow
        )
        actionEventDataTrack (
           section_id, component_id, content_id, audience, position, logic, bu, bu_line, flow, action_id, link
        )
    }


    /******************************************
    *         Tracks - Loggued Context        *
    ******************************************/
    
    // MP Home
    "/mp_home"(platform: "/", type: TrackType.View) {
        userProfile (required: false, type: PropertyType.String,, description: "User profile type", values: ['newbie', 'collector', 'payer'])
    }

    // MP Home - Merch Engine Events
    "/mp_home/sections/crossselling/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/crossselling/view"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/crossselling/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
    "/mp_home/sections/discountbenefits/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/discountbenefits/view"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/discountbenefits/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
    "/mp_home/sections/prioritymessages/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/prioritymessages/view"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/prioritymessages/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
    "/mp_home/sections/promobanner/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/promobanner/view"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/promobanner/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }
    "/mp_home/sections/oneshotmodal/print"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/oneshotmodal/view"(platform: "/", type: TrackType.Event) { eventDataTrack }
    "/mp_home/sections/oneshotmodal/tap"(platform: "/", type: TrackType.Event) { actionEventDataTrack }

    // MP Profile
    "/profile"(platform: "/", type: TrackType.View) {}

    // MP Activities
    "/listing"(platform: "/", isAbstract: true) {}
    "/listing/activities"(platform: "/web", type: TrackType.View) {}
    "/listing/gateway"(platform: "/web", type: TrackType.View) {}

    // MP Activities - Details/Shipping
    "/activity"(platform: "/web", isAbstract: true) {}
    "/activity/detail"(platform: "/web", type: TrackType.View) {}
    "/activity/detail/shipping"(platform: "/web", type: TrackType.View) {}

    // MP Activities - Balance/Advances
    "/activities"(platform: "/web", isAbstract: true) {}
    "/activities/balance"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances"(platform: "/web", type: TrackType.View) {}
    "/activities/balance/advances/congrats"(platform: "/web", type: TrackType.View) {}

    // MP Activities - Export
    "/activities/export"(platform: "/web", type: TrackType.View) {}

    // MP Shields
    "/shield"(platform: "/", type: TrackType.View) {}

    // MP Panel - Panel Layout
    "/panel_layout"(platform: "/") {
        navigationSections(
            description:"The sections that the user is receiving from the api.",
            type: PropertyType.ArrayList(PropertyType.Map(section_definition))
        )
    }

    // MP Panel - Charts
    "/charts"(platform: "/web", isAbstract: true){}
    "/charts/show"(platform: "/web", type: TrackType.View){}

    // MP Webview COVID
    "/mp_covid"(platform: "/", type: TrackType.View) {}

    // MP Webview COVID - Congrats
    "/mp_covid/congrats"(platform: "/", type: TrackType.View) {}

    // MP Webview COVID - Donation
    "/mp_covid/donation"(platform: "/", type: TrackType.View) {}

    // MP Webview COVID - Custom Amount
    "/mp_covid/custom_amount"(platform: "/", type: TrackType.View) {}

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // MP Banking - Balance
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}

    // MP Banking - PNF
    "/banking/pnf"(platform: "/", type: TrackType.View) {}


    /******************************************
    *         Tracks - Public Context         *
    ******************************************/

    // MP Landing - Digital Wallet
    "/digital_wallet"(platform: "/", type: TrackType.View) {}

    // MP Landing - Digital Wallet - Events
    "/digital_wallet/click_show_video"(platform: "/", type: TrackType.Event) {
        section(required: true, description: "Section from which the event comes", type: PropertyType.String)
    }
    "/digital_wallet/click_download_app"(platform: "/", type: TrackType.Event) {
        section_store(required: true, description: "Section from which the event comes and Store (Google Play or App Store)", type: PropertyType.String)
    }

    // MP Landing - Business Site
    "/business_site"(platform: "/", type: TrackType.View) {}

    // MP Landing - Business Site - Events
    "/business_site/click"(platform: "/", type: TrackType.Event) {
        action(required: true, description: "What action user's do (shortcut, know_more, new_account)", type: PropertyType.String)
        section(required: true, description: "Section where the event comes (physical, digital)", type: PropertyType.String)
        item(required: false, description: "Item where the event comes (checkout, qr, point)", type: PropertyType.String)
    }

    // MP Landing - Landing Scope
    "/landing"(platform: "/", isAbstract: true) {}

    // MP Landing - Landing Home
    "/landing/home"(platform: "/web") {}

    // MP Landing - Landing Sellers
    "/landing/sellers"(platform: "/") {}

    // MP Landing - Landing Sellers - Websites
    "/landing/sellers/websites"(platform: "/web") {}

    // MP Landing - Landing Sellers - Social
    "/landing/sellers/social"(platform: "/web") {}

    // MP Landing - Landing Sellers - Merchant Services
    "/landing/sellers/mss"(platform: "/") {
        page_name (type: PropertyType.String, required: true, description: "Landing page unique name")
    }

    // MP Landing - Landing Sellers - Merchant Services - Event
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

    // MP Landing - Landing Buyers
    "/landing/buyers"(platform: "/web") {}

    // MP Landing - Landing Promotions
    "/landing/promotions"(platform: "/web") {}

    // MP Landing - Landing Form Comercial
    "/landing/formcomercial"(platform: "/", type: TrackType.View) {}

    // MP Landing - Landing Form Comercial - Event
    "/landing/formcomercial/send_email"(platform:"/", type: TrackType.Event) {
        email (type: PropertyType.String, required: true, description: "Email from user")
    }

    // MP Splinter Landings - Landing Marketing
    "/landing/marketing"(platform: "/", type: TrackType.View) {
      key (type: PropertyType.String, required: true, description: "ID from a landing")
      startTime (type: PropertyType.String, required: true, description: "Configured start time from a landing")
      endTime (type: PropertyType.String, required: true, description: "Configured end time from a landing")
    }
}
