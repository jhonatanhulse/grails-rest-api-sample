package grails.rest.api.sample.event

import grails.events.annotation.gorm.Listener
import grails.rest.api.sample.Message
import grails.rest.api.sample.slack.SlackClient
import groovy.transform.CompileStatic
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@CompileStatic
class MessageEventListener {

    @Autowired
    SlackClient slackClient

    @Listener(Message)
    void afterInsert(PostInsertEvent event) {
        Message message = (Message) event.entityObject
        slackClient.send(message.text)
    }
}
