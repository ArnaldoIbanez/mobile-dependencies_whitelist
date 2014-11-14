package com.ml.melidata.catalog.dsl

import com.ml.melidata.catalog.TrackType

/**
 * Created by apetalas on 14/11/14.
 * Este set de clases se creo para probar dsl y no tocas las clases protagonistas
 * En el futuro todo este codigo ira en cada clase del catalogo
 */

class TracksDsl {

    def path = "";
    def properties = [:]
    def TrackType trackType = TrackType.View
    def ArrayList<TracksDsl> trackers;

    def static  tracks(closure){
        TracksDsl track = new TracksDsl();
        track.trackers = new ArrayList<TracksDsl>()
        closure.delegate = track
        closure()
        return track.trackers
    }

    def getTrack(){
        //println "path root node ${this.path}"
        //println "size: ${this.trackers.size()}"

        //this.trackers.each { t -> println t.path }
    }

    // Feucho
    def methodMissing(String path, args){
        //println "path: ${path}, args: ${args} "
        def clos
        def tra
        if(args.size() > 1){
            clos = args[1]
            tra = new TrackDsl(args[0])
        } else {
            clos = args[0]
            tra = new TrackDsl()
        }
        tra.path = path
        this.trackers.push(tra)

        clos.delegate = tra
        clos.resolveStrategy = Closure.DELEGATE_FIRST
        clos(args[1])
    }
}

class TrackDsl {

    def String path
    def platform

    def getPath(String value){

        //println "path: ${value}"
    }

    def methodMissing(String name, args) {
        //args[0].each {println it}
        //println "property name: ${name}, args: ${args}"

        def clone = args[0]
        def propi = new PropertyDsl(args[0])
        //propi.name = name
        //clone.delegate = propi
        //clone.resolveStrategy = Closure.DELEGATE_FIRST
        //clone(*args)
    }
}

class PropertyDsl{

    def name
    def type
    def values


    def type(param){
        //println "type: ${param}"
    }

    def getProp(){
        //println "name: ${name}, values: ${values}"
    }

}

class UtilDsl {

    def ArrayList<String> platforms

    def static utils(closure){
        //println "estoy en el clo"
        UtilDsl track = new UtilDsl();
        closure.delegate = track
        closure()
    }

    def methodMissing(String methodName, args) {
        //println "no existe el metodo ${methodName} con parametros ${args}"
    }

    def platform(Object prop, String name){
        //println "platform name ${name}, default: ${prop.default}"
    }

    def platform(String name){
        //println "platform only name: ${name}"
    }

    def eventType(Object[] args){
        //println args
    }

    def getMostrar(){
        println "plat"
        println this.platform
    }

}