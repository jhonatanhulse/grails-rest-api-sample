package grails.rest.api.sample.slack

import grails.plugins.rest.client.RequestCustomizer
import grails.plugins.rest.client.RestBuilder
import spock.lang.Specification

class DefaultSlackClientSpec extends Specification {

    void 'send should use RestBuilder with the right JSON'() {
        given:
        DefaultSlackClient slackClient = new DefaultSlackClient()
        slackClient.restBuilder = Mock(RestBuilder)
        slackClient.slackWebhookUrl = 'http://localhost'

        when:
        slackClient.send('text')

        then:
        1 * slackClient.restBuilder.post('http://localhost') { Closure cl ->
            cl.resolveStrategy = Closure.DELEGATE_FIRST
            cl.delegate = Mock(RequestCustomizer) {
                1 * json([text: 'text'])
            }
            cl()
            true
        }
    }
}
