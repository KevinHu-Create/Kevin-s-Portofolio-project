package components.inventorymanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class InventoryManager1LTest {

    @Test
    public void testAddItem_getItemCount_basic() {
        InventoryManager1L inventory = new InventoryManager1L();

        inventory.addItem("apple", 10);

        assertEquals(10, inventory.getItemCount("apple"));
    }

    @Test
    public void testAddItem_twice() {
        InventoryManager1L inventory = new InventoryManager1L();

        inventory.addItem("banana", 5);
        inventory.addItem("banana", 3);

        assertEquals(8, inventory.getItemCount("banana"));
    }

    @Test
    public void testHasItem_true() {
        InventoryManager1L inventory = new InventoryManager1L();

        inventory.addItem("orange", 1);

        assertTrue(inventory.hasItem("orange"));
    }

    @Test
    public void testHasItem_false() {
        InventoryManager1L inventory = new InventoryManager1L();

        assertFalse(inventory.hasItem("nonexistent"));
    }

    @Test
    public void testRemoveItem_reduceCount() {
        InventoryManager1L inventory = new InventoryManager1L();
        inventory.addItem("apple", 10);

        inventory.removeItem("apple", 4);

        assertEquals(6, inventory.getItemCount("apple"));
        assertTrue(inventory.hasItem("apple"));
    }

    @Test
    public void testRemoveItem_removeCompletely() {
        InventoryManager1L inventory = new InventoryManager1L();
        inventory.addItem("banana", 3);

        inventory.removeItem("banana", 3);

        assertEquals(0, inventory.getItemCount("banana"));
        assertFalse(inventory.hasItem("banana"));
    }

    @Test
    public void testRemoveItem_invalidQuantity_shouldThrow() {
        InventoryManager1L inventory = new InventoryManager1L();
        inventory.addItem("orange", 2);

        try {
            inventory.removeItem("orange", 5);
            fail("Expected AssertionError not thrown");
        } catch (AssertionError e) {
        }
    }

}
