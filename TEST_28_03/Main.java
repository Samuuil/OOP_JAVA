public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        ItineraryBuilder businessBuilder = new BusinessItineraryBuilder();
        director.setBuilder(businessBuilder);
        Itinerary businessItinerary = director.construct();
        System.out.println(businessItinerary);

        ItineraryBuilder vacationBuilder = new VacationItineraryBuilder();
        director.setBuilder(vacationBuilder);
        Itinerary vacationItinerary = director.construct();
        System.out.println(vacationItinerary);


        Mine mine = new Mine(400, 3); // Initialize mine with 100 resources and max 2 miners at a time
        Thread miner1 = new Thread(new Miner(mine, "Miner 1"));
        Thread miner2 = new Thread(new Miner(mine, "Miner 2"));
        Thread miner3 = new Thread(new Miner(mine, "Miner 3"));
        Thread miner4 = new Thread(new Miner(mine, "Miner 4"));
        Thread miner5 = new Thread(new Miner(mine, "Miner 5"));

        miner1.start();
        miner2.start();
        miner3.start();
        miner4.start();
        miner5.start();

        try {
            miner1.join();
            miner2.join();
            miner3.join();
            miner4.join();
            miner5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All miners have finished digging.");
    }
}
