package nl.tudelft.pixelperfect.pixelperfect.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;
import nl.tudelft.pixelperfect.pixelperfect.mini_game.AsteroidImpactActivity;

/**
 * This class represents the location of the Lab occupied by the Scientist.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"CanBeFinal", "unused", "UnusedParameters"})
public class LocationLabActivity extends AppCompatActivity {
    private GameClient game = GameClient.getInstance();
    private static Spaceship ship = Spaceship.getInstance();

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_lab);
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeFireEvent(View view) {
        game.sendMessage(new EventCompletedMessage(EventTypes.FIRE_OUTBREAK.ordinal()));
    }

    /**
     * Whenever the button to complete the Asteroid Field Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeAsteroidFieldEvent(View view) {
        Intent intent = new Intent(this, AsteroidImpactActivity.class);
        startActivity(intent);
    }
}
