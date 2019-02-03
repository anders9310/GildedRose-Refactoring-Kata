package com.gildedrose

class BackstagePass extends Item {
    BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)
    }

    int getQualityDifference() {
        if (sellIn > 10) {
            return 1
        } else if (sellIn >= 6 && sellIn <= 10) {
            return 2
        } else if (sellIn > 0 && sellIn < 6) {
            return 3
        } else {
            return -quality
        }
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
}
