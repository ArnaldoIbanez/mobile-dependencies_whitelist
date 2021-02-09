package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    def coordinatesStructure = objectSchemaDefinitions {
      latitude(required: true, type: PropertyType.String)
      longitude(required: true, type: PropertyType.String)
    }

    // VIEWS
    "/addresses"(platform: "/", isAbstract: true) {
        context(required: false, description: "The client which is using the addresses flow", values: ["MY_ML"], type: PropertyType.String)
    }
    
    "/addresses/input_address"(platform: "/", type: TrackType.View) {
        editing_address(required: false, description: "The address that the user is editing or null if it's a new address", type: PropertyType.Numeric)
    }
    
    "/addresses/input_address/map"(platform:"/", type: TrackType.View) {}

    // VIEWS ACTIONS
    "/addresses/input_address/back"(platform: "/", type: TrackType.Event) {}

    "/addresses/input_address/submit"(platform: "/", type: TrackType.Event) {}
    
    "/addresses/input_address/map/back"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/map/submit"(platform:"/", type: TrackType.Event) {}

    // INPUT ERRORS
    "/addresses/input_address/error"(platform:"/", type: TrackType.Event, isAbstract: true) {
        label(required: true, type: PropertyType.String, description: "The address input error message shown")
        value(required: false, type: PropertyType.String, description: "The address input error value")
    }

    "/addresses/input_address/error/name"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/error/zip_code"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/error/street_name"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/error/street_number"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/error/city"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/error/colony"(platform:"/", type: TrackType.Event) {}
    
    "/addresses/input_address/error/delivery"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/error/delivery_instructions"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/error/phone"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/error/additional_info"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/error/map"(platform: "/", type: TrackType.Event) {}

    // UX INFORMATION
    "/addresses/input_address/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {}

    "/addresses/input_address/dont_know_my_zip_code/submit"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/dont_know_my_zip_code/back"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a street suggestion")
        final_text(required: true, type: PropertyType.String, description: "The final text after selecting a street suggestion")
    }

    "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a phone suggestion")
        final_text(required: true, type: PropertyType.String, description: "The final text after selecting a phone suggestion")
    }
    
    "/addresses/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that are shown after opening the replace zip codes modal")
    }
    
    "/addresses/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that were shown on the replace zip codes modal")
    }

    "/addresses/input_address/select_map_position"(platform: "/", type: TrackType.Event) {
        suggested(required: true, type: PropertyType.Map(coordinatesStructure), description: "The suggested coordinates where we positioned the user on the map")
        final_coordinates(required: true, type: PropertyType.Map(coordinatesStructure), description: "The final coordinates where the user finally positioned on the map")
    }
}
