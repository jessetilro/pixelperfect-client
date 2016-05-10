package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;
import com.jme3.system.JmeContext;

import java.io.IOException;

/**
 * Created by jesse on 9-5-2016.
 */
public class GameClient {

    private Client client;
    private GameActivity activity;
    private boolean connected = false;

    private static volatile GameClient instance;

    /**
     * Whenever the RouteGenerator is created a new Route will be created (in this factory).
     */
    private GameClient() {
    }

    /**
     * Creates a new RouteGenerator instance if it has not yet been instantiated.
     *
     * @return The single RouteGenerator instance.
     */
    public static GameClient getInstance() {
        if (instance == null) {
            synchronized (GameClient.class) {
                if (instance == null) {
                    instance = new GameClient();
                }
            }
        }
        return instance;
    }

    public void setActivity(GameActivity activity) {
        this.activity = activity;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void connectToServer(String ip) {
        new ConnectTask().execute(ip);
    }

    public boolean isConnected() {
        return (client != null);
    }

}
