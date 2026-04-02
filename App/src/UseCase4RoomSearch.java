import java.util.HashMap;
import java.util.Map;

/**
 * Use Case 4: Room Search & Availability Check
 * @version 4.0
 */

// Room class (Domain Model)
class Room {
    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Beds: " + beds);
        System.out.println("Price: ₹" + price);
    }

    public String getType() {
        return type;
    }
}

// Inventory (Read-only usage here)
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0); // unavailable
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// Main Class
public class UseCase4RoomSearch {
    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v4.0 =====");

        // Room objects
        Room r1 = new Room("Single Room", 1, 2000);
        Room r2 = new Room("Double Room", 2, 3500);
        Room r3 = new Room("Suite Room", 3, 5000);

        // Inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("\n--- Available Rooms ---");

        // Search logic (Read-only)
        if (inventory.getAvailability(r1.getType()) > 0) {
            r1.displayDetails();
            System.out.println("Available: " + inventory.getAvailability(r1.getType()));
            System.out.println();
        }

        if (inventory.getAvailability(r2.getType()) > 0) {
            r2.displayDetails();
            System.out.println("Available: " + inventory.getAvailability(r2.getType()));
            System.out.println();
        }

        if (inventory.getAvailability(r3.getType()) > 0) {
            r3.displayDetails();
            System.out.println("Available: " + inventory.getAvailability(r3.getType()));
            System.out.println();
        }

        System.out.println("===============================");
    }
}