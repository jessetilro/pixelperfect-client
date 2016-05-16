package nl.tudelft.pixelperfect.client;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

import nl.tudelft.pixelperfect.event.Event;

/**
 * The EventCompletedMessage sends a message to the Server to tell that an event was completed.
 *
 * @author Floris Doolaard
 */
@Serializable
public class EventCompletedMessage extends AbstractMessage {
    private Event completed;

    public EventCompletedMessage() {

    }

    public EventCompletedMessage(Event completed){
        this.completed = completed;
    }
}
