package nl.tudelft.pixelperfect.pixelperfect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.RoleChosenMessage;
import nl.tudelft.pixelperfect.game.Roles;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationArmoryActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationDeckActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationEngineroomActivity;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationLabActivity;


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
    private static View janitorView;
    private boolean gameStarted;
    private GameClient game;
    private Roles chosenRole;

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null) {
            setContentView(R.layout.activity_role);

            gunnerView = findViewById(R.id.button_role_gunner);
            engineerView = findViewById(R.id.button_role_engineer);
            scientistView = findViewById(R.id.button_role_scientist);
            janitorView = findViewById(R.id.button_role_janitor);
            gameStarted = false;
        }
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            gameStarted = getIntent().getExtras().getBoolean("Game Started");
        }
        game = GameClient.getInstance();
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
        Intent intent = new Intent(RoleActivity.this, MainActivity.class);
        intent.putExtra("Game Started", gameStarted);
        startActivity(intent);
        finish();
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
    public static void updateRoleAvailability(RoleChosenMessage message) {
        switch(message.getRole()){
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
     * Whenever a role gets chosen, the other roles should be disabled.
     *
     * @param view the view of the button that was pressed.
     */
    public void disableOther(View view) {
        if(view != gunnerView){
            gunnerView.setEnabled(false);
        }
        if(view != engineerView){
            engineerView.setEnabled(false);
        }
        if(view != scientistView){
            scientistView.setEnabled(false);
        }
        if(view != janitorView){
            janitorView.setEnabled(false);
        }
    }

    /**
     * The method for clicking the Gunner button. The player will be transitioned to the Armory.
     *
     * @param view the view of the Button.
     */
    public void gunnerChosen(View view) {
        disableOther(view);

        if(chosenRole == null) {
            RoleChosenMessage role = new RoleChosenMessage("gunner", Roles.GUNNER);
            game.sendMessage(role);
        }

        chosenRole = Roles.GUNNER;
        if(gameStarted){
            Intent intent = new Intent(this, LocationArmoryActivity.class);
            startActivity(intent);
        } else {
            enterLobby();
        }
    }

    /**
     * The method for clicking the Engineer button. The player will be transitioned to the Engine room.
     *
     * @param view the view of the Button.
     */
    public void engineerChosen(View view) {
        disableOther(view);

        if(chosenRole == null) {
            RoleChosenMessage role = new RoleChosenMessage("engineer", Roles.ENGINEER);
            game.sendMessage(role);
        }
        chosenRole = Roles.ENGINEER;

        if(gameStarted){
            Intent intent = new Intent(this, LocationEngineroomActivity.class);
            startActivity(intent);
        } else {
            enterLobby();
        }
    }

    /**
     * The method for clicking the Scientist button. The player will be transitioned to the Lab.
     *
     * @param view the view of the Button.
     */
    public void scientistChosen(View view) {
        disableOther(view);

        if(chosenRole == null) {
            RoleChosenMessage role = new RoleChosenMessage("scientist", Roles.SCIENTIST);
            game.sendMessage(role);
        }
        chosenRole = Roles.SCIENTIST;

        if(gameStarted){
            Intent intent = new Intent(this, LocationLabActivity.class);
            startActivity(intent);
        } else {
            enterLobby();
        }
    }

    /**
     * The method for clicking the Janitor button. The player will be transitioned to the Lab.
     *
     * @param view the view of the Button.
     */
    public void janitorChosen(View view) {
        disableOther(view);

        if(chosenRole == null) {
            RoleChosenMessage role = new RoleChosenMessage("janitor", Roles.JANITOR);
            game.sendMessage(role);
        }
        chosenRole = Roles.JANITOR;

        if(gameStarted){
            Intent intent = new Intent(this, LocationDeckActivity.class);
            startActivity(intent);
        } else {
            enterLobby();
        }
    }

    public void enterLobby(){
        Intent lobby = new Intent(this, LobbyActivity.class);
        lobby.putExtra("Role", chosenRole);
        startActivity(lobby);
    }
}
