package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    ["mercadolibre", "mercadopago"].each { business ->
		defaultBusiness = business
		test("MGM ${business} tests") {

            /*************************
            * MGM PAYER TRACKS v2  *
            *************************/

            // MOBILE
            // Access MGM flow
            "/mgm/payers/init"(platform: "/mobile", type: TrackType.Event) {
                origin = "row"
            }

            // Invite Screen
            "/mgm/payers/invite"(platform: "/mobile", type: TrackType.View) {
                promoter = "promoter_id"
            }

            // Invite Screen Events
            "/mgm/payers/invite/invite"(platform: "/mobile", type: TrackType.Event) {
                media = "whatsapp"
                promoter = "promoter_id"
            }
            "/mgm/payers/invite/back"(platform: "/mobile", type: TrackType.Event) {
                promoter = "promoter_id"
            }
            "/mgm/payers/invite/terms"(platform: "/mobile", type: TrackType.Event) {
                promoter = "promoter_id"
            }

            // Redeem Screen
            "/mgm/payers/redeem"(platform: "/mobile", type: TrackType.View) {
                promoter = "promoter_id"
            }
            "/mgm/payers/redeem/option"(platform: "/mobile", type: TrackType.Event) {
                option = "cellphone_recharge"
                type = "use_coupon"
                promoter = "promoter_id"
            }
            "/mgm/payers/redeem/terms"(platform: "/mobile", type: TrackType.Event) {
                promoter = "promoter_id"
            }

            // No Redeem Screen
            "/mgm/payers/no_redeem"(platform: "/mobile", type: TrackType.View) {}

            // No Redeem Screen Events
            "/mgm/payers/no_redeem/invite"(platform: "/mobile", type: TrackType.Event) {
                media = "whatsapp"
            }
            "/mgm/payers/no_redeem/back"(platform: "/mobile", type: TrackType.Event) {}
            "/mgm/payers/no_redeem/terms"(platform: "/mobile", type: TrackType.Event) {}

            // WEB
            "/mgm/payers/stop_landing"(platform: "/web", type: TrackType.View) {
                promoter = "promoter_id"
            }
            "/mgm/payers/stop_landing/redirect"(platform: "/web", type: TrackType.Event) {
                promoter = "promoter_id"
            }
            "/mgm/payers/stop_landing"(platform: "/web", type: TrackType.View) {}
            "/mgm/payers/stop_landing/redirect"(platform: "/web", type: TrackType.Event) {}

            /*************************
            * MGM SELLER TRACKS *
            *************************/

            "/mgm_seller/referal" (platform: "/mobile", type: TrackType.View) {}
            "/mgm_seller/dashboard" (platform: "/mobile", type: TrackType.View) {}

            "/mgm_seller/referal/tap" (platform: "/mobile", type: TrackType.Event) {
                media = "whatsapp"
                device= "Point Mini"
                link= "dashboard"
            }

            "/mgm_seller/referal/swipe" (platform: "/mobile", type: TrackType.Event) {}

            /*************************
            * MGM TRACKS v3  *
            *************************/

            "/mgm/v3/promoter"(platform: "/mobile", type: TrackType.View) {
                program_id = "program_id"
                is_recurrent = true
                floating_banner_id = "floating_banner_id"
                sections = [
                    [ 
                        order: 0,
                        section_id: "section_id" 
                    ],
                    [
                        order: 1,
                        section_id: "section_id" 
                    ]
                ]
                from = "modals_engine"
            }

            "/mgm/v3/promoter/share/tap"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    is_recurrent = true
                    action_id = "action_id"
                    shared_app_id = "shared_app_id"
                    from = "modals_engine"
            }

            "/mgm/v3/promoter/banner/tap"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    is_recurrent = true
                    target_program = "mgm_point"
                    from = "modals_engine"
            }    

            "/mgm/v3/promoter/floating_banner/dismiss"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    is_recurrent = true
                    banner_id = "banner_id"
                    from = "modals_engine"
            }

            "/mgm/v3/guest"(platform: "/mobile", type: TrackType.View) {
                    program_id = "program_id"
                    sections = [
                        [ 
                            order: 0,
                            section_id: "section_id" 
                        ],
                        [
                            order: 1,
                            section_id: "section_id" 
                        ]
                    ]
                    from = "modals_engine"
            }

            "/mgm/v3/guest/cross_selling/tap"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    action_id = "action_id"
                    from = "modals_engine"
            }

            "/mgm/v3/guest/main_action/tap"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    action_id = "action_id"
                    from = "modals_engine"
            }

            "/mgm/v3/error"(platform: "/mobile", type: TrackType.View) {
                    program_id = "program_id"
                    reason = "kyc_invitado"
            }

            "/mgm/v3/error/dismiss"(platform: "/mobile", type: TrackType.Event) {
                    program_id = "program_id"
                    reason = "kyc_invitado"
            }

            "/mgm/v3/error/tap"(platform: "/mobile", type: TrackType.Event) {
                    cta = "quiet"
                    program_id = "program_id"
                    link = "meli://coupon"
                    reason = "kyc_invitado"
            }
        }
    }
}
