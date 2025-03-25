import java.util.Set;

import components.standard.Standard;

/**
 * Kernel interface for InventoryManager. Defines core operations of an
 * inventory system.
 */
public interface InventoryManagerKernel extends Standard<InventoryManager> {

    /**
     * Adds an item to the inventory with the given quantity.
     *
     * @param itemName
     *            Name of the item
     * @param quantity
     *            Quantity to be added
     * @requires itemName != null && quantity > 0
     * @ensures this.inventory[itemName] = #this.inventory[itemName] + quantity
     */
    void addItem(String itemName, int quantity);

    /**
     * Removes a specific quantity of an item from inventory.
     *
     * @param itemName
     *            Name of the item
     * @param quantity
     *            Quantity to be removed
     * @requires itemName != null && quantity > 0 && this.inventory[itemName] >=
     *           quantity
     * @ensures this.inventory[itemName] = #this.inventory[itemName] - quantity
     */
    void removeItem(String itemName, int quantity);

    /**
     * Checks if an item exists in inventory.
     *
     * @param itemName
     *            Name of the item
     * @return true if the item exists, false otherwise
     * @requires itemName != null
     * @ensures \result = (this.inventory contains itemName)
     */
    boolean hasItem(String itemName);

    /**
     * Gets the quantity of an item in inventory.
     *
     * @param itemName
     *            Name of the item
     * @return Quantity of the item, or 0 if not found
     * @requires itemName != null
     * @ensures \result = this.inventory[itemName] if itemName exists, else 0
     */
    int getItemCount(String itemName);

    /**
     * Returns the set of all item names in the inventory.
     *
     * @return Set of item names
     * @ensures \result = all keys in inventory
     */
    Set<String> getAllItems();
}
