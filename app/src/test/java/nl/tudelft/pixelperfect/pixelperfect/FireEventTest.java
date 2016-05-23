package nl.tudelft.pixelperfect.pixelperfect;


import nl.tudelft.pixelperfect.event.FireEvent;

/**
 * Created by Dmitry on 23/05/2016.
 */
public class FireEventTest extends EventTest {


    @Override
    public FireEvent create() {
        return new FireEvent(1, "TestEvent", "An Event to test the Class.", 42, 45, 99.42);
    }


}
