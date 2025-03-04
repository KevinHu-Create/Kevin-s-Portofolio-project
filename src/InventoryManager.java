import java.util.TreeMap;

/**
 * InventoryManager component following OSU CSE component design discipline.
 * This implementation follows the Standard<T> pattern and implements Kernel &
 * Secondary methods.
 */
public final class InventoryManager implements InventoryManagerInterface {

    /**
     * Stores the inventory data with item names as keys and their corresponding
     * quantities as values.
     */
    private final TreeMap<String, Integer> inventory;

    /**
     * Constructor for InventoryManager.
     */
    public InventoryManager() {
        this.inventory = new TreeMap<>();
    }

    /**
     * Kernel Methods (Core Functionalities).
     */
    @Override
    public void addItem(String itemName, int quantity) {
        if (this.inventory.containsKey(itemName)) {
            int newQuantity = this.inventory.get(itemName) + quantity;
            this.inventory.put(itemName, newQuantity);
        } else {
            this.inventory.put(itemName, quantity);
        }
    }

    @Override
    public void removeItem(String itemName, int quantity) {
        if (this.inventory.containsKey(itemName)) {
            int currentQuantity = this.inventory.get(itemName);
            if (currentQuantity <= quantity) {
                this.inventory.remove(itemName);
            } else {
                this.inventory.put(itemName, currentQuantity - quantity);
            }
        }
    }

    @Override
    public boolean hasItem(String itemName) {
        return this.inventory.containsKey(itemName);
    }

    @Override
    public int getItemCount(String itemName) {
        return this.inventory.getOrDefault(itemName, 0);
    }

    /**
     * Secondary Methods (Implemented using Kernel Methods).
     */
    @Override
    public void clearInventory() {
        this.inventory.clear();
    }

    /**
     * Checks if an item is considered low in stock. An item is considered low
     * if its quantity is less than 5.
     *
     * @param itemName
     *            the name of the item to check
     * @return true if the stock is low, false otherwise
     */
    @Override
    public boolean isStockLow(String itemName) {
        return this.getItemCount(itemName) < 5;
    }

    /**
     * Restocks an item by adding the given quantity to its existing count.
     *
     * @param itemName
     *            the name of the item to restock
     * @param quantity
     *            the amount to add to the stock
     * @throws IllegalArgumentException
     *             if quantity is negative
     */
    @Override
    public void restock(String itemName, int quantity) {
        this.addItem(itemName, quantity);
    }

    /**
     * Implements Standard Interface Requirement. Provides a new instance of
     * InventoryManager.
     *
     * @return new instance of InventoryManager
     */
    @Override
    public InventoryManager newInstance() {
        return new InventoryManager();
    }

    /**
     * Main method for testing InventoryManager functionality.
     *
     * @param args
     *            Command-line arguments (not used)
     */
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addItem("Laptop", 10);
        manager.addItem("Mouse", 3);
        System.out.println("Laptop count: " + manager.getItemCount("Laptop"));
        System.out.println("Mouse count: " + manager.getItemCount("Mouse"));

        manager.removeItem("Laptop", 5);
        System.out.println("Laptop count after removal: "
                + manager.getItemCount("Laptop"));

        manager.clearInventory();
        System.out.println(
                "Inventory cleared. Has Laptop? " + manager.hasItem("Laptop"));
    }
}
