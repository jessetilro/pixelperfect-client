package nl.tudelft.pixelperfect.pixelperfect.clienttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.RoleChosenMessage;
import nl.tudelft.pixelperfect.pixelperfect.Roles;

/**
 * Tests the RoleChosen message.
 *
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class RoleChosenMessageTest {

    private RoleChosenMessage message;

    /**
     * Set everything up.
     *
     */
    @Before
    public void initialise() {
        message = new RoleChosenMessage("Gunner", Roles.GUNNER);
    }

    /**
     * Tests the empty constructor.
     *
     */
    @Test
    public void testEmptyConstructor() {
        RoleChosenMessage message = new RoleChosenMessage();
        Assert.assertEquals(null, message.getLabel());
    }

    /**
     * Tests the getLabel function.
     *
     */
    @Test
    public void testGetLabel() {
        Assert.assertEquals("Gunner", message.getLabel());
    }

    /**
     * Tests the getRole function.
     *
     */
    @Test
    public void testGetRole() {
        Assert.assertEquals(Roles.GUNNER, message.getRole());
    }
}
