package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.ClientStateListener;
import com.jme3.network.Message;

import java.util.ArrayList;

import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;
import nl.tudelft.pixelperfect.player.PlayerRoles;

/**
 * The GameClient within the Android app.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public class GameClient {

    private Client client;
    private NetworkClientStateListener connectionListener;
    private ArrayList<NetworkClientMessageListener> messageListeners;
    private PlayerRoles role;
    private boolean running;

    private PixelPerfectActivity delegate;

    private static volatile GameClient instance;

    /**
     * Whenever the RouteGenerator is created a new Route will be created (in this factory).
     */
    private GameClient() {
        messageListeners = new ArrayList<>();
        connectionListener = new NetworkClientStateListener();
        running = false;
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

    /**
     * Reset the singleton to a fresh instance.
     * Used to reset the game when getting disconnected.
     */
    public static void reset() {
        if (instance != null) {
            synchronized (GameClient.class) {
                if (instance != null) {
                    instance.disconnect();
                    instance = new GameClient();
                }
            }
        }
    }

    public void registerMessageListener(NetworkClientMessageListener messageListener) {
        messageListeners.add(messageListener);
    }

    public void delegateTo(PixelPerfectActivity activity) {
        delegate = activity;
        connectionListener.delegateTo(activity);
        for (NetworkClientMessageListener messageListener : messageListeners) {
            messageListener.delegateTo(activity);
        }
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public void assignRole(PlayerRoles role) {
        this.role = role;
    }

    public PlayerRoles getRole() {
        return role;
    }

    public void setClient(Client client) {
        this.client = client;
        client.addClientStateListener(connectionListener);
    }

    /**
     * Get the instance that listens for client
     * @return
     */
    public ClientStateListener getConnectionListener() {
        return connectionListener;
    }

    /**
     * Connects with the Server.
     *
     * @param ip , the ip of the server.
     * @param delegate , a ConnectResponse.
     */
    public void connect(String ip, ConnectResponse delegate) {
        ConnectTask connect = new ConnectTask();
        connect.delegate = delegate;
        connect.execute(ip);
    }

    /**
     * Sends a message from the Client through the GameClient.
     *
     * @param message the message sent.
     */
    public void sendMessage(Message message) {
        if (isConnected()) {
            client.send(message);
        }
    }

    /**
     * Disconnect from the Server.
     */
    public void disconnect() {
        if (isConnected()) {
            client.close();
        }
        client = null;
    }

    /**
     * Checks whether there is a connection.
     *
     * @return a Boolean.
     */
    public boolean isConnected() {
        return (client != null && client.isConnected());
    }

}
