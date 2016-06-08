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
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.message.RepairMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;

/**
 * Created by Dmitry on 07/06/2016.
 */
public class IdleGameActivity extends AppCompatActivity {

    private GameClient game = GameClient.getInstance();
    private Random rng;
    private String code;
    private String template;

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

    public String generateString()
    {
        char[] code = new char[6];
        for (int i = 0; i < 5; i++)
        {
            code[i] = template.charAt(rng.nextInt(template.length()));
        }
        return new String(code);
    }

    private void showMessage(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void completeRepair(View view) {
        EditText prompt = (EditText) findViewById(R.id.passcode);
        String pass = prompt.getText().toString();
        //if(pass.equals(code)) {
            //showMessage("Correct");
            RepairMessage message = new RepairMessage(10);
            game.sendMessage(message);
        //}

        back(view);
    }

    public void back(View view) {
        Intent intent = new Intent(this, LocationLabActivity.class);
        startActivity(intent);
    }
}
