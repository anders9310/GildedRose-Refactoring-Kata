package com.gildedrose.updater

import com.gildedrose.Item

class BackstagePassUpdater extends ItemUpdater {

    BackstagePassUpdater(Item item) {
        super(item, 0, 50)
    }

    void update() {
        updateQualityForBackstagePass()
        updateSellIn()
    }

    private void updateQualityForBackstagePass() {
        if (item.sellIn <= 0) {
            item.quality = 0
        } else if (item.sellIn < 6) {
            item.quality += 3
        } else if (item.sellIn < 11) {
            item.quality += 2
        } else if (item.sellIn >= 11) {
            item.quality += 1
        }
        adjustQualityToThresholds()
    }
}
