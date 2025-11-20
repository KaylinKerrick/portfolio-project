import components.standard.Standard;

/**
 * Kernel interface for the StageLight component.
 *
 * @author Kaylin Kerrick
 */
public interface StageLightKernel extends Standard<StageLight> {
    /**
     * Changes the color shown from the stage light.
     *
     * @param colorIndex
     *            new color name (ex. "red")
     * @updates this
     * @ensures this.color = colorIndex
     */
    void setColor(String colorIndex);

    /**
     * Reports the current color of the light.
     *
     * @return the current color
     * @ensures getColor = this.color
     */
    String getColor();

    /**
     * Adjusts the light's level of brightness.
     *
     * @param level
     *            the brightness level (0 – 100)
     * @requires 0 <= level <= 100
     * @updates this
     * @ensures this.brightness = level
     */
    void setBrightness(int level);

    /**
     * Reports the current brightness level.
     *
     * @return the current brightness level
     * @ensures getBrightness = this.brightness
     */
    int getBrightness();

    /**
     * Changes the position where the light is pointing on stage.
     *
     * @param newPosition
     *            new position (ex. "left", "right", "center")
     * @updates this
     * @ensures this.position = newPosition
     */
    void setPosition(String newPosition);

    /**
     * Reports the current position of the light.
     *
     * @return the current position
     * @ensures getPosition = this.position
     */
    String getPosition();

    /**
     * Switches the light on or off.
     *
     * @updates this
     * @ensures isOn(this) = not isOn(#this)
     */
    void toggle();

    /**
     * Turns the light on.
     *
     * @updates this
     * @ensures this.power = true
     */
    void turnOn();

    /**
     * Turns the light off.
     *
     * @updates this
     * @ensures this.power = false
     */
    void turnOff();

    /**
     * Checks if the stage light is on.
     *
     * @return true if light is on, false otherwise
     * @ensures isOn = (this.power = true)
     */
    boolean isOn();
}
