import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof-of-concept for a StageLight component.
 *
 * @author Kaylin Kerrick
 */
public class StageLightProofOfConcept {

    /*
     * Representation.
     */
    private String color;
    private String position;
    private int brightness;
    private boolean isOn;

    /**
     * Constructor, sets light to a default setting.
     */
    public StageLightProofOfConcept() {
        this.color = "white";
        this.position = "center";
        this.brightness = 0;
        this.isOn = false;
    }

    /*
     *
     * Kernel Methods.
     *
     */

    /**
     * Changes the color of the light.
     *
     * @param indexedColor
     *            the new color
     */
    public void setColor(String indexedColor) {
        this.color = indexedColor;
    }

    /**
     * Changes the position of where the light is pointing.
     *
     * @param newPosition
     *            the new position on stage
     */
    public void setPosition(String newPosition) {
        this.position = newPosition;
    }

    /**
     * Adjusts the light's level of brightness.
     *
     * @param lightLevel
     *            brightness level (can be 0-100)
     */
    public void setBrightness(int lightLevel) {
        //We don't want the light level to go out of bounds (0-100)
        int lowestLevel = 0;
        int highestLevel = 100;

        if (lightLevel < lowestLevel) {
            lightLevel = 0;
        } else if (lightLevel > highestLevel) {
            lightLevel = 100;
        }

        this.brightness = lightLevel;
    }

    /**
     * Switches the light on/off.
     */
    public void toggle() {
        this.isOn = !this.isOn;
    }

    /*
     * Secondary Methods.
     */

    /**
     * Reports the current color, position, brightness, and toggle of the light.
     *
     * @return description of light's properties.
     */
    public String getStatus() {
        String result = "StageLight[";
        //Add the color
        result += "color=" + this.color;
        //Add the position
        result += ", position=" + this.position;
        //Add brightness
        result += ", brightness=" + this.brightness;
        //Add isOn
        result += ", isOn=" + this.isOn + "]";

        return result;
    }

    /*
     * Main Method.
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        StageLightProofOfConcept light = new StageLightProofOfConcept();
        //Print the original status
        out.println("Initial status: " + light.getStatus());

        //Change the light's status
        light.toggle();
        light.setColor("red");
        light.setPosition("left stage");
        light.setBrightness(75);

        //Print the changed status
        out.println("Final status: " + light.getStatus());
        out.close();
    }
}