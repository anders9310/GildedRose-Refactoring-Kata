package com.gildedrose.updater

import com.gildedrose.Item

abstract class ItemUpdater {

    protected Item item
    protected int minQuality
    protected int maxQuality

    abstract void update()

    ItemUpdater(Item item, int minQuality, int maxQuality) {
        this.item = item
        this.minQuality = minQuality
        this.maxQuality = maxQuality
    }

    protected void adjustQualityToThresholds() {
        adjustToMaximumQuality()
        adjustToMinimumQuality()
    }

    private void adjustToMaximumQuality() {
        if (item.quality > maxQuality) {
            item.quality = maxQuality
        }
    }

    private void adjustToMinimumQuality() {
        if (item.quality < minQuality) {
            item.quality = minQuality
        }
    }

    protected void updateSellIn() {
        item.sellIn--
    }
}
