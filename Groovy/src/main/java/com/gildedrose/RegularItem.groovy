package com.gildedrose

class RegularItem extends Item {
    RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality)
    }

    void updateSellIn() {
        sellIn -= 1
    }

    int getMaxQuality() {
        return 50
    }

    int getMinQuality() {
        return 0
    }

    int getQualityDifference() {
        if (sellIn > 0) {
            return -1
        } else {
            return -2
        }
    }
}
