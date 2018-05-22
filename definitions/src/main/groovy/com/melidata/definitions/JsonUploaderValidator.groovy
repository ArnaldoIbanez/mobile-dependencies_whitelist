package com.melidata.definitions

import com.melidata.metrics.format.QueryFormatter
import com.melidata.definitions.MelidataJsonValidator
import groovy.json.JsonException


class JsonUploaderValidator {

    private static CONCAT_FILE_NAME = "/tmp/queries.json"

    static boolean validate(){

        println "\n\n"+starBar()
        println "Validating queries...."
        println starBar()+"\n"

        def formatter = new QueryFormatter()
        def queryFormatterOutput

        try {
            queryFormatterOutput = formatter.buildJson()
        }
        catch ( JsonException e ){
            println("\033[91m - Error while validating croned queries. Check $CONCAT_FILE_NAME \033[0m")
            println( "" )
            println( e.getMessage())

            def outputFile = new File(CONCAT_FILE_NAME)
            outputFile.write(formatter.concatQueries())

            // throw e
            return false
        }
        println("\033[92m - Queries validated succesfully \033[0m")

        // TODO ADD QUERY COMPILATION VALIDATION

        MelidataJsonValidator.validate(queryFormatterOutput)
        return true
    }

    static starBar() {
        return "*************************************"
    }

}
