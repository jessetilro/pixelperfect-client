package nl.tudelft.pixelperfect.client;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 * The class that is sent by the server when it shares an event.
 *
 * @author Dmitry Malarev.
 */
@Serializable
public class EventsMessage extends AbstractMessage{
    private String event;

    /**
     * Constructor for the EventMessage class.
     */
    public EventsMessage() {
    }

    /**
     * Second constructor.
     *
     * @param s The content of the message.
     */
    public EventsMessage(String s) {
        event = s;
    }

    /**
     * Fetches the content of the message.
     *
     * @return The content of the message.
     */
    public String getEvent() {
        return event;
    }
}
