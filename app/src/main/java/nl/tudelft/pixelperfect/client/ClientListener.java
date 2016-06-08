package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

import nl.tudelft.pixelperfect.client.message.NewGameMessage;
import nl.tudelft.pixelperfect.client.message.RoleChosenMessage;
import nl.tudelft.pixelperfect.pixelperfect.LobbyActivity;

/**
 * The ClientListeners waits for incoming messages from the server and interpret them.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class ClientListener implements MessageListener<Client> {

    /**
     * Whenever the client listener receives a message from the Server it will determine what
     * to do with it per message.
     *
     * @param source the source of the message.
     * @param message the message received.
     */
    public void messageReceived(Client source, Message message) {
        if (message instanceof RoleChosenMessage) {
            updateRoleAvailability(message);
        } else if (message instanceof NewGameMessage) {
            LobbyActivity.startGame();
        }
    }

    /**
     * Updates the view of the roles in the RoleActivity so that no more than 1 player may choose
     * the same role.
     *
     * @param message the message received.
     */
    public void updateRoleAvailability(Message message) {
        
    }
}
