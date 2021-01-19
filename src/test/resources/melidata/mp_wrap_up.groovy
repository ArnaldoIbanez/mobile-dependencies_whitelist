package src.test.resources.melidata

import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = "mercadopago"

    /******************************************
    *  Mercado Pago Wrap Up  *
    ******************************************/

    test("Wrap Up") {
        "/wrap-up/home"(platform: "/", type: TrackType.View) {}
    }

    test("Wrap Up X-Sell click see more") {
        "/wrap-up/home/x-sell/click-see-more" (platform: "/", type: TrackType.Event) {
            productSellName = 'Créditos a tu medida'
            link = 'mercadopago://webview/?url=https%3A%2F%2Fwww.mercadopago.com.ar%2Fcredits%2Fhub%2F%23from%3Dwrap_up_mp%26additional_info%3Dxsell_banner'
        }
    }
}
