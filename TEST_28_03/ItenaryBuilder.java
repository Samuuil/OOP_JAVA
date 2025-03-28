abstract class ItineraryBuilder {
    protected Itinerary itinerary;

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void createNewItinerary() {
        itinerary = new Itinerary();
    }

    public abstract void buildFlights();
    public abstract void buildHotels();
    public abstract void buildActivities();
    public abstract void buildTransport();
}