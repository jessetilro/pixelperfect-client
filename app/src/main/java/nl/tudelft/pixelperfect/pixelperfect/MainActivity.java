package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jme3.network.Client;

import nl.tudelft.pixelperfect.client.ConnectResponse;
import nl.tudelft.pixelperfect.client.GameClient;

/**
 * This is the first screen for the app on which one can insert an ip-address of the server.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"UnusedParameters", "unused"})
public class MainActivity extends AppCompatActivity implements ConnectResponse {

    private GameClient game;
    private AlertDialog dialog;

    /**
     * Whenever this activity is created, the game will be initialized and a dialog will lead
     * the user to the next page.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = GameClient.getInstance();
        buildDialog();
    }

    /**
     * Builds a dialog which informs the user.
     */
    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Trying to establish a connection with the game server.")
                .setTitle("Connecting");
        dialog = builder.create();
    }

    /**
     * Starts the lobby.
     */
    private void setupLobby() {
        Intent intent = new Intent(this, LobbyActivity.class);
        startActivity(intent);
    }

    /**
     * Shows a small popup which fades away after a time-out.
     *
     * @param text the text to be shown.
     */
    private void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Manages the connection through the user. The user must enter an ip-address in order to
     * connect.
     * @param view , a basic block of user interface components.
     */
    public void connect(View view) {
        if (game.isConnected()) {
            showMessage("Already connected!");
            setupLobby();
            return;
        }
        EditText text = (EditText) findViewById(R.id.ip_address);
        @SuppressWarnings("ConstantConditions") String ip = text.getText().toString();
        if (ip.equals("")) {
            showMessage("Please enter an IP-Address");
            return;
        }
        dialog.show();
        game.connect(ip, this);
    }

    /**
     * Notifies the user whether the connection had failed or not.
     *
     * @param client , the client can tell whether there is a connection.
     */
    public void connectFinish(Client client) {
        dialog.dismiss();
        if (client != null) {
            game.setClient(client);
            showMessage("Connection established!");
            setupLobby();
        } else {
            showMessage("Connection failed...");
        }
    }
}
