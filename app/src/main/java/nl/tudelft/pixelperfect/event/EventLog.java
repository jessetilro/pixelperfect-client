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

    public Boolean contains(Events type) {
        return type.contains(events);
    }

    /**
     * Pops the first item from the start that has   right type.
     *
     * @param id , the id of the type.
     * @return the event that was popped.
     */
    public Event pop(int id) {
        switch(id) {
            case 0:
                for(int i = 0; i < events.size(); i++) {
                    if(events.get(i) instanceof AsteroidFieldEvent){
                        Event ret = events.get(i);
                        events.remove(i);
                        return ret;
                    }
                }
            case 1:
                for(int i = 0; i < events.size(); i++) {
                    if(events.get(i) instanceof FireEvent){
                        Event ret = events.get(i);
                        events.remove(i);
                        return ret;
                    }
                }
            case 2:
                for(int i = 0; i < events.size(); i++) {
                    if(events.get(i) instanceof HostileShipEvent){
                        Event ret = events.get(i);
                        events.remove(i);
                        return ret;
                    }
                }
            case 3:
                for(int i = 0; i < events.size(); i++) {
                    if(events.get(i) instanceof PlasmaLeakEvent){
                        Event ret = events.get(i);
                        events.remove(i);
                        return ret;
                    }
                }
        }
        return null;
    }


}
