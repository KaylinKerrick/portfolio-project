/**
 * The StageLight component's abstract class. Methods are implemented using only
 * Kernel and Standard methods.
 *
 * @author Kaylin Kerrick
 */
public abstract class StageLightSecondary implements StageLight {
    @Override
    public void fadeToBlack() {
        //Keep decrementing the brightness until it hits zero
        while (this.getBrightness() > 0) {
            //Decrement by 5 light levels each loop to slowly fade to black
            int fadedLevel = this.getBrightness() - 5;

            //Light level can't go below zero
            if (fadedLevel < 0) {
                fadedLevel = 0;
            }

            //Set the brightness to the new faded light level
            this.setBrightness(fadedLevel);
        }
    }

    @Override
    public void spotlight() {
        //Spotlight is center stage
        this.setPosition("center");

        //Spotlight has full brightness (100)
        this.setBrightness(100);

        //Spotlight is the color white
        this.setColor("white");

        //Spotlight must be on
        if (!this.isOn()) {
            this.toggle();
        }
    }

    @Override
    public String getStatus() {
        //Want to return a formatted string of the light's properties
        String status = "StageLight[color=" + this.getColor();
        status += ", position=" + this.getPosition();
        status += ", brightness=" + this.getBrightness();
        status += ", isOn=" + this.isOn() + "]";

        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof StageLight)) {
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
}
