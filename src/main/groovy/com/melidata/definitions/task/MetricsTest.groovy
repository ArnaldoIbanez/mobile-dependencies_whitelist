package com.melidata.definitions.task

import com.melidata.definitions.validators.BIIntegrationValidator

class MetricsTest {
    static void main(String[] args) {
        def status = BIIntegrationValidator.validateMetrics()

        if (!status)
            System.exit(1)
    }
}