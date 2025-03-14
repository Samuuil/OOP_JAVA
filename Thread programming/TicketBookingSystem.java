import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class TicketBookingSystem {
    private int availableTickets;
    private final Lock lock = new ReentrantLock(true);

    public TicketBookingSystem(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public boolean bookTicket(String customerName, int ticketsRequested) {
        try {
            if (lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                try {
                    if (ticketsRequested <= availableTickets) {
                        availableTickets -= ticketsRequested;
                        System.out.println(customerName + " successfully books " + ticketsRequested + " ticket(s).");
                        return true;
                    } else {
                        System.out.println(customerName + " unsuccessfully attempts to book " + ticketsRequested
                                + " ticket(s). Only " + availableTickets + " remain.");
                        return false;
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(customerName + " could not acquire the lock within 300ms and failed to book.");
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(customerName + " was interrupted while waiting for the lock.");
            return false;
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
