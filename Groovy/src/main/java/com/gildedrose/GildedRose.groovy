package com.gildedrose

class GildedRose {
    Item[] items

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros"
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
    private static final String AGED_BRIE = "Aged Brie"

    GildedRose(Item[] items) {
        this.items = items
    }

    void updateQuality() {
        for (Item item : items) {
            if (item.name == SULFURAS) {
                //Do nothing
            } else if (item.name == AGED_BRIE) {
                updateAgedBrie(item)
            } else if (item.name == BACKSTAGE_PASS) {
                updateBackstagePasses(item)
            } else {
                updateOrdinaryItem(item)
            }
        }
    }

    private static void updateOrdinaryItem(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 1
        } else {
            item.quality -= 2
        }

        adjustQualityThresholds(item)

        item.sellIn--
    }

    private static void updateAgedBrie(Item item) {
        if (item.sellIn > 0) {
            item.quality += 1
        } else {
            item.quality += 2
        }

        adjustQualityThresholds(item)

        item.sellIn--
    }

    private static void updateBackstagePasses(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0
        } else {
            if (item.sellIn <= 5) {
                item.quality += 3
            } else if (item.sellIn <= 10) {
                item.quality += 2
            } else if (item.sellIn > 10) {
                item.quality += 1
            }
        }

        adjustQualityThresholds(item)

        item.sellIn--
    }

    private static void adjustQualityThresholds(Item item) {
        if (item.quality > 50) {
            item.quality = 50
        }
        if (item.quality < 0) {
            item.quality = 0
        }
    }
}
