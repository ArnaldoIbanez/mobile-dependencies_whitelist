package src.main.resources.catalog.portability

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {
    '/' (platform: '/', isAbstract: true) { }

    '/portability' (platform: '/', isAbstract: true) { }

    '/portability/onboarding' (platform: '/', type: TrackType.View) { }

    '/portability/request' (platform: '/', type: TrackType.View) { }

    '/portability/congratulations' (platform: '/', type: TrackType.View) { }

    '/portability/status' (platform: '/', type: TrackType.View) { }

    '/portability/stop' (platform: '/', type: TrackType.View) { }

    '/portability/request-detail' (platform: '/', type: TrackType.View) { }

    '/portability/request/employer' (platform: '/mobile', type: TrackType.View) { }

    '/portability/request/bank' (platform: '/mobile', type: TrackType.View) { }

}
