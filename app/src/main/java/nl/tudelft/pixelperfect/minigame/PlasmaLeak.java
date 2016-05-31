package nl.tudelft.pixelperfect.minigame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import nl.tudelft.pixelperfect.client.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.Events;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.Spaceship;

/**
 * Created by Dmitry on 30/05/2016.
 */
public class PlasmaLeak extends AppCompatActivity{
    private GameClient game = GameClient.getInstance();
    private static Spaceship ship = Spaceship.getInstance();
    private ProgressBar progress;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minigame_plasma);
        progress = (ProgressBar) findViewById(R.id.mini_game_progress_bar);
        progress.incrementProgressBy(25);
    }

    public void complete(View view) {
        if(ship.getEventLog().contains(Events.PLASMA)) {
            game.sendMessage(new EventCompletedMessage("Plasma Event", ship.getEventLog().pop(Events.PLASMA).getId()));
        } else {
            game.sendMessage(new EventCompletedMessage("WRONG ANSWER", -1));
        }
    }

}
