package com.gildedrose.updater

import com.gildedrose.Item

class RegularItemUpdater extends ItemUpdater {

    RegularItemUpdater(Item item) {
        super(item, 0, 50)
    }

    void update() {
        this.item = item
        this.minQuality = 0
        this.maxQuality = 50
        updateQualityForItem(item)
        updateSellIn()
    }

    private void updateQualityForItem(Item item) {
        if (item.sellIn > 0) {
            item.quality -= 1
        } else {
            item.quality -= 2
        }
        adjustQualityToThresholds()
    }
}
