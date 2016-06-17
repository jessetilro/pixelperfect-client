package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;

/**
 * Class responsible for the handling of the fire outbreak event.  An amount of liters must be
 * selected with with a slider, and then the location of the fire must be chosen to deploy
 * the dousing blanket.
 *
 * @author David Alderliesten
 *
 */
public class FireOutbreakActivity extends AppCompatActivity {
    private GameClient game;
    private SeekBar waterBar;


    /**
     * On creation of the fire activity the content views will be initialized
     * and relevant information retrieved.  Also contains the seekbar value text/label
     * updater method, which is required.
     *
     * @param savedInstanceState the instance to create.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_outbreak);
        game = GameClient.getInstance();

        waterBar = (SeekBar)findViewById(R.id.waterBar);
        final TextView waterDisplay = (TextView)findViewById(R.id.literView);

        waterBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                waterDisplay.setText(String.valueOf(progress) + "Liters");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Required method, is not used.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Required method, is not used.
            }
        });
    }

    /**
     * Method responsible for completing the event and sending the data to the server application.
     *
     * @param passedValue
     *             the given water liter value.
     * @param passedLocation
     *             the given location value.
     */
    private void completeEvent(int passedValue, int passedLocation) {
        EventCompletedMessage message = new EventCompletedMessage(EventTypes.FIRE_OUTBREAK.ordinal());

        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("location", passedLocation);
        parameters.put("water", passedValue);

        message.setParameters(parameters);
        game.sendMessage(message);

        finish();
    }

    /**
     * Method for handling the air button douse event.
     *
     * @param view
     *             the current view of the button, required as per API.
     */
    public void onAirButtonPress(View view) {
        completeEvent(waterBar.getProgress(), 2);
    }

    /**
     * Method for handling the engine button douse event.
     *
     * @param view
     *             the current view of the button, required as per API.
     */
    public void onEnginePress(View view) {
        completeEvent(waterBar.getProgress(), 1);
    }

    /**
     * Method for handling the deck button douse event.
     *
     * @param view
     *             the current view of the button, required as per API.
     */
    public void onDeckPress(View view) {
        completeEvent(waterBar.getProgress(), 0);
    }
}
