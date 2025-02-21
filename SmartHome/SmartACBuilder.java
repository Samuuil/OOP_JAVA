public class SmartACBuilder {
    private int temperature = 22;
    private String mode = "Cool";

    public SmartACBuilder setTemperature(int temperature) {
        this.temperature = temperature;
        return this;
    }

    public SmartACBuilder setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public SmartAC build() {
        return new SmartAC(temperature, mode);
    }
}
