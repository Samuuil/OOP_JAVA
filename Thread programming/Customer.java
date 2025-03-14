import java.util.Random;

public class Customer implements Runnable, Comparable<Customer> {
    private final TicketBookingSystem bookingSystem;
    private final String customerName;
    private final int ticketsRequested;
    private static final Random random = new Random();

    public Customer(TicketBookingSystem bookingSystem, String customerName) {
        this.bookingSystem = bookingSystem;
        this.customerName = customerName;
        this.ticketsRequested = random.nextInt(5) + 1; // Requests between 1-5 tickets
    }

    @Override
    public void run() {
        bookingSystem.bookTicket(customerName, ticketsRequested);
    }

    public int getTicketsRequested() {
        return ticketsRequested;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.ticketsRequested, other.ticketsRequested);
    }
}
