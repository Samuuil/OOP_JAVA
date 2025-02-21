public class SmartLight implements SmartDevice {
    private int brightness;
    private String color;

    public SmartLight(int brightness, String color) {
        this.brightness = brightness;
        this.color = color;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart Light is ON with brightness " + brightness + " and color " + color);
    }

    @Override
    public String toString() {
        return "SmartLight[Brightness=" + brightness + ", Color=" + color + "]";
    }
}
