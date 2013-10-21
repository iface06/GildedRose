
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class GildedRoseTest {

    private Item item;

    @Test
    public void testReducingSellIn() {
        item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose.updateItem(item);
        assertEquals(9, item.getSellIn());
    }

    @Test
    public void testReducingQuality() {
        item = new Item("+5 Dexterity Vest", 10, 20);
        GildedRose.updateItem(item);
        assertEquals(19, item.getQuality());
    }

    @Test
    public void testQualityIsNeverNegativ() {
        item = new Item("+5 Dexterity Vest", 10, 0);
        GildedRose.updateItem(item);
        assertEquals(0, item.getQuality());
    }

    @Test
    public void testAgedBrieQualityIncreases() {
        item = new Item("Aged Brie", 10, 1);
        GildedRose.updateItem(item);
        assertEquals(2, item.getQuality());
    }

    @Test
    public void testAgedBrieQualityLimit() {
        item = new Item("Aged Brie", 10, 50);
        GildedRose.updateItem(item);
        assertEquals(50, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncreasesForMoreThan5Days() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1);
        GildedRose.updateItem(item);
        assertEquals(3, item.getQuality());
    }

    @Test
    public void testBackstagePassesQualityIncreasesForLessThan5Days() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1);
        GildedRose.updateItem(item);
        assertEquals(4, item.getQuality());
    }

    @Test
    public void testSulfurasNeverHasToSoldOrdecreaseQuality() {
        item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        GildedRose.updateItem(item);
        assertEquals(80, item.getQuality());
        assertEquals(1, item.getSellIn());
    }
    //New Functionality
//    @Test
//    public void testConjuredDegradeQualityTwice() {
//        item = new Item("Conjured Mana Cake", 5, 4);
//        GildedRose.updateItem(item);
//        assertEquals(2, item.getQuality());
//    }
}
