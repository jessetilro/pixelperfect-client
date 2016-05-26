package nl.tudelft.pixelperfect.pixelperfect.eventtest;

import nl.tudelft.pixelperfect.event.PlasmaLeakEvent;

/**
 * Test case for the Event subclass PlasmaLeakEvent.
 *
 * @author Dmitry Malarev
 */
public class PlasmaLeakEventTest extends EventTest{

    /**
     * Factory method for testing.
     *
     * @return PlasmaLeakEvent class
     */
    @Override
    public PlasmaLeakEvent create() {
        return new PlasmaLeakEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
