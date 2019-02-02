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
        if (item.quality < 50) {
            item.quality = item.quality + 1

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality += 1
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality += 1
                }
            }
        }
        if (item.sellIn < 1) {
            item.quality = 0
        }
    }

    private void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }

    private void updateQualityForItem(Item item) {
        if (item.quality > 0) {
            if (item.sellIn > 0) {
                item.quality -= 1
            } else {
                item.quality -= 2
            }
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1
    }
}
