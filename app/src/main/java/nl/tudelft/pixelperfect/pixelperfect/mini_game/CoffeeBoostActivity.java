package nl.tudelft.pixelperfect.pixelperfect.mini_game;



import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import nl.tudelft.pixelperfect.pixelperfect.R;

public class CoffeeBoostActivity extends Activity {

    private Button[] buttons = new Button[9];
    private static final Integer[] original_order = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private ArrayList<Integer> current_order = new ArrayList<Integer>();

    private GridLayout gridLayout;

    ArrayList<GridLayout.Spec> rows = new ArrayList<GridLayout.Spec>();
    ArrayList<GridLayout.Spec> columns = new ArrayList<GridLayout.Spec>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_boost);
        initialize();
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);
        GridLayout.Spec row3 = GridLayout.spec(2);
        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);
        GridLayout.Spec col3 = GridLayout.spec(2);
        rows.add(row1); rows.add(row2); rows.add(row3);
        columns.add(col1); columns.add(col2); columns.add(col3);
    }

    private void shuffle() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int limit = random.nextInt(10);
        for (int i = 0; i < limit; i++) {
            makeMove(buttons[random.nextInt(2)+1]);
        }
    }

    private void initialize() {
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);

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

//        shuffle();
    }

    private void makeMove(final Button clicked) {
        int number = Integer.parseInt((String) clicked.getText())-1;
        int position = current_order.indexOf(number);
        System.out.println("CLICKED: "+ number +"  AT POSITION:  " + position);
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

    private boolean sameRowOrColumn(int loc1, int loc2) {
        if ((loc1/3) == (loc2/3) || (loc1%3) == (loc2%3)) {
            return true;
        }
        return false;
    }
    private boolean areNeighbours(int loc1, int loc2) {
        if ( (Math.abs((loc1/3) - (loc2/3)) == 1)
                || Math.abs((loc1%3) - (loc2%3))  == 1 ) {
            return true;
        }
        return false;
    }

    public boolean gameComplete() {
        for(int i = 0; i < 9; i++) {
            if (!current_order.get(i).equals(original_order[i])) {
                return false;
            }
        }
        return true;
    }


    public void confirmCoffeeEvent(View view) {
        if (gameComplete()) {
            //TODO networking
            System.out.println("GEWONNNEN");
        }
    }
}

