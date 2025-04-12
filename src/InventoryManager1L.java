import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Kernel implementation of the InventoryManager component.
 *
 * Representation: - A Map<String, Integer> inventory, where keys are unique
 * item names and values are positive integers representing item counts.
 *
 * Convention: - All item names (keys) in the map are non-null and non-empty. -
 * All item quantities (values) are strictly positive integers (> 0).
 *
 * Correspondence: - For any item 'k', this.inventory.get(k) represents the
 * number of units of item 'k' in the inventory.
 */
public class InventoryManager1L extends InventoryManagerSecondary {

    private  Map<String, Integer> inventory;

    /**
     * Creates and returns a new empty representation for the inventory.
     *
     * @return a new empty map
     */
    private Map<String, Integer> createNewRep() {
        return new HashMap<>();
    }

    /**
     * No-argument constructor. Initializes the inventory as an empty map.
     */
    public InventoryManager1L() {
        this.inventory = this.createNewRep();
    }

    /**
     * {@inheritDoc}
     *
     * Creates and returns a new, empty instance of InventoryManager.
     *
     * @return new instance of InventoryManager
     */
    @Override
    public InventoryManager newInstance() {
        return new InventoryManager1L();
    }

    /**
     * {@inheritDoc}
     *
     * Clears all items from the inventory.
     */
    @Override
    public void clear() {
        this.inventory = this.createNewRep();
    }

    @Override
    public String toString() {
    return this.inventory.toString();
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
        return false;
    }
    InventoryManager1L other = (InventoryManager1L) o;
    return this.inventory.equals(other.inventory);
    }

    @Override
    public int hashCode() {
    return this.inventory.hashCode();
    }

    /**
     * {@inheritDoc}
     *
     * Transfers the contents of the source inventory into this inventory. The
     * source inventory will be empty after the operation.
     *
     * @param source
     *            the inventory to transfer from
     * @requires source != null
     * @ensures this = #source and source = empty
     */
    @Override
    public void transferFrom(InventoryManager source) {
        assert source != null : "source must not be null";

        this.clearInventory();

        for (String item : source.getAllItems()) {
            int quantity = source.getItemCount(item);
            this.restock(item, quantity);
        }

        source.clearInventory();
    }

    /**
     * {@inheritDoc}
     *
     * Adds the specified quantity of the given item to the inventory. If the
     * item already exists, the quantity is added to the existing count.
     *
     * @param name
     *            the name of the item
     * @param count
     *            the quantity to add
     * @requires itemName != null && quantity > 0
     * @ensures this.inventory[itemName] = #this.inventory[itemName] + quantity
     */
    @Override
    public void addItem(String name, int count) {
        assert name != null : "Violation of: name is not null";
        assert !name.isEmpty() : "Violation of: name is not empty";
        assert count > 0 : "Violation of: count > 0";

        int currentCount = this.inventory.getOrDefault(name, 0);
        this.inventory.put(name, currentCount + count);
    }

    /**
     * {@inheritDoc}
     *
     * Removes the specified quantity of the given item from the inventory. If
     * the remaining quantity becomes zero, the item is removed entirely.
     *
     * @param itemName
     *            the name of the item
     * @param quantity
     *            the quantity to remove
     * @requires itemName != null && quantity > 0 && this.inventory contains
     *           itemName && this.inventory[itemName] >= quantity
     * @ensures this.inventory[itemName] = #this.inventory[itemName] - quantity,
     *          or item removed if count reaches 0
     */
    @Override
    public void removeItem(String itemName, int quantity) {
        assert itemName != null : "itemName is null";
        assert quantity > 0 : "quantity must be > 0";
        assert this.inventory.containsKey(itemName) : "item does not exist";
        assert this.inventory.get(itemName) >= quantity : "not enough stock";

        int current = this.inventory.get(itemName);
        int newCount = current - quantity;

        if (newCount > 0) {
            this.inventory.put(itemName, newCount);
        } else {
            this.inventory.remove(itemName);
        }
    }

    /**
     * {@inheritDoc}
     *
     * Checks whether the inventory contains the specified item.
     *
     * @param itemName
     *            the name of the item to check
     * @return true if the item exists in inventory, false otherwise
     * @requires itemName != null
     * @ensures \result = (this.inventory contains itemName)
     */
    @Override
    public boolean hasItem(String itemName) {
        assert itemName != null : "itemName is null";
        return this.inventory.containsKey(itemName);
    }

    /**
     * {@inheritDoc}
     *
     * Returns the current quantity of the specified item. Returns 0 if the item
     * does not exist in the inventory.
     *
     * @param itemName
     *            the name of the item
     * @return the quantity of the item, or 0 if not present
     * @requires itemName != null
     * @ensures \result = this.inventory[itemName] if itemName exists, else 0
     */
    @Override
    public int getItemCount(String itemName) {
        assert itemName != null : "itemName is null";
        return this.inventory.getOrDefault(itemName, 0);
    }

    /**
     * {@inheritDoc}
     *
     * Returns a set containing all item names currently in the inventory. The
     * returned set is a copy and does not allow external modification of the
     * internal state.
     *
     * @return a sorted set of item names currently in the inventory
     */
    @Override
    public Set<String> getAllItems() {
        return new TreeSet<>(this.inventory.keySet());
    }
}
