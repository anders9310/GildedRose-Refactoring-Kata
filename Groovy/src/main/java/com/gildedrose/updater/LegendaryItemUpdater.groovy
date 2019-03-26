package com.gildedrose.updater

import com.gildedrose.Item

class LegendaryItemUpdater extends ItemUpdater {
    LegendaryItemUpdater(Item item) {
        super(item, item.quality, item.quality)
    }

    void update() {
        //Legendary items do not change their quality or sellIn
    }
}
