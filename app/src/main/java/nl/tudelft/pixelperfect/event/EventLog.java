package nl.tudelft.pixelperfect.event;

import java.util.ArrayList;

/**
 * Keeps track of the events that are active.
 *
 * @author Floris Doolaard
 */
public class EventLog {
    private ArrayList<Event> events;

    public EventLog(){
        events = new ArrayList<Event>();
    }

    /**
     * Add an Event to the EventLog.
     *
     * @param event , the event to be added.
     */
    public void add(Event event) {
        events.add(event);
    }


}
