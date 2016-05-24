package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * This Activity involves the allocation of roles. Each player is able to choose a unique
 * role in this activity.
 *
 * @author Floris Doolaard
 */
public class RoleActivity extends AppCompatActivity {

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
    }

    /**
     * Starts the GameActivity.
     */
    private void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void gunnerChosen(View view) {
        view.setAlpha(0.5f);
        startGame();
    }

    public void engineerChosen(View view) {
        view.setAlpha(0.5f);
        startGame();
    }

    public void scientistChosen(View view) {
        view.setAlpha(0.5f);
        startGame();
    }
}
