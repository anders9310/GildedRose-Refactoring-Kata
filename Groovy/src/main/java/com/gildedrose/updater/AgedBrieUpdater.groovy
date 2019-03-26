package com.gildedrose.updater

import com.gildedrose.Item

class AgedBrieUpdater extends ItemUpdater {

    AgedBrieUpdater(Item item) {
        super(item, 0, 50)
    }

    void update() {
        updateQuality()
        updateSellIn()
    }

    private void updateQuality() {
        if (item.sellIn > 0) {
            item.quality += 1
        } else {
            item.quality += 2
        }
        adjustQualityToThresholds()
    }
}
