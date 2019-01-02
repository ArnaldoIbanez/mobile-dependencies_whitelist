import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Map testing") {
        "/mapTesting"(platform: "/", type: TrackType.View) {
            result_type = [
                    result_status : "321421",
                    money: 200
            ]

            result_type_double_map = [
                    result_map : [result_status: "432321", money: 200],
                    money: 200
            ]

        }

        "/mapTesting/subdir"(platform: "/", type: TrackType.View) {
            result_type = [
                    result_status : "321421",
                    money: 200
            ]

            result_type_double_map = [
                    result_map : [result_status: "432321", money: 200],
                    money: 200
            ]

        }

        "/mapTesting/websubdir"(platform: "/web", type: TrackType.View) {
            result_type = [
                    result_status : "321421",
                    money: 200
            ]

            result_type_double_map = [
                    result_map : [result_status: "432321", money: 200],
                    money: 200
            ]

        }
    }
}
