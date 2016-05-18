package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.FireEvent;
import nl.tudelft.pixelperfect.event.HostileShipEvent;
import nl.tudelft.pixelperfect.event.PlasmaLeakEvent;

/**
 * The ClientListener waits for incoming messages from the server and interps them.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 */
public class ClientListener implements MessageListener<Client> {
    public void messageReceived(Client source, Message message) {
        if (message instanceof HelloMessage) {
            // do something with the message
            HelloMessage helloMessage = (HelloMessage) message;
            System.out.println("Client #"+source.getId()+" received: '"+helloMessage.getSomething()+"'");
        } else if (message instanceof EventsMessage) {
            Event mission;
            EventsMessage eve = (EventsMessage) message;
            System.out.println("Client #"+source.getId()+" received event: '"+eve.getEvent()+"'");
            String[] keys = eve.getEvent().split(" ");
            switch (keys[1]) {
                case "FireEvent":
                    mission = new FireEvent(Integer.getInteger(keys[0]), "", "", Long.getLong(keys[2]), Long.getLong(keys[3]), 0);
                    break;
                case "AsteroidFieldEvent":
                    mission = new AsteroidFieldEvent(Integer.getInteger(keys[0]), "", "", Long.getLong(keys[2]), Long.getLong(keys[3]), 0);
                    break;
                case "HostileShipEvent":
                    mission = new HostileShipEvent(Integer.getInteger(keys[0]), "", "", Long.getLong(keys[2]), Long.getLong(keys[3]), 0);
                    break;
                case "PlasmaLeakEvent":
                    mission = new PlasmaLeakEvent(Integer.getInteger(keys[0]), "", "", Long.getLong(keys[2]), Long.getLong(keys[3]), 0);
                    break;
                default:
                    mission = null;
                    break;
            }

        }
    }
}
