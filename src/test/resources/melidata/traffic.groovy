package src.test.resources.melidata

import com.ml.melidata.TrackType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

    test("Traffic with google data") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
            third_party = {
                source = "google"
                data = {
                    id = "EAIaIQobChMI8rLxq6fN6gIVS4CRCh0TgAK8EAkYAiABEgIMHPD_BwE"
                    gclid = "gclid_gIMHPD_BwE"
                }
            }
        }
    }

    test("Traffic with advanced google data") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
            third_party = {
                source = "google"
                data = {
                    id = "EAIaIQobChMI8rLxq6fN6gIVS4CRCh0TgAK8EAkYAiABEgIMHPD_BwE"
                    gclid = "gclid_gIMHPD_BwE"
                    keyword = "hot-sale"
                    target_id = "google"
                    device_model = "device-model"
                    product_partition_id = "partition-id"
                }
            }
        }
    }


    test("Traffic with google data") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
            third_party = {
                source = "google"
                data = {}
            }
        }
    }

    test("Traffic with facebook data") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
            third_party = {
                source = "facebook"
                data = {
                    ad_id = "23842577883810537"
                    adset_id = "23842577873970537"
                    adset_name = "MLC+%7C+BUYER%28365%29+%7C+VIP%287%29%28Living+y+Comedor%29+%7C+DSK-MOB"
                    campaign_id = "23842577866150537"
                    placement = "Facebook_Desktop_Feed"
                }
            }
        }
    }

    test("Traffic with facebook data") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
            third_party = {
                source = "facebook"
                data = {}
            }
        }
    }

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            word = "campaignName"
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
        }
    }

    test("Traffic") {
        "/traffic/inbound/matt"(platform: "/") {
            tool = 123456
            go = "http://ofertas.mercadolibre.com.mx/hot-sale"
        }
    }

    test("Mercado Pago Traffic from mobile/ios") {
        "/traffic/inbound/matt"(platform: "/mobile/ios", business:"mercadopago") {
            tool = 123456
            word = "campaignName"
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/android") {
        "/traffic/inbound/matt"(platform: "/mobile/android", business:"mercadopago") {
            tool = 123456
            word = "campaignName"
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/ios no word") {
        "/traffic/inbound/matt"(platform: "/mobile/ios", business:"mercadopago") {
            tool = 123456
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Mercado Pago Traffic from mobile/android no word") {
        "/traffic/inbound/matt"(platform: "/mobile/android", business:"mercadopago") {
            tool = 123456
            go = "https://www.mercadopago.com.mx/qr-code"
        }
    }

    test("Google search traffic without destination") {
        "/traffic/inbound/organic"(platform: "/") {
            referrer = "www.google.com"
        }

        "/traffic/inbound/organic"(platform: "/", business: "mercadopago") {
            referrer = "www.google.com"
        }
    }

    test("Google search traffic with destination") {
        "/traffic/inbound/organic"(platform: "/") {
            referrer = "www.google.com.uy"
            destination = "www.mercadolibre.com.uy"
        }

        "/traffic/inbound/organic"(platform: "/", business: "mercadopago") {
            referrer = "www.google.com.uy"
            destination = "www.mercadopago.com.uy"
        }
    }

    test("Notification traffic") {
        "/traffic/inbound/notification"(platform: "/") {
            news_id = "12332323"
        }

        "/traffic/inbound/notification"(platform: "/", business: "mercadopago") {
            news_id = "12332323"
        }
    }

    test("Direct traffic") {
        "/traffic/inbound/direct"(platform: "/") {
            go = "www.mercadolibre.com.uy"
        }
        "/traffic/inbound/direct"(platform: "/", business: "mercadopago") {
            go = "www.mercadolibre.com.uy"
        }
    }   
    
}