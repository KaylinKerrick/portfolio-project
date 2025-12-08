package components.stagelight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for the StageLight component.
 *
 * @author Kaylin Kerrick
 */
public class StageLightTest {

    //Tests for Abstract class / secondary methods

    @Test
    public void testFadeToBlack20() {
        StageLight light = new StageLight1L();
        light.setBrightness(20);
        light.fadeToBlack();
        assertEquals(0, light.getBrightness());
    }

    @Test
    public void testFadeToBlack100() {
        StageLight light = new StageLight1L();
        light.setBrightness(100);
        light.fadeToBlack();
        assertEquals(0, light.getBrightness());
    }

    @Test
    public void testFadeToBlack0() {
        StageLight light = new StageLight1L();
        light.setBrightness(0);
        light.fadeToBlack();
        assertEquals(0, light.getBrightness());
    }

    @Test
    public void testSpotlight1() {
        StageLight light = new StageLight1L();
        light.setBrightness(20);
        light.setPosition("left");

        light.spotlight();
        assertEquals(100, light.getBrightness());
        assertEquals("center", light.getPosition());
    }

    @Test
    public void testSpotlight2() {
        StageLight light = new StageLight1L();
        light.setBrightness(0);
        light.setPosition("right");

        light.spotlight();
        assertEquals(100, light.getBrightness());
        assertEquals("center", light.getPosition());
    }

    @Test
    public void testGetStatus1() {
        StageLight light = new StageLight1L();
        light.setBrightness(75);
        light.setColor("blue");
        light.setPosition("right");
        light.turnOn();

        String status = light.getStatus();
        assertTrue(status.contains("75"));
        assertTrue(status.contains("blue"));
        assertTrue(status.contains("right"));
        assertTrue(status.contains("on"));
    }

    @Test
    public void testGetStatus2() {
        StageLight light = new StageLight1L();

        light.setBrightness(50);
        light.setColor("red");
        light.setPosition("left");
        light.turnOff();

        String status = light.getStatus();

        assertTrue("Brightness should be included", status.contains("50"));
        assertTrue("Color should be included",
                status.toLowerCase().contains("red"));
        assertTrue("Position should be included",
                status.toLowerCase().contains("left"));
        assertTrue("Power state should be included",
                status.toLowerCase().contains("off"));
    }

    @Test
    public void testIsOn() {
        StageLight light = new StageLight1L();
        assertFalse(light.isOn());

        light.turnOn();
        assertTrue(light.isOn());

        light.turnOff();
        assertFalse(light.isOn());
    }

    //Tests for common methods

    @Test
    public void testEqualsDifferentScenarios() {
        StageLight light1 = new StageLight1L();
        StageLight light2 = new StageLight1L();

        assertTrue(light1.equals(light2));
        assertTrue(light1.equals(light1));
        assertFalse(light1.equals(null));
        assertFalse(light1.equals("not a light"));

        light2.setBrightness(10);
        assertFalse(light1.equals(light2));

        light2.setBrightness(0);
        light2.setColor("red");
        assertFalse(light1.equals(light2));

        light2.setColor("white");
        light2.setPosition("right");
        assertFalse(light1.equals(light2));
    }

    @Test
    public void testToStringContainsAllInfo() {
        StageLight light = new StageLight1L();
        light.setBrightness(80);
        light.setColor("green");
        light.setPosition("left");
        light.turnOn();

        String s = light.toString();
        assertTrue(s.contains("80"));
        assertTrue(s.contains("green"));
        assertTrue(s.contains("left"));
        assertTrue(s.contains("on"));
    }
}
