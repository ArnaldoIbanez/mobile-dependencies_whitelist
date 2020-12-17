package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    def coordinatesStructure = objectSchemaDefinitions {
      latitude(required: true, type: PropertyType.Numeric)
      longitude(required: true, type: PropertyType.Numeric)
    }

    // VIEWS
    "/addresses"(platform: "/", isAbstract: true) {
        context(required: true, description: "The client which is using the addresses flow", values: ["MY_ML"], type: PropertyType.String)
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
    "/addresses/input_address/name"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the name")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the name track the name value")
    }
    
    "/addresses/input_address/zip_code"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the zip_code")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the zip_code track the zip_code value")
    }

    "/addresses/input_address/street_name"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the street_name")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the street_name track the street_name value")
    }
    
    "/addresses/input_address/street_number"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the street_number")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the street_number track the street_number value")
    }
    
    "/addresses/input_address/city"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the city")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the city track the city value")
    }
    
    "/addresses/input_address/colony"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the colony")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the colony track the colony value")
    }
    
    "/addresses/input_address/delivery"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the delivery")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the delivery track the delivery value")
    }

    "/addresses/input_address/delivery_instructions"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the delivery_instructions")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the delivery_instructions track the delivery_instructions value")
    }

    "/addresses/input_address/phone"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the phone")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the phone track the phone value")
    }

    "/addresses/input_address/additional_info"(platform:"/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the additional info")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the additional info track the additional info value")
    }

    "/addresses/input_address/error_map"(platform: "/", type: TrackType.Event) {
        label(required: true, type: PropertyType.String, description: "If the address has an error on the map step")
        value(required: false, type: PropertyType.String, description: "If the address has an error on the map step track the map coordiantes value")
    }

    // UX INFORMATION
    "/addresses/input_address/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {}

    "/addresses/input_address/dont_know_my_zip_code/submit"(platform:"/", type: TrackType.Event) {}

    "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a street suggestion")
        finalText(required: true, type: PropertyType.String, description: "The final text after selecting a street suggestion")
    }

    "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
        written(required: true, type: PropertyType.String, description: "The written text before selecting a phone suggestion")
        finalText(required: true, type: PropertyType.String, description: "The final text after selecting a phone suggestion")
    }
    
    "/addresses/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that are shown after opening the replace zip codes modal")
    }
    
    "/addresses/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event) {
        count(required: true, type: PropertyType.Numeric, description: "The count of zip codes that were shown on the replace zip codes modal")
    }

    "/addresses/input_address/select_map_position"(platform: "/", type: TrackType.Event) {
        suggested(required: true, type: PropertyType.Map(coordinatesStructure), description: "The suggested coordinates where we positioned the user on the map")
        finalCoordinates(required: true, type: PropertyType.Map(coordinatesStructure), description: "The final coordinates where the user finally positioned on the map")
    }
}
