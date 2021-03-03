package src.test.resources.melidata

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
  defaultBusiness = "mercadolibre"

  test("data_privacy") {
    // Mercadolibre
    "/landing_data_privacy"(platform: "/web") {}
    "/landing_data_privacy/event/click"(platform: "/web") {
      text = "Nuestros principios"
      component = "sidebar"
    }
    "/landing_data_privacy/event/click"(platform: "/web") {
      text = "Podés tener más detalles sobre el uso de nuestras plataformas en Términos y Condiciones"
      component = "link"
    }
    "/landing_data_privacy/event/click"(platform: "/web") {
      text = "Términos y condiciones de uso del sitio"
      component = "quick_access"
    }
    "/landing_data_privacy/event/scroll"(platform: "/web") {
      text = "Responsabilidad sobre los datos"
      component = "view"
    }
    "/landing_data_privacy/event/hover"(platform: "/web") {
      text = "2-actualizar-corregir"
      component = "tooltip"
    }

    // Mercadopago
    "/landing_data_privacy"(platform: "/web", business: "mercadopago") {}
    "/landing_data_privacy/event/click"(platform: "/web", business: "mercadopago") {
      text = "Nuestros principios"
      component = "sidebar"
    }
    "/landing_data_privacy/event/click"(platform: "/web", business: "mercadopago") {
      text = "Podés tener más detalles sobre el uso de nuestras plataformas en Términos y Condiciones"
      component = "link"
    }
    "/landing_data_privacy/event/click"(platform: "/web", business: "mercadopago") {
      text = "Términos y condiciones de uso del sitio"
      component = "quick_access"
    }
    "/landing_data_privacy/event/scroll"(platform: "/web", business: "mercadopago") {
      text = "Responsabilidad sobre los datos"
      component = "view"
    }
    "/landing_data_privacy/event/hover"(platform: "/web", business: "mercadopago") {
      text = "2-actualizar-corregir"
      component = "tooltip"
    }
  }
}