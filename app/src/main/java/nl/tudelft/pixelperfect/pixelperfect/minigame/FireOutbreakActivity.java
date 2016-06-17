package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import nl.tudelft.pixelperfect.client.GameClient;
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

        SeekBar waterBar = (SeekBar)findViewById(R.id.waterBar);
        final TextView waterDisplay = (TextView)findViewById(R.id.literView);

        waterBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                waterDisplay.setText(String.valueOf(progress));
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
}
