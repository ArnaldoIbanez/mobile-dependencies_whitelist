import com.ml.melidata.TrackType
import com.ml.melidata.catalog.PropertyType

import static com.ml.melidata.catalog.parsers.dsl.TrackDsl.tracks

tracks {

    initiative = "1159"

    // MP Alliance BancoColombioa
    "/alliance"(platform: "/web", isAbstract: true) {}
    "/alliance/landing"(platform: "/", type: TrackType.View) {
        company_name (required:true, description: "name of the allied company")
    }

    "/growth"(platform: "/", isAbstract: true) {}
    "/growth/login"(platform: "/", type: TrackType.View) {
        view (type: PropertyType.String, required: true, description: "Name of view", values: ["split", "guest"])
    }

    // Merchant Acquisition
    "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/qr"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/flows"(platform: "/", isAbstract: true) {}

    // QR Assignment > Pageviews
    "/merchant_acquisition/flows/qr-assignment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-assignment/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-assignment/error"(platform:"/", type: TrackType.View) {
        status (type: PropertyType.String, required: true, description: "Error Status, ex: invalidAccess, error")
    }

    // QR Assignment > Events
    "/merchant_acquisition/flows/qr-assignment/validate_email"(platform:"/", type: TrackType.Event) {
        valid (type: PropertyType.Boolean, required: true, description: "Ex: true or false")
    }
    "/merchant_acquisition/flows/qr-assignment/qr_scan"(platform:"/", type: TrackType.Event) {
        qr_content (type: PropertyType.String, required: true, description: "Ex: http://qrContent")
    }

    // Bobinas > Pageviews
    "/merchant_acquisition/flows/paper_rolls"(platform: "/", type: TrackType.View) {
        view (
                type: PropertyType.String,
                required: true, description: "Type of view",
                values: ["order", "registration", "congrats_waiting", "congrats_success", "congrats_registration", "access_denied", "error"]
        )
    }
    "/merchant_acquisition/flows/paper_rolls/modal"(platform: "/", isAbstract: true) {}

    // Bobinas > Events
    "/merchant_acquisition/flows/paper_rolls/complete_form"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/paper_rolls/modal/update_address"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/paper_rolls/modal/add_address"(platform: "/", type: TrackType.Event) {}

    // QR Queue Web > Pageviews
    "/merchant_acquisition/flows/qr-queue"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/amount"(platform:"/", type: TrackType.View) {
        onboarding (type: PropertyType.Boolean, required: true, description: "Flag that determines if onboarding was shown. Ex: true / false")
    }
    "/merchant_acquisition/flows/qr-queue/waiting-payment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/congrats"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-queue/error"(platform:"/", type: TrackType.View) {}

    // QR Queue Web > Events
    "/merchant_acquisition/flows/qr-queue/amount/download"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/print"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/replace-amount"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/pos-changed"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/amount/store-changed"(platform:"/", type: TrackType.Event) {}

    "/merchant_acquisition/flows/qr-queue/waiting-payment/retry"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/flows/qr-queue/waiting-payment/extend-time"(platform:"/", type: TrackType.Event) {}

    // Point Transfer
    "/merchant_acquisition/flows/transfer-device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/empty"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/transfer-device/error"(platform:"/", type: TrackType.View) {}

    // Point Register
    "/merchant_acquisition/flows/register-device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/register-device/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/register-device/error"(platform:"/", type: TrackType.View) {}

    // Release Options
    "/merchant_acquisition/flows/release-options"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/release-options/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/release-options/error"(platform:"/", type: TrackType.View) {}

    // Micrositio - reseller
    "/merchant_acquisition/flows/resellers"(platform:"/", type: TrackType.View) {}
    //bundles
    "/merchant_acquisition/flows/resellers/bundles"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/bundles/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/bundles/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }

	// wrap up
	"/merchant_acquisition/flows/wrap_up"(platform: "/", isAbstract: true) {}
	"/merchant_acquisition/flows/wrap_up/home"(platform:"/", type: TrackType.View) {}
	"/merchant_acquisition/flows/wrap_up/home/x_sell"(platform:"/", type: TrackType.View) {}
	"/merchant_acquisition/flows/wrap_up/home/x_sell/click_see_more"(platform:"/", type: TrackType.Event) {
        product_sell_name(required: true, type: PropertyType.String, description: "The product sell name")
        link(required: true, type: PropertyType.String, description: "Link to execute")
    }

    //mgm
    "/merchant_acquisition/flows/resellers/mgm"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/mgm/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/mgm/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    //dashboard
    "/merchant_acquisition/flows/resellers/dashboard"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/dashboard/click"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/share"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/open"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    "/merchant_acquisition/flows/resellers/dashboard/close"(platform:"/", type: TrackType.Event) {
        page_resource (type: PropertyType.String, required: true, description: "Name of page section, example: 'share-code', 'device-bundle', ..")
    }
    //benefits
    "/merchant_acquisition/flows/resellers/benefits"(platform:"/", type: TrackType.View) {}
    //metrics
    "/merchant_acquisition/flows/resellers/metrics"(platform:"/", type: TrackType.View) {}
    //associate_device
    "/merchant_acquisition/flows/resellers/associate_device"(platform:"/", type: TrackType.View) {}
    //register_device
    "/merchant_acquisition/flows/resellers/register_device"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/individual"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/register_device/bundle"(platform:"/", type: TrackType.View) {}

    // Share MGM Web > Pageviews
    "/merchant_acquisition/flows/share_mgm"(platform: "/", type: TrackType.View) {}
    "/merchant_acquisition/flows/share_mgm/device"(platform: "/", isAbstract: true) {}

    // Share MGM Web > Events
    "/merchant_acquisition/flows/share_mgm/about_share"(platform: "/", type: TrackType.Event) {}

    "/merchant_acquisition/flows/share_mgm/share_device_button"(platform: "/", type: TrackType.Event) {
        product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/more_info_device"(platform: "/", type: TrackType.Event) {
        product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/device/invite"(platform: "/", type: TrackType.Event) {
        media (type: PropertyType.String, required: true, description: "In which channel did the user shared the coupon (ex: Whatsapp)")
        product (type: PropertyType.String, required: true, description: "Name of device, example: 'point-h'")
    }

    "/merchant_acquisition/flows/share_mgm/device/invite/send_email"(platform: "/", parentPropertiesInherited: false, type: TrackType.Event) {}

    "/merchant_acquisition/flows/share_mgm/banner"(platform: "/", type: TrackType.Event) {
        banner_name (type: PropertyType.String, required: true, description: "Name of banner (ex: Kit promotional)")
    }

	// Share MGM Invite and Win > Pageviews
    "/merchant_acquisition/flows/share_mgm/invite_and_win"(platform: "/", type: TrackType.View) {}

	// Share MGM Invite and Win > Events
	"/merchant_acquisition/flows/share_mgm/invite_and_win/scrolling_between_device_cards"(platform: "/", type: TrackType.Event) {
        product (type: PropertyType.String, required: true, description: "Product which user scrolled (ex: Point Plus)")
    }
	"/merchant_acquisition/flows/share_mgm/invite_and_win/click_button_social_network"(platform: "/", type: TrackType.Event) {
        media (type: PropertyType.String, required: true, description: "Name of social network (ex: WhatsApp)")
        product (type: PropertyType.String, required: true, description: "Name of product (ex: Point Plus)")
    }
	"/merchant_acquisition/flows/share_mgm/invite_and_win/click_dashboard_awards"(platform: "/", type: TrackType.Event) {}
	"/merchant_acquisition/flows/share_mgm/invite_and_win/click_terms_of_use"(platform: "/", type: TrackType.Event) {}
	"/merchant_acquisition/flows/share_mgm/invite_and_win/click_mgm_wallet"(platform: "/", type: TrackType.Event) {}

    // Invite and Win
    "/merchant_acquisition/point"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/point/landing"(platform: "/", isAbstract: true) {}

    "/merchant_acquisition/point/landing/invite_and_win"(platform: "/", type: TrackType.View) {}
    "/merchant_acquisition/point/landing/invite_and_win/recommend"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/point/landing/invite_and_win/sign_up"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/point/landing/invite_and_win/additional_benefits"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/point/landing/invite_and_win/point_details"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/point/landing/invite_and_win/qr_details"(platform: "/", type: TrackType.Event) {}
    "/merchant_acquisition/point/landing/invite_and_win/kit_download"(platform: "/", type: TrackType.Event) {}

    // Associar Point - Micrositio - reseller
    "/merchant_acquisition/flows/resellers/point_register"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/associate"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/success"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/resellers/point_register/no_account"(platform:"/", type: TrackType.View) {}

    // Envio proactivo QR - Associar QR + Point - qr-point-assignment
    "/merchant_acquisition/flows/qr-point-assignment"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/qr"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/store"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/congrats"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/qr-point-assignment/unauthorized"(platform:"/", type: TrackType.View) {}

    // Fluxo de reversa Point - autogeração de etiqueta
    "/merchant_acquisition/flows/point_reverse"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/info"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/address"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/flows/point_reverse/success"(platform:"/", type: TrackType.View) {}

    // QR Landing > Pageviews
    "/merchant_acquisition/qr/landing"(platform:"/", type: TrackType.View) {}

    // QR Landing > Events
    "/merchant_acquisition/qr/landing/promotions"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/landing/video"(platform:"/", type: TrackType.Event) {
        value (values: ["hero", "afterhero"], type: PropertyType.String, required: true, description: "Section where the trigger it is placed. Could be hero/afterHero")
        trigger (type: PropertyType.String, required: true, description: "button that triggers the qr video")
    }
    "/merchant_acquisition/qr/landing/landing-get-qr-code"(platform:"/", type: TrackType.Event) {}

    // QR Flow > Pageviews
    "/merchant_acquisition/qr/onboarding"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/qr-code"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/pending"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/settings"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/permission-denied"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/qr/web-mobile"(platform:"/", type: TrackType.View) {}

    // QR Flow > Events
    "/merchant_acquisition/qr/qr-code/download"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/print"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/faqs"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/help"(platform:"/", type: TrackType.Event) {}
    "/merchant_acquisition/qr/qr-code/rates"(platform:"/", type: TrackType.Event) {}

    // MMC Flow > PageViews
    "/merchant_acquisition/mydata"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/mydata/edit"(platform: "/", type: TrackType.View) {}
    "/merchant_acquisition/mydata/success"(platform: "/", type: TrackType.View) {}

    // Merchant Acqusition Point Landings - Set Language In Chinese
    // "/merchant_acquisition"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/point-landings"(platform: "/", isAbstract: true) {}
    "/merchant_acquisition/point-landings/app-chinese"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/point-landings/app-chinese/error"(platform:"/", type: TrackType.View) {}
    "/merchant_acquisition/point-landings/app-chinese/success"(platform:"/", type: TrackType.View) {}

    //Merchant Acqusition - widgets
    "/merchant_acquisition/widget"(platform:"/", type: TrackType.View) {
        type (type: PropertyType.String, required: true, values: ["reverse-label", "reset-chip"], description: "Widget name, could be reverse-label, bobinas, shipping & more")
    }


    "/browser" (platform: "/mobile", isAbstract: true){}
    "/browser/tracking" (platform: "/mobile", type: TrackType.Event){
        browser_id (type: PropertyType.String, required: true, description: "Specifies the browser id")
    }
}