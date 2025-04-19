package components.inventorymanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InventoryManagerTest {

    @Test
    public void testClearInventory_basic() {
        InventoryManager inventory = new InventoryManager1L();
        inventory.addItem("apple", 10);
        inventory.addItem("banana", 5);

        inventory.clearInventory();

        assertFalse(inventory.hasItem("apple"));
        assertFalse(inventory.hasItem("banana"));
    }

    @Test
    public void testIsStockLow_true() {
        InventoryManager inventory = new InventoryManager1L();
        inventory.addItem("milk", 2);

        assertTrue(inventory.isStockLow("milk"));
    }

    @Test
    public void testIsStockLow_false() {
        InventoryManager inventory = new InventoryManager1L();
        inventory.addItem("eggs", 10);

        assertFalse(inventory.isStockLow("eggs"));
    }

    @Test
    public void testRestock_basic() {
        InventoryManager inventory = new InventoryManager1L();
        inventory.addItem("juice", 3);

        inventory.restock("juice", 7);

        assertEquals(10, inventory.getItemCount("juice"));
    }

}
