/**
 * Enhanced interface for the InventoryManager component. This interface extends
 * InventoryManagerKernel and adds additional functionality.
 */
public interface InventoryManagerInterface extends InventoryManagerKernel {
    /**
     * Clears all inventory items.
     *
     * @ensures this.inventory = {}
     */
    void clearInventory();

    /**
     * Checks if an item's stock is low (below 5).
     *
     * @param itemName
     *            the name of the item
     * @return true if the stock is low, false otherwise
     * @requires itemName != null
     */
    boolean isStockLow(String itemName);

    /**
     * Restocks an item by adding the given quantity.
     *
     * @param itemName
     *            the name of the item
     * @param quantity
     *            the amount to add to the stock
     * @requires itemName != null && quantity > 0
     * @ensures this.inventory[itemName] = #this.inventory[itemName] + quantity
     */
    void restock(String itemName, int quantity);

    /**
     * Creates a new instance of InventoryManager.
     *
     * @return a new instance of InventoryManager
     */
    InventoryManagerInterface newInstance();
}
