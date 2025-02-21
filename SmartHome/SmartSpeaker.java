public class SmartSpeaker implements SmartDevice {
    private int volume;
    private String language;

    public SmartSpeaker(int volume, String language) {
        this.volume = volume;
        this.language = language;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart Speaker is ON with volume " + volume + " and language " + language);
    }

    @Override
    public String toString() {
        return "SmartSpeaker[Volume=" + volume + ", Language=" + language + "]";
    }
}
