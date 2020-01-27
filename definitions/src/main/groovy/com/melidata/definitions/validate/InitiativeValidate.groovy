package com.melidata.definitions.validate

import groovy.sql.Sql
import com.melidata.definitions.validate.*

class InitiativeValidate {

    private static List initiatives = []

    static void generateInitiativesList() {
        initiatives = getAllInitiativesFromDump()
    }

    private static List getAllInitiativesFromDump() {
        def query = buildQuery()
        def presto_certs_path = System.getProperty("user.dir") + "/src/main/resources/presto_cacerts"

        def db = [url:"jdbc:presto://melidata-presto.ml.com:443/hive/default?SSL=true&SSLKeyStorePath=${presto_certs_path}&applicationNamePrefix=catalog",
                  user:'catalog_md', password:'Entrada.10', driver:'com.facebook.presto.jdbc.PrestoDriver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
        List result = []
        sql.eachRow(query) { row ->
            InitiativeModel im = new InitiativeModel(row.idinitiative, row.externalname, row.name)
            result << im
        }

        return result
    }

    private static String buildQuery() {
        return "SELECT name,  application.idinitiative, externalName from application_initiatives_export as application\n" +
                "JOIN initiatives_export as initiative ON initiative.idinitiative = application.idinitiative"
    }

    static validateInitiative(String initiative) {
        initiatives.any() {InitiativeModel init -> init.getInitiativeName() == initiative }
    }

    static String getInitiativeFromApplication(String application) {
        return initiatives.find({InitiativeModel init -> init.getApplicationName() == application}).getInitiativeName()
    }
}
