package nl.tudelft.pixelperfect.client;

import android.os.AsyncTask;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;

import java.io.IOException;

/**
 * Created by jesse on 10-5-2016.
 */
public class ConnectTask extends AsyncTask<String, Void, Client> {

    private Exception exception;

    protected Client doInBackground(String... ip) {
        Client client;
        try {
            client = Network.connectToServer(ip[0], 6143);
            Serializer.registerClass(HelloMessage.class);
            client.start();
            client.addMessageListener(new ClientListener(), HelloMessage.class);
        } catch (IOException e) {
            client = null;
        }
        return client;
    }

    protected void onPostExecute(Client client) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}