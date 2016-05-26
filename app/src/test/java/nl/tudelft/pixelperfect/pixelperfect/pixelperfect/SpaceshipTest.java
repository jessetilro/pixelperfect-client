package nl.tudelft.pixelperfect.pixelperfect.pixelperfect;

import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.event.FireEvent;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Tests the Spaceship class.
 *
 * @author Floris Doolaard
 */
public class SpaceshipTest {
    private Spaceship spaceship;
    private Event event;

    /**
     * Initializes objects.
     */
    @Before
    public void before() {
        spaceship = Spaceship.getInstance();
        event = new FireEvent(0, "summary", "description", 0, 0, 0);
    }

    /**
     * Tests the updateEventLog method.
     */
    @Test
    public void testUpdateEventLog() {
        spaceship.updateEventLog(event);
        assertTrue(spaceship.getEventLog().contains(Events.FIRE));

        assertFalse(spaceship.getEventLog().contains(Events.ASTEROID));
    }

}
