package nl.tudelft.pixelperfect.pixelperfect.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.RoleActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.CoffeeBoostActivity;
import nl.tudelft.pixelperfect.pixelperfect.minigame.FireOutbreakActivity;

/**
 * The location of the Janitor where he can make some coffee.
 *
 * @author Floris Doolaard
 */
@SuppressWarnings("CanBeFinal")
public class LocationDeckActivity extends AppCompatActivity {
    private GameClient game = GameClient.getInstance();

    /**
     * This method shows what happens when this Activity is created.
     *
     * @param savedInstanceState , a Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_deck);
    }

    /**
     * When you press the back button the mobile device, you will go to the RoleActivity in which
     * you still have the same role.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LocationDeckActivity.this, RoleActivity.class);
        intent.putExtra("Game Started", true);
        finish();
        startActivity(intent);
    }

    /**
     * Whenever the button to complete the Fire Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    @SuppressWarnings("UnusedParameters")
    public void completeFireEvent(View view){
        Intent intent = new Intent(this, FireOutbreakActivity.class);
        startActivity(intent);
    }

    /**
     * Whenever the button to complete the Plasma Leak Event is pressed this will happen.
     *
     * @param view , the view of the page.
     */
    @SuppressWarnings("UnusedParameters")
    public void completeCoffeeEvent(View view) {
        Intent intent = new Intent(this, CoffeeBoostActivity.class);
        startActivity(intent);
    }
}
