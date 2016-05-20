package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.EventLog;
import nl.tudelft.pixelperfect.event.Events;

/**
 * The GameActivity page is a page where game starts. It is the main menu of the Android app.
 */
@SuppressWarnings({"UnusedParameters", "unused"})
public class GameActivity extends AppCompatActivity {
    private GameClient game;
    private static EventLog eventLog;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        eventLog = new EventLog();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = GameClient.getInstance();

    }

    public static void updateEventLog(Event event) {
        eventLog.add(event);
    }

    /**
     * Whenever the button to complete the Asteroid Field Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeAsteroidFieldEvent(View view){
        if(eventLog.contains(Events.ASTEROID)){
            game.sendMessage(new EventCompletedMessage("Asteroid Field Event", eventLog.pop(Events.ASTEROID).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeFireEvent(View view){
        if(eventLog.contains(Events.FIRE)){
            game.sendMessage(new EventCompletedMessage("Fire Event", eventLog.pop(Events.FIRE).getId()));
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
        if(eventLog.contains(Events.HOSTILE)){
            game.sendMessage(new EventCompletedMessage("Hostile Ship Event", eventLog.pop(Events.HOSTILE).getId()));
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
        if(eventLog.contains(Events.PLASMA)){
            game.sendMessage(new EventCompletedMessage("Plasma Leak Event", eventLog.pop(Events.PLASMA).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }

}
