package components.stagelight;

/**
 * Kernel implementation for StageLight.
 *
 * @author Kaylin Kerrick
 *
 */
public class StageLight1L extends StageLightSecondary {
    //The Representation

    /**
     * Current color of the light.
     *
     * @convention color != null
     * @correspondence this.color = this.color
     */
    private String color;

    /**
     * Current position of the light on stage.
     *
     * @convention position != null
     * @correspondence this.position = this.position
     */
    private String position;

    /**
     * Current brightness level of the light.
     *
     * @convention 0 <= brightness <= 100
     * @correspondence this.brightness = this.brightness
     */
    private int brightness;

    /**
     * Whether the light is turned on/off.
     *
     * @convention powerOn is either true (light on) or false (light off)
     * @correspondence this.isOn = this.powerOn
     */
    private boolean powerOn;

    // Default constructor
    public StageLight1L() {
        this.createNewRep();
    }

    private void createNewRep() {
        this.color = "white";
        this.position = "center";
        this.brightness = 0;
        this.powerOn = false;
    }

    // The Kernel Methods
    @Override
    public void setColor(String c) {
        assert c != null : "Color cannot be null";
        this.color = c;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void setPosition(String p) {
        assert p != null : "Position cannot be null";
        this.position = p;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public void setBrightness(int level) {
        assert 0 <= level && level <= 100 : "Brightness out of range";
        this.brightness = level;
    }

    @Override
    public int getBrightness() {
        return this.brightness;
    }

    @Override
    public void turnOn() {
        this.powerOn = true;
    }

    @Override
    public void turnOff() {
        this.powerOn = false;
    }

    @Override
    public boolean isOn() {
        return this.powerOn;
    }

    @Override
    public void toggle() {
        this.powerOn = !this.powerOn;
    }

    //Standard Methods
    @Override
    public void clear() {
        this.color = "white";
        this.position = "center";
        this.brightness = 0;
        this.powerOn = false;
    }

    @Override
    public void transferFrom(StageLight source) {
        assert source != null : "Source cannot be null";
        assert source instanceof StageLight1L : "Source must be StageLight1L";

        StageLight1L localSource = (StageLight1L) source;

        this.color = localSource.color;
        this.position = localSource.position;
        this.brightness = localSource.brightness;
        this.powerOn = localSource.powerOn;

        // Clear source
        localSource.clear();
    }

    @Override
    public StageLight newInstance() {
        return new StageLight1L();
    }
}
