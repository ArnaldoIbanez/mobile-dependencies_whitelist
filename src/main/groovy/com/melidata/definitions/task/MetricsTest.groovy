package com.melidata.definitions.task

import com.melidata.definitions.validators.MetricsValidator

class MetricsTest {
    static void main(String[] args) {
        def status = MetricsValidator.validateMetrics()

        if (!status)
            System.exit(1)
    }
}