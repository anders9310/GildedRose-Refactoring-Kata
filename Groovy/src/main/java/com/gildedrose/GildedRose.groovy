package com.gildedrose

class GildedRose {
    Item[] items

    GildedRose(Item[] items) {
        this.items = items
    }

    void updateQuality() {
        items.each { Item item ->
            item.updateQuality()
            item.updateSellIn()
        }
    }
}
