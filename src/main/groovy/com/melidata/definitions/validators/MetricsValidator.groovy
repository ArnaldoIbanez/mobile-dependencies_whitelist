package com.melidata.definitions.validators

import com.ml.melidata.metrics.MetricsFactory
import com.melidata.metrics.format.MetricsFormatter

class MetricsValidator {

    private static CONCAT_FILE_NAME = "/tmp/queries.json"

    static boolean validateMetrics(){

        println "\n\n"+starBar()
        println "Validating Metrics...."
        println starBar()+"\n"

        def metricsOutput

        try {
            metricsOutput =  new MetricsFormatter(MetricsFactory.metrics).output
        }
        catch ( Exception e ){
            println("\033[91m - Error while validating metrics.\033[0m")
            println( "" )
            println( e.getMessage())

            return false
        }

        println("\033[92m - Metrics validated succesfully \033[0m")
        return true
    }

    static starBar() {
        return "*************************************"
    }

}
