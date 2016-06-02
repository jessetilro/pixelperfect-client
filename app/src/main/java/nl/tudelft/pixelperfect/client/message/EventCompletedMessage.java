package nl.tudelft.pixelperfect.client.message;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

import java.util.Collection;

import nl.tudelft.pixelperfect.event.parameter.EventParameter;

/**
 * The EventCompletedMessage sends a message to the Server to tell that an event was completed.
 *
 * @author Floris Doolaard
 * @author Jesse Tilro
 */
@SuppressWarnings("unused")
@Serializable
public class EventCompletedMessage extends AbstractMessage {
    private int completed;
    private String label;
    private Collection<EventParameter> parameters;

    /**
     * The EventCompletedMessage constructor.
     */
    public EventCompletedMessage() {

    }

    /**
     * The constructor with a specific Event completed.
     *
     * @param completed A completed Event.
     * @param label A name as a String.
     */
    public EventCompletedMessage(String label, @SuppressWarnings("SameParameterValue") int completed) {
        this.label = label;
        this.completed = completed;
    }

    /**
     * Gets the Event that was completed.
     *
     * @return A completed Event.
     */
    public int getCompletedEvent() {
        return completed;
    }

    /**
     * Retrieves the label of the completed event.
     *
     * @return A String.
     */
    public String getLabel() {
        return label;
    }
}
