package nl.tudelft.pixelperfect.pixelperfect.minigame;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import nl.tudelft.pixelperfect.client.GameClient;
import nl.tudelft.pixelperfect.client.message.EventCompletedMessage;
import nl.tudelft.pixelperfect.event.type.EventTypes;
import nl.tudelft.pixelperfect.pixelperfect.PixelPerfectActivity;
import nl.tudelft.pixelperfect.pixelperfect.R;
import nl.tudelft.pixelperfect.pixelperfect.location.LocationDeckActivity;

/**
 * Mini-game for the Janitor.
 *
 * @author Wouter Zirkzee
 *
 */
public class CoffeeBoostActivity extends PixelPerfectActivity {

    private final GameClient game = GameClient.getInstance();
    private Button[] buttons = new Button[9];
    private static final Integer[] original_order = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private GridLayout gridLayout;
    private ArrayList<Integer> current_order = new ArrayList<Integer>();
    private ArrayList<GridLayout.Spec> rows = new ArrayList<GridLayout.Spec>();
    private ArrayList<GridLayout.Spec> columns = new ArrayList<GridLayout.Spec>();


    /**
     * This method is for when this activity is started.
     *
     * @param savedInstanceState
     *                      A bundle.
     */
    @Override
    public void initialize(Bundle savedInstanceState) {
        setContentView(R.layout.activity_minigame_coffee_boost);
        initialize();
    }

    /**
     * Shuffle the game before starting.
     */
    private void shuffle() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int limit = 100;
        for (int i = 0; i < limit; i++) {
            makeMove(buttons[random.nextInt(7)+1]);
        }
        if (gameComplete()){
            shuffle();
        }
    }

    /**
     * Initialize some aspects of this game.
     */
    private void initialize() {
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        int[] buttonsIds = {R.id.button1, R.id.button2, R.id.button3,
                R.id.button4, R.id.button5, R.id.button6, R.id.button7,
                R.id.button8, R.id.button9};
        for (int i = 0; i < buttonsIds.length; i++) {
            buttons[i] = (Button) findViewById(buttonsIds[i]);
        }
        for(int i = 0; i < 9; i++) {
            current_order.add(i);
        }

        for (int i = 1; i < 9; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                                               public void onClick(View v) {
                                                   makeMove((Button) v);
                                               }
                                           }
            );
        }

        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);
        GridLayout.Spec row3 = GridLayout.spec(2);
        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);
        GridLayout.Spec col3 = GridLayout.spec(2);
        rows.add(row1); rows.add(row2); rows.add(row3);
        columns.add(col1); columns.add(col2); columns.add(col3);
        shuffle();
    }

    /**
     * Swap buttons if they are correctly positioned.
     *
     * @param clicked
     *              The clicked button.
     */
    private void makeMove(final Button clicked) {
        int number = Integer.parseInt((String) clicked.getText())-1;
        int position = current_order.indexOf(number);
        int empty_space_position = current_order.indexOf(0);

        if (sameRowOrColumn(empty_space_position, position) &&
                areNeighbours(empty_space_position, position)) {


            gridLayout.removeView(buttons[0]);
            gridLayout.removeView(buttons[number]);

            gridLayout.addView(buttons[0], new GridLayout.LayoutParams(rows.get((position/3)), columns.get((position%3))));
            gridLayout.addView(buttons[number], new GridLayout.LayoutParams(rows.get((empty_space_position/3)), columns.get((empty_space_position%3))));

            current_order.remove(position);
            current_order.add(position, 0);
            current_order.remove(empty_space_position);
            current_order.add(empty_space_position, number);
        }
    }

    /**
     * Check if the buttons are in the same row or column.
     *
     * @param loc1
     *              Location of the first button.
     * @param loc2
     *             Location of the second button.
     * @return True if they are in the same row or column.
     */
    private boolean sameRowOrColumn(int loc1, int loc2) {
        return ((loc1/3) == (loc2/3) || (loc1%3) == (loc2%3));
    }

    /**
     * Check if the tapped button is next to the empty space.
     *
     * @param loc1
     *              Location of the first button.
     * @param loc2
     *             Location of the second button.
     * @return True if the distance is 1 in any direction.
     */
    private boolean areNeighbours(int loc1, int loc2) {
        return ((Math.abs((loc1/3) - (loc2/3)) == 1)
        || Math.abs((loc1%3) - (loc2%3))  == 1);
    }

    /**
     * Check if the game is completed.
     *
     * @return True if completed, otherwise false.
     */
    private boolean gameComplete() {
        for(int i = 0; i < 9; i++) {
            if (!current_order.get(i).equals(original_order[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the game is complete and send a message.
     *
     * @param view
     *          A view.
     */
    @SuppressWarnings("UnusedParameters")
    public void confirmCoffeeEvent(View view) {
        if (gameComplete()) {
            game.sendMessage(new EventCompletedMessage(EventTypes.COFFEE_BOOST.ordinal()));
            Intent intent = new Intent(this, LocationDeckActivity.class);
            startActivity(intent);
        }
    }
}

