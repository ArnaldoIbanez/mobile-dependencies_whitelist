package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("vis credits flow") {
        def mandatory = {
            bank = "votorantim"
            category_id = "MLB1744"
            category_path = ["MLB1743", "MLB1744"]
            item_id = "MLB1445621120"
            seller_id = 167086843
            vertical = "motors"
        }

        def optionals = {
            city = "Santo André"
            domain_id = "MLB-CARS_AND_VANS"
            flow_type = "INVALID"
            map_item_attributes = [
                    [ attribute_id:"BRAND", value_id:"60297", value_name:"Toyota"],
                    [ attribute_id:"MODEL", value_id:"60337", value_name:"Yaris" ],
                    [ attribute_id:"YEAR", value_name:"2012"]
            ]
            item_condition = "new"
            item_seller_type = "car_dealer"
        }

        "/vis_credits/pre_analysis"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/simulator"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/simulation_details"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/application_form/step_1"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/application_form/step_2"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/application_form/step_3"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/application_form/step_4"(platform: "/", type: TrackType.View) {
            mandatory()
            optionals()
        }

        "/vis_credits/congrats"(platform: "/", type: TrackType.View) {
            congrats_status = "APPROVED"
            context = "high_score"
            mandatory()
            optionals()
        }

        "/vis_credits/not_found"(platform: "/", type: TrackType.View) {
            error = "Page not found"
            mandatory()
            optionals()
        }

        "/vis_credits/error"(platform: "/", type: TrackType.View) {
            error = "Error 500"
            mandatory()
            optionals()
        }

    }

}
