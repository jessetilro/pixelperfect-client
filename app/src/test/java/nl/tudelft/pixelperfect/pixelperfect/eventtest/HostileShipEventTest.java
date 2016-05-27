package nl.tudelft.pixelperfect.pixelperfect.eventtest;

import nl.tudelft.pixelperfect.event.HostileShipEvent;

/**
 * Test case for the Event subclass HostileShipEvent.
 *
 * @author Dmitry Malarev
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
