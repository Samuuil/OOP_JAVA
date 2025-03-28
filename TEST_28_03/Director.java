class Director {
    private ItineraryBuilder builder;

    public void setBuilder(ItineraryBuilder builder) {
        this.builder = builder;
    }

    public Itinerary construct() {
        builder.createNewItinerary();
        builder.buildFlights();
        builder.buildHotels();
        builder.buildActivities();
        builder.buildTransport();
        return builder.getItinerary();
    }
}