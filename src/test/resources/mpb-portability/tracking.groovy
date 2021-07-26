package src.test.resources.portability

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = 'mercadopago'

    test('test path') {
    '/' (platform: '/', type: TrackType.View) { }

    '/portability' (platform: '/', type: TrackType.View) { }
    
    '/portability/onboarding' (platform: '/', type: TrackType.View) { }

    '/portability/kyc' (platform: '/', type: TrackType.View) { }

    '/portability/kyc/onboarding' (platform: '/', type: TrackType.View) { }

    '/portability/kyc/congrat' (platform: '/', type: TrackType.View) { }

    '/portability/request' (platform: '/', type: TrackType.View) { }

    '/portability/request-error' (platform: '/', type: TrackType.View) { }

    '/portability/review' (platform: '/', type: TrackType.View) { }

    '/portability/congratulations' (platform: '/', type: TrackType.View) { }

    '/portability/status' (platform: '/', type: TrackType.View) { }

    '/portability/stop' (platform: '/', type: TrackType.View) { }

    '/portability/validation' (platform: '/', type: TrackType.View) { }

    '/portability/validation/stop' (platform: '/', type: TrackType.View) { }

    '/portability/request-detail' (platform: '/', type: TrackType.View) { }
    }
}
