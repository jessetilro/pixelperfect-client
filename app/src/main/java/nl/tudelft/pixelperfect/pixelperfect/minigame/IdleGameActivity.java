package nl.tudelft.pixelperfect.pixelperfect.minigame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.RepairMessage;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;

/**
 * The activity the players can do to repair the ship.
 *
 */
public class IdleGameActivity extends AppCompatActivity {

    private GameClient game = GameClient.getInstance();
    private Random rng;
    private String code;
    private String template;

    /**
     * What the class should do if the activity is created.
     *
     * @param savedInstanceState , A bundle.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigame_idle);
        template = "abcdefghijklmnopqrstuvwxyz";
        rng = new Random();
        code = generateString();
        TextView view  = (TextView) findViewById(R.id.Code);
        view.setText(code);
    }

    /**
     * Creates a random 5 letter string as a passcode.
     *
     * @return , The generated passcode.
     */
    public String generateString()
    {
        char[] code = new char[5];
        for (int i = 0; i < 5; i++)
        {
            code[i] = template.charAt(rng.nextInt(template.length()));
        }
        return new String(code);
    }

    /**
     * What it should when the repairs are submitted.
     *
     * @param view , The view of the page
     */
    public void completeRepair(View view) {
        EditText prompt = (EditText) findViewById(R.id.passcode);
        String pass = prompt.getText().toString();
        System.out.println(pass);
        System.out.println(code);
        if(pass.equals(code)) {
            RepairMessage message = new RepairMessage();
            game.sendMessage(message);
        }

        back(view);
    }

    /**
     * Returns the player to the event screen.
     *
     * @param view , The view of the page.
     */
    public void back(View view) {
        finish();
    }
}
