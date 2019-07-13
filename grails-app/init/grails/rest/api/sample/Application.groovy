package grails.rest.api.sample

import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@CompileStatic
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp grailsApp = new GrailsApp(Application)
        grailsApp.run(args)
    }
}
