import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1046"

    /**
    *PDV tracks
    */
    propertyDefinitions {
        path(required: true, type: PropertyType.String, description: "end path to invoke finish onboarding", values: ["/collections", "/collections/setup/onboarding"])
        pos_management(required: true, type: PropertyType.Boolean, description: 'indicates user preference of pos management')
        cash_management(required: true, type: PropertyType.Boolean, description: 'indicates user preference of cash management')
        external_payments(required: true, type: PropertyType.Boolean, description: 'indicates user preference of external payments')
        key(required: false, type: PropertyType.String, description: "search key")
        category_id(required: false, type: PropertyType.String, description: "optional search category")
        has_image(required: true, type: PropertyType.Boolean, description: "product has image")
        has_category(required: true, type: PropertyType.Boolean, description: "product has category")
        has_variants(required: true, type: PropertyType.Boolean, description: "product has variants")
        catalog_context(required: true, type: PropertyType.String, description: "the context where the product or category is deleted", values: ["/pdv/product/list", "/pdv/product/edition", "/pdv/category/list", "/pdv/category/edition"])
        category_products(required: false, type: PropertyType.Numeric, description: "number of products associated to the category")
    }

    propertyGroups {
        export_props(path, pos_management, cash_management)
        search_product(key, category_id)
        product_props(has_image, has_category, has_variants)
    }

    "/pdv"(platform: "/", isAbstract: true) {}

    /**
    *PDV onboarding tracks
    */
    "/pdv/onboarding"(platform: "/", isAbstract: true) {}
        
    //FTU
    "/pdv/onboarding/start"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/init_onboarding"(platform: "/", type: TrackType.Event) {}

    //CREATE-STORE
    "/pdv/onboarding/store_setup"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/create_store"(platform: "/", type: TrackType.Event) {}

    //POS-SETUP
    "/pdv/onboarding/pos_setup"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/pos_management"(platform: "/", type: TrackType.Event) {
        pos_management(required: true, type: PropertyType.Boolean, description: "pos management is enabled")
        cash_management(required: true, type: PropertyType.Boolean, description: "cash management is enabled")
        external_payments(required: true, type: PropertyType.Boolean, description: "external payments are enabled")
    }
    "/pdv/onboarding/end"(platform: "/", type: TrackType.Event) {
        path(required: true, type: PropertyType.String, description: "ftu path")
    }

    //DEVICE-MANAGEMENT
    "/pdv/onboarding/link"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/unlink"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/buy_pos"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/register"(platform: "/", type: TrackType.Event) {}

    /**
    *PDV catalog tracks
    */
    //PRODUCT
    "/pdv/product"(platform: "/", isAbstract: true) {}
    "/pdv/product/list"(platform: "/", type: TrackType.View) {}
    "/pdv/product/search"(platform: "/", type: TrackType.Event) {
        search_product
    }
    "/pdv/product/creation"(platform: "/", type: TrackType.View) {}
    "/pdv/product/creation/done"(platform: "/", type: TrackType.Event) {
        product_props
    }
    "/pdv/product/edition"(platform: "/", type: TrackType.View) {}
    "/pdv/product/edition/done"(platform: "/", type: TrackType.Event) {
        product_props
    }
    "/pdv/product/delete"(platform: "/", isAbstract: true) {}
    "/pdv/product/delete/start"(platform: "/", type: TrackType.Event) {}
    "/pdv/product/delete/end"(platform: "/", type: TrackType.Event) {
        catalog_context(required: true, type: PropertyType.String, description: "the context where the product or category is deleted", values: ["/pdv/product/list", "/pdv/product/edition", "/pdv/category/list", "/pdv/category/edition"])
    }
    "/pdv/product/edit_category"(platform: "/", isAbstract: true) {}
    "/pdv/product/edit_category/start"(platform: "/", type: TrackType.Event) {}
    "/pdv/product/edit_category/end"(platform: "/", type: TrackType.Event) {}
    "/pdv/product/discount"(platform: "/", isAbstract: true) {}
    "/pdv/product/discount/start"(platform: "/", type: TrackType.Event) {}
    "/pdv/product/discount/end"(platform: "/", type: TrackType.Event) {}

    //CATEGORY
    "/pdv/category"(platform: "/", isAbstract: true) {}
    "/pdv/category/list"(platform: "/", type: TrackType.View) {}
    "/pdv/category/creation"(platform: "/", type: TrackType.View) {}
    "/pdv/category/creation/done"(platform: "/", type: TrackType.Event) {
        category_products(required: false, type: PropertyType.Numeric, description: "number of products associated to the category")
    }
    "/pdv/category/edition"(platform: "/", type: TrackType.View) {}
    "/pdv/category/edition/done"(platform: "/", type: TrackType.Event) {
        category_products(required: false, type: PropertyType.Numeric, description: "number of products associated to the category")
    }
    "/pdv/category/delete"(platform: "/", isAbstract: true) {}
    "/pdv/category/delete/start"(platform: "/", type: TrackType.Event) {}
    "/pdv/category/delete/end"(platform: "/", type: TrackType.Event) {
        catalog_context(required: true, type: PropertyType.String, description: "the context where the product or category is deleted", values: ["/pdv/product/list", "/pdv/product/edition", "/pdv/category/list", "/pdv/category/edition"])
    }
}

