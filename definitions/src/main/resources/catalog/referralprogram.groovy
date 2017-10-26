import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType


tracks {

    //Referral Program - Activation

    "/referral"(platform: "/", isAbstract: true) {}

    "/referral/promoter"(platform: "/", isAbstract: true) {}

    "/referral/promoter/main"(type: TrackType.View) {}

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
