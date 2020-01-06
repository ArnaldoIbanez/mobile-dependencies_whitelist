import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    /**
    *PDV tracks
    */
    propertyDefinitions {
        path(required: true, type: PropertyType.String, description: "end path to invoke finish onboarding", values: ["/collections", "/collections/setup/onboarding"])
        pos_management(required: true, type: PropertyType.Boolean, description: 'indicates user preference of pos management')
        cash_management(required: true, type: PropertyType.Boolean, description: 'indicates user preference of cash management')
    }

    propertyGroups {
        export_props(path, pos_management, cash_management)
    }

    "/pdv"(platform: "/", isAbstract: true) {}

    /**
    *PDV onboarding tracks
    */
    "/pdv/onboarding"(platform: "/", isAbstract: true) {}
        
    //FTU
    "/pdv/onboarding/start"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/start"(platform: "/", type: TrackType.Event) {}

    //CREATE-STORE
    "/pdv/onboarding/create_store"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/create_store"(platform: "/", type: TrackType.Event) {}

    //POS-SETUP
    "/pdv/onboarding/pos_setup"(platform: "/", type: TrackType.View) {}
    "/pdv/onboarding/pos_management"(platform: "/", type: TrackType.Event) {
        pos_management(required: true, type: PropertyType.Boolean, description: "pos management is enabled")
        cash_management(required: true, type: PropertyType.Boolean, description: "cash management is enabled")
    }
    "/pdv/onboarding/end"(platform: "/", type: TrackType.Event) {
        path(required: true, type: PropertyType.String, description: "ftu path")
    }

    //DEVICE-MANAGEMENT
    "/pdv/onboarding/link"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/unlink"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/buy_pos"(platform: "/", type: TrackType.Event) {}
    "/pdv/onboarding/register"(platform: "/", type: TrackType.Event) {}
}
