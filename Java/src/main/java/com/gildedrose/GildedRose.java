package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Aged Brie":
                    increaseQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleBackStagePasses(item);
                    break;
                case "+5 Dexterity Vest":
                case "Elixir of the Mongoose":
                case "Conjured Mana Cake":
                    decreaseQuality(item);
                    decreaseSellIn(item);
                    if (item.sellIn < 0) {
                        decreaseQuality(item);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void handleBackStagePasses(Item item){
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
