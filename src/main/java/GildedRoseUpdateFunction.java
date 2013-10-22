
import java.util.List;

/**
 *
 * @author Tobias
 */
public class GildedRoseUpdateFunction {

    public void apply(Item item) {
        if (isNormalProduct(item)) {
            if (isQualityGreaterZero(item)) {
                reduceQualityByOne(item);

                if (isSellInOvertaken(item)) {
                    reduceQualityByOne(item);
                }
            }
            reduceSellIn(item);

        } else {
            if (item.getQuality() < 50) {
                increaseQualityByOne(item);
                increaseQualityForBackstagePasses(item);
                reduceSellIn(item);
            }

            if (isSellInOvertaken(item)) {
                if (item.getQuality() < 50) {
                    increaseQualityByOne(item);
                }
            }
        }
    }

    private boolean isNormalProduct(Item item) {
        return (!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()) && !"Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private boolean isQualityGreaterZero(Item item) {
        return item.getQuality() > 0;
    }

    private void reduceQualityByOne(Item item) {
        item.setQuality(item.getQuality() - 1);
    }

    private void increaseQualityByOne(Item item) {
        item.setQuality(item.getQuality() + 1);
    }

    private void reduceSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    private void increaseQualityForBackstagePasses(Item item) {
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    increaseQualityByOne(item);
                }
            }

            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    increaseQualityByOne(item);
                }
            }
        }
    }

    private boolean isSellInOvertaken(Item item) {
        return item.getSellIn() < 0;
    }
}
