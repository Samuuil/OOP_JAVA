class VacationItineraryBuilder extends ItineraryBuilder {
    @Override
    public void buildFlights() {
        itinerary.add("jet");
    }

    @Override
    public void buildHotels() {
        itinerary.add("Marinela");
    }

    @Override
    public void buildActivities() {
        itinerary.add("Plaza");
    }

    @Override
    public void buildTransport() {
        itinerary.add("Buggati");
    }
}