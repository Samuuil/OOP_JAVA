class BusinessItineraryBuilder extends ItineraryBuilder {
    @Override
    public void buildFlights() {
        itinerary.add("Business Class");
    }

    @Override
    public void buildHotels() {
        itinerary.add("Milenium");
    }

    @Override
    public void buildActivities() {
        itinerary.add("Bushido");
    }

    @Override
    public void buildTransport() {
        itinerary.add("Maybach");
    }
}