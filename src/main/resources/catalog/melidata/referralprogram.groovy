package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    initiative = "1171"

    //Referral Program - Activation

    "/referral"(platform: "/", isAbstract: true) {}

    "/referral/promoter"(platform: "/", isAbstract: true) {}

    "/referral/promoter/main"(type: TrackType.View) {}

    "/referral/promoter/main/social"(type: TrackType.Event) {
        action(required: true,
                values: ["share_link", "copy_link"],
                description: "Type of promoter main page social share button clicked")
        label(required: false,
                values: ["whatsapp", "facebook", "twitter", "email"],
                description: "Type of share_link event")
    }

    "/referral/promoter/error"(platform: "/", isAbstract: true) {}

    "/referral/promoter/error/self_invite"(type: TrackType.View) {}

    "/referral/promoter/error/activated_user"(type: TrackType.View) {}

    "/referral/referred"(platform: "/", isAbstract: true) {}

    "/referral/referred/main"(type: TrackType.View) {}

    "/referral/referred/error"(platform: "/", isAbstract: true) {}

    "/referral/referred/error/has_benefit"(type: TrackType.View) {}

    "/referral/referred/congrats"(platform: "/mobile", isAbstract: true) {}

    "/referral/referred/congrats/login"(platform: "/mobile", type: TrackType.View) {}

    "/referral/referred/congrats/register"(platform: "/mobile", type: TrackType.View) {}

}
