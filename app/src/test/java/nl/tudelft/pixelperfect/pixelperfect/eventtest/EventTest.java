package nl.tudelft.pixelperfect.pixelperfect.eventtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.event.Event;

/**
 * The test case for the abstract class Event.
 *
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public abstract class EventTest {

    private Event toTest;

    /**
     * Setting up the Event class for the test.
     */
    @Before
    public void initialize() {
        toTest = create();
    }

    /**
     * Factory method for testing.
     *
     * @return class to be tested.
     */
    public abstract Event create();

    /**
     * Testing the getId method.
     */
    @Test
    public void testGetId() {
        Assert.assertEquals(toTest.getId(), 1);
    }

    /**
     * Testing the getSummary method.
     */
    @Test
    public void testGetSummary() {
        Assert.assertEquals(toTest.getSummary(), "TestEvent");
    }

    /**
     * Testing the getDescription method.
     */
    @Test
    public void testGetDescription() {
        Assert.assertEquals(toTest.getDescription(), "An Event to test the Class.");
    }

    /**
     * When the duration of an event has not yet passed since it's creation, it should not be
     * recognized as expired.
     */
    @Test
    public void testIsExpiredFalse() {
        Assert.assertFalse(toTest.isExpired(83));
    }

    /**
     * When the duration of an event has passed since it's creation, it should be recognized as
     * expired.
     */
    @Test
    public void testIsExpiredTrue() {
        Assert.assertTrue(toTest.isExpired(88));
    }


    /**
     * Testing the getDamage method.
     */
    @Test
    public void testGetDamage() {
        Assert.assertEquals(99.42, toTest.getDamage(), 0.0);
    }
}
