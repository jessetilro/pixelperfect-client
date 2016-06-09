package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationArmoryActivity;

/**
 * Represent the screen the client gets when a PlasmaLeakEvent is active.
 *
 * @author Jesse Tilro
 */
public class HostileShipActivity extends AppCompatActivity {
    private GameClient game = GameClient.getInstance();

    /**
     * Initializing elements when the activity is created.
     *
     * @param savedInstanceState, a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame_hostile_ship);
    }

    /**
     * If the event is completed, send the message to the server.
     *
     * @param view, the view of the page.
     */
    public void complete(View view) {
        EventCompletedMessage message = new EventCompletedMessage(EventTypes.HOSTILE_SHIP.ordinal());
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("testParam", 42);
        message.setParameters(parameters);
        game.sendMessage(message);
        Intent intent = new Intent(this, LocationArmoryActivity.class);
        startActivity(intent);
    }


}
