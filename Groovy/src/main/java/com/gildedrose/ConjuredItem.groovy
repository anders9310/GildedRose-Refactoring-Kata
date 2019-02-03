package com.gildedrose

class ConjuredItem extends Item {
    ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality)
    }

    void updateSellIn() {

    }

    int getMaxQuality() {
        return 50
    }

    int getMinQuality() {
        return 0
    }

    int getQualityDifference() {
        return defaultQualityDifference() * 2
    }
}
