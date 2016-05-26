package nl.tudelft.pixelperfect.pixelperfect.clienttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.client.EventsMessage;

/**
 * Test case for the event message class.
 *
 * Created by Dmitry on 23/05/2016.
 */
public class EventsMessageTest {

    EventsMessage events;

    /**
     * Set everything up.
     *
     */
    @Before
    public void initialise() {
        events = new EventsMessage(2, "Lorem", 43L, 67L);
    }

    /**
     * Tests the empty constructor.
     *
     */
    @Test
    public void testEmptyConstructor() {
        EventsMessage message = new EventsMessage();
        Assert.assertEquals(null, message.getType());
    }

    /**
     * Tests the getId function.
     *
     */
    @Test
    public void testGetId() {
        Assert.assertEquals(2, events.getID());
    }

    /**
     * Tests the getType function.
     *
     */
    @Test
    public void testGetType() {
        Assert.assertEquals("Lorem", events.getType());
    }

    /**
     * Tests the getTimestamp function.
     *
     */
    @Test
    public void testGetTimestamp() {
        Assert.assertEquals(43L, events.getTime(), 0);
    }

    /**
     * Tests the getDuration function.
     *
     */
    @Test
    public void testGetDuration() {
        Assert.assertEquals(67L, events.getDuration(), 0);
    }
}
