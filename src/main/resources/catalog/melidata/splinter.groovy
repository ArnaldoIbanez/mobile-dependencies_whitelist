package catalog.melidata

import com.ml.melidata.catalog.PropertyType
import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks
import com.ml.melidata.TrackType

tracks {

    initiative = "1202"
    defaultBusiness = "mercadolibre"

    //Landings Deals - retrocompatibility
    "/deals"(platform: "/", isAbstract: true) {}

    "/deals/landing"(platform: "/") {
        deal_id(required: false, type: PropertyType.String, description: "Deal id")
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }

    // Pageviews
    "/splinter"(platform: "/", isAbstract: true) {}
    "/splinter/landing"(platform: "/", isAbstract: true) {}
    "/splinter/landing/all"(platform: "/", isAbstract: true) {}
    "/splinter/landing/all/vertical"(platform: "/", isAbstract: true) {}
    "/splinter/landing/adv"(platform: "/", isAbstract: true) {}
    "/splinter/landing/mp"(platform: "/", isAbstract: true) {}
    "/splinter/landing/mkt"(platform: "/", isAbstract: true) {}
    "/splinter/landing/mkt/vertical"(platform: "/", isAbstract: true) {}
    "/splinter/landing/cl"(platform: "/", isAbstract: true) {}

    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/esportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/beleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/brinquedos"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/eletronico"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/casa"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/all/vertical/servicos"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/deals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/tier1"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/video"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/discovery"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/communicationals"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/sparkle"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/promotions"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/moda"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/deportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/esportes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/belleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/beleza"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/juguetes"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/brinquedos"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/electronica"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/eletronico"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/hogar"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/casa"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/servicios"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/mkt/vertical/servicos"(platform: "/",  type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/producto"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/produto"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/especiales"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/especial"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/store"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/adv/deals"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }
    "/splinter/landing/cl/portal_inmobiliario"(platform: "/", type: TrackType.View) {
        deal_print_id(required: false, type: PropertyType.String, description: "Unique deal id hash")
    }

    // events

    "/splinter/landing/all/deals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
        filters(required: true, description: "filters applied")
    }
    "/splinter/landing/all/tier1"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
        filters(required: true, description: "filters applied")
    }
    "/splinter/landing/all/video"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/discovery"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/communicationals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/sparkle"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/promotions"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/moda"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/deportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/esportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/belleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/beleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/juguetes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/brinquedos"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/electronica"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/eletronico"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/hogar"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/casa"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/servicios"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/all/vertical/servicos"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/deals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/tier1"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/video"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/discovery"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/communicationals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/sparkle"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/promotions"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/moda"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/deportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/esportes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/belleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/beleza"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/juguetes"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/brinquedos"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/electronica"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/eletronico"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/hogar"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/casa"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/servicios"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/mkt/vertical/servicos"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/producto"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/produto"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/especiales"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/especial"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/store"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
    "/splinter/landing/adv/deals"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }

    "/splinter/landing/cl/portal_inmobiliario"(platform: "/",  type: TrackType.Event) {
        category(required: false, type: PropertyType.String, description: "Landing category", values: ["landings"])
        action(required: false, type: PropertyType.String, description: "Name of the campaign")
        label(required: false, type: PropertyType.String, description: "Component related info")
    }
}