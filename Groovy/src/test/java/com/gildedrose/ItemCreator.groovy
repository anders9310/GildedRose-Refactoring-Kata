package com.gildedrose

class ItemCreator {
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros"
    static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
    static final String AGED_BRIE = "Aged Brie"

    static Item createSulfuras(int sellIn) {
        return new Item(SULFURAS, sellIn, 80)
    }

    static Item createBackstagePass(int sellIn, int quality) {
        return new Item(BACKSTAGE_PASS, sellIn, quality)
    }

    static Item createAgedBrie(int sellIn, int quality) {
        return new Item(AGED_BRIE, sellIn, quality)
    }
}
