package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.RoleChosenMessage;


/**
 * This Activity involves the allocation of roles. Each player is able to choose a unique
 * role in this activity.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public class RoleActivity extends AppCompatActivity {
    private static View gunnerView;
    private static View engineerView;
    private static View scientistView;
    private GameClient game = GameClient.getInstance();

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
     * Gets the View of the Gunner button.
     *
     * @return a View of the button.
     */
    public static View getGunnerView() {
        return gunnerView;
    }

    /**
     * Gets the View of the Engineer button.
     *
     * @return a View of the button.
     */
    public static View getEngineerView() {
        return engineerView;
    }

    /**
     * Gets the View of the Gunner button.
     *
     * @return a View of the button.
     */
    public static View getScientistView() {
        return scientistView;
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

        RoleChosenMessage role = new RoleChosenMessage("gunner", Roles.GUNNER);
        game.sendMessage(role);
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

        RoleChosenMessage role = new RoleChosenMessage("engineer", Roles.ENGINEER);
        game.sendMessage(role);
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

        RoleChosenMessage role = new RoleChosenMessage("scientist", Roles.SCIENTIST);
        game.sendMessage(role);
        Intent intent = new Intent(this, LocationLabActivity.class);
        startActivity(intent);
    }
}
