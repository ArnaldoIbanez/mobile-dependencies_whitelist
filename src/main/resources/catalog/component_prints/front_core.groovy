package catalog.component_prints

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**************************************************************
 * CONTACT: In case of changes over this file, please send us
 *  a message to our e-mail: front_native_devs@mercadolibre.com
 **************************************************************/

/********************************
 *   WALLET HOME PRINT TRACKS   *
 ********************************/

tracks {

    def banking_balance_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Balance id")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance segmentation")
        hidden(required: true, type: PropertyType.Boolean, description: "Balance hidden by user")
        pending_balance(required: true, type: PropertyType.Boolean, description: "Balance pending")
    }

    "/wallet_home/prints" (platform: "/mobile") {
        banking_v2-balance(required: false, type: PropertyType.Map(banking_balance_definition), description: "The banking v2 section information")
    }
}
