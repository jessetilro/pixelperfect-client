package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Network;
import com.jme3.network.serializing.Serializer;
import com.jme3.system.JmeContext;

import java.io.IOException;

/**
 * Created by jesse on 9-5-2016.
 */
public class GameClient extends com.jme3.app.SimpleApplication {

    private Client client;

    /**
     * Launch the PixelPerfect jMonkeyEngine client application.
     *
     * @param args Parameters for the process.
     */
    public static void main(String[] args) {
        GameClient app = new GameClient();
        app.start(JmeContext.Type.Display);
    }

    /**
     * Initialise the application, settings up the network client to connect to the server.
     */
    @Override
    public void simpleInitApp() {
        try {
            client = Network.connectToServer("192.168.1.248", 6143);
            Serializer.registerClass(HelloMessage.class);
            client.start();
            client.addMessageListener(new ClientListener(), HelloMessage.class);
        } catch (IOException e) {
            // Show a message.
        } finally {
            // Do some other stuff.
        }

    }

}
