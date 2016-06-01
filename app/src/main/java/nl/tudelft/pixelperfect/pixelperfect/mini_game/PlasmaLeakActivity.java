package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private boolean deckOff;
    private boolean armoryOff;
    private boolean engineOff;
    private boolean labOff;
    private boolean lockedIn;

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
        deckOff = false;
        armoryOff = false;
        engineOff = false;
        labOff = false;
        lockedIn = false;
    }

    public void switchLab(View view) {
        labOff = !labOff;
    }

    public void switchArmory(View view) {
        armoryOff = !armoryOff;
    }

    public void switchDeck(View view) {
        deckOff = !deckOff;
    }

    public void switchEngine(View view) {
        engineOff = !engineOff;
    }

    public void lockIn(View view) {
        if (lockedIn = true){
            return;
        }
        else {
            Button armory = (Button) findViewById(R.id.Pipe_Armory);
            armory.setClickable(false);
            Button engine = (Button) findViewById(R.id.Pipe_Engine);
            engine.setClickable(false);
            Button lab = (Button) findViewById(R.id.Pipe_Lab);
            lab.setClickable(false);
            Button deck = (Button) findViewById(R.id.Pipe_Deck);
            deck.setClickable(false);
            lockedIn = true;
            progress.incrementProgressBy(40);
        }
    }

    /**
     * If the event is completed, send the message to the server.
     *
     * @param view, the view of the page.
     */
    public void complete(View view) {
        if(ship.getEventLog().contains(Events.PLASMA) && progress.getProgress() == 100) {
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
