package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jme3.network.Client;

import nl.tudelft.pixelperfect.client.ConnectResponse;
import nl.tudelft.pixelperfect.client.ConnectTask;
import nl.tudelft.pixelperfect.client.GameActivity;
import nl.tudelft.pixelperfect.client.GameClient;

public class MainActivity extends AppCompatActivity implements GameActivity, ConnectResponse {

    private GameClient game;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = GameClient.getInstance();
        game.setActivity(this);
        buildDialog();
    }

    private void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Trying to establish a connection with the game server.")
                .setTitle("Connecting");
        dialog = builder.create();
    }

    public void connect(View view) {
        if (game.isConnected()) {
            showMessage("Already connected!");
            return;
        }
        EditText text = (EditText) findViewById(R.id.ip_address);
        String ip = text.getText().toString();
        dialog.show();
        ConnectTask connect = new ConnectTask();
        connect.delegate = this;
        connect.execute(ip);
    }

    public void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void connectFinish(Client client) {
        if (client != null) {
            game.setClient(client);
            showMessage("Connection established!");
        } else {
            showMessage("Connection failed...");
        }
        dialog.dismiss();
    }
}
