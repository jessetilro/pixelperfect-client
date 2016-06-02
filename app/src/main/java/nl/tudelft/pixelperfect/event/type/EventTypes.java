package nl.tudelft.pixelperfect.event.type;

/**
 * Enumeration of the different types of Events in the game. The ordinals, i.e. the indices of the
 * types in this enumeration, correspond to the numeric type identifiers of the Event types
 * described in the Event Data File. Keep that in mind when updating this enumeration!
 *
 * @author Jesse Tilro
 *
 */
public enum EventTypes {
    FIRE_OUTBREAK,
    PLASMA_LEAK,
    ASTEROID_IMPACT,
    HOSTILE_SHIP,
    COFFEE_BOOST
}
