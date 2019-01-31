package com.gildedrose

import spock.lang.Specification

class GildedRoseSpec extends Specification {

    void "foo"() {
        given:
            def items = [new Item("foo", 0, 0)] as Item[]
            def app = new GildedRose(items)
        when:
            app.updateQuality()
        then:
            "fixme" == app.items[0].name
    }
}
