package nl.tudelft.pixelperfect.pixelperfect;

import nl.tudelft.pixelperfect.event.PlasmaLeakEvent;

/**
 * Created by Dmitry on 23/05/2016.
 */
public class PlasmaLeakEventTest extends EventTest{

    @Override
    public PlasmaLeakEvent create() {
        return new PlasmaLeakEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }
}
