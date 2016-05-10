package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jme3.network.Client;
import com.jme3.system.JmeContext;

import nl.tudelft.pixelperfect.client.GameActivity;
import nl.tudelft.pixelperfect.client.GameClient;

public class MainActivity extends AppCompatActivity implements GameActivity {

    private GameClient game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = GameClient.getInstance();
    }

    public void connect(View view) {
        EditText text = (EditText) findViewById(R.id.ip_address);
        String ip = text.getText().toString();
        System.out.println("Connecting to: " + ip);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Trying to establish a connection with the game server at '" + ip + "'.")
                .setTitle("Connecting");
        AlertDialog dialog = builder.create();
        dialog.show();
        game.connectToServer(ip);
    }

    public void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
