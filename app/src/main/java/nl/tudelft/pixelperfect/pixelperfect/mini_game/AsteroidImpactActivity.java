package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import nl.tudelft.pixelperfect.pixelperfect.R;

/**
 * The mini-game Asteroid Impact in which the use must click a wrench-button a certain amount of
 * times to repair the ship.
 *
 * @author Floris Doolaard
 */
public class AsteroidImpactActivity extends AppCompatActivity  {
    private ProgressBar progressBar;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game_asteroid_impact);

        progressBar = (ProgressBar) findViewById(R.id.mini_game_asteroid_impact_progressBar);
    }

    /**
     * When the user presses the button, progress should be made.
     *
     * @param view the View of the button.
     */
    public void createProgress(View view) {
        if(progressBar.getProgress() != 100) {
            progressBar.incrementProgressBy(5);
        } else {
            //TO DO - Send message to Server.
        }

    }

}
