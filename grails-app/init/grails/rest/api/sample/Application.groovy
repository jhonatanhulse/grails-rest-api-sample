package grails.rest.api.sample

import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic

@CompileStatic
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp grailsApp = new GrailsApp(Application)
        grailsApp.run(args)
    }
}
