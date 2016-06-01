package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;

/**
 * Represent the screen the client gets when a PlasmaLeakEvent is active.
 *
 * @author Dmitry
 */
public class PlasmaLeakActivity extends AppCompatActivity{
    private GameClient game = GameClient.getInstance();
    private static Spaceship ship = Spaceship.getInstance();
    private ProgressBar progress;


    /**
     * Initializing elements when the activity is created.
     *
     * @param savedInstanceState, a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_plasma);
        progress = (ProgressBar) findViewById(R.id.mini_game_progress_bar);
        progress.incrementProgressBy(25);
    }


    /**
     * If the event is completed, send the message to the server.
     *
     * @param view, the view of the page.
     */
    public void complete(View view) {
        if(ship.getEventLog().contains(Events.PLASMA)) {
            game.sendMessage(new EventCompletedMessage("Plasma Event", ship.getEventLog().pop(Events.PLASMA).getId()));
            Intent intent = new Intent(this, LocationEngineroomActivity.class);
            startActivity(intent);
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
            Intent intent = new Intent(this, LocationEngineroomActivity.class);
            startActivity(intent);
        }
    }

}
