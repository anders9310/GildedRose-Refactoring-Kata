package com.gildedrose

import com.gildedrose.updater.AgedBrieUpdater
import com.gildedrose.updater.BackstagePassUpdater
import com.gildedrose.updater.ItemUpdater
import com.gildedrose.updater.LegendaryItemUpdater
import com.gildedrose.updater.RegularItemUpdater

class GildedRose {
    Item[] items
    private String AGED_BRIE = "Aged Brie"
    private String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
    private String SULFURAS = "Sulfuras, Hand of Ragnaros"

    GildedRose(Item[] items) {
        this.items = items
    }

    void updateQuality() {
        items.each { Item item ->
            ItemUpdater updater = makeItemUpdater(item)
            updater.update()
        }
    }

    ItemUpdater makeItemUpdater(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieUpdater(item)
            case BACKSTAGE_PASS:
                return new BackstagePassUpdater(item)
            case SULFURAS:
                return new LegendaryItemUpdater(item)
            default:
                return new RegularItemUpdater(item)
        }
    }
}
