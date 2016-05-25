package nl.tudelft.pixelperfect.pixelperfect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This class represents the location of the Engine Room occupied by the Engineer.
 *
 * @author Floris Doolaard
 */
public class LocationEngineroomActivity extends AppCompatActivity {

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_engineroom);
    }
}
