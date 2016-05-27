package nl.tudelft.pixelperfect.pixelperfect.eventtest;


import nl.tudelft.pixelperfect.event.FireEvent;

/**
 * Test case for the Event subclass FireEvent.
 *
 * @author Dmitry Malarev
 */
public class FireEventTest extends EventTest {


    /**
     * Factory method for testing.
     *
     * @return FireEvent class
     */
    @Override
    public FireEvent create() {
        return new FireEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }


}
