import components.stagelight.StageLight;
import components.stagelight.StageLight1L;

/**
 * A proof-of-concept class that demonstrates how the StageLight component can
 * be used.
 *
 * @author Kaylin Kerrick
 */
public class StageLightController {
    /**
     * The StageLight instance used in this controller.
     */
    private StageLight light;

    /**
     * Default constructor.
     */
    public StageLightController() {
        this.light = new StageLight1L();
    }

    /**
     * Runs a sequence of light commands to demonstrate the StageLight
     * component.
     */
    public void runLightSequence() {
        //Set inital properties of the light for this specific scene
        this.light.turnOn();
        this.light.setColor("blue");
        this.light.setBrightness(70);
        this.light.setPosition("center");

        //Print the status of the light
        System.out.println("Opening Scene: " + this.light.getStatus());

        //Fade to black for a scene transition
        this.light.fadeToBlack();
        System.out.println("Scene transition: " + this.light.getStatus());

        //Next scene requires a spotlight
        this.light.spotlight();
        System.out.println("Spotlight Scene: " + this.light.getStatus());
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        StageLightController controller = new StageLightController();
        controller.runLightSequence();
    }
}
