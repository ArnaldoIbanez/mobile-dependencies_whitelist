package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("classifieds credits flow") {
        def properties = {
            vertical = "motors"
            seller_id = 167086843
            item_id = "MLA792156560"
            category_id = "MLA43718"
            buyer_id = 177056843
            bank = "santander"
            congrats_status = "APPROVED"
            category_path = ["MLB1743", "MLB1744"]
        }

        "/classi_credits/pre_analysis"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/simulator"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

         "/classi_credits/simulation_details"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/application_form/step_1"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/application_form/step_2"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/application_form/step_3"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/application_form/step_4"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/evaluation/congrats"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/evaluation/reject"(platform: "/web/mobile", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/birth_city"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/birth_nationality"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/issuer_entity"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/issuer_state"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/birth_state"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/address_city"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/address_state"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/address_country"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/modal_fullscreen/occupation"(platform: "/", type: TrackType.View) {
            properties()
        }

        "/classi_credits/container_congrats"(platform: "/", type: TrackType.View) {
            properties()
        }

    }

}
