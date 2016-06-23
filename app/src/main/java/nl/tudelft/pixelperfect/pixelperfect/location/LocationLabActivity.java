package nl.tudelft.pixelperfect.pixelperfect.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.RoleActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.FireOutbreakActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.IdleGameActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.PlasmaLeakActivity;

/**
 * This class represents the location of the Lab occupied by the Scientist.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings({"CanBeFinal", "unused", "UnusedParameters"})
public class LocationLabActivity extends PixelPerfectActivity {
    private GameClient game = GameClient.getInstance();

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void initialize(Bundle savedInstanceState) {
        setContentView(R.layout.activity_location_lab);
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
     * When you press the back button the mobile device, you will go to the RoleActivity in which
     * you still have the same role.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LocationLabActivity.this, RoleActivity.class);
        finish();
        startActivity(intent);
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeFireEvent(View view) {
       Intent intent = new Intent(this, FireOutbreakActivity.class);
        startActivity(intent);
    }

    /**
     * Whenever the button to complete the Plasma Leak Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completePlasmaLeakEvent(View view) {
        Intent intent = new Intent(this, PlasmaLeakActivity.class);
        startActivity(intent);
    }

    /**
     * Whenever the button to execute repairs is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    public void completeRepairs(View view) {
        Intent intent = new Intent(this, IdleGameActivity.class);
        startActivity(intent);
    }
}
