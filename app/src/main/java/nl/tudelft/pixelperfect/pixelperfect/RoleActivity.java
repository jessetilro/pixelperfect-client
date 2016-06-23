package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.RoleAllocationMessage;
import nl.tudelft.pixelperfect.player.PlayerRoles;


/**
 * This Activity involves the allocation of roles. Each player is able to choose a unique
 * role in this activity.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("unused")
public class RoleActivity extends PixelPerfectActivity {
    private static View gunnerView;
    private static View engineerView;
    private static View scientistView;
    private static View janitorView;
    private GameClient game;
    private static Context mContext;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_role);

            gunnerView = findViewById(R.id.button_role_gunner);
            engineerView = findViewById(R.id.button_role_engineer);
            scientistView = findViewById(R.id.button_role_scientist);
            janitorView = findViewById(R.id.button_role_janitor);
        }
        game = GameClient.getInstance();
        mContext = this;

        checkForConnection();

        game.assignRole(null);
        game.stop();

        // The hardcoded role is arbitrary. Because of the "true" parameter,
        // the server will simply clear the role for this user.
        game.sendMessage(new RoleAllocationMessage(PlayerRoles.ENGINEER, true));
    }

    /**
     * When the home button is pressed in the actionbar, the user will go to the MainActivity.
     * This has the same function as the back button on the device
     * itself.
     *
     * @param item the item in the action bar.
     * @return states whether a function was executed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }

    /**
     * When you press the back button the mobile device, you will go to the mainActivity.
     */
    @Override
    public void onBackPressed() {
        reset();
    }

    /**
     * Whenever this Activity is restored this method will decide how to restore it.
     *
     * @param savedInstanceState the instance to restore.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Whenever the Activity gets destroyed, this method will be called and the activity will be
     * saved.
     *
     * @param savedInstanceState the state that will be saved.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Updates the view of the roles in the RoleActivity so that no more than 1 player may choose
     * the same role.
     *
     * @param message the message received.
     */
    public static void updateRoleAvailability(RoleAllocationMessage message) {
        switch (message.getRole()) {
            case GUNNER:
                gunnerView.setEnabled(false);
                break;
            case ENGINEER:
                engineerView.setEnabled(false);
                break;
            case JANITOR:
                janitorView.setEnabled(false);
                break;
            case SCIENTIST:
                scientistView.setEnabled(false);
                break;
            default:
                break;
        }
    }

    /**
     * The method for clicking the Gunner button. The player will be transitioned to the Armory.
     *
     * @param view the view of the Button.
     */
    public void gunnerChosen(View view) {
        RoleAllocationMessage role = new RoleAllocationMessage(PlayerRoles.GUNNER, false);
        game.sendMessage(role);
    }

    /**
     * The method for clicking the Engineer button. The player will be transitioned to the Engine room.
     *
     * @param view the view of the Button.
     */
    public void engineerChosen(View view) {
        RoleAllocationMessage role = new RoleAllocationMessage(PlayerRoles.ENGINEER, false);
        game.sendMessage(role);
    }

    /**
     * The method for clicking the Scientist button. The player will be transitioned to the Lab.
     *
     * @param view the view of the Button.
     */
    public void scientistChosen(View view) {
        RoleAllocationMessage role = new RoleAllocationMessage(PlayerRoles.SCIENTIST, false);
        game.sendMessage(role);
    }

    /**
     * The method for clicking the Janitor button. The player will be transitioned to the Lab.
     *
     * @param view the view of the Button.
     */
    public void janitorChosen(View view) {
        RoleAllocationMessage role = new RoleAllocationMessage(PlayerRoles.JANITOR, false);
        game.sendMessage(role);
    }

    public static void showMessage(String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(mContext, message, duration);
        toast.show();
    }

}
