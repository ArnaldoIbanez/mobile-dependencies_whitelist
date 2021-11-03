package src.main.resources.catalog.pospaymentregrets

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

tracks {
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
