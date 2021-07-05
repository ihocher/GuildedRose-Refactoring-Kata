package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void AgedBrieQualityMaxCheck(){
        Item[] items = new Item[]{new Item("Aged Brie", 0,0 )};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<60;i++){
            app.updateQuality();
        }

        assertEquals(-60, app.items[0].sellIn);
        assertEquals(50,app.items[0].quality);
    }

    @Test
    void SulfurasQualityMaxCheck(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0,80 )};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<100;i++){
            app.updateQuality();
        }

        assertEquals(0, app.items[0].sellIn);
        assertEquals(80,app.items[0].quality);
    }

    @Test
    void notSpecialItemLessThanZero(){
        Item[] items = new Item[]{new Item("Elixir of the Mongoose", 2,30 )};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<4;i++){
            app.updateQuality();
        }
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(24,app.items[0].quality);
    }

    @Test
    void QualityIncreaseBrie(){
        Item[] items = new Item[]{new Item("Aged Brie", 5,30 )};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<2;i++){
            app.updateQuality();
        }
        assertEquals(3, app.items[0].sellIn);
        assertEquals(32,app.items[0].quality);
    }

    @Test
    void BackstageZeroQualityAfterSellInDate(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2,20 )};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<4;i++){
            app.updateQuality();
        }

        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0,app.items[0].quality);
    }

    @Test
    void BackstageQualityIncreaseLessThanTenDays(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",10,30)};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<2;i++){
            app.updateQuality();
        }
        assertEquals(8, app.items[0].sellIn);
        assertEquals(34,app.items[0].quality);
    }

    @Test
    void BackstageQualityIncreaseLessThanFiveDays(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",5,30)};
        GildedRose app = new GildedRose(items);

        for(int i =0;i<2;i++){
            app.updateQuality();
        }
        assertEquals(3, app.items[0].sellIn);
        assertEquals(36,app.items[0].quality);
    }

    @Test
    void checkConjured() {
        Item[] items = new Item[]{new Item("Conjured", 10, 20)};
        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 2; i++) {
            app.updateQuality();
        }

        assertEquals(8, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }
}
