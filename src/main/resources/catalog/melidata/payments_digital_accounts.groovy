package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.TrackType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1238"

    /******************************************
    *  Payments - Digital Accounts - Banking  *
    ******************************************/

    // MP Banking
    "/banking"(platform: "/", isAbstract: true) {}

    // Balance
    "/banking/balance"(platform: "/", type: TrackType.View) {}
    "/banking/calendar"(platform: "/", type: TrackType.View) {}
    "/banking/activities"(platform: "/", type: TrackType.View) {}

    // PNF
    "/banking/pnf"(platform: "/", type: TrackType.View) {}

    // Movements
    "/banking/movements"(platform: "/", type: TrackType.View) {}
}
