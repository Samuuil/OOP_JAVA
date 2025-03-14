
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int totalTickets = 10;
        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalTickets);

        Thread[] customers = new Thread[6]; // Example: 6 customers

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Customer(bookingSystem, "Customer-" + (i + 1)));
            customers[i].start();
        }

        // Wait for all threads to finish
        for (Thread customer : customers) {
            try {
                customer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tickets remaining: " + bookingSystem.getAvailableTickets());
    }
}