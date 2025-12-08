package components.stagelight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for the StageLight1L kernel implementation.
 *
 * @author Kaylin Kerrick
 */
public class StageLight1LTest {

    //Test Kernel and Standard Methods

    @Test
    public void testDefaultConstructor() {
        StageLight1L light = new StageLight1L();
        //Color should be white, position center, brightness 0, and off by default
        assertEquals("white", light.getColor());
        assertEquals("center", light.getPosition());
        assertEquals(0, light.getBrightness());
        assertFalse(light.isOn());
    }

    @Test
    public void testColor() {
        StageLight1L light = new StageLight1L();
        light.setColor("red");
        assertEquals("red", light.getColor());

        light.setColor("blue");
        assertEquals("blue", light.getColor());
    }

    @Test
    public void testPosition() {
        StageLight1L light = new StageLight1L();
        light.setPosition("left");
        assertEquals("left", light.getPosition());

        light.setPosition("right");
        assertEquals("right", light.getPosition());
    }

    @Test
    public void testBrightness() {
        StageLight1L light = new StageLight1L();
        light.setBrightness(50);
        assertEquals(50, light.getBrightness());

        light.setBrightness(100);
        assertEquals(100, light.getBrightness());

        light.setBrightness(0);
        assertEquals(0, light.getBrightness());
    }

    @Test
    public void testPowerState() {
        StageLight1L light = new StageLight1L();
        light.turnOn();
        assertTrue(light.isOn());

        light.turnOff();
        assertFalse(light.isOn());
    }

    //Test Secondary Methods

    @Test
    public void testFadeToBlack() {
        StageLight1L light = new StageLight1L();
        light.setBrightness(80);

        light.fadeToBlack();

        assertEquals(0, light.getBrightness());

        // Test fading a light that's already fully black
        light.fadeToBlack();
        assertEquals(0, light.getBrightness());
    }

    @Test
    public void testSpotlight() {
        StageLight1L light = new StageLight1L();

        light.setBrightness(30);
        light.setPosition("left");
        light.spotlight();

        assertEquals(100, light.getBrightness());
        assertEquals("center", light.getPosition());
    }

    @Test
    public void testPossibleLightSequence() {
        StageLight1L light = new StageLight1L();
        light.setBrightness(40);
        light.setColor("green");
        light.setPosition("right");
        light.turnOn();

        assertEquals(40, light.getBrightness());
        assertEquals("green", light.getColor());
        assertEquals("right", light.getPosition());
        assertTrue(light.isOn());

        light.fadeToBlack();
        assertEquals(0, light.getBrightness());

        light.spotlight();
        assertEquals(100, light.getBrightness());
        assertEquals("center", light.getPosition());
    }

    //Test Common Methods

    @Test
    public void testEquals() {
        StageLight1L light1 = new StageLight1L();
        StageLight1L light2 = new StageLight1L();

        assertTrue(light1.equals(light1));
        assertTrue(light1.equals(light2));

        light2.setBrightness(50);
        assertFalse(light1.equals(light2));
        assertFalse(light1.equals(null));
        assertFalse(light1.equals("not a light"));

        // Change color and position
        light2.setBrightness(0);
        light2.setColor("red");
        light2.setPosition("left");

        assertFalse(light1.equals(light2));
    }
}
