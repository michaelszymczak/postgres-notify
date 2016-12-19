package com.michaelszymczak.examples.postgresnotify

import spock.lang.Specification

class DemoTest extends Specification {
    def "foo"() {
        expect:
        new Demo().ok()

    }
}
