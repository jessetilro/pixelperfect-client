package nl.tudelft.pixelperfect.pixelperfect.clienttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;

/**
 * Tests the EventCompleted message.
 *
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class EventCompletedMessageTest {

    private EventCompletedMessage event;

    /**
     * Set everything up.
     *
     */
    @Before
    public void initialise() {
        event = new EventCompletedMessage("Lorem", 3);
    }

    /**
     * Tests the empty constructor.
     *
     */
    @Test
    public void testEmptyConstructor() {
        EventCompletedMessage message = new EventCompletedMessage();
        Assert.assertEquals(null, message.getLabel());
    }

    /**
     * Tests the getLabel function.
     *
     */
    @Test
    public void testGetLabel() {
        Assert.assertEquals("Lorem", event.getLabel());
    }

    /**
     * Tests the getCompletedEvent function.
     *
     */
    @Test
    public void testGetCompleted() {
        Assert.assertEquals(3, event.getCompletedEvent());
    }
}
