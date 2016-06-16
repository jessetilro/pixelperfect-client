package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;

/**
 * Class responsible for the handling of the fire outbreak event.  A choice must
 * be made between multiple solutions, and then selected where to
 * deploy them to combat the fire.
 *
 * @author David Alderliesten
 *
 */
public class FireOutbreakActivity extends AppCompatActivity {
    private GameClient game;

    private int fireLocation;

    private CheckBox useFireExtinguisher;
    private CheckBox useAutomator;
    private CheckBox useWaterBucket;
    private CheckBox useFireBlanket;
    private CheckBox useHammer;

    private Button deployToAirSupport;
    private Button deployToEngine;
    private Button deployToWingPlasma;

    /**
     * On creation of the fire activity the content views will be initialized
     * and relevant information retrieved.
     *
     * @param savedInstanceState the instance to create.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_outbreak);

        useFireExtinguisher = (CheckBox) findViewById(R.id.extinguishBox);
        useAutomator = (CheckBox) findViewById(R.id.automatedKillerBox);
        useWaterBucket = (CheckBox) findViewById(R.id.bucketBox);
        useFireBlanket = (CheckBox) findViewById(R.id.blanketBox);
        useHammer = (CheckBox) findViewById(R.id.hammerBox);

        deployToAirSupport = (Button) findViewById(R.id.airSupportButton);
        deployToEngine = (Button) findViewById(R.id.engineButton);
        deployToWingPlasma = (Button) findViewById(R.id.deckButton);

        game = GameClient.getInstance();
    }

    /**
     * Class that sends the completed message with the validated parameter
     * to the game class.
     *
     * @param passedState
     *      The given state of validation.
     */
    private void validateAction(int passedState) {
        if(passedState > -1) {
            Map<String, Integer> parameters = new HashMap<String, Integer>();
            parameters.put("location", passedState);

            EventCompletedMessage message = new EventCompletedMessage(EventTypes.FIRE_OUTBREAK.ordinal());
            message.setParameters(parameters);

            game.sendMessage(message);
        }

        finish();
    }

    /**
     * Class aimed at verifying the total score obtained to verify the selected methods.
     * A small value is good for the engines, a large value is good for the wings.
     *
     * @return total score found.
     */
    private int accumulatedVerification() {
        // Int for verifying the accumulated selection.
        int verifyAccumulator = 0;

        // Running through all cases and adding values as needed.
        if(useFireExtinguisher.isEnabled()) {
            verifyAccumulator += 5;
        }

        if(useAutomator.isEnabled()) {
            verifyAccumulator += 50;
        }

        if(useWaterBucket.isEnabled()) {
            verifyAccumulator += 3;
        }

        if(useFireBlanket.isEnabled()) {
            verifyAccumulator += 8;
        }

        if(useHammer.isEnabled()) {
            verifyAccumulator += 2;
        }

        // Returning the found accumulation.
        return verifyAccumulator;
    }

    /**
     * Class that handles the airSupportButton press event and validates
     * the selected method.
     *
     * @param view
     *      The passed view.
     */
    public void onAirButtonPress(View view) {
        if(fireLocation == 0) {
            int accumulation = accumulatedVerification();

            if((0 <= accumulation) && (accumulation < 1000)) {
                validateAction(2);
            } else {
                validateAction(-1);
            }
        } else {
            validateAction(-1);
        }
    }

    /**
     * Class that handles the engineButton press event and validates
     * the selected method.
     *
     * @param view
     *      The passed view.
     */
    public void onEnginePress(View view) {
        if(fireLocation == 1) {
            int accumulation = accumulatedVerification();

            if((0 <= accumulation) && (accumulation < 1000)) {
                validateAction(1);
            } else {
                validateAction(-1);
            }
        } else {
            validateAction(-1);
        }
    }

    /**
     * Class that handles the engineButton press event and validates
     * the selected method.
     *
     * @param view
     *      The passed view.
     */
    public void onDeckPress(View view) {
        if(fireLocation == 2) {
            int accumulation = accumulatedVerification();

            if((0 <= accumulation) && (accumulation <= 1000)) {
                validateAction(0);
            } else {
                validateAction(-1);
            }
        } else {
            validateAction(-1);
        }
    }
}
