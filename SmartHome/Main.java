public class Main {
    public static void main(String[] args) {
        SmartHomeManager homeManager = SmartHomeManager.getInstance();

        SmartDevice light = SmartDeviceFactory.createDevice("light");
        SmartDevice ac = SmartDeviceFactory.createDevice("ac");
        SmartDevice speaker = SmartDeviceFactory.createDevice("speaker");

        homeManager.addDevice(light);
        homeManager.addDevice(ac);
        homeManager.addDevice(speaker);

        SmartDevice customLight = new SmartLightBuilder().setBrightness(80).setColor("Blue").build();
        SmartDevice customAC = new SmartACBuilder().setTemperature(18).setMode("Heat").build();
        SmartDevice customSpeaker = new SmartSpeakerBuilder().setVolume(70).setLanguage("Spanish").build();

        homeManager.addDevice(customLight);
        homeManager.addDevice(customAC);
        homeManager.addDevice(customSpeaker);

        OldHeater oldHeater = new OldHeater();
        SmartDevice adaptedHeater = new HeaterAdapter(oldHeater);
        homeManager.addDevice(adaptedHeater);

        homeManager.showDevices();

        System.out.println("\nTurning on all devices:");
        for (SmartDevice device : new SmartDevice[]{light, ac, speaker, customLight, customAC, customSpeaker, adaptedHeater}) {
            device.turnOn();
        }
    }
}
