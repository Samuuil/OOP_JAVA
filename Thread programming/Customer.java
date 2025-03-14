import java.util.Random;

public class Customer implements Runnable {
    private final TicketBookingSystem system;
    private final String customerName;
    private final int ticketsRequested;

    public Customer(TicketBookingSystem system, String customerName) {
        this.system = system;
        this.customerName = customerName;
        this.ticketsRequested = new Random().nextInt(5) + 1;
    }

    @Override
    public void run() {
        system.bookTicket(customerName, ticketsRequested);
    }
}

