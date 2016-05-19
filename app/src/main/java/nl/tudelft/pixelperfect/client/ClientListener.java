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
 * The ClientListeners waits for incoming messages from the server and interpret them.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
class ClientListener implements MessageListener<Client> {
    public void messageReceived(Client source, Message message) {
        if (message instanceof HelloMessage) {
            // do something with the message
            HelloMessage helloMessage = (HelloMessage) message;
            System.out.println("Client #"+source.getId()+" received: '"+helloMessage.getSomething()+"'");
        } else if (message instanceof EventsMessage) {
            Event mission;
            EventsMessage eve = (EventsMessage) message;
            System.out.println("Client #"+source.getId()+" received event: '"+eve.getType()+"'");
            switch (eve.getType()) {
                case "FireEvent":
                    mission = new FireEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    break;
                case "AsteroidFieldEvent":
                    mission = new AsteroidFieldEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    break;
                case "HostileShipEvent":
                    mission = new HostileShipEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    break;
                case "PlasmaLeakEvent":
                    mission = new PlasmaLeakEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    break;
                default:
                    mission = null;
                    break;
            }
        }
    }
}
