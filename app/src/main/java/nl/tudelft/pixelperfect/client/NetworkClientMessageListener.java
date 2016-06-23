package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

import nl.tudelft.pixelperfect.client.message.DisconnectMessage;
import nl.tudelft.pixelperfect.client.message.NewGameMessage;
import nl.tudelft.pixelperfect.client.message.RoleAllocationMessage;
import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;

/**
 * The ClientListeners waits for incoming messages from the server and interpret them.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class NetworkClientMessageListener implements MessageListener<Client> {

    private PixelPerfectActivity delegate;

    public void delegateTo(PixelPerfectActivity activity) {
        delegate = activity;
    }

    /**
     * Whenever the client listener receives a message from the Server it will determine what
     * to do with it per message.
     *
     * @param source  the source of the message.
     * @param message the message received.
     */
    public void messageReceived(Client source, Message message) {
        if (message instanceof RoleAllocationMessage) {
            handleRoleChosenMessage((RoleAllocationMessage) message);
        } else if (message instanceof NewGameMessage) {
            handleNewGameMessage();
        } else if (message instanceof DisconnectMessage) {
            GameClient game = GameClient.getInstance();
            game.disconnect();
        }
    }

    /**
     * When a New Game Message has been received, this confirms that an active game session
     * is currently going, and we should start playing.
     */
    public void handleNewGameMessage() {
        if (delegate != null) {
            System.out.println("Starting game!");
            delegate.startGame();
        }
    }

    /**
     * Handle a received RoleChoseMessage.
     *
     * @param message The message to handle.
     */
    public void handleRoleChosenMessage(RoleAllocationMessage message) {
        System.out.println("Received role chosen message.");
        if (message.isAllocated()) {
            System.out.println("Server granted request for " + message.getRole().toString());
            if (delegate != null) {
                delegate.enterLobby(message.getRole());
            }
        } else {
            System.out.println("Server denied request for " + message.getRole().toString());
        }
    }
}
