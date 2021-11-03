package src.test.resources.pospaymentregrets

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = 'mercadopago'

    test('Test Refund paths') {
    '/' (platform: '/', type: TrackType.View) { }

    '/pospayment' (platform: '/', type: TrackType.View) { }

    '/pospayment/home' (platform: '/', type: TrackType.View) { }

    '/pospayment/home/regret' (platform: '/', type: TrackType.View) { }

    '/pospayment/home/regret' (platform: '/', type: TrackType.View) { user_profile = 'newbie' }
    }
}
