/**
 * Enhanced interface for the StageLight component.
 *
 * Extends {@code StageLightKernel} to include secondary operations that can be
 * implemented with the kernel methods.
 *
 * @author Kaylin Kerrick
 */
public interface StageLight extends StageLightKernel {
    /**
     * Light will slowly fade to black (level 0).
     *
     * @updates this
     * @ensures this.brightness = 0
     */
    void fadeToBlack();

    /**
     * Centers the light and brings to max brightness (level 100).
     *
     * @updates this
     * @ensures this.brightness = 100 and this.position = "center"
     */
    void spotlight();

    /**
     * Checks if the stage light is on.
     *
     * @return true if light is on, false otherwise
     * @ensures isOn = (this is turned on)
     */
    boolean isOn();

    /**
     * Reports the current status of the light.
     *
     * @return string description of this light’s color, position, brightness,
     *         and power state
     * @ensures getStatus = [string describing the state of this]
     */
    String getStatus();
}
