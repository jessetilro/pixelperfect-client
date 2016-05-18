package nl.tudelft.pixelperfect.event;

import com.jme3.scene.Geometry;

/**
 * A class for storing and defining events, called upon by the event scheduler.
 *
 * @author David Alderliesten
 *
 */
public abstract class Event {
    private String summary;
    private String description;
    private int id;
    private long timestamp;
    private long duration;
    private double damage;

    /**
     * Constructor for the event class, taking parameters for the type of event, a summary of the
     * event/name, a description of the event, a timestamp to start, a duration, and a damage if the
     * event is failed.
     *
     * @param id
     *          The unique id of the event.
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
    public Event(int id, String summary, String description, long timestamp, long duration,
                 double damage) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.timestamp = timestamp;
        this.duration = duration;
        this.damage = damage;
    }

    /**
     * Getter for the event id.
     *
     * @return The id of event.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter for the event summary/name.
     *
     * @return Summary/name of the event.
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Get the description of the event.
     *
     * @return Description of event.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Check whether the event is expired at a given moment in time.
     *
     * @param time
     *          The moment in time at which to check the expiration.
     * @return Whether the event is expired.
     */
    public boolean isExpired(long time) {
        return (time > (timestamp + duration));
    }

    /**
     * Get the damage that will be done to the ship in the case of event failure.
     *
     * @return The event's damage value.
     */
    public double getDamage() {
        return this.damage;
    }

    /**
     * Allow events to render notifications to the players.
     *
     * @param geo
     *          Object to be mutated as notification.
     */
    public abstract void notification(Geometry geo);
}