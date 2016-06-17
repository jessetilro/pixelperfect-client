package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.ClientStateListener;

/**
 * Monitors the status of the connection with the server.
 *
 * @author Jesse Tilro
 */
public class NetworkClientStateListener implements ClientStateListener {

    @Override
    public void clientConnected(Client c) {
        System.out.println("Connected");
    }

    @Override
    public void clientDisconnected(Client c, DisconnectInfo info) {
        System.out.println("Disconnected");
    }
}
