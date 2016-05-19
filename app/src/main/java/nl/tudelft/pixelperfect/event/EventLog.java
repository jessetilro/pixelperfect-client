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

    public Boolean contains(int id) {
        switch(id) {
            case 0:
                for(Event event : events) {
                    if(event instanceof AsteroidFieldEvent){
                        return true;
                    }
                }
                return false;
            case 1:
                for(Event event : events) {
                    if(event instanceof FireEvent){
                        return true;
                    }
                }
                return false;
            case 2:
                for(Event event : events) {
                    if(event instanceof HostileShipEvent){
                        return true;
                    }
                }
                return false;
            case 3:
                for(Event event : events) {
                    if(event instanceof PlasmaLeakEvent){
                        return true;
                    }
                }
        }
        return false;
    }

    /**
     * Pops the first item from the start that has the right type.
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
