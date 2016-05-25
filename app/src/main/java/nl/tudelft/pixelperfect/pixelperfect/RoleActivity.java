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
    private static View gunnerView;
    private static View engineerView;
    private static View scientistView;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        gunnerView = findViewById(R.id.button_role_gunner);
        engineerView = findViewById(R.id.button_role_engineer);
        scientistView = findViewById(R.id.button_role_scientist);
    }

    public static void updateButtons(int role) {
        switch (role) {
            case 0:
                gunnerView.setAlpha(0.5f);
                gunnerView.setEnabled(false);
                break;
            case 1:
                engineerView.setAlpha(0.5f);
                engineerView.setEnabled(false);
                break;
            case 2:
                scientistView.setAlpha(0.5f);
                scientistView.setEnabled(false);
                break;
        }

    }

    public void gunnerChosen(View view) {
        view.setAlpha(0.5f);

        Intent intent = new Intent(this, LocationArmoryActivity.class);
        startActivity(intent);
    }

    public void engineerChosen(View view) {
        view.setAlpha(0.5f);

        Intent intent = new Intent(this, LocationEngineroomActivity.class);
        startActivity(intent);
    }

    public void scientistChosen(View view) {
        view.setAlpha(0.5f);

        Intent intent = new Intent(this, LocationLabActivity.class);
        startActivity(intent);
    }
}
