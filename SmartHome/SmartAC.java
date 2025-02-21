public class SmartAC implements SmartDevice {
    private int temperature;
    private String mode;

    public SmartAC(int temperature, String mode) {
        this.temperature = temperature;
        this.mode = mode;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart AC is ON at " + temperature + "°C in " + mode + " mode.");
    }

    @Override
    public String toString() {
        return "SmartAC[Temperature=" + temperature + "°C, Mode=" + mode + "]";
    }
}
