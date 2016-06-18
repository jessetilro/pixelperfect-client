package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;

/**
 * Represent the screen the client gets when a PlasmaLeakEvent is active.
 *
 * @author Dmitry
 */
@SuppressWarnings("UnusedParameters")
public class PlasmaLeakActivity extends PixelPerfectActivity{
    private GameClient game = GameClient.getInstance();
    private ProgressBar progress;
    private int removedBolts;
    private int sector;

    /**
     * Initializing elements when the activity is created.
     *
     * @param savedInstanceState, a Bundle.
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        setContentView(R.layout.activity_minigame_plasma_leak);
        progress = (ProgressBar) findViewById(R.id.mini_game_progress_bar);
        removedBolts = 0;
    }

    /**
     * What happens if the lab radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchLab(View view) {
        sector = 0;
    }

    /**
     * What happens if the armory radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchArmory(View view) {
        sector = 1;
    }

    /**
     * What happens if the deck radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchDeck(View view) {
        sector = 3;
    }

    /**
     * What happens if the engine radio button is pressed.
     *
     * @param view, the view of the page.
     */
    public void switchEngine(View view) {
            sector = 2;
    }

    /**
     * Step 1 of the mini-game process.
     *
     * @param view, the view of the page.
     */
    public void removeBolts(View view) {
        if(progress.getProgress() < 25) {
            if(removedBolts != 5 ) {
                progress.incrementProgressBy(5);
                removedBolts++;
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
            if(removedBolts == 5) {
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
            if(removedBolts != 0 ) {
                progress.incrementProgressBy(5);
                removedBolts--;
            }
        }
    }

    /**
     * If the event is completed, send the message to the server.
     *
     * @param view, the view of the page.
     */
    public void complete(View view) {
        if(progress.getProgress() == 100) {
            EventCompletedMessage message = new EventCompletedMessage(EventTypes.PLASMA_LEAK.ordinal());
            Map<String, Integer> parameters = new HashMap<String, Integer>();
            parameters.put("sector", sector);
            message.setParameters(parameters);
            game.sendMessage(message);
            Intent intent = new Intent(this, LocationLabActivity.class);
            startActivity(intent);
        }
    }

}
