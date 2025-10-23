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
     * Changes the position where the light is pointing on stage.
     *
     * @param newPosition
     *            new position (ex. "left", "right", "center")
     * @updates this
     * @ensures this.position = newPosition
     */
    void setPosition(String newPosition);

    /**
     * Switches the light on or off.
     *
     * @updates this
     * @ensures isOn(this) = not isOn(#this)
     */
    void toggle();

}
