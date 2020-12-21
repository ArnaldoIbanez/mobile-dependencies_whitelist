package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
tracks
        {
            initiative = "1179"

            propertyDefinitions {
                latitude(required: false, type: PropertyType.String, description: "The latitude of driver at that point")
                longitude(required: false, type: PropertyType.String, description: "The longitude of driver at that point")
            }

            propertyGroups {
                location(latitude, longitude)
            }

            def offers_info_definition = objectSchemaDefinitions {
                offer_price(required: false, type: PropertyType.Numeric, description: "Specifies the offer price")
                facility_id(required: true, type: PropertyType.String, description: "Specifies the offer facility id")
                start_date(required: true, type: PropertyType.String, description: "Specifies the offer start date")
                end_date(required: true, type: PropertyType.String, description: "Specifies the offer end date")
                order_id(required: true, type: PropertyType.String, description: "Specifies the offer id")
            }

            def orders_info_definition = objectSchemaDefinitions {
                order_price(required: false, type: PropertyType.Numeric, description: "Specifies the offer price")
                facility_id(required: true, type: PropertyType.String, description: "Specifies the offer facility id")
                start_date(required: true, type: PropertyType.String, description: "Specifies the offer start date")
                end_date(required: true, type: PropertyType.String, description: "Specifies the offer end date")
                order_id(required: true, type: PropertyType.String, description: "Specifies the offer id")
            }

        //Tracks for Offers Flow in Crowd App

            "/crowd/offers"(platform: "/mobile", type: TrackType.View) {
                location
                offers_info(type: PropertyType.ArrayList(PropertyType.Map(offers_info_definition)), required: true)
            }

            "/crowd/offers/detail"(platform: "/mobile", type: TrackType.View) {
                location
                offers_info(type: PropertyType.ArrayList(PropertyType.Map(offers_info_definition)), required: true)
            }

            "/crowd/offers/detail/map"(platform: "/mobile", type: TrackType.Event) {
                location
                offers_info(type: PropertyType.ArrayList(PropertyType.Map(offers_info_definition)), required: true)
            }

            "/crowd/offers/detail/confirm"(platform: "/mobile", type: TrackType.Event) {
                location
                offers_info(type: PropertyType.ArrayList(PropertyType.Map(offers_info_definition)), required: true)
            }

        //Tracks for Offers Flow in Crowd App

            "/crowd/confirmations"(platform: "/mobile", type: TrackType.View) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/detail"(platform: "/mobile", type: TrackType.View) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/detail/map"(platform: "/mobile", type: TrackType.Event) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/detail/cancel"(platform: "/mobile", type: TrackType.Event) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/detail/cancel_modal"(platform: "/mobile", type: TrackType.View) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/cancellation/reasons"(platform: "/mobile", type: TrackType.View) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
            }

            "/crowd/confirmations/cancellation/reasons/cancel"(platform: "/mobile", type: TrackType.Event) {
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: true)
                reason(required: true, type: PropertyType.String, description: "Specifies the cancellation reason")
            }
        }

