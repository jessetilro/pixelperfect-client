package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.EventLog;

/**
 * The GameActivity page is a page where game starts. It is the main menu of the Android app.
 */
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
    public void completeAsteroid(View view){
        AsteroidFieldEvent asteroidFieldEvent = new AsteroidFieldEvent(0, "An asteroid field", "Very dangerous", )
    }

}
