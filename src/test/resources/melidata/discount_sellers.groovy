package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // *******************************************************
    // ******************** Events - Form ********************
    // *******************************************************

    test("Mercadopago discount sellers form open") {
        "/discount_sellers/form/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            origin = "push"
        }
    }

    test("Mercadopago discount sellers form view") {
        "/discount_sellers/form" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            form_model = "{modelo}"
            mcc = "1234"
            melicapaign_id = "1"
            origin = "push"
            clone_campaign_id = "1"
            tooltip = "Budget"
        }
    }

    test("Mercadopago discount sellers form redirect") {
        "/discount_sellers/form/redirect" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            melicampaign_id = "1"
            redirection_to = "landing"
        }
    }

    test("Mercadopago discount sellers form section change") {
        "/discount_sellers/form/section/change" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            section = "coupon_caps"
            section_output = "{modelo}"
        }
    }

    test("Mercadopago discount sellers form section open") {
        "/discount_sellers/form/section/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            modal = "{modelo}"
        }
    }

    test("Mercadopago discount sellers form section close") {
        "/discount_sellers/form/section/close" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            modal = "{modelo}"
        }
    }

    test("Mercadopago discount sellers form section friction") {
        "/discount_sellers/form/section/friction" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            section = "coupon_caps"
            description = "description"
        }
    }

    test("Mercadopago discount sellers form error") {
        "/discount_sellers/form/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            description = "description"
        }
    }
    
    test("Mercadopago discount sellers form error") {
        "/discount_sellers/form/modal_confirm/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            type = "amount"
            description = "description"
        }
    }
    
    test("Mercadopago discount sellers form error") {
        "/discount_sellers/form/modal_confirm/close" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            type = "amount"
            description = "description"
        }
    }

    test("Mercadopago discount sellers form create") {
        "/discount_sellers/form/create" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            form_output = "{modelo}"
        }
    }

    test("Mercadopago discount sellers form back") {
        "/discount_sellers/form/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    test("Mercadopago discount sellers form result success") {
        "/discount_sellers/form/result/success" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            campaign_id = "1"
        }
    }

    test("Mercadopago discount sellers form result pending") {
        "/discount_sellers/form/result/pending" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            campaign_id = "1"
        }
    }

    test("Mercadopago discount sellers form result rejected") {
        "/discount_sellers/form/result/rejected" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    // **********************************************************
    // ******************** Events - History ********************
    // **********************************************************

    test("Mercadopago discount sellers history open") {
        "/discount_sellers/history/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    test("Mercadopago discount sellers history view sin banner de moderacion") {
        "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            campaigns = "{modelo}"
        }
    }
    
    test("Mercadopago discount sellers history view con banner de moderacion") {
        "/discount_sellers/history" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            campaigns = "{modelo}"
            moderation = "{modelo}"
        }
    }

    test("Mercadopago discount sellers history redirect") {
        "/discount_sellers/history/redirect" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            redirection_to = "landing"
        }
    }

    test("Mercadopago discount sellers history tap") {
        "/discount_sellers/history/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            campaign_id = "1"
            target = "card"
            title = "Title"
        }
    }

    test("Mercadopago discount sellers history main action") {
        "/discount_sellers/history/main_action" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            title = "Title"
        }
    }

    test("Mercadopago discount sellers history error") {
        "/discount_sellers/history/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            description = "description"
        }
    }

    test("Mercadopago discount sellers history back") {
        "/discount_sellers/history/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    // *********************************************************
    // ******************** Events - Detail ********************
    // *********************************************************

    test("Mercadopago discount sellers detail open") {
        "/discount_sellers/detail/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    test("Mercadopago discount sellers detail view") {
        "/discount_sellers/detail" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            campaign_id = "1"
            status = "en curso"
            budget_total = "1000"
            budget_used = "100"
            payments = "2"
            payed_amount = "1"
            main_action_title = "Title"
            quick_actions = "{modelo}"
        }
    }

    test("Mercadopago discount sellers detail tap") {
        "/discount_sellers/detail/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            target = "quick_action"
            title = "Pausar"
        }
    }

    test("Mercadopago discount sellers detail modal open") {
        "/discount_sellers/detail/modal/open" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            type = "pause"
        }
    }

    test("Mercadopago discount sellers detail modal close") {
        "/discount_sellers/detail/modal/close" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            type = "pause"
        }
    }

    test("Mercadopago discount sellers detail modal confirm") {
        "/discount_sellers/detail/modal/confirm" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            type = "pause"
        }
    }

    test("Mercadopago discount sellers detail error") {
        "/discount_sellers/detail/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            description = "description"
        }
    }

    test("Mercadopago discount sellers detail back") {
        "/discount_sellers/detail/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }

    // **********************************************************
    // ******************** Events - Landing ********************
    // **********************************************************

    test("Mercadopago discount sellers landing view") {
        "/discount_sellers/landing" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            landing_id = "ftu"
        }
    }

    test("Mercadopago discount sellers landing tap") {
        "/discount_sellers/landing/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            title = "Title"
        }
    }
    
    test("Mercadopago discount sellers landing back") {
        "/discount_sellers/landing/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }
    
    // **********************************************************
    // ******************** Events - Congrats *******************
    // **********************************************************
    
    test("Mercadopago discount sellers congrats view") {
        "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            status = "pending"
        }
    }
    
    test("Mercadopago discount sellers congrats tap") {
        "/discount_sellers/congrats/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            title = "Title"
        }
    }
    
    test("Mercadopago discount sellers congrats close") {
        "/discount_sellers/congrats/close" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }
}
