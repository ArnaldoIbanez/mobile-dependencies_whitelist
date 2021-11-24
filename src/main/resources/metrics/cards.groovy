import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def experimentsRegex = '(cards|wallet_home)/.*'

metrics {
    'cards.acquisition'(description: 'Counts when a user request a card using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn {
            condition {
                path('/prepaid/acquisition/congrats',
        '/cards/hybrid/request/virtual/success',
        '/cards/hybrid/request/physical/success',
        '/cards/hybrid/request/physical/challenge/success',
        '/cards/mpcard/request/virtual/success',
        '/cards/mpcard/request/physical/success',
        '/cards/mpcard/request/physical/challenge/success')
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.acquisition.virtual'(description: 'Counts when a user request a virtual card using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn {
            condition {
                path('/cards/hybrid/request/virtual/success', '/cards/mpcard/request/virtual/success')
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.acquisition.physical'(description: 'Counts when a user request a physical card using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn {
            condition {
                path('/prepaid/acquisition/congrats',
                    '/cards/hybrid/request/physical/success',
                    '/cards/hybrid/request/physical/challenge/success',
                    '/cards/mpcard/request/physical/success',
                    '/cards/mpcard/request/physical/challenge/success')
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.activation'(description: 'Counts when a user unlock a card using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn {
            condition {
                or(
                path('/prepaid/activation/congrats', '/cards/hybrid/unlock/success'),
                and(
                        equals('path', '/cards/acquisition/congrats'),
                        or(
                            equals('event_data.type', 'unlock_nip'),
                            equals('event_data.type', 'unlock_without_nip')
                        )

                )
            )
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.nfc.enrollment'(description: 'Counts when a user request a nfc card using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn{
            condition{
                or(
                path(
                    '/cards/nfc/enrollment/hub/onboarding',
                    '/cards/nfc/acquisition/create_nfc_card',
                    '/cards/nfc/enrollment/instructions'),
                and(
                    equals('path', '/cards/nfc/enrollment/tokenization/new_card_push/success'),
                    or(
                        equals('event_data.action', 'new_card_push_received_success'),
                        equals('event_data.information', 'tokenization completed event')

                    )
                )
            )
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.nfc.hub.configuration'(description: 'Counts when a user enter to Nfc Configuration Hub using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn{
            condition{
                or(
                    path('/cards/nfc/configuration/hub'),
                    and (
                        equals('path','/cards/nfc/configuration/hub/step/tap'),
                        or(
                            equals('event_data.action', 'step_tap_and_pay'),
                            equals('event_data.action', 'step_pin'),
                            equals('event_data.action', 'step_nfc'),
                            equals('event_data.action', 'step_nfc_freeze')
                        )
                    )
                )
                equals('application.business', 'mercadopago')
            }
        }
    }
    'cards.nfc.hub.enrollment'(description: 'Counts when a user enter to Nfc Enrollment Hub using Mercado Pago app') {
        experiment(regex(experimentsRegex))

        countsOn{
            condition{
                or(
                    path('/cards/nfc/enrollment/hub'),
                    and(
                        equals('path', '/cards/nfc/enrollment/hub/step/tap'),
                        or(
                            equals('event_data.action', 'step_tap_and_pay'),
                            equals('event_data.action', 'step_pin'),
                            equals('event_data.action', 'step_nfc')
                        )
                    )
                )
                equals('application.business', 'mercadopago')
            }
        }
    }
}