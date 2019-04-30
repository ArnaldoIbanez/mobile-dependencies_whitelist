import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    "/current_location"(platform: "/", isAbstract: true) {}
    "/current_location/navigation"(platform: "/", isAbstract: true) {}
    "/current_location/navigation/pick"(platform: "/", type: TrackType.Event) {}
    "/current_location/navigation/close"(platform: "/", type: TrackType.Event) {}
    "/current_location/navigation/pick_onboarding"(platform: "/", type: TrackType.Event) {}
    "/current_location/navigation/close_onboarding"(platform: "/", type: TrackType.Event) {}
    "/current_location/hub"(platform: "/", type: TrackType.View) {        
        addresses_quantity(required: true, type: PropertyType.Numeric,  description: "Addresses quantity")
        has_errors(required: true, type: PropertyType.Boolean,  description: "Indicates if the form submited has errors with zipcode")
        zipcode(required: true, type: PropertyType.String,  description: "Zipcode added by the user")
    }
    "/current_location/hub/select_address"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/current_location/hub/add_zipcode"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {        
        has_errors(required: true, type: PropertyType.Boolean,  description: "Indicates if the zipcode added has errors")
        zipcode(required: true, type: PropertyType.String,  description: "Zipcode added by the user")
    }
    "/current_location/hub/create_address"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}
    "/current_location/hub/find_zipcode"(platform: "/", type: TrackType.Event, parentPropertiesInherited: false) {}    
}
