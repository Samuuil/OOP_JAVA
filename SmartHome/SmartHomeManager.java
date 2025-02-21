import java.util.ArrayList;
import java.util.List;

public class SmartHomeManager {
    private static SmartHomeManager instance;
    private List<SmartDevice> devices;

    private SmartHomeManager() {
        devices = new ArrayList<>();
    }

    public static SmartHomeManager getInstance() {
        if (instance == null) {
            instance = new SmartHomeManager();
        }
        return instance;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void showDevices() {
        for (SmartDevice device : devices) {
            System.out.println(device);
        }
    }
}
