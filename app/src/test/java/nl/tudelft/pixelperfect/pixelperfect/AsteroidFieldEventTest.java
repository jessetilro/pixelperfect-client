package nl.tudelft.pixelperfect.pixelperfect;


import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;

/**
 * Created by Dmitry on 23/05/2016.
 */
public class AsteroidFieldEventTest extends EventTest{

    @Override
    public AsteroidFieldEvent create() {
        return new AsteroidFieldEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
