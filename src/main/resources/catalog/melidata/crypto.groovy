package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks




tracks
        {
            initiative = "1047"

              //Crypto tracks

            "/crypto/dashboard" (platform: "/mobile", type: TrackType.View) {}

            "/crypto/detail" (platform: "/mobile", type: TrackType.View) {
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
            }

            "/crypto/calculate" (platform: "/mobile", type: TrackType.View) {
              action(type: PropertyType.String, required: true, description: 'the Opration type SELL o BUY')
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
            }

            "/crypto/review" (platform: "/mobile", type: TrackType.View) {
              action(type: PropertyType.String, required: true, description: 'the Opration type SELL o BUY')
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
              amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
            }
            "/crypto/transaction_detail" (platform: "/mobile", type: TrackType.View) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
            }
            "/crypto/transactions_list" (platform: "/mobile", type: TrackType.View) {
              ticker(type: PropertyType.String, required: true, description: 'cryptocurrency abbreviation')
            }
            "/crypto/transaction_summary" (platform: "/mobile", type: TrackType.View) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
            }
            "/crypto/complete_transaction" (platform: "/mobile", type: TrackType.Event) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
              amount(type: PropertyType.Numeric, required: true, description: 'amount of the operation in local currency')
              ticker(type: PropertyType.String, required: true, description: 'cryptocurrency abbreviation')
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
              amount_crypto(type: PropertyType.Numeric, required: true, description: 'amount of the cryptoCurrency')
            }
        }
