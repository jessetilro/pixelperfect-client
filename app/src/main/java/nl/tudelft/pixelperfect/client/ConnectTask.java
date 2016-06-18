package nl.tudelft.pixelperfect.client;

import android.os.AsyncTask;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;

import java.io.IOException;

import nl.tudelft.pixelperfect.client.message.DisconnectMessage;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.message.RepairMessage;
import nl.tudelft.pixelperfect.client.message.NewGameMessage;
import nl.tudelft.pixelperfect.client.message.RoleChosenMessage;
import nl.tudelft.pixelperfect.player.PlayerRoles;

/**
 * This class will initialize the Network.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public class ConnectTask extends AsyncTask<String, Void, Client> {

    private Exception exception;
    public ConnectResponse delegate;

    /**
     * Registering the messages that can be sent and starts the client.
     *
     * @param ip the IP of the Server
     * @return a Client.
     */
    protected Client doInBackground(String... ip) {
        Client client;
        try {
            client = Network.connectToServer(ip[0], 6143);
            Serializer.registerClass(EventCompletedMessage.class);
            Serializer.registerClass(RoleChosenMessage.class);
            Serializer.registerClass(NewGameMessage.class);
            Serializer.registerClass(RepairMessage.class);
            Serializer.registerClass(DisconnectMessage.class);
            client.start();
            client.addMessageListener(new ClientListener(), EventCompletedMessage.class);
            client.addMessageListener(new ClientListener(), RoleChosenMessage.class);
            client.addMessageListener(new ClientListener(), RepairMessage.class);
            client.addMessageListener(new ClientListener(), NewGameMessage.class);
            client.addMessageListener(new ClientListener(), DisconnectMessage.class);
        } catch (IOException e) {
            client = null;
        }
        return client;
    }

    protected void onPostExecute(Client client) {
        delegate.connectFinish(client);
    }
}
