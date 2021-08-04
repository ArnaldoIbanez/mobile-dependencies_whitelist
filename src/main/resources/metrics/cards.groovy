import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

def experimentsRegex = '(cards|wallet_home)/.*'

metrics {
    'cards.acquisition'(description: 'Counts when a user request a card using Mercado Pago app') {
        startWith {
            experiment(regex(experimentsRegex))
        }

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
        startWith {
            experiment(regex(experimentsRegex))
        }

        countsOn {
            condition {
                path('/cards/hybrid/request/virtual/success', '/cards/mpcard/request/virtual/success')
                equals('application.business', 'mercadopago')
            }
        }
    }

    'cards.acquisition.physical'(description: 'Counts when a user request a physical card using Mercado Pago app') {
        startWith {
            experiment(regex(experimentsRegex))
        }

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
        startWith {
            experiment(regex(experimentsRegex))
        }

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
}