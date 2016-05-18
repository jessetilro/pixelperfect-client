package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;

/**
 * The GameActivity page is a page where game starts. It is the main menu of the Android app.
 */
public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameClient game;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button button = (Button) findViewById(R.id.button_complete_event);
        button.setOnClickListener(this);

        game = GameClient.getInstance();

    }

    /**
     * Sends a message to the Server when clicked on the button_complete_event Button.
     *
     * @param v , the View of the activity.
     */
    @Override
    public void onClick(View v) {
        EventCompletedMessage eventCompleted = new EventCompletedMessage("0");
        game.sendMessage(eventCompleted);
    }
}
