package nl.tudelft.pixelperfect.pixelperfect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button button = (Button) findViewById(R.id.button_complete_event);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
