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
    
    test("Mercadopago discount sellers congrats success view") {
        "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            status = "success"
        }
    }
    
    test("Mercadopago discount sellers congrats pending view") {
        "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            status = "pending"
        }
    }
    
    test("Mercadopago discount sellers congrats rejected view") {
        "/discount_sellers/congrats" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            status = "rejected"
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
    
    // **********************************************************
    // ******************** Events - FTU ************************
    // **********************************************************
    
    test("Mercadopago discount sellers FTU view with URL") {
        "/discount_sellers/ftu" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
            url = "some url"
        }
    }
    
    test("Mercadopago discount sellers FTU view without URL") {
        "/discount_sellers/ftu" (platform: "/mobile", type: TrackType.View) {
            session_id = "1"
        }
    }
    
    test("Mercadopago discount sellers ftu tap") {
        "/discount_sellers/ftu/tap" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            title = "Title"
        }
    }
    
    test("Mercadopago discount sellers ftu back") {
        "/discount_sellers/ftu/back" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
        }
    }
    
    test("Mercadopago discount sellers ftu error") {
        "/discount_sellers/ftu/error" (platform: "/mobile", type: TrackType.Event) {
            session_id = "1"
            description = "error description"
        }
    }

    // Prefecture
    test('Prefecture stores click'){
        "/instore/prefecture/tap"(platform: "/", type: TrackType.Event) {
            link = "stores"
        }
    }

    test('Prefecture go home error click'){
        "/instore/prefecture/error/tap"(platform: "/", type: TrackType.Event) {
            link = "go_home"
        }
    }    

    test("Prefecture") {
        "/instore/prefecture"(platform: "/", type: TrackType.View) {}

    }

    test('Prefecture error view'){
        "/instore/prefecture/error"(platform: "/", type: TrackType.View) {}
    }
 
     // INSTORE NEW HOME DISCOUNTS SELLERS

 
    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Home") {
        "/discount_sellers/v2/home"(platform: "/", type: TrackType.View) {
            session_id= "qowejqboej1b11klasdsjal"
            segments = [
                "featured_campaign",
                "template_campaigns",
                "personalized_campaign",
                "how_to",
            ] 
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Segment Your campaigns") {
        "/discount_sellers/v2/home/segment"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "list"
            segment_id = "your_campaigns"
            position = 0
            segment_data = [
                components= [
                    [
                        component_id = "100524",
                        status = "PAUSED",
                        budget_total = 2000,
                        budget_used = 1000,
                    ],
                    [
                        component_id = "15_OFF_SATURDAY",
                        status = "INACTIVE",
                    ],
                    [
                        component_id = "20_OFF_HAPPY_HOUR",
                        status = "ACTIVE",
                    ]            
                ]
            ]
            see_more = true
        }
    }
   
    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Segment campaigns one click") {
        "/discount_sellers/v2/home/segment"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "list"
            segment_id = "template_campaigns"
            position = 1
            segment_data = [
                components= [
                    [
                        component_id = "100524"
                    ],
                    [
                        component_id = "15_OFF_SATURDAY"
                    ],
                    [
                        component_id = "20_OFF_HAPPY_HOUR",
                    ]            
                ]
            ]
            see_more = false
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Segment: Moderacion") {
        "/discount_sellers/v2/home/segment"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "modal"
            segment_id = "moderation"
            position = 0
            segment_data = [
                components  = [
                    [
                        data_id = "modify"
                    ]
                ]
            ] 
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Segment: Create campaign") {
        "/discount_sellers/v2/home/segment"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "button"
            segment_id = "personalized_campaign"
            position = 3 
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers Error > segment
    test("Home sellers - Segment: Melicampaign") {
        "/discount_sellers/v2/home/segment"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "banner"
            segment_id = "featured_campaign"
            position = 3
        }
    }
    test("Home sellers -Home Tap") {
        "/discount_sellers/v2/home/tap"(platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            drawing_type = "list"
            segment_id = "featured_campaign"
            position = 3
            component = [
                component_id = "213219",
                position = 1
            ]
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers Detail "Active" > Pageview
    test("Home sellers - Detail") {
        "/discount_sellers/v2/detail" (platform: "/", type: TrackType.View) {
            session_id= "qowejqboej1b11klasdsjal"
            campaign_id = "432682"
            status = "ACTIVE"
            payments = "123"
            budget_total = "1500"
            payed_amount = "421"
            budget_used = "12"
            actions = ["pause","finish"]
        }
    }
     // Instore (ISDT) - Webview -  Home Sellers Detail "Active" > tap
    test("Home sellers - Detail - tap") {
        "/discount_sellers/v2/detail/tap" (platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            campaign_id = "432682"
            status = "ACTIVE"
            payments = "123"
            budget_total = "1500"
            payed_amount = "421"
            budget_used = "12"
            action = "repeat"
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers History > Pageview
    test("Home sellers - history") {
        "/discount_sellers/v2/history" (platform: "/", type: TrackType.View) {
            session_id= "qowejqboej1b11klasdsjal"
            campaigns = [
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "ACTIVE"
                ],
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "INACTIVE"
                ],
            ]
        }
    }   
    // Instore (ISDT) - Webview -  Home Sellers History > tap
    test("Home sellers - History - tap") {
        "/discount_sellers/v2/history/tap" (platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            component_id = "100524"
            position = 3
            budget_total = 2000
            budget_used = 1000
            status = "ACTIVE"           
            payed_amount = 6235
            payments = 65
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers History > filter
    test("Home sellers - History - filter") {
        "/discount_sellers/v2/history/filter" (platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            campaigns = [
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "ACTIVE"
                ],
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "INACTIVE"
                ],
            ]
            active_filters = ['ONGOING'] 
            filter_selected = "PAUSED"
            is_selected = false

        }
    }
    // Instore (ISDT) - Webview -  Home Sellers History > scroll
    test("Home sellers - History - scroll") {
        "/discount_sellers/v2/history/scroll" (platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            campaigns = [
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "ACTIVE"
                ],
                [
                    component_id = "30013420",
                    payments = 342,
                    payed_amount = 1230,
                    budget_used = 1000,
                    budget_total = 1230,
                    status = "INACTIVE"
                ],
            ]
            active_filters = ['ONGOING'] 
            page = 2
            

        }
    }
    // Instore (ISDT) - Webview -  Home Sellers error > Pageview
    test("Home sellers - error") {
        "/discount_sellers/v2/error" (platform: "/", type: TrackType.View) {
            session_id= "qowejqboej1b11klasdsjal"
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers History > tap
    test("Home sellers - error - tap") {
        "/discount_sellers/v2/error/tap" (platform: "/", type: TrackType.Event) {
            session_id= "qowejqboej1b11klasdsjal"
            link = "go_home"  
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers template-details > Pageview
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details" (platform: "/", type: TrackType.View) {
            session_id= "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"  
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers template-details > tap
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details/tap" (platform: "/", type: TrackType.Event) {
            session_id = "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"
            action = "TyC"
        }
    }

    // Instore (ISDT) - Webview -  Home Sellers template-details > tap
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details/congrats" (platform: "/", type: TrackType.Event) {
            session_id = "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"
            campaign_id = "672315"
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers template-details > congrats > tap
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details/congrats" (platform: "/", type: TrackType.Event) {
            session_id = "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"
            campaign_id = 672315
            result = "success"
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers template-details > congrats > tap
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details/congrats" (platform: "/", type: TrackType.Event) {
            session_id = "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"
            result = "fail"
        }
    }
    // Instore (ISDT) - Webview -  Home Sellers template-details > congrats > tap
    test("Home sellers - template-details") {
        "/discount_sellers/v2/template-details/congrats/tap" (platform: "/", type: TrackType.Event) {
            session_id = "qowejqboej1b11klasdsjal"
            template_id = "default_template_MLA"
            campaign_id = 672315
            action = "admin"
        }
    }




}