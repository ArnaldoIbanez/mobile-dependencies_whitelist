package src.test.resources.melidata
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType;

trackTests {

    defaultBusiness = "mercadolibre"

    test("Navigation Sections - Mercadolibre") {

        "/navigation_sections/navigation_menu_ml" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/navigation_menu_ml/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "login"
        }

        "/navigation_sections/navigation_menu_mp" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/your_profile" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/your_business" (platform: "/mobile", type: TrackType.View) {}

        "/navigation_sections/navigation_menu_mp/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "your_business"
        }
        "/navigation_sections/your_profile/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "seguridad"
        }
        "/navigation_sections/your_business/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "point"
        }
    }

    defaultBusiness = "mercadopago"

    test("Navigation Sections - MercadoPago") {

        "/navigation_sections/navigation_menu_ml" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/navigation_menu_ml/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "login"
        }

        "/navigation_sections/navigation_menu_mp" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/your_profile" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/your_business" (platform: "/mobile", type: TrackType.View) {}
        "/navigation_sections/your_business_v2" (platform: "/mobile", type: TrackType.View) {}
        
        "/navigation_sections/navigation_menu_mp/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "your_business"
        }
        "/navigation_sections/your_profile/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "seguridad"
        }
        "/navigation_sections/your_business/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "point"
        }
        "/navigation_sections/your_business_v2/tap" (platform: "/mobile", type: TrackType.Event) {
            id = "point"
        }
    }
}