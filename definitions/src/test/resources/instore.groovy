import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"
    
    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Instore
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Instore - views") {
        "/instore/scan_qr"(platform: "/mobile", type: TrackType.View) {}
        "/instore/manual_price"(platform: "/mobile", type: TrackType.View) {}
        "/instore/scan_qr/ftu"(platform: "/mobile", type: TrackType.View) {}

        "/instore/waiting"(platform: "/mobile", type: TrackType.View) {}

        "/instore/map"(platform: "/mobile", type: TrackType.View) {}
        "/instore/generic_error"(platform: "/mobile", type: TrackType.View) {
            additional_info = {message="Escanear código QR"
                icon="error"
                description="Solo puedes pagar usando códigos de Mercado Pago"
                message="¿Estas seguro que ese código es para pagar?"
                actions=[{
                             id="try_again"
                             link="meli://mp/scan_qr"
                             label="Intentar nuevamente"
                             type="link"
                         }]}
        }
    }

    test("Instore - events") {

        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "gas_jockey"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "gas_pump"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "gas_clock"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "gastronomy_cashier"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "gastronomy_order"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "generic_cashier"
        }
        "/instore/waiting"(platform: "/mobile", type: TrackType.Event) {
            view = "generic_ticket"
        }
    }

}
