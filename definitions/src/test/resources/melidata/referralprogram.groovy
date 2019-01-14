package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    defaultBusiness = "mercadolibre"


    test("Referral Program tracks") {
        "/referral/promoter/main"(platform: "/", type: TrackType.View) {}

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "email"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "facebook"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "twitter"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "share_link"
            label = "whatsapp"
        }

        "/referral/promoter/main/social"(platform: "/", type: TrackType.Event) {
            action = "copy_link"
        }

        "/referral/promoter/error/self_invite"(platform: "/", type: TrackType.View) {}

        "/referral/promoter/error/activated_user"(platform: "/", type: TrackType.View) {}

        "/referral/referred/main"(platform: "/", type: TrackType.View) {}

        "/referral/referred/error/has_benefit"(platform: "/", type: TrackType.View) {}

        "/referral/referred/congrats/login"(platform: "/mobile", type: TrackType.View) {}

        "/referral/referred/congrats/register"(platform: "/mobile", type: TrackType.View) {}
    }


}
