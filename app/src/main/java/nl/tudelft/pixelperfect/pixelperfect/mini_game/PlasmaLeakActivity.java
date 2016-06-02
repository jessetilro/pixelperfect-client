package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;

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
    private int removedbolts;
    private boolean deckOn;
    private boolean armoryOn;
    private boolean engineOn;
    private boolean labOn;

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
        deckOn = false;
        armoryOn = false;
        engineOn = false;
        labOn = false;
        removedbolts = 0;
    }

    public void switchLab(View view) {
            labOn = true;
            deckOn = false;
            armoryOn = false;
            engineOn = false;
    }

    public void switchArmory(View view) {
            labOn = false;
            deckOn = false;
            armoryOn = true;
            engineOn = false;
    }

    public void switchDeck(View view) {
            labOn = false;
            deckOn = true;
            armoryOn = false;
            engineOn = false;
    }

    public void switchEngine(View view) {
            labOn = false;
            deckOn = false;
            armoryOn = false;
            engineOn = true;
    }

    public void removeBolts(View view) {
        if(progress.getProgress() < 25) {
            if(removedbolts != 5 ) {
                progress.incrementProgressBy(5);
                removedbolts++;
            }
        }
    }

    public void repairPipe(View view) {
        if(progress.getProgress() < 75 && progress.getProgress() >=25) {
            if(removedbolts == 5) {
                progress.incrementProgressBy(5);
            }
        }
    }

    public void insertBolts(View view) {
        if(progress.getProgress() < 100 && progress.getProgress() >=75) {
            if(removedbolts != 0 ) {
                progress.incrementProgressBy(5);
                removedbolts--;
            }
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
