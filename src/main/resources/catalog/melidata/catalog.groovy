package catalog.melidata

import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog

/**
 * Main catalog definitions
 */
catalog {

    /**
     * All available platform
     */

    platforms = [
            "/",
            "/web",
            "/web/desktop",
            "/web/mobile",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
            "/email"
    ]

    abPlatforms = [
            "/web/desktop",
            "/web/mobile",
            "/mobile/android",
            "/mobile/ios"
    ]

    abPlatformsSubscriptions = [
            "/",
            "/web",
            "/web/desktop",
            "/web/mobile",
            "/mobile",
            "/mobile/android",
            "/mobile/ios",
    ]

    def mercadolibre = ["mercadolibre"]

    def mercadopago = ["mercadopago"]

    def mercadoshops = ["mercadoshops"]

    def mercadoenvios = ["mercadoenvios"]

    def extra_marketplace = [
            "tucarro",
            "tumoto",
            "tuinmueble",
            "metroscubicos",
            "portalinmobiliario"
    ]

    def all = mercadolibre + mercadopago

    all.each { business ->
        include business, "mp_frontend.groovy"
        include business, "authentication.groovy"
        include business, "bugsnag.groovy"
        include business, "cx.groovy"
        include business, "identity_validation.groovy"
        include business, "remedies.groovy"
        include business, "melidata_sdk.groovy"
        include business, "registrations.groovy"
        include business, "chargebacks.groovy"
        include business, "px.groovy"
        include business, "mobile_commons.groovy"
        include business, "google_connect.groovy"
        include business, "security_settings.groovy"
        include business, "privacy_preferences.groovy"
        include business, "mgm.groovy"
        include business, "mediations.groovy"
        include business, "esc_manager.groovy"
        include business, "traffic.groovy"
        include business, "coupon.groovy"
        include business, "dynamic_stop_landing.groovy"
        include business, "payers_growth.groovy"
        include business, "modals_engine.groovy"
        include business, "collaborators.groovy"
        include business, "loyalty_v2.groovy"
        include business, "credits.groovy"
        include business, "card_form.groovy"
        include business, "merchengine.groovy"
        include business, "navigation_sections.groovy"
        include business, "cookie_disclaimer.groovy"
        include business, "checkoutOff.groovy"
        include business, "insurtech.groovy"
        include business, "addresses.groovy"
        include business, "bulk_publish.groovy"
        include business, "bulk_edit.groovy"
    }

    mercadolibre.each { business ->
        include business, "add_to_cart.groovy"
        include business, "bookmarks.groovy"
        include business, "buyIntention.groovy"
        include business, "listingIntention.groovy"
        include business, "cards_cobranded_ml.groovy"
        include business, "cards_prepaid.groovy"
        include business, "cartCheckout.groovy"
        include business, "cartList.groovy"
        include business, "compatibilities.groovy"
        include business, "cellphone_recharge.groovy"
        include business, "checkout.groovy"
        include business, "credits_marketplace.groovy"
        include business, "credits_classifieds.groovy"
        include business, "moderations.groovy"
        include business, "email.groovy"
        include business, "fulfillment.groovy"
        include business, "home.groovy"
        include business, "loyalty.groovy"
        include business, "marketplace.groovy"
        include business, "melidata_sdk.groovy"
        include business, "mobile.groovy"
        include business, "myml.groovy"
        include business, "myml_mercadoshops.groovy"
        include business, "my_purchases.groovy"
        include business, "seller_central.groovy"
        include business, "vendor_central.groovy"
        include business, "onboarding.groovy"
        include business, "orders_feed.groovy"
        include business, "quotation.groovy"
        include business, "quote.groovy"
        include business, "questions.groovy"
        include business, "recommendations.groovy"
        include business, "referralprogram.groovy"
        include business, "reviews.groovy"
        include business, "returns.groovy"
        include business, "search.groovy"
        include business, "sell.groovy"
        include business, "structuredData.groovy"
        include business, "subscriptions.groovy"
        include business, "variations.groovy"
        include business, "vip.groovy"
        include business, "advertising.groovy"
        include business, "classifieds_landings.groovy"
        include business, "instore.groovy"
        include business, "discount_center_touchpoints.groovy"
        include business, "qr_discount.groovy"
        include business, "zip_finder.groovy"
        include business, "current_location.groovy"
        include business, "download_app.groovy"
        include business, "incentivate_login.groovy"
        include business, "supermarket.groovy"
        include business, "contact.groovy"
        include business, "full.groovy"
        include business, "front_core.groovy"
        include business, "dynamic_links.groovy"
        include business, "sube_recharge.groovy"
        include business, "billing.groovy"
        include business, "asset_management.groovy"
        include business, "remedy.groovy"
        include business, "kyc.groovy"
        include business, "liveness.groovy"
        include business, "user_blocker.groovy"
        include business, "pdp.groovy"
        include business, "qadb.groovy"
        include business, "promotions.groovy"
        include business, "sp_prepaid.groovy"
        include business, "official_stores.groovy"
        include business, "notifications.groovy"
        include business, "post_purchase.groovy"
        include business, "cdn_metrics.groovy"
        include business, "splinter.groovy"
        include business, "update_browser.groovy"
        include business, "ml_insurtech.groovy"
        include business, "trends.groovy"
        include business, "data_privacy.groovy"
        include business, "sms.groovy"
        include business, "reviewPages.groovy"
        include business, "wallet_ml.groovy"
        include business, "whatsapp.groovy"
        include business, "global_selling.groovy"
        include business, "categories.groovy"
        include business, "category_landing.groovy"
    }

    mercadopago.each { business ->
        include business, "mp_architecture.groovy"
        include business, "activities.groovy"
        include business, "mp_digital_account.groovy"
        include business, "mpfrontcore.groovy"
        include business, "payments_digital_accounts.groovy"
        include business, "account_fund.groovy"
        include business, "bulk_payments.groovy"
        include business, "mercadopago.groovy"
        include business, "credits_credit_card.groovy"
        include business, "credits_mercadopago.groovy"
        include business, "mercadopago_mails.groovy"
        include business, "mercadopago_devsite.groovy"
        include business, "cards_cobranded.groovy"
        include business, "cards_prepaid.groovy"
        include business, "cards_hybrid.groovy"
        include business, "cards_mpcard.groovy"
        include business, "cellphone_recharge.groovy"
        include business, "asset_management.groovy"
        include business, "single_player.groovy"
        include business, "instore.groovy"
        include business, "sube_recharge.groovy"
        include business, "transport.groovy"
        include business, "remedy.groovy"
        include business, "kyc.groovy"
        include business, "liveness.groovy"
        include business, "user_blocker.groovy"
        include business, "digital_account.groovy"
        include business, "front_core.groovy"
        include business, "mplayer.groovy"
        include business, "money_in.groovy"
        include business, "money_out.groovy"
        include business, "disbursements.groovy"
        include business, "pos_seller.groovy"
        include business, "preference.groovy"
        include business, "discount_sellers.groovy"
        include business, "unified_onboarding.groovy"
        include business, "profile_engine.groovy"
        include business, "pos_management.groovy"
        include business, "discount_center.groovy"
        include business, "discount_center_touchpoints.groovy"
        include business, "external.groovy"
        include business, "pos_billings.groovy"
        include business, "pdv.groovy"
        include business, "sp_prepaid.groovy"
        include business, "tools_for_sellers.groovy"
        include business, "mp_growth.groovy"
        include business, "pog_comm.groovy"
        include business, "point_payment.groovy"
        include business, "digital_goods.groovy"
        include business, "sp_bill_payments.groovy"
        include business, "notifications.groovy"
        include business, "data_privacy.groovy"
        include business, "wallet.groovy"
        include business, "mp_insurtech.groovy"
        include business, "mobile.groovy"
        include business, "fees_installment.groovy"
        include business, "costs_section.groovy"
        include business, "mp_growth_onlinepayments.groovy"
        include business, "mango_admin.groovy"
        include business, "cashout.groovy"
        include business, "pix.groovy"
        include business, "black_friday.groovy"
        include business, "business_config.groovy"
        include business, "qr_journey.groovy"
    }

    mercadoshops.each { business ->
        include business, "authentication.groovy"
        include business, "notifications_mshops.groovy"
    }

    mercadoenvios.each { business ->
        include business, "flex.groovy"
        include business, "full.groovy"
        include business, "wms.groovy"
        include business, "logistics.groovy"
        include business, "drivers_app.groovy"
        include business, "crowd.groovy"
        include business, "places.groovy"
        include business, "notifications_menvios.groovy"
    }

    extra_marketplace.each { business ->
        include business, "authentication.groovy"
        include business, "bookmarks.groovy"
        include business, "contact.groovy"
        include business, "advertising.groovy"
        include business, "moderations.groovy"
        include business, "email.groovy"
        include business, "home.groovy"
        include business, "myml.groovy"
        include business, "billing.groovy"
        include business, "download_app.groovy"
        include business, "official_stores.groovy"
        include business, "qadb.groovy"
        include business, "quotation.groovy"
        include business, "recommendations.groovy"
        include business, "registrations.groovy"
        include business, "search.groovy"
        include business, "security_settings.groovy"
        include business, "sell.groovy"
        include business, "seller_central.groovy"
        include business, "cx.groovy"
        include business, "traffic.groovy"
        include business, "vip.groovy"
        include business, "splinter.groovy"
    }

}
