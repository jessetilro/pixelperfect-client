package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;

/**
 * The mini-game Asteroid Impact in which the use must click a wrench-button a certain amount of
 * times to repair the ship.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public class AsteroidImpactActivity extends PixelPerfectActivity {
    private GameClient game = GameClient.getInstance();
    private ProgressBar progressBarEnergyShield;
    private ProgressBar progressBarHyperdrive;
    private Boolean repairingEnergyShield;

    /**
     * On creation of the Activity the the content views will be initialized.
     *
     * @param savedInstanceState the instance to create.
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        setContentView(R.layout.activity_minigame_asteroid_impact);

        progressBarEnergyShield = (ProgressBar) findViewById(R.id.mini_game_asteroid_impact_progressBar1);
        progressBarHyperdrive = (ProgressBar) findViewById(R.id.mini_game_asteroid_impact_progressBar2);

        repairingEnergyShield = true;
    }

    /**
     * When the user presses the button, progress should be made.
     *
     * @param view the View of the button.
     */
    @SuppressWarnings("UnusedParameters")
    public void createProgress(View view) {
        if (repairingEnergyShield) {
            increaseProgress(progressBarEnergyShield);
        } else {
            increaseProgress(progressBarHyperdrive);
        }
    }

    /**
     * Increases progress of a progressBar and sends a message whenever it is done.
     *
     * @param progressBar the progressBar on which progress must increase.
     */
    public void increaseProgress(ProgressBar progressBar) {
        progressBar.incrementProgressBy(5);

        if (progressBar.getProgress() >= 95) {
            EventCompletedMessage message = new EventCompletedMessage(EventTypes.ASTEROID_IMPACT.ordinal());
            Map<String, Integer> parameters = new HashMap<String, Integer>();
            parameters.put("locationDamageImpact", (repairingEnergyShield ? 0 : 1));
            message.setParameters(parameters);
            game.sendMessage(message);

            Intent intent = new Intent(this, LocationEngineroomActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Whenever a radio button from the RadioGroup gets clicked it must select the accompanied
     * progress bar.
     *
     * @param view the view of the RadioGroup.
     */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.mini_game_asteroid_impact_radio1:
                if (checked)
                    repairingEnergyShield = true;
                break;
            case R.id.mini_game_asteroid_impact_radio2:
                if (checked)
                    repairingEnergyShield = false;
                break;
        }
    }

}
