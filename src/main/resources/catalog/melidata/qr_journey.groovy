import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

/**
* Qr-journey tracks
*/
tracks {

    '/qr'(platform: '/', isAbstract: true, initiative: '1046') { }
    '/qr/journey'(platform: '/', isAbstract: true) { }

    // ONBOARDING
    '/qr/journey/onboarding'(platform:'/', type: TrackType.View) { }
    '/qr/journey/onboarding/done'(platform:'/', type: TrackType.Event) { }

    // PRICING
    '/qr/journey/pricing'(platform:'/', type: TrackType.View) { }
    '/qr/journey/pricing/done'(platform:'/', type: TrackType.Event) { }

    // CONGRATS-CODE
    '/qr/journey/congrats-code'(platform:'/', type: TrackType.View) { }
    '/qr/journey/congrats-code/print'(platform:'/', type: TrackType.Event) { }
    '/qr/journey/congrats-code/download'(platform:'/', type: TrackType.Event) { }

    // SUPPORT
    '/qr/journey/support'(platform:'/', type: TrackType.View) { }
    '/qr/journey/support/done'(platform:'/', type: TrackType.Event) { }

    // PERMISSION-DENIED
    '/qr/journey/permission-denied'(platform:'/', type: TrackType.View) { }

    // ERROR
    '/qr/journey/error'(platform:'/', type: TrackType.View) { }

    // WEB-MOBILE
    '/qr/journey/web-mobile'(platform:'/', type: TrackType.View) { }

    // FTU
    '/qr/journey/ftu'(platform: '/', type: TrackType.View) { }
    '/qr/journey/ftu/done'(platform: '/', type: TrackType.Event) { }

    // CODE
    '/qr/journey/code'(platform: '/', type: TrackType.View) { }
    '/qr/journey/code/print'(platform: '/', type: TrackType.Event) { }
    '/qr/journey/code/download'(platform: '/', type: TrackType.Event) { }
    '/qr/journey/code/done'(platform: '/', type: TrackType.Event) { }

    // CONGRATS
    '/qr/journey/congrats'(platform: '/', type: TrackType.View) { }
    '/qr/journey/congrats/done'(platform: '/', type: TrackType.Event) { }
}
