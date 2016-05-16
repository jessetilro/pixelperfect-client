package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.AsteroidFieldEvent;

public class GameActivity extends AppCompatActivity {
    private GameClient game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = GameClient.getInstance();
        sendMessage();
    }

    private void sendMessage(){
        EventCompletedMessage eventCompleted = new EventCompletedMessage(new AsteroidFieldEvent(1, "Hello Messages!", "Description", 10, 20, 0));
        game.sendMessage(eventCompleted);
    }
}
