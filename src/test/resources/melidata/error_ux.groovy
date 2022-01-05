package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"

    //------------------------------------------------------------------------------------------------------------------------------------------------------
    // TRACKS Error UX
    //------------------------------------------------------------------------------------------------------------------------------------------------------

    test("Error UX tracks - ML") {

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            screen = "VipActivity"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            screen = "VipActivity"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
            screen = "VipActivity"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            visual_type = "full_screen"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            screen = "VipActivity"
            visual_type = "snackbar"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
            screen = "VipActivity"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            screen = "VipActivity"
            visual_type = "snackbar"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            visual_type = "snackbar"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
        }
    }

    defaultBusiness = "mercadopago"

    test("Error UX tracks - MP") {

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            screen = "VipActivity"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            screen = "VipActivity"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
            screen = "VipActivity"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            visual_type = "full_screen"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "full_screen"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            screen = "VipActivity"
            visual_type = "snackbar"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
            screen = "VipActivity"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            screen = "VipActivity"
            visual_type = "snackbar"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
            detail = "java.lang.NullPointerException: Attempt to invoke virtual method 'void java.util.Calendar.add(int, int)' on a null object reference"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            number = "01"
            visual_type = "snackbar"
        }

        "/error/generic"(platform: "/mobile", type: TrackType.View) {
            team = "VIP"
            id = "128hdg57hf6"
            visual_type = "snackbar"
        }
    }
}
