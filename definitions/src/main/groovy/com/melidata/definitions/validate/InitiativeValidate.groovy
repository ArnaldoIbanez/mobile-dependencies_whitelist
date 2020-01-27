package com.melidata.definitions.validate

import groovy.sql.Sql


class InitiativeValidate {

    private static List initiatives

    static void generateInitiativesList() {
        initiatives = getAllInitiativesFromDump()
    }

    private static List getAllInitiativesFromDump() {
        def query = buildQuery()
        def presto_certs_path = System.getProperty("user.dir") + "/src/main/resources/presto_cacerts"
        System.err.println("Query:")
        System.err.println("${query}")
        System.err.println("")

        def db = [url:"jdbc:presto://melidata-presto.ml.com:443/hive/default?SSL=true&SSLKeyStorePath=${presto_certs_path}&applicationNamePrefix=catalog",
                  user:'catalog_md', password:'Entrada.10', driver:'com.facebook.presto.jdbc.PrestoDriver']
        def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
        List result = []
        sql.eachRow(query) { row ->
            result << [row.externalname]
        }

        return result
    }

    private static String buildQuery() {
        return "SELECT externalname \n" + "FROM initiatives_export \n"
    }

}
