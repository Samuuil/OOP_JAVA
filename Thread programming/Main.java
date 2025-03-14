
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int totalTickets = 10;
        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);

        PriorityQueue<Customer> customerQueue = new PriorityQueue<>();

        for (int i = 0; i < 6; i++) {
            customerQueue.add(new Customer(bookingSystem, "Customer-" + (i + 1)));
        }

        while (!customerQueue.isEmpty()) {
            Thread customerThread = new Thread(customerQueue.poll());
            customerThread.start();

            try {
                customerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tickets remaining: " + bookingSystem.getAvailableTickets());
    }
}