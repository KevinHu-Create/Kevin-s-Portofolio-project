import java.util.Set;
import java.util.TreeSet;

/**
 * Abstract class that implements the secondary methods of the
 * {@code InventoryManager} component. All methods are implemented using only
 * kernel methods, and this class assumes no knowledge of the underlying
 * representation.
 *
 * This follows the OSU CSE component design discipline.
 */
public abstract class InventoryManagerSecondary implements InventoryManager {

    /**
     * {@inheritDoc}
     *
     * Clears the entire inventory by removing all items.
     */
    @Override
    public void clearInventory() {
        Set<String> items = new TreeSet<>(this.getAllItems());
        for (String item : items) {
            int quantity = this.getItemCount(item);
            this.removeItem(item, quantity);
        }
    }

    /**
     * {@inheritDoc}
     *
     * Determines whether the stock of a particular item is considered low. An
     * item is considered low if its quantity is less than 5.
     *
     * @param itemName
     *            the name of the item to check
     * @return {@code true} if the stock is low; {@code false} otherwise
     */
    @Override
    public boolean isStockLow(String itemName) {
        assert itemName != null : "Violation of: itemName is not null";
        return this.getItemCount(itemName) < 5;
    }

    /**
     * {@inheritDoc}
     *
     * Restocks the given item by adding the specified quantity.
     *
     * @param itemName
     *            the name of the item to restock
     * @param quantity
     *            the amount to add to the item’s stock
     */
    @Override
    public void restock(String itemName, int quantity) {
        assert itemName != null : "Violation of: itemName is not null";
        assert quantity > 0 : "Violation of: quantity > 0";
        this.addItem(itemName, quantity);
    }

    /**
     * Returns a string representation of the inventory contents.
     *
     * @return a formatted string showing all items and their quantities
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory:\n");

        for (String item : this.getAllItems()) {
            sb.append(item).append(": ").append(this.getItemCount(item))
                    .append("\n");
        }

        return sb.toString();
    }

}
