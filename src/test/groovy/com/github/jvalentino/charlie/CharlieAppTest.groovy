package com.github.jvalentino.charlie

import org.springframework.boot.SpringApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import spock.lang.Specification

class CharlieAppTest extends Specification {

    def setup() {
        GroovyMock(SpringApplication, global:true)
    }

    def "test main"() {
        when:
        CharlieApp.main(null)

        then:
        1 * SpringApplication.run(CharlieApp, null)
    }

    def "Test configure"() {
        given:
        CharlieApp subject = new CharlieApp()
        SpringApplicationBuilder builder = GroovyMock()

        when:
        subject.configure(builder)

        then:
        1 *  builder.sources(CharlieApp)
    }
}
