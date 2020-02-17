package com.gildedrose


import spock.lang.Specification
import spock.lang.Unroll

class GildedRoseSpec extends Specification {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros"
    static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
    static final String AGED_BRIE = "Aged Brie"

    @Unroll
    void "the quality of an ordinary item is updated one time"() {
        given:
            Item foo = new Item("foo", sellInBefore, qualityBefore)
            GildedRose app = new GildedRose([foo] as Item[])
        when:
            app.updateQuality()
        then:
            foo.quality == qualityAfter
            foo.sellIn == sellInBefore - 1
        where:
            qualityBefore | sellInBefore | qualityAfter
            10            | 2            | 9
            10            | 1            | 9
            10            | 0            | 8
            10            | -1           | 8
            1             | 1            | 0
            0             | 1            | 0
            1             | 0            | 0
            0             | 0            | 0
    }

    @Unroll
    void "Aged brie is updated one time"() {
        given:
            Item agedBrie = new Item(AGED_BRIE, sellInBefore, qualityBefore)
            GildedRose app = new GildedRose([agedBrie] as Item[])
        when:
            app.updateQuality()
        then:
            agedBrie.quality == qualityAfter
        where:
            qualityBefore | sellInBefore | qualityAfter
            0             | 1            | 1
            1             | 1            | 2
            48            | 1            | 49
            49            | 1            | 50
            50            | 1            | 50
            0             | 0            | 2
            1             | 0            | 3
            47            | 0            | 49
            48            | 0            | 50
            49            | 0            | 50
            50            | 0            | 50
    }

    @Unroll
    void "Legendary item is updated one time"() {
        given:
            Item legendaryItem = new Item(SULFURAS, sellIn, 80)
            GildedRose app = new GildedRose([legendaryItem] as Item[])
        when:
            app.updateQuality()
        then:
            legendaryItem.quality == 80
        where:
            sellIn << [-1, 0, 1, 2]
    }

    @Unroll
    void "Backstage pass is updated one time"() {
        given:
            Item backstagePass = new Item(BACKSTAGE_PASS, sellIn, qualityBefore)
            GildedRose app = new GildedRose([backstagePass] as Item[])
        when:
            app.updateQuality()
        then:
            backstagePass.quality == qualityAfter
        where:
            qualityBefore | sellIn | qualityAfter
            10            | 12     | 11
            10            | 11     | 11
            10            | 10     | 12
            10            | 6      | 12
            10            | 5      | 13
            10            | 1      | 13
            10            | 0      | 0
            10            | -1     | 0
    }
}
