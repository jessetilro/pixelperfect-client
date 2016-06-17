package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
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
     * and relevant information retrieved.
     *
     * @param savedInstanceState the instance to create.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_outbreak);

        game = GameClient.getInstance();
    }
}
