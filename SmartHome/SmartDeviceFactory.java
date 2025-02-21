public class SmartDeviceFactory {
    public static SmartDevice createDevice(String type) {
        switch (type.toLowerCase()) {
            case "light":
                return new SmartLight(70, "White");
            case "ac":
                return new SmartAC(24, "Cool");
            case "speaker":
                return new SmartSpeaker(50, "English");
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}
