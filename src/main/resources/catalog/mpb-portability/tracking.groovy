package src.main.resources.catalog.portability

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
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
