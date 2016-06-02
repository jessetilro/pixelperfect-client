package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.event.parameter.EventParameter;
import nl.tudelft.pixelperfect.event.parameter.EventParameterValues;
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

    /**
     * What happens if the lab radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchLab(View view) {
            labOn = true;
            deckOn = false;
            armoryOn = false;
            engineOn = false;
    }

    /**
     * What happens if the armory radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchArmory(View view) {
            labOn = false;
            deckOn = false;
            armoryOn = true;
            engineOn = false;
    }

    /**
     * What happens if the deck radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchDeck(View view) {
            labOn = false;
            deckOn = true;
            armoryOn = false;
            engineOn = false;
    }

    /**
     * What happens if the engine radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchEngine(View view) {
            labOn = false;
            deckOn = false;
            armoryOn = false;
            engineOn = true;
    }

    /**
     * Step 1 of the mini-game process.
     *
     * @param view, the view of the page.
     */
    public void removeBolts(View view) {
        if(progress.getProgress() < 25) {
            if(removedbolts != 5 ) {
                progress.incrementProgressBy(5);
                removedbolts++;
            }
        }
    }

    /**
     * Step 2 of the mini-game process.
     *
     * @param view, the view of the page.
     */
    public void repairPipe(View view) {
        if(progress.getProgress() < 75 && progress.getProgress() >=25) {
            if(removedbolts == 5) {
                progress.incrementProgressBy(5);
            }
        }
    }

    /**
     * Step 3 of the mini-game process.
     *
     * @param view, the view of the page.
     */
    public void insertBolts(View view) {
        if(progress.getProgress() < 100 && progress.getProgress() >=75) {
            if(removedbolts != 0 ) {
                progress.incrementProgressBy(5);
                removedbolts--;
            }
        }
    }

    /**
     * Sends a faulty message.
     *
     */
    public void sendFailure() {
        game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        Intent intent = new Intent(this, LocationEngineroomActivity.class);
        startActivity(intent);
    }


    /**
     * If the event is completed, send the message to the server.
     *
     * @param view, the view of the page.
     */
    public void complete(View view) {
        if(ship.getEventLog().contains(Events.PLASMA) && progress.getProgress() == 100) {
            EventCompletedMessage message = new EventCompletedMessage("Plasma Event", ship.getEventLog().pop(Events.PLASMA).getId());
            Map<String, Integer> parameters = new HashMap<String, Integer>();
            if(labOn) {
                parameters.put("sector", 0);
            } else if(armoryOn) {
                parameters.put("sector", 1);
            } else if(deckOn) {
                parameters.put("sector", 2);
            } else if(engineOn) {
                parameters.put("sector", 3);
            } else {
                sendFailure();
                return;
            }
            message.setParameters(parameters);
            game.sendMessage(message);
            Intent intent = new Intent(this, LocationEngineroomActivity.class);
            startActivity(intent);

        } else {
            sendFailure();
        }
    }

}
