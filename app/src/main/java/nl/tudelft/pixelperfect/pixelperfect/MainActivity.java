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
public class MainActivity extends PixelPerfectActivity implements ConnectResponse {

    private GameClient game;

    /**
     * Whenever this activity is created, the game will be initialized and a dialog will lead
     * the user to the next page.
     *
     * @param savedInstanceState A Bundle.
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        game = getGame();
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        buildDialog("Connecting", "Trying to establish a connection with the game server.");
    }

    /**
     * Starts the roles.
     */
    private void setupRoles() {
        Intent intent = new Intent(this, RoleActivity.class);
        startActivity(intent);
    }

    /**
     * Manages the connection through the user. The user must enter an ip-address in order to
     * connect.
     * @param view , a basic block of user interface components.
     */
    public void connect(View view) {
        if (game.isConnected()) {
            showMessage("Already connected!");
            setupRoles();
            return;
        }
        EditText text = (EditText) findViewById(R.id.ip_address);
        @SuppressWarnings("ConstantConditions") String ip = text.getText().toString();
        if (ip.equals("")) {
            showMessage("Please enter an IP-Address");
            return;
        }
        showDialog();
        game.connect(ip, this);
    }

    /**
     * Notifies the user whether the connection had failed or not.
     *
     * @param client , the client can tell whether there is a connection.
     */
    public void connectFinish(Client client) {
        dismissDialog();
        if (client != null) {
            game.setClient(client);
            showMessage("Connection established!");
            setupRoles();
        } else {
            showMessage("Connection failed...");
        }
    }
}
