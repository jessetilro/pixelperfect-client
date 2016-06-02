package nl.tudelft.pixelperfect.pixelperfect.eventtest;


/**
 * Test case for the Event subclass AsteroidImpactEvent.
 *
 * @author Dmitry Malarev
 */
public class AsteroidImpactEventTest extends EventTest{


    /**
     * Factory method for testing.
     *
     * @return AsteroidImpactEvent class
     */
    @Override
    public AsteroidImpactEvent create() {
        return new AsteroidImpactEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
