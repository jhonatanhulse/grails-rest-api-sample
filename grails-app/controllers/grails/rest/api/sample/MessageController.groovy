package grails.rest.api.sample

import grails.compiler.GrailsCompileStatic
import grails.rest.RestfulController

@GrailsCompileStatic
class MessageController extends RestfulController {

    static responseFormats = ['json', 'xml']

    MessageController() {
        super(Message)
    }
}
