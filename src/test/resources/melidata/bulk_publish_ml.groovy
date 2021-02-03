package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    test("seller central bulk publish hub view") {
        "/seller_central/bulk/publish/hub"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish categories view") {
        "/seller_central/bulk/publish/categories"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish upload view") {
        "/seller_central/bulk/publish/upload"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish show email") {
        "/seller_central/bulk/publish/upload/show_custom_mail_box"(platform: "/web", type: TrackType.Event) {
            show_custom_mail_box = true
        }
    }

    test("seller central bulk publish send custom email") {
        "/seller_central/bulk/publish/upload/send_custom_mail_box"(platform: "/web", type: TrackType.Event) {
            show_custom_mail_box = true
            custom_mail = false
            invalid_mail = false
        }
    }

    test("seller central bulk publish download congrats view") {
        "/seller_central/bulk/publish/download/congrats"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish upload congrats view") {
        "/seller_central/bulk/publish/upload/congrats"(platform: "/web", type: TrackType.View) {}
    }

    test("seller central bulk publish download categories event") {
        "/seller_central/bulk/publish/categories/download_excel"(platform: "/web", type: TrackType.Event) {
            total = 10
            last_published = 5
            most_used = 1
            search_list = 4
            modal = 0
        }
    }

    test("seller central bulk publish show adults modal") {
        "/seller_central/bulk/publish/categories/adult/modal/show"(platform: "/web", type: TrackType.View) {
            adult = false
        }
    }

    test("seller central bulk publish cancel adults modal") {
        "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
            action = "cancel"
            adult = false
        }
    }

    test("seller central bulk publish confirm adults modal") {
        "/seller_central/bulk/publish/categories/adult/modal"(platform: "/web", type: TrackType.Event) {
            action = "confirm"
            adult = false
        }
    }

    test("seller central bulk publish confirm adult task") {
        "/seller_central/bulk/publish/categories/adult/confirm"(platform: "/web", type: TrackType.Event) {
            adult = true
        }
    }

    test("seller central bulk publish catalog_task show") {
        "/seller_central/bulk/publish/categories/catalog_task/show"(platform: "/web", type: TrackType.Event) {}
    }

    test("seller central bulk publish categories tab selection") {
        "/seller_central/bulk/publish/categories/tab_selection"(platform: "/web", type: TrackType.Event) {
            tab = "categories"
        }
    }

    test("seller central bulk publish upload email congrats") {
        "/seller_central/bulk/publish/upload/email/congrats"(platform: "/web", type: TrackType.Event) {}
    }
}
