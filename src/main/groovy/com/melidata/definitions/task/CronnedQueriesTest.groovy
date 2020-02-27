package com.melidata.definitions.task

import com.melidata.definitions.validators.BIIntegrationValidator

class CronnedQueriesTest {
    static void main(String[] args) {
        def status = BIIntegrationValidator.validateQueries()

        if (!status)
            System.exit(1)
    }
}