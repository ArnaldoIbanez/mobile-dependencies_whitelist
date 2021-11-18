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

    def banking_action_item_definition = objectSchemaDefinitions {
        component_id(type: PropertyType.String, required: true, description: "Action id")
        content_id(type: PropertyType.String, required: true, description: "Content id")
        position(type: PropertyType.Numeric, required: true, description: "Position")
        enabled(type: PropertyType.Boolean, required: true, description: "Enabled")
    }

    def banking_balance_item_definition = objectSchemaDefinitions {
        component_id(required: true, type: PropertyType.String, description: "Balance id")
        balance_histogram(required: true, type: PropertyType.Numeric, description: "Balance segmentation")
        hidden(required: true, type: PropertyType.Boolean, description: "Balance hidden by user")
        pending_balance(required: true, type: PropertyType.Boolean, description: "Balance pending")
    }

    "/wallet_home/print" (platform: "/mobile", type: TrackType.View) {
        banking_v2%2Dbalance(required: false, type: PropertyType.Map(banking_balance_item_definition), description: "The balance information")
    }
}
