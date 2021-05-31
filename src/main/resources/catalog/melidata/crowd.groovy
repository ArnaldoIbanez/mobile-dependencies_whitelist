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

            def weekly_detail_definition = objectSchemaDefinitions {
                preinvoice_id(required: true, type: PropertyType.String, description: "The id of the pre invoice")
                preinvoice_status(required: true, type: PropertyType.String, description: "The status of the pre invoice")
                period(required: true, type: PropertyType.String, description: "The period of the pre invoice")
                type(required: true, type: PropertyType.String,
                        values: ["regular", "complementary", "unused_vehicle"],
                        description: "The type of the pre invoice")
            }

            def daily_detail_definition = objectSchemaDefinitions {
                preinvoice_id(required: true, type: PropertyType.String, description: "The id of the pre invoice")
                preinvoice_status(required: true, type: PropertyType.String, description: "The status of the pre invoice")
                date(required: true, type: PropertyType.String, description: "The day of the detail")
            }

            def pagination_metadata_definition = objectSchemaDefinitions {
                offset(required: true, type: PropertyType.Numeric, description: "The offset of the pagination")
                limit(required: true, type: PropertyType.Numeric, description: "The limit of the pagination")
                count(required: true, type: PropertyType.Numeric, description: "The count of the pagination")
                latest_visible_period(required: true, type: PropertyType.String, description: "The latest visible period of the pagination")
            }

            //Tracks for Offers Flow in Crowd App

            "/crowd/offers"(platform: "/mobile", type: TrackType.View) {
                location
                offers_info(type: PropertyType.ArrayList(PropertyType.Map(offers_info_definition)), required: true)
            }

            "/crowd/offers/not_available_detail"(platform: "/mobile", type: TrackType.View, parentPropertiesInherited: false) {
                location
                offer_id(type: PropertyType.String, required: true)
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

            //Tracks for login flow in crowd app

            "/crowd/login/result"(platform: "/mobile", type: TrackType.View) {
                location
                type(required: true, type: PropertyType.String, description: "Specifies driver status pending/disabled/unknown")
            }

            "/crowd/login/success"(platform: "/mobile", type: TrackType.Event) {
                location
                type(required: true, type: PropertyType.String, description: "Specifies driver status active/inactive")
            }

            "/crowd/login/join"(platform: "/mobile", type: TrackType.Event) {
                location
            }

            "/crowd/login/already_registered"(platform: "/mobile", type: TrackType.Event) {
                location
            }

            "/crowd/login/faq"(platform: "/mobile", type: TrackType.Event) {
                location
            }

            "/crowd/login/requirements"(platform: "/mobile", type: TrackType.Event) {
                location
            }

            //Tracks for next_trip flow in crowd app

            "/crowd/next_trip"(platform: "/mobile", type: TrackType.View) {
                vehicle_id(required: false, type: PropertyType.String, description: "Specifies the current vehicle id")
                location
                orders_info(type: PropertyType.ArrayList(PropertyType.Map(orders_info_definition)), required: false)
            }

            "/crowd/next_trip/checkin_in"(platform: "/mobile", type: TrackType.Event) {
                vehicle_id(required: true, type: PropertyType.String, description: "Specifies the current vehicle id")
            }

            "/crowd/next_trip/map"(platform: "/mobile", type: TrackType.Event) {
                vehicle_id(required: true, type: PropertyType.String, description: "Specifies the current vehicle id")
            }

            //Tracks lib flux
            "/flux-client/list-shipments/geofence/mock"(platform: "/mobile", type: TrackType.Event) {
                user_id(required: true, type: PropertyType.String, description: "Specifies the current vehicle id")
            }

            /// EARNING FLOW TRACKS

            "/crowd/earning_history/hub"(platform: "/mobile", type: TrackType.View) {
                location
            }

            "/crowd/earning_history/hub/paginate"(platform: "/mobile", type: TrackType.Event) {
                location
                pagination_metadata(type: PropertyType.Map(pagination_metadata_definition), required: true)
            }

            "/crowd/earning_history/hub/daily_detail"(platform: "/mobile", type: TrackType.View) {
                location
                daily_detail(type: PropertyType.Map(daily_detail_definition), required: true)
            }

            "/crowd/earning_history/hub/daily_detail/tooltip"(platform: "/mobile", type: TrackType.Event) {
                location
                daily_detail(type: PropertyType.Map(daily_detail_definition), required: true)
            }

            "/crowd/earning_history/hub/daily_detail/help"(platform: "/mobile", type: TrackType.Event) {
                location
                daily_detail(type: PropertyType.Map(daily_detail_definition), required: true)
            }

            "/crowd/earning_history/weekly_detail"(platform: "/mobile", type: TrackType.View) {
                location
                weekly_detail(type: PropertyType.Map(weekly_detail_definition), required: true)
            }

            "/crowd/earning_history/weekly_detail/invoice/tap"(platform: "/mobile", type: TrackType.Event) {
                location
                weekly_detail(type: PropertyType.Map(weekly_detail_definition), required: true)
            }

            "/crowd/earning_history/weekly_detail/payment/tap"(platform: "/mobile", type: TrackType.Event) {
                location
                weekly_detail(type: PropertyType.Map(weekly_detail_definition), required: true)
            }

            "/crowd/earning_history/weekly_detail/help"(platform: "/mobile", type: TrackType.Event) {
                location
                weekly_detail(type: PropertyType.Map(weekly_detail_definition), required: true)
            }

            "/crowd/earning_history/weekly_detail/tooltip"(platform: "/mobile", type: TrackType.Event) {
                location
                weekly_detail(type: PropertyType.Map(weekly_detail_definition), required: true)
            }

        }
