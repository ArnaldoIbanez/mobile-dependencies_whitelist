package com.melidata.definitions.format

class HiveFormatter extends CatalogFormatter {

    HiveFormatter(String catalogName) {
        super(catalogName)
    }

    def generate(String business) {
        def platforms = getPlatforms(catalog.platformTrees.get(business))

        platforms.collectEntries{k,v -> [k,getPathInfo(v.tracksTree.children)]}
    }

    def getPathInfo(def c) {
        getTrackInfo(c).collectEntries{[it.key,it.value]}.findAll{it.value}
    }

    def getTrackInfo(def c) {
        if (c?.containsKey('/') && c?.size() == 1) {
            def v = c.'/'
            return getLine('/',v)
        } else
            return c ? c.collect {k,v -> getLine(k,v) }.flatten() : []
    }

    def getLine(def k, def v) {
        combine(new MapEntry(k,extractProps(v)), getTrackInfo(v.children))
    }

    def formatOutput(def data) {
        def b = new StringBuilder()
        data.each { business, d ->
            d.each { platform, trackInfo ->
                trackInfo.each { path, params ->
                    params.each { name, attrs ->
                        def vals = [business,platform,path,name] + attrs
                        def line = vals.join('\t')
                        b.append(line + System.getProperty('line.separator'))
                    }
                }
            }
        }

        b.length = Math.max(b.length() - 1, 0)
        b.toString()
    }


    static void main(String[] args) {
        String catalogName = args[0]
        def file = new File("catalog.csv")
        file.delete()

        file << new HiveFormatter(catalogName).output
    }
}
