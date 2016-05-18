package nl.tudelft.pixelperfect.client;

import android.os.AsyncTask;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;

import java.io.IOException;

/**
 * This class will initialize the Network.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 */
class ConnectTask extends AsyncTask<String, Void, Client> {

    private Exception exception;
    public ConnectResponse delegate;

    protected Client doInBackground(String... ip) {
        Client client;
        try {
            client = Network.connectToServer(ip[0], 6143);
            Serializer.registerClass(HelloMessage.class);
            Serializer.registerClass(EventCompletedMessage.class);
            client.start();
            client.addMessageListener(new ClientListener(), HelloMessage.class);
            client.addMessageListener(new ClientListener(), EventCompletedMessage.class);
        } catch (IOException e) {
            client = null;
        }
        return client;
    }

    protected void onPostExecute(Client client) {
        delegate.connectFinish(client);
    }
}
