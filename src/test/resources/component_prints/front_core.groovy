package src.test.resources.component_prints
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests
import com.ml.melidata.TrackType

/**************************************************************
 * CONTACT: In case of changes over this file, please send us
 *  a message to our e-mail: front_native_devs@mercadolibre.com
 **************************************************************/

/**************************
 * WALLET HOME TEST TRACKS *
 **************************/

trackTests {

    defaultBusiness = "mercadopago"

    test("Mercadopago Home print") {
        "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
            {banking_v2-balance} = [
                    [
                            component_id: "balance",
                            balance_histogram: 6.0,
                            hidden: false,
                            pending_balance: false
                    ]
            ]
        }
    }

}
