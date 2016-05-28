package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;
import com.jme3.network.Message;
import com.jme3.network.MessageListener;

import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.FireEvent;
import nl.tudelft.pixelperfect.event.HostileShipEvent;
import nl.tudelft.pixelperfect.event.PlasmaLeakEvent;
import nl.tudelft.pixelperfect.pixelperfect.LocationArmoryActivity;
import nl.tudelft.pixelperfect.pixelperfect.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.LocationLabActivity;
import nl.tudelft.pixelperfect.pixelperfect.RoleActivity;

/**
 * The ClientListeners waits for incoming messages from the server and interpret them.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 * @author Dmitry Malarev
 */
@SuppressWarnings("unused")
public class ClientListener implements MessageListener<Client> {
    public void messageReceived(Client source, Message message) {
        if (message instanceof EventsMessage) {
            Event mission;
            EventsMessage eve = (EventsMessage) message;
            System.out.println("Client #"+source.getId()+" received event: '"+eve.getType()+"'");
            switch (eve.getType()) {
                case "FireEvent":
                    mission = new FireEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    LocationArmoryActivity.updateEventLog(mission);
                    break;
                case "AsteroidFieldEvent":
                    mission = new AsteroidFieldEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    LocationLabActivity.updateEventLog(mission);
                    break;
                case "HostileShipEvent":
                    mission = new HostileShipEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    LocationArmoryActivity.updateEventLog(mission);
                    break;
                case "PlasmaLeakEvent":
                    mission = new PlasmaLeakEvent(eve.getID(), "", "", eve.getTime(), eve.getDuration(), 0);
                    LocationEngineroomActivity.updateEventLog(mission);
                    break;
                default:
                    break;
            }
        } else if (message instanceof RoleChosenMessage) {
            RoleChosenMessage roleMessage = (RoleChosenMessage) message;
            switch (roleMessage.getRole()) {
                case GUNNER:
                    RoleActivity.getGunnerView().setAlpha(0.5f);
                    RoleActivity.getGunnerView().setEnabled(false);
                    break;
                case ENGINEER:
                    RoleActivity.getEngineerView().setAlpha(0.5f);
                    RoleActivity.getEngineerView().setEnabled(false);
                    break;
                case SCIENTIST:
                    RoleActivity.getScientistView().setAlpha(0.5f);
                    RoleActivity.getScientistView().setEnabled(false);
                    break;
                case JANITOR:
                    RoleActivity.getJanitorView().setAlpha(0.5f);
                    RoleActivity.getScientistView().setEnabled(false);
                    break;
                default:
                    break;
            }
        }
    }
}
