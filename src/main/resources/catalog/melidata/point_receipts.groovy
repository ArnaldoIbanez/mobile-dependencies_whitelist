import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
* Point Receipts Tracks
*/
tracks {

    initiative = "1300"

    '/point'(platform: '/', isAbstract: true) { }
    '/point/receipts'(platform: '/', isAbstract: true) { }

    // RECEIPT APPROVED
    '/point/receipts/approved'(platform:'/', type: TrackType.View) { }
    '/point/receipts/approved/unsubscribe'(platform:'/', type: TrackType.Event) { }

    // RECEIPT REFUNDED
    '/point/receipts/refunded'(platform:'/', type: TrackType.View) { }
    '/point/receipts/refunded/unsubscribe'(platform:'/', type: TrackType.Event) { }

    // RECEIPT REJECTED
    '/point/receipts/rejected'(platform:'/', type: TrackType.View) { }
    '/point/receipts/rejected/unsubscribe'(platform:'/', type: TrackType.Event) { }

    // ERROR
    '/point/receipts/error'(platform:'/', type: TrackType.View) { }

    // UNSUBSCRIBE
    '/point/receipts/unsubscribe'(platform: '/', type: TrackType.View) { }
    '/point/receipts/unsubscribe/done'(platform: '/', type: TrackType.Event) { }

    // CONGRATS
    '/point/receipts/unsubscribe/congrats'(platform: '/', type: TrackType.View) { }
    '/point/receipts/unsubscribe/congrats/done'(platform: '/', type: TrackType.Event) { }
}
