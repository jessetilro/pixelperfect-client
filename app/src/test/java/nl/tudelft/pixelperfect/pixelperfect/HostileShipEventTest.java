package nl.tudelft.pixelperfect.pixelperfect;

import nl.tudelft.pixelperfect.event.HostileShipEvent;

/**
 * Test case for the Event subclass HostileShipEvent.
 *
 * Created by Dmitry on 23/05/2016.
 */
public class HostileShipEventTest extends EventTest{

    /**
     * Factory method for testing.
     *
     * @return HostileShipEvent class
     */
    @Override
    public HostileShipEvent create() {
        return new HostileShipEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
