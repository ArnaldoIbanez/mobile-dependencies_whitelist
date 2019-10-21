package com.melidata.definitions

import com.google.gson.Gson
import com.google.gson.GsonBuilder


class MelidataJsonValidator {

    static validate(String cronjson) {
        Gson gson = new GsonBuilder().create()
        Map cron = gson.fromJson(cronjson, Map)
        validateUnrepeatedColumns(cron)
        validateUnrepeatedNames(cron)
    }

    static validateUnrepeatedColumns(Map cron) {
        cron.data.each { task ->
            def columns = task.extract.columns.collect{ it.name }
            if (columns.size() != columns.clone().unique().size()) {
                throw new Exception("Repeated columns at ${task.process_name} JSON")
            }
        }
    }

    static validateUnrepeatedNames(Map jsonmelidata) {
        def processes = jsonmelidata.data.collect{ it.process_name }
        if (processes.size() != processes.clone().unique().size())
            throw new Exception("Repeated process names")
    }

}
