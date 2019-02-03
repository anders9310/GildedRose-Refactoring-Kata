package com.gildedrose

println("OMGHAI!")

Item[] items = [
        new RegularItem("+5 Dexterity Vest", 10, 20),
        new AgedBrie(2, 0),
        new RegularItem("Elixir of the Mongoose", 5, 7),
        new RegularItem("Sulfuras, Hand of Ragnaros", 0, 80),
        new RegularItem("Sulfuras, Hand of Ragnaros", -1, 80),
        new BackstagePass(15, 20),
        new BackstagePass(10, 49),
        new BackstagePass(5, 49),
        // this conjured item does not work properly yet
        new RegularItem("Conjured Mana Cake", 3, 6)] as Item[]

GildedRose app = new GildedRose(items)

int days = 2
if (args.length > 0) {
    days = Integer.parseInt(args[0]) + 1
}

for (int i = 0; i < days; i++) {
    println("-------- day " + i + " --------")
    println("name, sellIn, quality")
    for (Item item in items) {
        println(item)
    }
    println ""
    app.updateQuality()
}
