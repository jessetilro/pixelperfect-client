package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameClient game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button button = (Button) findViewById(R.id.button_complete_event);
        button.setOnClickListener(this);

        game = GameClient.getInstance();

    }

    private void sendMessage(){
        EventCompletedMessage eventCompleted = new EventCompletedMessage(new AsteroidFieldEvent(1, "Hello Messages!", "Description", 10, 20, 0));
        game.sendMessage(eventCompleted);
    }

    @Override
    public void onClick(View v) {
        sendMessage();
    }
}
