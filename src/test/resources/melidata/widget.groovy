package src.test.resources.melidata

import com.ml.melidata.TrackType
import static com.melidata.definitions.parsers.dsl.TrackTestDsl.trackTests

trackTests {
    defaultBusiness = 'mercadopago'

    test('Widget config screen is accessed') {
        '/widget/seller_collect/config'(platform: '/mobile/android', type: TrackType.View) {
            widget_id = 1
            collect_methods_count = 0
        }
    }

    test('Widget config screen fails to open') {
        '/widget/seller_collect/config/error'(platform: '/mobile/android', type: TrackType.View) {
            widget_id = 1
        }
    }

    test('User tries tu add a new widget not being logged in') {
        '/widget/seller_collect/config/not_logged'(platform: '/mobile/android', type: TrackType.View) {
            widget_id = 1
        }
    }

    test('User exits config page using back button') {
        '/widget/seller_collect/config/back'(platform: '/mobile/android', type: TrackType.Event) {
            widget_id = 1
        }
    }

    test('User saves widget configuration') {
        '/widget/seller_collect/config/save'(platform: '/mobile/android', type: TrackType.Event) {
            widget_id = 1
            collect_method = 'point'
        }
    }

    test('User taps over the widget') {
        '/widget/seller_collect/tap'(platform: '/mobile/android', type: TrackType.Event) {
            widget_id = 1
            collect_method = 'point'
        }
    }

    test('User removes widget from homescreen') {
        '/widget/seller_collect/remove'(platform: '/mobile/android', type: TrackType.Event) {
            widget_id = 1
            collect_method = 'qr'
        }
    }

    test('User taps widget not being logged in') {
        '/widget/seller_collect/not_logged'(platform: '/mobile/android', type: TrackType.Event) {
            widget_id = 1
            collect_method = 'point'
        }
    }

    test('User goes to check widget faq') {
        '/gadgets/chooser'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
            supports_floating_button = false
        }
        '/gadgets/widget_settings'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
    }

    test("User goes to activate the floating button but doesn't have permissions") {
        '/gadgets/chooser'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
            supports_floating_button = true
        }
        '/gadgets/floating_button_settings'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
    }

    test('User dismissed permission modal') {
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions/dismiss'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
    }

    test('User continues inside permission modal but doesnt grant permissions') {
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions/continue'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions/denied'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
    }

    test('User grants permission for the floating button') {
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions/continue'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/modal_draw_overlays_permissions/granted'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/start_now'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
            button_uuid = '000-000-000-000'
        }
    }

    test('User with permissions goes to activate the floating button without schedule') {
        '/gadgets/chooser'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
            supports_floating_button = true
        }
        '/gadgets/floating_button_settings'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/start_now'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
            button_uuid = '111-111-111-111'
        }
        '/floating_button/button_mounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            trigger = 'manual'
            tooltip_buttons = ['point', 'qr', 'link']
            side_buttons = ['configuration']
        }
    }

    test('User with permissions goes to schedule the floating button but then decides to delete it') {
        '/gadgets/chooser'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
            supports_floating_button = true
        }
        '/gadgets/floating_button_settings'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/schedule_saved'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
            button_uuid = '111-111-111-111'
            opening_time = {
                hour = 1
                minutes = 30
            }
            closing_time = {
                hour = 11
                minutes = 30
            }
            opening_days = ['monday', 'wednesday']
        }
        '/gadgets/floating_button_settings/schedule_cleared'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
        }
    }

    test('User with permissions goes to activate the floating button with schedule inside opening hours') {
        '/gadgets/chooser'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
            supports_floating_button = true
        }
        '/gadgets/floating_button_settings'(platform: '/mobile/android', type: TrackType.View) {
            session_uuid = '000-000-000-000'
        }
        '/gadgets/floating_button_settings/schedule_saved'(platform: '/mobile/android', type: TrackType.Event) {
            session_uuid = '000-000-000-000'
            button_uuid = '111-111-111-111'
            opening_time = {
                hour = 1
                minutes = 30
            }
            closing_time = {
                hour = 11
                minutes = 30
            }
            opening_days = ['monday', 'wednesday']
        }
        '/floating_button/scheduled_start'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_mounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            trigger = 'schedule'
            tooltip_buttons = ['point', 'qr', 'link']
            side_buttons = ['configuration']
        }
    }

    test('User with the button running opens it and starts a payment with point') {
        '/floating_button/button_view_opened'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_tapped'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            button_id = 'point'
        }
        '/floating_button/button_view_closed'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
    }

    test('User closes the button during opening hours but reopens it from the notification') {
        '/floating_button/button_unmounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/reopen_button_notification_shown'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/reopen_button_notification_accepted'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_mounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            trigger = 'notification'
            tooltip_buttons = ['point', 'qr', 'link']
            side_buttons = ['configuration']
        }
    }

    test('User closes the button during opening hours and decides to close it for today') {
        '/floating_button/button_unmounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/reopen_button_notification_shown'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/reopen_button_notification_dismissed'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_stopped'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
    }

    test('User is using the floating button and starts watching a video in landscape mode') {
        '/floating_button/button_screen_dimensions_change'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            new_width = 1200
            new_height = 200
        }
    }

    test("User reboots it's phone while having a saved schedule") {
        '/floating_button/phone_reboot_reconfiguring_button'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/scheduled_start'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_mounted'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
            trigger = 'schedule'
            tooltip_buttons = ['point', 'qr', 'link']
            side_buttons = ['configuration']
        }
    }

    test('User is using the button and later in the day the configured closing hour arrives') {
        '/floating_button/button_view_opened'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_view_closed'(platform: '/mobile/android', type: TrackType.View) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/scheduled_stop'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
        '/floating_button/button_stopped'(platform: '/mobile/android', type: TrackType.Event) {
            button_uuid = '111-111-111-111'
            button_type = 'seller_collect'
        }
    }
}
