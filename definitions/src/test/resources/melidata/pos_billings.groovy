package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = "mercadopago"

    test("pos billings views") {
        "/pos_billings/billings"(platform: "/", type: TrackType.View) {
          certificate="ACTIVE"
        }
        "/pos_billings/filters"(platform: "/", type: TrackType.View) {}

        "/pos_billings/export"(platform: "/", type: TrackType.View) {
            share_type="download"
            context="billings"
            masive=true
        }

        "/pos_billings/invoice"(platform: "/", type: TrackType.View) {}
    }

    test("pos billings events") {
        "/pos_billings/friction/certificate_warning"(platform: "/", type: TrackType.Event) {}
        "/pos_billings/friction/certificate_expired"(platform: "/", type: TrackType.Event) {}

        "/pos_billings/search"(platform: "/", type: TrackType.Event) {
            creation_start_date="2010-01-16"
            creation_end_date="2010-08-16"
        }

        "/pos_billings/export/confirm"(platform: "/", type: TrackType.Event) {
            share_type="email"
            context="billings"
            masive=true
        }

        "/pos_billings/export/success"(platform: "/", type: TrackType.Event) {
            share_type="email"
            context="invoice"
            masive=false
        }
        "/pos_billings/friction/export"(platform: "/", type: TrackType.Event) {
            share_type="download"
            context="billings"
            masive=true
        }
    }
}
