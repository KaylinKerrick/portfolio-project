/**
 * Kernel implementation for StageLight.
 *
 * @author Kaylin Kerrick
 *
 *         Convention: - color != null - position != null - 0 <= brightness <=
 *         100
 *
 *         Correspondence: - this.color is the abstract light color -
 *         this.position is the abstract light position - this.brightness is the
 *         abstract light level - this.powerOn is the abstract power state
 */

public class StageLight1L extends StageLightSecondary {

    //The Representation
    private String color;
    private String position;
    private int brightness;
    private boolean powerOn;

    // Default constructor initializes to off at center stage.
    public StageLight1L() {
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
