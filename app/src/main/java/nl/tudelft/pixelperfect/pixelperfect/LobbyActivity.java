package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.game.Roles;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationArmoryActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationDeckActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.PlasmaLeakActivity;

/**
 * The lobby is where the client user connects to the game and waits for the captain to start it.
 *
 * @author Floris Doolaard
 */
public class LobbyActivity extends AppCompatActivity {
    private static Context mContext;
    private static Roles chosenRole;

    /**
     * Whenever this activity is created the layout will be set.
     *
     * @param savedInstanceState a Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        mContext = this;
        chosenRole = (Roles) getIntent().getSerializableExtra("Role");
    }

    /**
     * Starts the game because a message was received from the server.
     */
    public static void startGame() {
        if (chosenRole == null) {
            return;
        }

        Intent newGame;
        switch(chosenRole){
            case GUNNER:
                newGame = new Intent(mContext, LocationArmoryActivity.class);
                break;
            case ENGINEER:
                newGame = new Intent(mContext, LocationEngineroomActivity.class);
                break;
            case SCIENTIST:
                newGame = new Intent(mContext, LocationLabActivity.class);
                break;
            case JANITOR:
                newGame = new Intent(mContext, LocationDeckActivity.class);
                break;
            default:
                System.out.println("Error: something went wrong trying to select a role.");
                newGame = new Intent(mContext, MainActivity.class);
                break;
        }
        mContext.startActivity(newGame);
    }
}
