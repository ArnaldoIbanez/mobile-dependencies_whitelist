package catalog.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    test("Device Health") {

        "/devices/health/location_risk"(platform: "/mobile", type: TrackType.App) { }

        "/devices/health/location_risk/request"(platform: "/mobile", type: TrackType.App) {
            provider = "incognia"
            event_type = "sign-up"
            identifier = "xxx"
            body = [
                "installation_id": "87618ead-1dc4-487b-bda9-a04bc641540c",
                "account_id": "c0180f084661bdba97ef14d2f4e3a6e4103209d8b8d08bea9e1f603b233c"
            ]
        }
        "/devices/health/location_risk/request"(platform: "/mobile", type: TrackType.App) {
            provider = "incognia"
            event_type = "log-in"
            identifier = "xxx"
            body = [
                "installation_id": "87618ead-1dc4-487b-bda9-a04bc641540c",
                "account_id": "c0180f084661bdba97ef14d2f4e3a6e4103209d8b8d08bea9e1f603b233c"
            ]
        }
        "/devices/health/location_risk/request"(platform: "/mobile", type: TrackType.App) {
            provider = "incognia"
            event_type = "payment"
            identifier = "xxx"
            body = [
                "installation_id": "87618ead-1dc4-487b-bda9-a04bc641540c",
                "account_id": "c0180f084661bdba97ef14d2f4e3a6e4103209d8b8d08bea9e1f603b233c"
            ]
        }
        "/devices/health/location_risk/request"(platform: "/mobile", type: TrackType.App) {
            provider = "incognia"
            event_type = "payment"
            identifier = "1234"
            body = [
                "installation_id": "87618ead-1dc4-487b-bda9-a04bc641540c",
                "account_id": "c0180f084661bdba97ef14d2f4e3a6e4103209d8b8d08bea9e1f603b233c"
            ]
        }

        "/devices/health/location_risk/result"(platform: "/mobile", type: TrackType.App) {
            result = [
                "id": "87618ead-1dc4-487b-bda9-a04bc641540c",
                "risk_assessment": "unknown_risk",
                "device_model": "iPhone12,5",
                "location_permission_enabled": false,
                "location_sensors_enabled": true,
                "probable_root": true,
                "emulator": false,
                "gps_spoofing": true,
                "from_official_store": true,
                "geocode_quality": "good",
                "address_quality": "good",
                "address_match": "street",
                "location_events_near_address": 38,
                "location_events_quantity": 288,
                "device_fraud_reputation": "unknown",
                "known_account": true,
                "request_id": "8afc84a7-f1d4-488d-bd69-36d9a37168b7",
                "distance_to_trusted_location": 21.06295635345013,
                "last_location_ts": "2022-11-01T22:45:53.299Z",
                "sensor_match_type": "gps"
            ]
            identifier = "xxx"
        }

        "/devices/health/location_risk/permissions"(platform: "/mobile", type: TrackType.App) {
            permission_type = "location"
            granted = true
        }
        "/devices/health/location_risk/permissions"(platform: "/mobile", type: TrackType.App) {
            permission_type = "location_background"
            granted = false
        }
        "/devices/health/location_risk/permissions"(platform: "/mobile", type: TrackType.App) {
            permission_type = "location"
            granted = false
        }
        "/devices/health/location_risk/permissions"(platform: "/mobile", type: TrackType.App) {
            permission_type = "location_background"
            granted = true
        }
        
        "/devices/health/location_risk/property_set"(platform: "/mobile", type: TrackType.App) {
            provider = "incognia"
            property_name = "installationID"
            property_value = "my-installtion-id"
        }
    }
}
