import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 3: Centralized Room Inventory Management
 * Demonstrates use of HashMap for managing room availability.
 *
 * @author Vijai
 * @version 3.0
 */

// Inventory class (Single Source of Truth)
class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor → initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

// Main class
public class UseCase3InventorySetup {
    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v3.0 =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Example update
        System.out.println("\nUpdating Double Room availability...");
        inventory.updateAvailability("Double Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\n===============================");
    }
}