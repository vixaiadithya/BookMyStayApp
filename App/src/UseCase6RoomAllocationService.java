import java.util.*;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 * @version 6.0
 */

// Reservation class
class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

// Inventory Service
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decrease(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Booking Service
class BookingService {
    private Map<String, Set<String>> allocatedRooms = new HashMap<>();
    private Set<String> usedRoomIds = new HashSet<>();
    private int counter = 1;

    public String allocateRoom(String roomType) {
        String roomId;

        do {
            roomId = roomType.replace(" ", "") + "-" + counter++;
        } while (usedRoomIds.contains(roomId));

        usedRoomIds.add(roomId);

        allocatedRooms.putIfAbsent(roomType, new HashSet<>());
        allocatedRooms.get(roomType).add(roomId);

        return roomId;
    }
}

// Main class
public class UseCase6RoomAllocationService {
    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v6.0 =====");

        // Queue (FIFO)
        Queue<Reservation> queue = new LinkedList<>();
        queue.add(new Reservation("Alice", "Single Room"));
        queue.add(new Reservation("Bob", "Double Room"));
        queue.add(new Reservation("Charlie", "Single Room"));

        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService();

        System.out.println("\n--- Reservation Confirmation ---");

        while (!queue.isEmpty()) {
            Reservation r = queue.poll();

            if (inventory.getAvailability(r.roomType) > 0) {
                String roomId = service.allocateRoom(r.roomType);
                inventory.decrease(r.roomType);

                System.out.println("Confirmed: " + r.guestName +
                        " | " + r.roomType +
                        " | Room ID: " + roomId);
            } else {
                System.out.println("Failed: " + r.guestName +
                        " | No rooms available");
            }
        }

        System.out.println("\n===============================");
    }
}
