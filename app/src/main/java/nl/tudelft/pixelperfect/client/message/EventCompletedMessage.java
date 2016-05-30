package nl.tudelft.pixelperfect.client.message;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 * The EventCompletedMessage sends a message to the Server to tell that an event was completed.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
@Serializable
public class EventCompletedMessage extends AbstractMessage {
    private int completed;
    private String label;

    /**
     * The EventCompletedMessage constructor.
     */
    public EventCompletedMessage() {

    }

    /**
     * The constructor with a specific Event completed.
     *
     * @param completed , a completed Event.
     * @param label , a name as a String.
     */
    public EventCompletedMessage(String label, @SuppressWarnings("SameParameterValue") int completed) {
        this.label = label;
        this.completed = completed;
    }

    /**
     * Gets the Event that was completed.
     *
     * @return a completed Event.
     */
    public int getCompletedEvent() {
        return completed;
    }

    /**
     * Retrieves the label of the completed event.
     *
     * @return , a String.
     */
    public String getLabel() {
        return label;
    }
}
