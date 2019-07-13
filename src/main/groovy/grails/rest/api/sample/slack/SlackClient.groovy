package grails.rest.api.sample.slack

import groovy.transform.CompileStatic

@CompileStatic
interface SlackClient {

    void send(String text)
}
