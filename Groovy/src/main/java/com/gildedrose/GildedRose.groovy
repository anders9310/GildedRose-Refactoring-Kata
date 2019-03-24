package com.gildedrose

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
            switch (item.name) {
                case AGED_BRIE:
                    updateQualityForAgedBrie(item)
                    updateSellIn(item)
                    break
                case BACKSTAGE_PASS:
                    updateQualityForBackstagePass(item)
                    updateSellIn(item)
                    break
                case SULFURAS:
                    break
                default:
                    updateQualityForItem(item)
                    updateSellIn(item)
            }

        }
    }

    private void updateQualityForBackstagePass(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0
        } else if (item.sellIn < 6) {
            item.quality += 3
        } else if (item.sellIn < 11) {
            item.quality += 2
        } else if (item.sellIn >= 11) {
            item.quality += 1
        }
        adjustToMinimumThreshold(item, 0)
        adjustToMaximumThreshold(item, 50)
    }

    private void updateQualityForAgedBrie(Item item) {
        if (item.sellIn > 0) {
            item.quality += 1
        } else {
            item.quality += 2
        }
        adjustToMaximumThreshold(item, 50)
    }

    private void updateQualityForItem(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 1
        } else {
            item.quality -= 2
        }
        adjustToMinimumThreshold(item, 0)
    }

    private void adjustToMaximumThreshold(Item item, int threshold) {
        if (item.quality > threshold) {
            item.quality = threshold
        }
    }

    private void adjustToMinimumThreshold(Item item, int threshold) {
        if (item.quality < threshold) {
            item.quality = threshold
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1
    }
}
