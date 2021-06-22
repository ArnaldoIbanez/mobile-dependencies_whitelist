package src.test.resources.melidata

import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {

  defaultBusiness = "mercadopago"

  test("Release options screen referrer null") {
    "/settings/release_options"(platform: "/", type:TrackType.View) {
      referrer = ""
    }
  }

  test("Release options screen referrer null") {
    "/settings/release_options"(platform: "/", type:TrackType.View) {}
  }

  test("Release options screen referrer not null") {
    "/settings/release_options"(platform: "/", type:TrackType.View) {
      referrer = "https://www.mercadopago.com.ar/business"
    }
  }

  test("Release options lib put") {
    "/release_options_ui/update"(platform: "/", type:TrackType.Event) {
      channel = "point"
      payment_method_type = "credit"
      release_days = "14"
      percentage = "3.09"
    }
  }

  test("Release options lib get") {
    "/release_options_ui/render_channel"(platform: "/", type:TrackType.Event) {
      channel = "point"
    }
  }

  // Contact Email Section
  test("Contact email home") {
    "/tfs_contact_email/home"(platform: "/", type:TrackType.View) {}
  }

  test("Contact email error") {
    "/tfs_contact_email/error"(platform: "/", type:TrackType.View) {
    }
  }

  test("Contact email congrats") {
    "/tfs_contact_email/congrats"(platform: "/", type:TrackType.View) {
    }
  }
}
