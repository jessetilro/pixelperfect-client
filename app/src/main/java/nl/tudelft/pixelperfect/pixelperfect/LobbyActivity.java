package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nl.tudelft.pixelperfect.client.GameClient;

/**
 * The lobby is where the client user connects to the game and waits for the captain to start it.
 *
 * @author Floris Doolaard
 */
public class LobbyActivity extends AppCompatActivity {
    private static Context mContext;

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
    }

    public static void startGame() {
        Intent newGame = new Intent(mContext, RoleActivity.class);
        mContext.startActivity(newGame);
    }
}
