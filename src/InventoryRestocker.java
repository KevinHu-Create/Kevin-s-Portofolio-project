import components.inventorymanager.InventoryManager;
import components.inventorymanager.InventoryManager1L;

public class InventoryRestocker {

    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager1L();

        // set initial stock
        inventory.addItem("water", 2);
        inventory.addItem("snacks", 6);
        inventory.addItem("notebooks", 0);
        inventory.addItem("pens", 4);

        System.out.println("=== Before Restocking ===");
        for (String item : inventory.getAllItems()) {
            System.out.println(item + ": " + inventory.getItemCount(item));
        }

        // Auto restock
        for (String item : inventory.getAllItems()) {
            if (inventory.isStockLow(item)) {
                inventory.restock(item, 10);
                System.out.println("Restocked: " + item);
            }
        }

        System.out.println("\n=== After Restocking ===");
        for (String item : inventory.getAllItems()) {
            System.out.println(item + ": " + inventory.getItemCount(item));
        }
    }
}
