package com.gildedrose

abstract class Item {

    String name

    int sellIn

    int quality

    Item(String name, int sellIn, int quality) {
        this.name = name
        this.sellIn = sellIn
        this.quality = quality
    }

    @Override
    String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    void updateQuality() {
        int newQuality = quality + getQualityDifference()
        if (newQuality > getMaxQuality()) {
            quality = getMaxQuality()
        } else if (newQuality < getMinQuality()) {
            quality = getMinQuality()
        } else {
            quality = newQuality
        }
    }

    abstract void updateSellIn()

    abstract int getMaxQuality()

    abstract int getMinQuality()

    abstract int getQualityDifference()

    protected int defaultQualityDifference() {
        if (sellIn > 0) {
            return -1
        } else {
            return -2
        }
    }
}
