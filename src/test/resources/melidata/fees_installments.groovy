package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    // TASAS & PLAZOS //

    test("Main view loads successfully") {
        "/fees_installments/fees/view" (platform: "/", type: TrackType.View) { }
    }

    test("When the view finishes loading with all components") {
        "/fees_installments/fees/success" (platform: "/", type: TrackType.Event) {
            value = [
                [
                    product_id: "test_product_id",
                    payment_methods: [
                        [
                            payment_method_id: "test_payment_method_id",
                            release_options: [
                                [
                                    release_option_id: "test_release_option_id",
                                    values: [
                                        [
                                            installment: "test_installment",
                                            fee: 3.5
                                        ]
                                    ]
                                ]
                            ]
                        ]
                    ]
                ]
            ]
        }
    }

    test("Main view could not be loaded") {
        "/fees_installments/fees/error" (platform: "/", type: TrackType.Event) {
            status = 404
            message = "Error message"
        }
    }

    test("When the user taps the configure button") {
        "/fees_installments/fees/product/configure/action"( platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
        }
    }

    test("When a collaborator taps the configure button but doesn't have access") {
        "/fees_installments/fees/product/configure/disable/tooltip/show" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            tooltip_id = "test_tooltip_id"
        }
    }

    test("When a collaborator who doesn't have access, closeds the tooltip") {
        "/fees_installments/fees/product/configure/disable/tooltip/hide" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            tooltip_id = "test_tooltip_id"
        }
    }

    test("When a collaborator taps the primary action of a tooltip") {
        "/fees_installments/fees/product/configure/disable/tooltip/primary" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            tooltip_id = "test_tooltip_id"
            url = "url"
        }
    }

    test("When a collaborator taps the secondary action of a tooltip") {
        "/fees_installments/fees/product/configure/disable/tooltip/secondary" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            tooltip_id = "test_tooltip_id"
            url = "url"
        }
    }

    test("When the users taps on a footer's FAQ") {
        "/fees_installments/fees/product/footer/action" (platform: "/", type: TrackType.Event) {
            footer_id = "test_footer_id"
            url = "url"
        }
    }

    test("When the user taps on a footer's tooltip") {
        "/fees_installments/fees/product/footer/tooltip/show" (platform: "/", type: TrackType.Event) {
            footer_id = "test_footer_id"
            tooltip_id = "test_tooltip_id"
        }
    }

    test("When the user closes a footer's tooltip") {
        "/fees_installments/fees/product/footer/tooltip/hide" (platform: "/", type: TrackType.Event) {
            footer_id = "test_footer_id"
            tooltip_id = "test_tooltip_id"
        }
    }

    test("When the user taps the primary action of a footer's tooltip") {
        "/fees_installments/fees/product/footer/tooltip/primary" (platform: "/", type: TrackType.Event) {
            footer_id = "test_footer_id"
            tooltip_id = "test_tooltip_id"
            url = "url"
        }
    }

    test("When the user taps the secondary action of a footer's tooltip") {
        "/fees_installments/fees/product/footer/tooltip/secondary" (platform: "/", type: TrackType.Event) {
            footer_id = "test_footer_id"
            tooltip_id = "test_tooltip_id"
            url = "url"
        }
    }

    // TASAS & PLAZOS //
    
    test("Fees screen loads successfully") {
        "/fees_installments/fees_selection/view" (platform: "/", type: TrackType.View) {
            product_id = "test_product_id"
        }
    }

    test("When the fees selection view finishes loading with all components") {
        "/fees_installments/fees_selection/success" (platform: "/", type: TrackType.Event) {
            value = [
                product_id: "test_product_id",
                payment_methods: [
                    [
                        payment_method_id: "test_payment_method_id",
                        release_options: [
                            [
                                release_option_id: "test_release_option_id",
                                values: [
                                    [
                                        installment: "test_installment",
                                        fee: 3.5
                                    ]
                                ]
                            ]
                        ]
                    ]
                ]
            ]
        }
    }

    test("Fees screen could not be loaded") {
        "/fees_installments/fees_selection/error" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            status = 404
            message = "Error message"
        }
    }

    test("When the fees selection view finishes loading after updating") {
        "/fees_installments/fees_selection/update/success" (platform: "/", type: TrackType.Event) {
            value = [
                product_id: "test_product_id",
                payment_methods: [
                    [
                        payment_method_id: "test_payment_method_id",
                        release_options: [
                            [
                                release_option_id: "test_release_option_id",
                                values: [
                                    [
                                        installment: "test_installment",
                                        fee: 3.5
                                    ]
                                ]
                            ]
                        ]
                    ]
                ]
            ]
        }
    }

    test("Update fees selection error") {
        "/fees_installments/fees_selection/update/error" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
            status = 404
            message = "Error message"
        }
    }

    test("When users goes back from fees selection screen") {
        "/fees_installments/fees_selection/back" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
        }
    }

    test("When users taps on cancel button in fees selection screen") {
        "/fees_installments/fees_selection/cancel" (platform: "/", type: TrackType.Event) {
            product_id = "test_product_id"
        }
    }

    // FAQ WEB VIEW //

    test("When the FAQ loads successfully") {
        "/fees_installments/faq/view" (platform: "/", type: TrackType.View) {
            url = "https://google.com"
        }
    }

    test("When the FAQ couldn't be loaded") {
        "/fees_installments/faq/error" (platform: "/", type: TrackType.Event) {
            status = 404
            message = "Error message"
        }
    }

    test("When the user taps on back button") {
        "/fees_installments/faq/back" (platform: "/", type: TrackType.Event) {}
    }
}