package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.Collection;
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
    private int armor;

    /**
     * Initializing elements when the activity is created.
     *
     * @param savedInstanceState, a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame_hostile_ship);
        armor = 0;
    }

    /**
     * Handler called when the selection for the armor field is updated.
     *
     * @param view The view element.
     */
    public void onSelectArmor(View view) {
        int[] ids = {R.id.purple_armor, R.id.red_armor, R.id.green_armor};
        for (int index = 0; index < ids.length; index++) {
            if (ids[index] == view.getId()) {
                armor = index;
            }
        }
    }

    /**
     * Read the entered x-coordinate from the view.
     *
     * @return The entered position x parameter value.
     */
    private int readPositionX() {
        EditText positionX = (EditText) findViewById(R.id.position_x);
        return Integer.parseInt(positionX.getText().toString());
    }

    /**
     * Read an entered integer value from the view.
     *
     * @param id The view element id to read from.
     * @return The entered integer value.
     */
    private int readInteger(int id) {
        EditText editText = (EditText) findViewById(id);
        return Integer.parseInt(editText.getText().toString());
    }

    /**
     * If the event is completed, send the message to the server.
     *
     * @param view The view element.
     */
    public void complete(View view) {
        EventCompletedMessage message = new EventCompletedMessage(EventTypes.HOSTILE_SHIP.ordinal());
        Map<String, Integer> parameters = new HashMap<String, Integer>();
        parameters.put("positionX", readInteger(R.id.position_x));
        parameters.put("positionY", readInteger(R.id.position_y));
        parameters.put("armor", armor);
        message.setParameters(parameters);
        game.sendMessage(message);

        Intent intent = new Intent(this, LocationArmoryActivity.class);
        startActivity(intent);
    }


}
