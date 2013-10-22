
/**
 *
 * @author Tobias
 */
public class Product extends Item implements UpdateableItem {

    public Product(Item item) {
        super(item.getName(), item.getSellIn(), item.getQuality());
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
