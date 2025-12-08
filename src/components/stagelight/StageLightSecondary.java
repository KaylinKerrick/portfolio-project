package components.stagelight;

/**
 * Secondary implementation for StageLight.
 *
 * @author Kaylin Kerrick
 *
 *         Implements all secondary methods using the kernel methods.
 */
public abstract class StageLightSecondary implements StageLight {

    protected StageLightSecondary() {
        //This is the default constructor
    }

    //Implement the secondary methods
    @Override
    public void fadeToBlack() {
        while (this.getBrightness() > 0) {
            this.setBrightness(this.getBrightness() - 1);
        }

        this.turnOff();
    }

    @Override
    public void spotlight() {
        this.turnOn();
        this.setBrightness(100);
        this.setPosition("center");
    }

    @Override
    public String getStatus() {
        return "Color: " + this.getColor() + ", Position: " + this.getPosition()
                + ", Brightness: " + this.getBrightness() + ", Power: "
                + (this.isOn() ? "On" : "Off");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StageLight)) {
            return false;
        }
        StageLight other = (StageLight) obj;
        return this.getColor().equals(other.getColor())
                && this.getPosition().equals(other.getPosition())
                && this.getBrightness() == other.getBrightness()
                && this.isOn() == other.isOn();
    }

    @Override
    public String toString() {
        return this.getStatus();
    }

    @Override
    public int hashCode() {
        int result = this.getColor().hashCode();
        result = 31 * result + this.getPosition().hashCode();
        result = 31 * result + this.getBrightness();
        result = 31 * result + (this.isOn() ? 1 : 0);
        return result;
    }
}
