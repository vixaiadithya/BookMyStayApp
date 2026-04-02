import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 5: Booking Request (First-Come-First-Served)
 * @version 5.0
 */

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Room Type: " + roomType);
    }
}

// Main class
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v5.0 =====");

        // Queue for booking requests (FIFO)
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding booking requests
        bookingQueue.add(new Reservation("Alice", "Single Room"));
        bookingQueue.add(new Reservation("Bob", "Double Room"));
        bookingQueue.add(new Reservation("Charlie", "Suite Room"));

        System.out.println("\n--- Booking Requests in Queue ---");

        // Display queue (FIFO order)
        for (Reservation r : bookingQueue) {
            r.display();
        }

        System.out.println("\n===============================");
    }
}