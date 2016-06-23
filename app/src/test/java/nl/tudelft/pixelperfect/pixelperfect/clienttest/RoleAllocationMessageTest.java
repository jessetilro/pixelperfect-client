package nl.tudelft.pixelperfect.pixelperfect.clienttest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.pixelperfect.client.message.RoleAllocationMessage;
import nl.tudelft.pixelperfect.player.PlayerRoles;

/**
 * Tests the RoleChosen message.
 *
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class RoleAllocationMessageTest {

    private RoleAllocationMessage message;

    /**
     * Set everything up.
     *
     */
    @Before
    public void initialize() {
        message = new RoleAllocationMessage(PlayerRoles.GUNNER, true);
    }

    /**
     * Tests the getLabel function.
     *
     */
    @Test
    public void testIsAllocated() {
        Assert.assertEquals(true, message.isAllocated());
    }

    /**
     * Tests the getRole function.
     *
     */
    @Test
    public void testGetRole() {
        Assert.assertEquals(PlayerRoles.GUNNER, message.getRole());
    }
}
