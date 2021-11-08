package catalog.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {
    initiative = "1171"
    // Pospayment Refunds
    '/' (platform: '/', type: TrackType.View) {
      user_profile(
        required: false,
        type: PropertyType.String,
        values: ['guest', 'no_offer', 'seller', 'payer', 'newbie', 'collector', 'sellers', 'payers', 'collectors', 'undefined'],
        description: 'Tracks the user profile')
    }

    '/pospayment' (platform: '/', type: TrackType.View) {
      user_profile(
        required: false,
        type: PropertyType.String,
        values: ['guest', 'no_offer', 'seller', 'payer', 'newbie', 'collector', 'sellers', 'payers', 'collectors', 'undefined'],
        description: 'Tracks the user profile')
    }

    '/pospayment/refunds' (platform: '/', type: TrackType.View) { }

    '/pospayment/refunds/confirm' (platform: '/', type: TrackType.View) { }

    '/pospayment/refunds/refund' (platform: '/', type: TrackType.View) {
      is_split(
        required: true,
        type: PropertyType.Boolean,
        description: 'Tracks whether the payment was performed using a Splitter')
      errors(
        required: true,
        type: PropertyType.Boolean,
        description: 'Tracks whether the refund had errors')
      operation_type(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the payment\'s operation type')
      payment_status(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the payment\'s status')
      currency_id(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the payment\'s currency type')
      marketplace(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the payment\'s marketplace it was generated from')
      was_partial_refund(
        required: true,
        type: PropertyType.Boolean,
        description: 'Tracks whether it was a partial refund')
      one_time_refund(
        required: true,
        type: PropertyType.Boolean,
        description: 'Tracks whether it was a one-time refund')
      can_refund_partially(
        required: true,
        type: PropertyType.Boolean,
        description: 'Tracks whether the payment can be partially refunded')
      processing_mode(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the payment\'s processing mode')
      collections_to_refund(
        required: true,
        type: PropertyType.Numeric,
        description: 'Tracks the number of payment collections to refund')
      failed_percentage(
        required: true,
        type: PropertyType.Numeric,
        description: 'Tracks the percentage of failed refund transactions')
      refund_result(
        required: true,
        type: PropertyType.String,
        description: 'Tracks the result of the refund transaction',
        values: ['success', 'warning', 'error'])
    }

    // Pospayment Regrets
    '/pospayment/home' (platform: '/', type: TrackType.View) {
      user_profile(
        required: false,
        type: PropertyType.String,
        values: ['guest', 'no_offer', 'seller', 'payer', 'newbie', 'collector', 'sellers', 'payers', 'collectors', 'undefined'],
        description: 'Tracks the user profile')
    }

    '/pospayment/home/regret' (platform: '/', type: TrackType.View) {
      user_profile(
        required: false,
        type: PropertyType.String,
        values: ['guest', 'no_offer', 'seller', 'payer', 'newbie', 'collector', 'sellers', 'payers', 'collectors', 'undefined'],
        description: 'Tracks the user profile')
    }
}