package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1212"

    "/garex"(platform: "/", isAbstract: true) {}

    def roda_device = objectSchemaDefinitions {
        brand(required: true, type: PropertyType.String, description: "Brand of device. For ex: Samsung.")
        model(required: false, type: PropertyType.String, description: "Model of the device. For ex: J7. Send by provider.")
        model_code(required: false, type: PropertyType.String, description: "Model code of the device. For ex: SM-J700M. Get from native.")
        size(required: true, type: PropertyType.String, description: "Size of the device. For ex: 64GB.")
        device_code(required: false, type: PropertyType.String, description: "device code to quote. For ex: diw387_1u1")
    }

    def garex_track_structure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Selected warranty option id. For ex: MLA-HAIR_CLIPPERS_GAR110203")
        period(required: true, type: PropertyType.Numeric, description: "Period of de selected warranty (months). For ex: 12")
        cost(required: true, type: PropertyType.Numeric, description: "Cost of selected warranty.")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Revenue share fee of selected warranty.")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue of selected warranty.")
        currency_id(required: true, type: PropertyType.String, description: "Currency of selected warranty. For ex: ARS")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Rate of the discount on the original cost.")
    }

    def financing_type_track_structure = objectSchemaDefinitions {
        no_interest_allowed(required: true, type: PropertyType.Boolean, description: "True when the item allows no interest payments on financing")
        installments(required: false, type: PropertyType.Numeric, description: "Number of available installments to finance payment")
    }

    def item_track_structure = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "Item ID. For ex: MLA824281356")
        domain_id(required: true, type: PropertyType.String, description: "Item domain. For ex: MLA-TELEVISIONS")
        financing_type(required: false, type: PropertyType.Map(financing_type_track_structure), description: "Financing data of item if it has")
        category_path(required: true, type: PropertyType.ArrayList, description: "Category path of the item. For ex: ['MLA1051', 'MLA1055']")
    }

    def grd_price = objectSchemaDefinitions {
        final_amount(required: true, type: PropertyType.Numeric, description: "final amount")
        discount_rate(required: false, type: PropertyType.Numeric, description: "discount rate")
    }

    def grd_option = objectSchemaDefinitions {
        brand(required: false, type: PropertyType.String, description: "model")
        coverage(required: false, type: PropertyType.String, description: "coverage")
        deductible_amount(required: false, type: PropertyType.Numeric, description: "deductible amount")
        model(required: false, type: PropertyType.String, description: "model")
        size(required: false, type: PropertyType.String, description: "size")
        manufacturer_warranty(required: false, type: PropertyType.Numeric, description: "factory warranty time")
    }

    def grd_protection_option = objectSchemaDefinitions {
        product_id(required: true, type: PropertyType.String, description: "id of the warranty option")
        price(required: true, type: PropertyType.Map(grd_price), description: "price of the warranty option")
        period(required: true, type: PropertyType.Numeric, description: "period of the warranty option")
        option_data(required: false, type: PropertyType.Map(grd_option), description: "extra information of the warranty option")
    }

    def grd_protection_item = objectSchemaDefinitions {
        id(required: true, type: PropertyType.String, description: "id of the item that is offered a protection")
        domain_id(required: true, type: PropertyType.String, description: "domain of the item that is offered a protection")
        price(required: true, type: PropertyType.Numeric, description: "price of the item that is offered a protection")
    }

    def congrats_payment = objectSchemaDefinitions {
        id(required: true, type: PropertyType.Numeric, description: "id of the payment")
        payment_type_id(required: true, type: PropertyType.String, description: "payment type id used in the transaction")
        transaction_amount(required: true, type: PropertyType.Numeric, description: "transaction amount paid")
        status(required: true, type: PropertyType.String, description: "status of payment")
    }

    // Web
    "/garex/checkout"(platform:"/web", type: TrackType.View) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/more_info"(platform:"/web", type: TrackType.Event) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/selected_garex"(platform:"/web", type: TrackType.Event) {
        garex(required: true, type: PropertyType.Map(garex_track_structure))
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/not_selected_garex"(platform:"/web", type: TrackType.Event) {
        item(required: true, type: PropertyType.Map(item_track_structure))
        options_has_discount(required: true, type: PropertyType.Boolean, description: "When pricing-elasticity experiment is on, this will determine if items has discounts to offer")
    }
    "/garex/checkout/delete"(platform:"/web", parentPropertiesInherited: false, type: TrackType.Event) {
        garex(required: true, type: PropertyType.Map(garex_track_structure))
    }

    //Mobile
    "/garex/checkout"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }
    "/garex/checkout/more_info"(platform:"/mobile", type: TrackType.Event) {}
    "/garex/checkout/selected_garex"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/not_selected_garex"(platform:"/mobile", type: TrackType.Event) {}
    "/garex/checkout/delete"(platform:"/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Warranty id removed")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/garex/checkout/back"(platform: "/mobile", type: TrackType.Event) {}
    "/garex/checkout/tap_selector"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/selected_warranty_option"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }
    "/garex/checkout/conditions_disclaimer"(platform: "/mobile", type: TrackType.Event) {}
    "/garex/checkout/terms_disclaimer"(platform: "/mobile", type: TrackType.Event) {}

    "/garex/skeleton"(platform:"/mobile", type: TrackType.View) {
        session_id(required: false, type: PropertyType.String, description: "Session id of the user")
    }
    "/garex/skeleton/back"(platform:"/mobile", type: TrackType.Event) {}

    "/garex/checkout/quote_creation_success"(platform: "/mobile", type: TrackType.Event) {
        quote_id(required: true, type: PropertyType.String, description: "Quotation id for the garex")
    }

    "/garex/checkout/quote_creation_error"(platform: "/mobile", type: TrackType.Event) {
        garex_id(required: true, type: PropertyType.String, description: "Selected warranty id")
        period(required: true, type: PropertyType.Numeric, description: "Contracted warranty period")
        cost(required: true, type: PropertyType.Numeric, description: "Warranty cost")
        revenue_share_fee(required: true, type: PropertyType.Numeric, description: "Percentage of revenue for mercado libre")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for mercado libre")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }


    // QPAGE_ON - MOBILE

    "/insurtech/qpage_on/skeleton"(platform:"/mobile", type: TrackType.View) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on/skeleton/back"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on"(platform:"/mobile", type: TrackType.View) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on/select"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: false, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/help"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
    }

    "/insurtech/qpage_on/add"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: false, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/skip"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on/quote_fail"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        period(required: true, type: PropertyType.Numeric, description: "Product period")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        original_cost(required: false, type: PropertyType.Numeric, description: "Product original cost")
        discount_rate(required: false, type: PropertyType.Numeric, description: "Product discount rate")
        revenue_share_fee(required: false, type: PropertyType.Numeric, description: "Percentage of revenue for Meli")
        revenue(required: true, type: PropertyType.Numeric, description: "Revenue value for Meli")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    "/insurtech/qpage_on/quote_success"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
        quote_id(required: false, type: PropertyType.String, description: "Quote id")
    }

    "/insurtech/qpage_on/back"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
    }

    "/insurtech/qpage_on/error"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        error_type(required: false, type: PropertyType.String, description: "Error type obtained")
    }

    "/insurtech/qpage_on/delete"(platform:"/mobile", type: TrackType.Event) {
        session_id(required: true, type: PropertyType.String, description: "Session id of the user")
        flow_id(required: true, type: PropertyType.String, description: "Product id of insurtech")
        quote_id(required: false, type: PropertyType.String, description: "Quote id")
        option_id(required: true, type: PropertyType.String, description: "Selected option id")
        cost(required: true, type: PropertyType.Numeric, description: "Product cost")
        currency_id(required: true, type: PropertyType.String, description: "Currency id")
    }

    // INSURTECH Webview
    "/insurtech/webview"(platform: "/", isAbstract: true) {}
    "/insurtech/webview/generic-error"(platform:"/mobile", type: TrackType.Event) {
        deeplink(required: true, type: PropertyType.String, description: "Deeplink that enter on webview.")
        device(required: true, type: PropertyType.Map(roda_device), description: "Device data of user")
    }

    //INSURTECH Hub-ON
    "/insurtech/qpage_on"(platform:"/web", type: TrackType.View, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/select"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
         item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
         option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
         has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
         has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/add"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/quote_success"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/quote_fail"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/skip"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/help"(platform:"/web", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
    }

    "/insurtech/qpage_on/faq"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_id(required: true, type: PropertyType.String, description: "product type id")
        coverage(required: false, type: PropertyType.String, description: "protection coverage")
        manufacturer_warranty(required: false, type: PropertyType.Numeric, description: "factory warranty time")
        period(required: false, type: PropertyType.Numeric, description: "duration of warranty")
    }

    "/insurtech/qpage_on/terms"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_id(required: true, type: PropertyType.String, description: "product type id")
        from(required: true, type: PropertyType.String, description: "from origin where this was requested")
    }

    "/insurtech/qpage_on/particular_conditions"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_id(required: true, type: PropertyType.String, description: "product type id")
        from(required: true, type: PropertyType.String, description: "from origin where this was requested")
    }

    // Hub-ON garex flow experiment
    "/insurtech/marketplace"(platform: "/", isAbstract: true) {}
    "/insurtech/marketplace/checkout"(platform:"/", isAbstract: true) {}
    "/insurtech/marketplace/checkout/garex_flow"(platform:"/", type: TrackType.View) {
        item(required: true, type:PropertyType.Map(grd_protection_item), description: "Basic data of the item to which garex is offered")
        options(required: false, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "garex options offered for item" )
    }

    //INSURTECH Hub-OFF
    "/insurtech/qpage_off"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/select"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/add"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/quote_success"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/quote_fail"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        options(required: true, type: PropertyType.ArrayList(PropertyType.Map(grd_protection_option)), description: "information on the coverage options offered to the item")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/help"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection is offered")
        option_selected(required: true, type:PropertyType.Map(grd_protection_option), description: "selected coverage options")
        has_roda(required: true, type: PropertyType.Boolean, description: "RODA protections are offered in sight")
        has_garex(required: true, type: PropertyType.Boolean, description: "GAREX protections are offered in sight")
        order_id(required: true, type:  PropertyType.String, description: "Marketplace order id to quote item for insurtech products")
    }

    "/insurtech/qpage_off/faq"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        product_id(required: true, type: PropertyType.String, description: "product type id")
        coverage(required: false, type: PropertyType.String, description: "protection coverage")
        manufacturer_warranty(required: false, type: PropertyType.Numeric, description: "factory warranty time")
        period(required: false, type: PropertyType.Numeric, description: "duration of warranty")
    }

    "/insurtech/qpage_off/error"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {}

    "/insurtech/qpage_off/fallback"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {}

    "/insurtech/qpage_off/congrats"(platform:"/", type: TrackType.View, parentPropertiesInherited:false) {
        order_id(required: true, type: PropertyType.String, description: "order id that initiates postcompra flow")
        product_id(required: true, type: PropertyType.String, description: "purchased protection product id")
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection has been purchased")
        payment(required: true, type: PropertyType.Map(congrats_payment), description: "payment information")
    }

    "/insurtech/qpage_off/congrats/go_to_protections_page"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        order_id(required: true, type: PropertyType.String, description: "order id that initiates postcompra flow")
        product_id(required: true, type: PropertyType.String, description: "purchased protection product id")
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection has been purchased")
        payment(required: true, type: PropertyType.Map(congrats_payment), description: "payment information")
    }

    "/insurtech/qpage_off/congrats/go_to_my_protections_page"(platform:"/", type: TrackType.Event, parentPropertiesInherited:false) {
        order_id(required: true, type: PropertyType.String, description: "order id that initiates postcompra flow")
        product_id(required: true, type: PropertyType.String, description: "purchased protection product id")
        item(required: true, type: PropertyType.Map(grd_protection_item), description: "information of the item to which protection has been purchased")
        payment(required: true, type: PropertyType.Map(congrats_payment), description: "payment information")
    }
}
