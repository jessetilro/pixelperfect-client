package nl.tudelft.pixelperfect.pixelperfect.eventtest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.event.FireEvent;
import nl.tudelft.pixelperfect.event.PlasmaLeakEvent;

/**
 * Test case for the event log.
 *
 * @author Dmitry Malarev
 */
@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class EventLogTest {

    private EventLog log;
    private FireEvent fire;

    /**
     * Initializes the log and a FireEvent instance.
     *
     */
    @Before
    public void init() {
        log = new EventLog();
        fire = new FireEvent(2, "Lorem", "Ipsum", 3L, 5L, 5.0);
        log.add(fire);
    }

    /**
     * Tests the add function of the log.
     *
     */
    @Test
    public void testAdd() {
        PlasmaLeakEvent plasma = new PlasmaLeakEvent(2, "Lorem", "Ipsum", 3L, 5L, 5.0);
        log.add(plasma);
        Assert.assertTrue(log.contains(Events.PLASMA));
    }

    /**
     * Tests the contain function on a present event.
     *
     */
    @Test
    public void testContainsTrue() {
        Assert.assertTrue(log.contains(Events.FIRE));
    }

    /**
     * Tests the contain function on a missing event.
     *
     */
    @Test
    public void testContainsFalse() {
        Assert.assertFalse(log.contains(Events.HOSTILE));
    }

    /**
     * Tests the pop method.
     *
     */
    @Test
    public void testPop() {
        log.pop(Events.FIRE);
        Assert.assertFalse(log.contains(Events.FIRE));
    }

}
