package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import nl.tudelft.pixelperfect.client.GameClient;

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

}
