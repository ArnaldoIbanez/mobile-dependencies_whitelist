package src.test.resources.melidata
import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

/**
* Point Receipts Tracks
*/
trackTests {

    defaultBusiness = "mercadopago"

    test("Point Receipts") {
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
}
