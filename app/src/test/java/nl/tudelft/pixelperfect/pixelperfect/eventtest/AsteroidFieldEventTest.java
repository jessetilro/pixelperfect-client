package nl.tudelft.pixelperfect.pixelperfect.eventtest;


import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;

/**
 * Test case for the Event subclass AsteroidFieldEvent.
 *
 * Created by Dmitry on 23/05/2016.
 */
public class AsteroidFieldEventTest extends EventTest{


    /**
     * Factory method for testing.
     *
     * @return AsteroidFieldEvent class
     */
    @Override
    public AsteroidFieldEvent create() {
        return new AsteroidFieldEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
