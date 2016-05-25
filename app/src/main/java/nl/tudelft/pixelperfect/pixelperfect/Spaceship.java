package nl.tudelft.pixelperfect.pixelperfect;

import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.EventLog;

/**
 * The Spaceship class represents the spaceship in the game having its own attributes.
 * Technically every player has its own spaceship class. The Server will update the spaceship
 * environment if needed.
 *
 * @author Floris Doolaard
 */
public class Spaceship {
    private static volatile Spaceship instance;
    private static EventLog eventLog;

    private Spaceship() {
        eventLog = new EventLog();
    }

    /**
     * Creates a new Spaceship instance unless it was already created.
     *
     * @return the instance of the Spaceship.
     */
    public static Spaceship getInstance() {
        if(instance == null) {
            synchronized (Spaceship.class) {
                if (instance == null) {
                    instance = new Spaceship();
                }
            }
        }
        return instance;
    }

    /**
     * Updates the EventLog of the Spaceship.
     *
     * @param event
     */
    public static void updateEventLog(Event event){
        eventLog.add(event);
    }

    /**
     * Returns the EventLog of the spaceship.
     *
     * @return an EventLog
     */
    public EventLog getEventLog() {
        return eventLog;
    }
}
