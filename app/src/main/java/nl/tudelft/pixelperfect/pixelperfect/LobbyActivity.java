package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.NewGameMessage;
import nl.tudelft.pixelperfect.player.PlayerRoles;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationArmoryActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationDeckActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;

/**
 * The lobby is where the client user connects to the game and waits for the captain to start it.
 *
 * @author Floris Doolaard
 * @author Jesse Tilro
 */
public class LobbyActivity extends PixelPerfectActivity {
    private static Context mContext;
    private static PlayerRoles chosenRole;

    /**
     * Whenever this activity is created the layout will be set.
     *
     * @param savedInstanceState a Bundle
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        setContentView(R.layout.activity_lobby);

        mContext = this;
        chosenRole = (PlayerRoles) getIntent().getSerializableExtra("Role");

        getGame().stop();

        getGame().sendMessage(new NewGameMessage());
    }

    /**
     * When the home button is pressed in the actionbar, the user will go to the MainActivity.
     * This has the same function as the back button on the device
     * itself.
     *
     * @param item the item in the action bar.
     * @return states whether a function was executed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    /**
     * When you press the back button the mobile device, you will go to the mainActivity.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, RoleActivity.class);
        intent.putExtra("message", "You are no longer " + getGame().getRole());
        startActivity(intent);
        finish();
    }

    /**
     * Refresh by asking the server whether the game has already started.
     */
    public void refresh(View element) {
        showMessage("Refreshing...");
        checkForConnection();
        getGame().sendMessage(new NewGameMessage());
    }
}
