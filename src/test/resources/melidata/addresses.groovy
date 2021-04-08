package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    test("Addresses - Test the views") { 
        "/addresses/input_address"(platform: "/", type: TrackType.View) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map"(platform: "/", type: TrackType.View) {
            context = "MY_ML"
            editing_address = null
        }
    }
    
    test("Addresses - Test the views actions") { 
        "/addresses/input_address/back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the input errors") { 
        "/addresses/input_address/error/name"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/error/zip_code"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = "00"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/street_name"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/street_number"(platform:"/",  type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = "aaa"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/city"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/colony"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/delivery"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/delivery_instructions"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/phone"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = "!*"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/error/map"(platform: "/", type: TrackType.Event) {
            label = "Mové el mapa y ubicá el pin en tu ubicación exacta"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the UX info") { 
        "/addresses/input_address/unknown_zip_code"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/unknown_zip_code_submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/unknown_zip_code_back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
            written = "sug"
            final_text = "suggested street"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
            written = "123"
            final_text = "12345678"
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 10.0
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 2.0
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_map_position"(platform: "/", type: TrackType.Event) {
            suggested = [
                "latitude": "12.12",
                "longitude": "42.42"
            ]
            final_coordinates = [
                "latitude": "12.13",
                "longitude": "42.40"
            ]
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/moved_to_my_location"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/location_permission_granted"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/location_permission_requested"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/complete_loading"(platform: "/", type: TrackType.Event) {
            start_loading = "2021-02-24 12:12:12"
         }
    }

    defaultBusiness = "mercadopago"
    
    test("Addresses - Test the views") { 
        "/addresses/input_address"(platform: "/", type: TrackType.View) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map"(platform: "/", type: TrackType.View) {
            context = "MY_ML"
            editing_address = null
        }
    }
    
    test("Addresses - Test the views actions") { 
        "/addresses/input_address/back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the input errors") { 
        "/addresses/input_address/error/name"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/error/zip_code"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = "00"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/street_name"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/street_number"(platform:"/",  type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = "aaa"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/city"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/colony"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/delivery"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/delivery_instructions"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/phone"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = "!*"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/error/map"(platform: "/", type: TrackType.Event) {
            label = "Mové el mapa y ubicá el pin en tu ubicación exacta"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the UX info") { 
        "/addresses/input_address/unknown_zip_code"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/unknown_zip_code_submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/unknown_zip_code_back"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
            written = "sug"
            final_text = "suggested street"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
            written = "123"
            final_text = "12345678"
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/search_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 10.0
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/select_replaced_zip_code"(platform: "/", type: TrackType.Event) {
            count = 2.0
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_map_position"(platform: "/", type: TrackType.Event) {
            suggested = [
                "latitude": "12.12",
                "longitude": "42.42"
            ]
            final_coordinates = [
                "latitude": "12.13",
                "longitude": "42.40"
            ]
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/map/moved_to_my_location"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/location_permission_granted"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/location_permission_requested"(platform: "/", type: TrackType.Event) { }
        "/addresses/input_address/map/complete_loading"(platform: "/", type: TrackType.Event) {
            start_loading = "2021-02-24 12:12:12"
         }
    }
}
