package nl.tudelft.pixelperfect.pixelperfect.mini_game;



import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import nl.tudelft.pixelperfect.pixelperfect.R;


@SuppressWarnings("deprecation")
public class CoffeeBoostActivity extends Activity {

    private Button[] buttons = new Button[9];
    private Boolean movable;
    private static final Integer[] original_order = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private ArrayList<Integer> current_order = new ArrayList<Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_boost);

        initialize();
        draw();
    }

    private void initialize() {
        buttons[0] = (Button) findViewById(R.id.Button0);
        buttons[1] = (Button) findViewById(R.id.Button1);
        buttons[2] = (Button) findViewById(R.id.Button2);
        buttons[3] = (Button) findViewById(R.id.Button3);
        buttons[4] = (Button) findViewById(R.id.Button4);
        buttons[5] = (Button) findViewById(R.id.Button5);
        buttons[6] = (Button) findViewById(R.id.Button6);
        buttons[7] = (Button) findViewById(R.id.Button7);
        buttons[8] = (Button) findViewById(R.id.Button8);

        for(int i = 0; i < 9; i++) {
            current_order.add(i);
        }
        Collections.shuffle(this.current_order);

        for (int i = 1; i < 9; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {
                                              public void onClick(View v) {
                                                  makeMove((Button) v);
                                              }
                                          }
            );
        }
    }

    private void makeMove(final Button clicked) {
        movable = false;
        int number = Integer.parseInt((String) clicked.getText());
        int position = current_order.indexOf(number);
        int empty_space_position = current_order.indexOf(0);
        switch(empty_space_position) {
            case(0):
                if (position == 1 || position == 3)
                    movable = true;
                break;
            case(1):
                if (position == 0 || position == 2 || position == 4)
                    movable = true;
                break;
            case(2):
                if (position == 1 || position == 5)
                    movable = true;
                break;
            case(3):
                if (position == 0 || position == 4 || position == 6)
                    movable = true;
                break;
            case(4):
                if (position == 1 || position == 3 || position == 5 || position == 7)
                    movable = true;
                break;
            case(5):
                if (position == 2 || position == 4 || position == 8)
                    movable = true;
                break;
            case(6):
                if (position == 3 || position == 7)
                    movable = true;
                break;
            case(7):
                if (position == 4 || position == 6 || position == 8)
                    movable = true;
                break;
            case(8):
                if (position == 5 || position == 7)
                    movable = true;
                break;
        }

        if (movable) {
            current_order.remove(position);
            current_order.add(position, 0);
            current_order.remove(empty_space_position);
            current_order.add(empty_space_position, number);

            draw();
        }
    }

    public boolean gameComplete() {
        for(int i = 0; i < 9; i++) {
            if (!current_order.get(i).equals(original_order[i])) {
                return false;
            }
        }
        return true;
    }


    private void draw() {
        for (int i = 0; i < 9; i++) {
            int original_location = current_order.get(i);
            AbsoluteLayout.LayoutParams layout =
                    (AbsoluteLayout.LayoutParams) buttons[original_location].getLayoutParams();
            switch(i) {
                case(0):
                    layout.x = 0;
                    layout.y = 0;
                    break;
                case(1):
                    layout.x = 200;
                    layout.y = 0;
                    break;
                case(2):
                    layout.x = 400;
                    layout.y = 0;
                    break;
                case(3):
                    layout.x = 0;
                    layout.y = 200;
                    break;
                case(4):
                    layout.x = 200;
                    layout.y = 200;
                    break;
                case(5):
                    layout.x = 400;
                    layout.y = 200;
                    break;
                case(6):
                    layout.x = 0;
                    layout.y = 400;
                    break;
                case(7):
                    layout.x = 200;
                    layout.y = 400;
                    break;
                case(8):
                    layout.x = 400;
                    layout.y = 400;
                    break;

            }
            buttons[original_location].setLayoutParams(layout);
        }
    }

    public void confirmCoffeeEvent(View view) {
        if (gameComplete()) {
            //TODO networking
            System.out.println("GEWONNNEN");
        }
    }
}

