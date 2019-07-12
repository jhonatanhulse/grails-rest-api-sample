package grails.rest.api.sample

import grails.boot.GrailsApp as BaseGrailsApp
import groovy.transform.CompileStatic
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.DotenvEntry
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.MapPropertySource
import org.springframework.core.env.MutablePropertySources

@CompileStatic
class GrailsApp extends BaseGrailsApp {

    GrailsApp(Object... sources) {
        super(sources)
    }

    @Override
    protected void configurePropertySources(ConfigurableEnvironment environment, String[] args) {
        MutablePropertySources sources = environment.getPropertySources()

        sources.addFirst(getDotenvPropertySource())

        super.configurePropertySources(environment, args)
    }

    private static MapPropertySource getDotenvPropertySource() {
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load()

        Map dotenvProperties = [:]

        for (DotenvEntry entry : dotenv.entries()) {
            dotenvProperties.put(entry.getKey(), entry.getValue())
        }

        new MapPropertySource('dotenvProperties', dotenvProperties)
    }
}
