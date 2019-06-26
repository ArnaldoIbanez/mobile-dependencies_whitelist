import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    "/antenna_recharge_manual_input"(platform: "/mobile", type: TrackType.View) {}
    "/topup_helper" (platform: "/mobile", type:TrackType.View) {}
}