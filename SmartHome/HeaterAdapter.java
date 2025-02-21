public class HeaterAdapter implements SmartDevice {
    private OldHeater oldHeater;

    public HeaterAdapter(OldHeater oldHeater) {
        this.oldHeater = oldHeater;
    }

    @Override
    public void turnOn() {
        System.out.println("Adapter: Converting to Smart Heater...");
        oldHeater.heatUp(5);
    }

    @Override
    public String toString() {
        return "HeaterAdapter[OldHeater]";
    }
}
