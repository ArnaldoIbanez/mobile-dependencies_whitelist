package src.test.resources.portability

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

import com.ml.melidata.TrackType

trackTests {
    defaultBusiness = 'mercadopago'

    test('test path') {
      "/" (platform: '/') { } 

      "/portability" (platform: '/') { }

      '/portability/onboarding' (platform: '/', type: TrackType.View) { }

      '/portability/request' (platform: '/', type: TrackType.View) { }

      '/portability/congratulations' (platform: '/', type: TrackType.View) { }

      '/portability/status' (platform: '/', type: TrackType.View) { }

      '/portability/stop' (platform: '/', type: TrackType.View) { }

      '/portability/request-detail' (platform: '/', type: TrackType.View) { }

      '/portability/request/employer' (platform: '/mobile', type: TrackType.View) { }

      '/portability/request/bank' (platform: '/mobile', type: TrackType.View) { }
    }
}
