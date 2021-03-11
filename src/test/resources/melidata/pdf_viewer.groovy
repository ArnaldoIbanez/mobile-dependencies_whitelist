package melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadopago"

    test("PDF Viewer") {

        def mandatory = {
            flow = "no_flow"
        }

        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Mercado Pago
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // PDF Visualization
        "/pdf_viewer"(platform: "/mobile", type: TrackType.View) {
            mandatory()
        }

        // Back
        "/pdf_viewer/back"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }

        // Share
        "/pdf_viewer/share"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }

        // Error
        "/pdf_viewer/show_error"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }

        // Retry
        "/pdf_viewer/retry"(platform: "/mobile", type: TrackType.Event) {
            mandatory()
        }


        //------------------------------------------------------------------------------------------------------------------------------------------------------
        // TRACKS Meli
        //------------------------------------------------------------------------------------------------------------------------------------------------------

        // PDF Visualization
        "/pdf_viewer"(platform: "/mobile", business: "mercadolibre", type: TrackType.View) {
            mandatory()
        }

        // Back
        "/pdf_viewer/back"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }

        // Share
        "/pdf_viewer/share"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }

        // Error
        "/pdf_viewer/show_error"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }

        // Retry
        "/pdf_viewer/retry"(platform: "/mobile", business: "mercadolibre", type: TrackType.Event) {
            mandatory()
        }
    }
}

