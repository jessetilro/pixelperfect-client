package nl.tudelft.pixelperfect.pixelperfect.mini_game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
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
        seekBar = (SeekBar) findViewById(R.id.mini_game_asteroid_impact_seekBar);

        progressBar.incrementProgressBy(99);
        seekBar.incrementProgressBy(40);
    }

}
