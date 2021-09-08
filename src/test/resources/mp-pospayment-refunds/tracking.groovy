package src.test.resources.pospaymentrefunds

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = 'mercadopago'

    test('Test Refund paths') {
    '/' (platform: '/', type: TrackType.View) { }

    '/pospayment/refunds' (platform: '/', type: TrackType.View) { }

    '/pospayment' (platform: '/', type: TrackType.View) { }

    '/pospayment/refunds/confirm' (platform: '/', type: TrackType.View) { }

    '/pospayment/refunds/refund' (platform: '/', type: TrackType.View) {
      is_split = false
      errors = false
      operation_type = 'regular_payment'
      payment_status = 'approved'
      currency_id = 'ARS'
      marketplace = 'NONE'
      was_partial_refund = false
      one_time_refund = false
      can_refund_partially = true
      processing_mode = 'aggregator'
      collections_to_refund = 2
      failed_percentage = 0
      refund_result = 'success'
    }
    }
}
