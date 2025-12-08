import components.stagelight.StageLight;
import components.stagelight.StageLight1L;

/**
 * Demonstration for the StageLight component in the main method.
 *
 * Shows a basic example of StageLight1L and how it can be used.
 *
 * @author Kaylin Kerrick
 */
public class StageLightDemo {
    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Create a StageLight object
        StageLight light = new StageLight1L();

        //First print the initial state of the light
        System.out.println("Initial Light Status:");
        System.out.println(light.getStatus());

        //Turn on the light
        light.turnOn();

        //Set the brightness level, color, and position
        light.setBrightness(75);
        light.setColor("blue");
        light.setPosition("center");

        //Reprint the state of the light after changing the settings
        System.out.println("Updated Light Status:");
        System.out.println(light.getStatus());

        //Now we want to make the light a spotlight
        light.spotlight();

        //Print the status of the spotlight
        System.out.println("After Calling a Spotlight:");
        System.out.println(light.getStatus());

        //Now we want to fade the light to black to make smooth transition
        light.fadeToBlack();

        //Print the final status of the light
        System.out.println("After Fading to Black:");
        System.out.println(light.getStatus());
    }
}
