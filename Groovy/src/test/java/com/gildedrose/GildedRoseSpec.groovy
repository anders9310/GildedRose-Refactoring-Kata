package com.gildedrose


import spock.lang.Specification
import spock.lang.Unroll
/*TODO test cases
* SellIn date for Sulfuras is unchanged
* quality thresholds for all different item types
* Quality increase for aged brie after it is supposed to be sold*/
class GildedRoseSpec extends Specification {

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros"
    static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"

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
            10            | 1            | 9
            10            | 1            | 9
            10            | 0            | 8
            10            | -1           | 8
            1             | 1            | 0
            0             | 1            | 0
    }

    @Unroll
    void "Aged brie is updated one time"() {
        given:
            Item agedBrie = new Item("Aged Brie", 10, qualityBefore)
            GildedRose app = new GildedRose([agedBrie] as Item[])
        when:
            app.updateQuality()
        then:
            agedBrie.quality == qualityAfter
        where:
            qualityBefore | qualityAfter
            0             | 1
            1             | 2
            49            | 50
            50            | 50
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

    void "Item recognition is case sensitive"() {
        given:
            int qualityBefore = 10
            Item specialItem = new Item("Aged Brie", 10, qualityBefore)
            Item specialItemInLowercase = new Item("aged brie", 10, qualityBefore)
            Item[] items = [specialItem, specialItemInLowercase]
            GildedRose app = new GildedRose(items)
        when:
            app.updateQuality()
        then:
            specialItem.quality == qualityBefore + 1
            specialItemInLowercase.quality == qualityBefore - 1
    }

}
