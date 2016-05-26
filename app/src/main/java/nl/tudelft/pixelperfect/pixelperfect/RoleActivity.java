package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Intent;
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

    /**
     * Will update the buttons' alpha (opacity) and will set the button be un-enabled.
     *
     * @param role the buttonRole to adjust.
     */
    public static void updateButtons(Roles role) {
        switch (role) {
            case GUNNER:
                gunnerView.setAlpha(0.5f);
                gunnerView.setEnabled(false);
                break;
            case ENGINEER:
                engineerView.setAlpha(0.5f);
                engineerView.setEnabled(false);
                break;
            case SCIENTIST:
                scientistView.setAlpha(0.5f);
                scientistView.setEnabled(false);
                break;
        }

    }

    /**
     * The method for clicking the Gunner button. The player will be transitioned to the Armory.
     *
     * @param view the view of the Button.
     */
    public void gunnerChosen(View view) {
        view.setAlpha(0.5f);
        engineerView.setEnabled(false);
        scientistView.setEnabled(false);

        Intent intent = new Intent(this, LocationArmoryActivity.class);
        startActivity(intent);
    }

    /**
     * The method for clicking the Engineer button. The player will be transitioned to the Engine room.
     *
     * @param view the view of the Button.
     */
    public void engineerChosen(View view) {
        view.setAlpha(0.5f);
        gunnerView.setEnabled(false);
        scientistView.setEnabled(false);


        Intent intent = new Intent(this, LocationEngineroomActivity.class);
        startActivity(intent);
    }

    /**
     * The method for clicking the Scientist button. The player will be transitioned to the Lab.
     *
     * @param view the view of the Button.
     */
    public void scientistChosen(View view) {
        view.setAlpha(0.5f);
        gunnerView.setEnabled(false);
        engineerView.setEnabled(false);


        Intent intent = new Intent(this, LocationLabActivity.class);
        startActivity(intent);
    }
}
