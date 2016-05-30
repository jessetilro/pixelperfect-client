package nl.tudelft.pixelperfect.pixelperfect.location;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;

/**
 * This class represents the location of the Engine Room occupied by the Engineer.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"CanBeFinal", "unused", "UnusedParameters"})
public class LocationEngineroomActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_location_engineroom);
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
     * Whenever the button to complete the Plasma Leak Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completePlasmaLeakEvent(View view){
        if(ship.getEventLog().contains(Events.PLASMA)){
            game.sendMessage(new EventCompletedMessage("Plasma Leak Event", ship.getEventLog().pop(Events.PLASMA).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }
}
