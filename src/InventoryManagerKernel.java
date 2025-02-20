/**
 * Kernel interface for InventoryManager. Defines core operations of an
 * inventory system.
 */
public interface InventoryManagerKernel {
    /**
     * Adds an item to the inventory with the given quantity.
     *
     * @param itemName
     *            Name of the item
     * @param quantity
     *            Quantity to be added
     */
    void addItem(String itemName, int quantity);

    /**
     * Removes a specific quantity of an item from inventory.
     *
     * @param itemName
     *            Name of the item
     * @param quantity
     *            Quantity to be removed
     */
    void removeItem(String itemName, int quantity);

    /**
     * Checks if an item exists in inventory.
     *
     * @param itemName
     *            Name of the item
     * @return true if the item exists, false otherwise
     */
    boolean hasItem(String itemName);

    /**
     * Gets the quantity of an item in inventory.
     *
     * @param itemName
     *            Name of the item
     * @return Quantity of the item, or 0 if not found
     */
    int getItemCount(String itemName);
}
