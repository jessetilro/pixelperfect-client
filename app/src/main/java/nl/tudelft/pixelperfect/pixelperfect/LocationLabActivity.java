package nl.tudelft.pixelperfect.pixelperfect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.Events;

/**
 * This class represents the location of the Lab occupied by the Scientist.
 *
 * @author Floris Doolaard
 */
public class LocationLabActivity extends AppCompatActivity {
    private GameClient game;
    private static Spaceship ship;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_lab);

        game = GameClient.getInstance();
        ship = Spaceship.getInstance();
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
     * Whenever the button to complete the Asteroid Field Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeAsteroidFieldEvent(View view){
        if(ship.getEventLog().contains(Events.ASTEROID)){
            game.sendMessage(new EventCompletedMessage("Asteroid Field Event", ship.getEventLog().pop(Events.ASTEROID).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }
}
