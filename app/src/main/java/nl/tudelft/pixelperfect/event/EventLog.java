package nl.tudelft.pixelperfect.event;

import java.util.ArrayList;

/**
 * Keeps track of the events that are active.
 *
 * @author Floris Doolaard
 */
public class EventLog {
    @SuppressWarnings("CanBeFinal")
    private ArrayList<Event> events;

    public EventLog(){
        events = new ArrayList<>();
    }

    /**
     * Add an Event to the EventLog.
     *
     * @param event , the event to be added.
     */
    public void add(Event event) {
        events.add(event);
    }

    /**
     * Checks if the log contains an event of this type.
     *
     * @param type the type of the event.
     * @return true if it is in the ArrayList, otherwise false.
     */
    public Boolean contains(Events type) {
        return type.contains(events);
    }

    /**
     * Pops the first item from the start that has   right type.
     *
     * @param type , the type of the event.
     * @return the event that was popped.
     */
    public Event pop(Events type) {
       return type.pop(events);
    }


}
