import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog

/**
 * Main catalog definitions
 */
catalog {

	/**
	 * All available platforms
	 */
	platforms = [
			"/",
			"/web",
			"/web/desktop",
			"/web/desktop/forced",
			"/web/mobile",
			"/web/mobile/forced",
			"/web/mobile/static",
			"/mobile",
			"/mobile/android",
			"/mobile/ios",
			"/email"
	]

	/**
	 *
	 * The events means actions that happens without launch a View,
	 * as example of that we can consider Bookmark an item in a VIP page
	 * Every event is an action, so the verbs available are:
	 *
	 * - back:  the event of back from a page, specially in mobile
	 * - abort: the user abort the action (e.g: back pressed before api response)
	 * - delete: when something is deleted
	 * - apply: when a criteria is applied
	 * - post: create a new entity
	 */

	def marketplace = [
			"mercadolibre",
			"tucarro",
			"tumoto",
			"tulancha",
			"tuinmueble",
			"autoplaza",
			"metroscubicos",
			"portalinmobiliario"
	]

	def mercadopago = ["mercadopago"]

	def all = marketplace + mercadopago

	//all.each { business ->
	//	include business, "registration.groovy"
	//}

	marketplace.each { business ->
		include business, "marketplace.groovy"
	}

	mercadopago.each { business ->
		include business, "mercadopago.groovy"
	}
}
