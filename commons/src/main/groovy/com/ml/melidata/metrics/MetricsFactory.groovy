package com.ml.melidata.metrics

class MetricsFactory {

    final static String DIRECTORY = "metrics/"

    public static Metrics getMetrics() {
        println "MetricsFactory"
        ClassLoader cl = Thread.currentThread().contextClassLoader
        GroovyShell shell = new GroovyShell(cl)

        Metrics finalMetrics = new Metrics()

        URL url = cl.getResource(DIRECTORY);
        for ( File file : new File(url.toURI()).listFiles(new FilenameFilter() {
            @Override
            boolean accept(File dir, String name) {
                return name.endsWith(".groovy")
            }
        }) ) {
            println("File: ${file.getAbsolutePath()}")
            Reader data = new InputStreamReader(cl.getResourceAsStream(DIRECTORY + file.getName()))
            Metrics metrics = shell.parse(data).run()

            finalMetrics.metricDefinitions.addAll(metrics.getDefinitions())
        }

        return finalMetrics
    }

}
