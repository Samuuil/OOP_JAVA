public class SmartSpeakerBuilder {
    private int volume = 50;
    private String language = "English";

    public SmartSpeakerBuilder setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public SmartSpeakerBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public SmartSpeaker build() {
        return new SmartSpeaker(volume, language);
    }
}
