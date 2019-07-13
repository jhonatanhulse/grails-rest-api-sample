package grails.rest.api.sample.slack

import grails.plugins.rest.client.RestBuilder
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
@CompileStatic
class DefaultSlackClient implements SlackClient {

    @Value('${SLACK_WEBHOOK_URL}')
    String slackWebhookUrl

    @Autowired
    RestBuilder restBuilder

    void send(String text) {
        restBuilder.post(slackWebhookUrl) {
            json text: text
        }
    }
}
