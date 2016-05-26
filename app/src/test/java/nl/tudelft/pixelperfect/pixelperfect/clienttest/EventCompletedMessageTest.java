package nl.tudelft.pixelperfect.pixelperfect.clienttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;

/**
 * Tests the EventCompleted message.
 *
 * Created by Dmitry on 23/05/2016.
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
