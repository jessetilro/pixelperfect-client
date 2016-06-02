package nl.tudelft.pixelperfect.event;

import com.jme3.scene.Geometry;

/**
 * A type of Event, imposing a dangerous Asteroid Field.
 *
 * @author Wouter Zirkzee
 * @author Floris Doolaard
 */
@SuppressWarnings({"SameParameterValue", "unused"})
public class AsteroidImpactEvent extends Event {

    /**
     * Constructor for AsteroidField event.
     *
     * @param id
     *          The desired id.
     * @param summary
     *          Summary/name of the event.
     * @param description
     *          A description of the event.
     * @param timestamp
     *          The timestamp of start of the event.
     * @param duration
     *          The time to live milliseconds until the event expires.
     * @param damage
     *          The damage done to the ship on even failure.
     */
    public AsteroidImpactEvent(int id, String summary, String description, long timestamp,
                               long duration, double damage) {
        super(id, summary, description, timestamp, duration, damage);
    }

    /**
     * Show a specific notification for this event.
     *
     * @param geo
     *          Object to be mutated.
     */
    public void notification(Geometry geo) {
        // TODO
    }
}