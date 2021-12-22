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
              operation(type: PropertyType.String, required: true, description: 'the Opration type SELL o BUY', values: ["SELL", "BUY"])
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
            }

            "/crypto/review" (platform: "/mobile", type: TrackType.View) {
              operation(type: PropertyType.String, required: true, description: 'the Opration type SELL o BUY', values: ["SELL", "BUY"])
              market(type: PropertyType.String, required: true, description: 'the market of the cryptoCurrency')
              amount(type: PropertyType.Numeric, required: true, description: 'Amount of the operation in local currency')
            }
            "/crypto/transaction/detail" (platform: "/mobile", type: TrackType.View) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
            }
            "/crypto/transaction/list" (platform: "/mobile", type: TrackType.View) {
              ticker(type: PropertyType.String, required: true, description: 'cryptocurrency abbreviation')
            }
            "/crypto/transaction/summary" (platform: "/mobile", type: TrackType.View) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
            }
            "/crypto/transaction/complete" (platform: "/mobile", type: TrackType.Event) {
              id(type: PropertyType.String, required: true, description: 'transaction identifier')
              ticker(type: PropertyType.String, required: true, description: 'cryptocurrency abbreviation')
              operation(type: PropertyType.String, required: true, description: 'the Opration type SELL o BUY', values: ["SELL", "BUY"])
              local_currency(type: PropertyType.String, required: true, description: 'Local currency')
              state(type: PropertyType.String, required: true, description: 'state of transaction', values: ["SUCCESS", "ERROR"])
            }
            "/crypto/onboarding" (platform: "/mobile", type: TrackType.View) {
              connection_type(type: PropertyType.String, required: false, description: 'Defines the type of connection the user is using')
              registration_type(type: PropertyType.String, required: false, description: 'Defines how the user was registered')
              user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
            }
            "/crypto/load_error" (platform: "/mobile", type: TrackType.View) {
              connection_type(type: PropertyType.String, required: false, description: 'Defines the type of connection the user is using')
              registration_type(type: PropertyType.String, required: false, description: 'Defines how the user was registered')
              user_profile(type: PropertyType.String, required: false, description: 'Profile of user')
              errors(type: PropertyType.String, required: false, description: 'Type of error', values: ["no_internet_connection", "not_available_on_country", "no_site_connection","cant_show_data"])
            }

            "/crypto/educational" (platform: "/", type: TrackType.View) {
                crypto(required: false, type: PropertyType.String, description: "Currency")
            }
        }
