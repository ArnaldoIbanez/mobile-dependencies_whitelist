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
        "/addresses/input_address/map/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the input errors") { 
        "/addresses/input_address/name"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/zip_code"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = "00"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/street_name"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/street_number"(platform:"/",  type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = "aaa"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/city"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/colony"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/delivery"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/delivery_instructions"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/phone"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = "!*"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error_map"(platform: "/", type: TrackType.Event) {
            label = "Mové el mapa y ubicá el pin en tu ubicación exacta"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the UX info") { 
        "/addresses/input_address/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/dont_know_my_zip_code/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
            written = "sug"
            finalText = "suggested street"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
            written = "123"
            finalText = "12345678"
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
                "latitude": 12.12,
                "longitude": 42.42
            ]
            finalCoordinates = [
                "latitude": 12.13,
                "longitude": 42.40
            ]
            context = "MY_ML"
            editing_address = 12312312312
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
        "/addresses/input_address/map/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the input errors") { 
        "/addresses/input_address/name"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/zip_code"(platform:"/", type: TrackType.Event){
            label = "La cantidad de caracteres ingresados es inválida"
            value = "00"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/street_name"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/street_number"(platform:"/",  type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = "aaa"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/city"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/colony"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/delivery"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/delivery_instructions"(platform:"/", type: TrackType.Event){
            label = "Completa este dato"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/phone"(platform:"/", type: TrackType.Event){
            label = "Ingresar solo valores numéricos"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/additional_info"(platform:"/", type: TrackType.Event){
            label = "Revisa este dato"
            value = "!*"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/error_map"(platform: "/", type: TrackType.Event) {
            label = "Mové el mapa y ubicá el pin en tu ubicación exacta"
            value = ""
            context = "MY_ML"
            editing_address = 12312312312
        }
    }

    test("Addresses - Test the UX info") { 
        "/addresses/input_address/dont_know_my_zip_code"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }        
        "/addresses/input_address/dont_know_my_zip_code/submit"(platform: "/", type: TrackType.Event) {
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_street_name"(platform: "/", type: TrackType.Event) {
            written = "sug"
            finalText = "suggested street"
            context = "MY_ML"
            editing_address = 12312312312
        }
        "/addresses/input_address/select_phone"(platform: "/", type: TrackType.Event) {
            written = "123"
            finalText = "12345678"
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
                "latitude": 12.12,
                "longitude": 42.42
            ]
            finalCoordinates = [
                "latitude": 12.13,
                "longitude": 42.40
            ]
            context = "MY_ML"
            editing_address = 12312312312
        }
    }
}
