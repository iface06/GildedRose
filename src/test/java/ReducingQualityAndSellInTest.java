
import org.junit.Test;
import static org.junit.Assert.*;

public class ReducingQualityAndSellInTest {

    @Test
    public void testReducingQuality() {
        Item item = new Item("Test Item", 10, 10);
        ReducingQualityAndSellInFunction f = new ReducingQualityAndSellInFunction();
        f.apply(item);

        assertEquals(9, item.getQuality());
    }

    @Test
    public void testQualityZero() {
        Item item = new Item("Test Item", 10, 0);
        ReducingQualityAndSellInFunction f = new ReducingQualityAndSellInFunction();
        f.apply(item);

        assertEquals(0, item.getQuality());
    }

    @Test
    public void testReducingQualityTwice() {
        Item item = new Item("Test Item", -1, 10);
        ReducingQualityAndSellInFunction f = new ReducingQualityAndSellInFunction();
        f.apply(item);

        assertEquals(8, item.getQuality());
    }

    @Test
    public void testReducingSellIn() {
        Item item = new Item("Test Item", 10, 10);
        ReducingQualityAndSellInFunction f = new ReducingQualityAndSellInFunction();
        f.apply(item);

        assertEquals(9, item.getSellIn());
    }

    private static class ReducingQualityAndSellInFunction {

        private void apply(Item item) {
            reducingQuality(item);
            reducingSellIn(item);

        }

        private void reducingQuality(Item item) {
            if (item.getSellIn() < 0) {
                item.setQuality(item.getQuality() - 2);
            } else if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }

        private void reducingSellIn(Item item) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }
}
