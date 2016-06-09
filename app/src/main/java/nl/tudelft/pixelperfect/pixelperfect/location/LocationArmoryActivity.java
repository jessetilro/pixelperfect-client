package nl.tudelft.pixelperfect.pixelperfect.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.minigame.HostileShipActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.PlasmaLeakActivity;


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
        game.sendMessage(new EventCompletedMessage(EventTypes.FIRE_OUTBREAK.ordinal()));
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
