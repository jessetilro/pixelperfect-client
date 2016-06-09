package nl.tudelft.pixelperfect.pixelperfect.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.minigame.HostileShipActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.FireOutbreakActivity;


/**
 * This class represents the location of the Armory occupied by the Gunner.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"CanBeFinal", "unused", "UnusedParameters"})
public class LocationArmoryActivity extends AppCompatActivity {
    private GameClient game = GameClient.getInstance();

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_armory);
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeFireEvent(View view) {
        Intent intent = new Intent(this, FireOutbreakActivity.class);
        startActivity(intent);
    }

    /**
     * Whenever the button to complete the Hostile Ship Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeHostileShipEvent(View view) {
        Intent intent = new Intent(this, HostileShipActivity.class);
        startActivity(intent);
    }
}
