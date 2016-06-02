package nl.tudelft.pixelperfect.pixelperfect.location;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jme3.network.AbstractMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.event.parameter.EventParameter;
import nl.tudelft.pixelperfect.event.parameter.EventParameterValues;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;


/**
 * This class represents the location of the Armory occupied by the Gunner.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"CanBeFinal", "unused", "UnusedParameters"})
public class LocationArmoryActivity extends AppCompatActivity {
    private GameClient game = GameClient.getInstance();
    private static Spaceship ship = Spaceship.getInstance();

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_armory);
    }

    /**
     * Updates the eventLog of the ship.
     *
     * @param mission the mission to update the EventLog with.
     */
    public static void updateEventLog(Event mission){
        ship.updateEventLog(mission);
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeFireEvent(View view){
        if(ship.getEventLog().contains(Events.FIRE)){
            game.sendMessage(new EventCompletedMessage("Fire Event", ship.getEventLog().pop(Events.FIRE).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }

    /**
     * Whenever the button to complete the Hostile Ship Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeHostileShipEvent(View view){
        if(ship.getEventLog().contains(Events.HOSTILE)){
            EventCompletedMessage message = new EventCompletedMessage("Hostile Ship Event", ship.getEventLog().pop(Events.HOSTILE).getId());
            Map<String, Integer> parameters = new HashMap<String, Integer>();
            parameters.put("testParam", 42);
            message.setParameters(parameters);
            game.sendMessage(message);
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }
}
