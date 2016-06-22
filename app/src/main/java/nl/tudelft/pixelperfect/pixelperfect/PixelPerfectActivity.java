package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationArmoryActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationDeckActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;
import nl.tudelft.pixelperfect.player.PlayerRoles;

/**
 * The super type of all activities in the application.
 * Used to easily share a persistent state and common logic between the activities.
 *
 * @author Jesse Tilro
 */
public abstract class PixelPerfectActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private GameClient game;

    /**
     * Whenever this activity is created, the PixelPerfect activity will be initialized and it will then delegate to its subclass.
     *
     * @param savedInstanceState A Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = GameClient.getInstance();
        game.delegateTo(this);

        String message = getIntent().getStringExtra("message");
        if (message != null) {
            showMessage(message);
            getIntent().removeExtra("message");
        }

        initialize(savedInstanceState);
    }

    /**
     * Get the singleton instance of the Game.
     *
     * @return The game.
     */
    public GameClient getGame() {
        return game;
    }

    /**
     * Check for connection with the server. If disconnected, go back to main activity.
     */
    public void checkForConnection() {
        if (!game.isConnected()) {
            reset();
        }
    }

    /**
     * Reset the application by resetting the game logic and returning to the initial activity.
     * Used when getting disconnected.
     */
    public void reset() {
        GameClient.reset();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("message", "Connection closed...");
        startActivity(intent);
        finish();
    }

    /**
     * The concrete activity should implement an initialize method to which this super type can delegate.
     *
     * @param savedInstanceState A Bundle.
     */
    protected abstract void initialize(Bundle savedInstanceState);

    /**
     * Builds a dialog which informs the user.
     *
     * @param title   The title of the dialog.
     * @param message The title of the message.
     */
    public void buildDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Trying to establish a connection with the game server.")
                .setTitle("Connecting");
        dialog = builder.create();
    }

    /**
     * Show the dialog that was built before.
     */
    public void showDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }

    /**
     * Dismiss the current dialog.
     */
    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }


    /**
     * Shows a small popup which fades away after a time-out.
     *
     * @param text the text to be shown.
     */
    public void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Enter the lobby activity.
     */
    public void enterLobby(PlayerRoles role) {
        game.assignRole(role);
        Intent lobby = new Intent(this, LobbyActivity.class);
        lobby.putExtra("message", "You are the " + role.toString());
        startActivity(lobby);
        finish();
    }

    /**
     * Start the game.
     */
    public void startGame() {
        Map<PlayerRoles, Intent> destination = new HashMap<>();
        destination.put(PlayerRoles.GUNNER, new Intent(this, LocationArmoryActivity.class));
        destination.put(PlayerRoles.ENGINEER, new Intent(this, LocationEngineroomActivity.class));
        destination.put(PlayerRoles.SCIENTIST, new Intent(this, LocationLabActivity.class));
        destination.put(PlayerRoles.JANITOR, new Intent(this, LocationDeckActivity.class));

        if (game.getRole() != null && !game.isRunning()) {
            game.start();
            Intent newGame = destination.get(game.getRole());
            startActivity(newGame);
            finish();
        }
    }

}
