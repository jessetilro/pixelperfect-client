package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Space;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;
import nl.tudelft.pixelperfect.event.Event;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;

/**
 * The mini-game Asteroid Impact in which the use must click a wrench-button a certain amount of
 * times to repair the ship.
 *
 * @author Floris Doolaard
 */
public class AsteroidImpactActivity extends AppCompatActivity  {
    private Spaceship ship;
    private GameClient game;
    private ProgressBar progressBarEnergyShield;
    private ProgressBar progressBarHyperdrive;
    private Boolean repairingEnergyShield;

    /**
     * On creation of the Activity the the content views will be initialized.
     *
     * @param savedInstanceState the instance to create.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game_asteroid_impact);

        progressBarEnergyShield = (ProgressBar) findViewById(R.id.mini_game_asteroid_impact_progressBar1);
        progressBarHyperdrive = (ProgressBar) findViewById(R.id.mini_game_asteroid_impact_progressBar2);

        game = GameClient.getInstance();
        ship = Spaceship.getInstance();
        repairingEnergyShield = true;
    }

    /**
     * When the user presses the button, progress should be made.
     *
     * @param view the View of the button.
     */
    public void createProgress(View view) {
        if(repairingEnergyShield){
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
    public void increaseProgress(ProgressBar progressBar){
        if(progressBar.getProgress() != 100) {
            progressBar.incrementProgressBy(5);
        } else {
            if(ship.getEventLog().contains(Events.ASTEROID)){
                Event event = ship.getEventLog().peek(Events.ASTEROID);

                game.sendMessage(new EventCompletedMessage("Asteroid Field Event", ship.getEventLog().pop(Events.ASTEROID).getId()));
            } else {
                game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
            }
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

        switch(view.getId()) {
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
