import components.inventorymanager.InventoryManager;
import components.inventorymanager.InventoryManager1L;

public class InventoryAppDemo1 {

    public static void main(String[] args) {
        // create InventoryManager object
        InventoryManager inventory = new InventoryManager1L();

        // add item
        inventory.addItem("apple", 10);
        inventory.addItem("banana", 5);

        // add again to show the additem function works well
        inventory.addItem("apple", 3);

        // search for item quantity, and also show that getItem and hasItem workswell
        System.out.println("Apple count: " + inventory.getItemCount("apple"));
        // should be 13
        System.out.println("Has banana? " + inventory.hasItem("banana"));
        // should be true

        // go around all the stock item
        System.out.println("\n=== Inventory Contents ===");
        for (String item : inventory.getAllItems()) {
            System.out.println(item + ": " + inventory.getItemCount(item));
        }

        // remove some numbers of banana
        inventory.removeItem("banana", 3);
        System.out.println("\nAfter removing 3 bananas:");
        System.out.println("Banana count: " + inventory.getItemCount("banana"));

        // remove apple
        inventory.removeItem("apple", 13);
        System.out.println("\nAfter removing all apples:");
        System.out.println("Has apple? " + inventory.hasItem("apple"));

        // print the final stock
        System.out.println("\n=== Final Inventory ===");
        System.out.println(inventory.toString());
    }
}
