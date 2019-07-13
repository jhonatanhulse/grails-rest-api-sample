package grails.rest.api.sample.event

import grails.rest.api.sample.Message
import grails.rest.api.sample.slack.SlackClient
import org.grails.datastore.mapping.engine.event.PostInsertEvent
import spock.lang.Specification

class MessageEventListenerSpec extends Specification {

    void 'afterInsert should send message to Slack'() {
        given:
        MessageEventListener messageEventListener = new MessageEventListener()
        messageEventListener.slackClient = Mock(SlackClient)

        Message message = new Message(text: 'text')
        PostInsertEvent postInsertEvent = Mock(PostInsertEvent) {
            getEntityObject() >> message
        }

        when:
        messageEventListener.afterInsert(postInsertEvent)

        then:
        1 * messageEventListener.slackClient.send('text')
    }
}
