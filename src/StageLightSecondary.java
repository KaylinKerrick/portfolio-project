/**
 * The StageLight component's abstract class. Methods are implemented using only
 * Kernel and Standard methods.
 *
 * @author Kaylin Kerrick
 */
public class StageLightSecondary {

    /*
     * Fade to Black lowers the stage light level slowly until zero (black).
     */
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

    /*
     * Spotlight means the light is center stage, full brightness, white, and
     * on.
     */
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

    /*
     * The status of the StageLight details the light's color, position,
     * brightness, and toggle (on/off).
     */
    @Override
    public String getStatus() {
        //Want to return a formatted string of the light's properties
        String status = "StageLight[color=" + this.getColor();
        status += ", position=" + this.getPosition();
        status += ", brightness=" + this.getBrightness();
        status += ", isOn=" + this.isOn() + "]";
    }

    /*
     * Common Object Method: equals.
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal = (obj instanceof StageLight)
                && this.getStatus().equals(((StageLight) obj).getStatus());

        return equal;
    }

    /*
     * Common Object Method: toString.
     */
    @Override
    public String toString() {
        return this.getStatus();
    }
}
