package nl.tudelft.pixelperfect.pixelperfect.mini_game;



import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.GridLayout;

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
//
//        movable = false;
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

    private void makeMove(final Button b) {
        movable = true;
        int number, position, emptyspace_position;
        number = Integer.parseInt((String) b.getText());
        position = current_order.indexOf(number);
        emptyspace_position = current_order.indexOf(0);
        switch(emptyspace_position) {
            case(0):
                if (position == 1 || position == 3)
                    movable = false;
                break;
            case(1):
                if (position == 0 || position == 2 || position == 4)
                    movable = false;
                break;
            case(2):
                if (position == 1 || position == 5)
                    movable = false;
                break;
            case(3):
                if (position == 0 || position == 4 || position == 6)
                    movable = false;
                break;
            case(4):
                if (position == 1 || position == 3 || position == 5 || position == 7)
                    movable = false;
                break;
            case(5):
                if (position == 2 || position == 4 || position == 8)
                    movable = false;
                break;
            case(6):
                if (position == 3 || position == 7)
                    movable = false;
                break;
            case(7):
                if (position == 4 || position == 6 || position == 8)
                    movable = false;
                break;
            case(8):
                if (position == 5 || position == 7)
                    movable = false;
                break;
        }

        if (movable) {
            return;
        }

        current_order.remove(position);
        current_order.add(position, 0);
        current_order.remove(emptyspace_position);
        current_order.add(emptyspace_position,number);

        draw();
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
//            GridLayout.LayoutParams grid = (GridLayout.LayoutParams) buttons[original_location].getLayoutParams();
//            grid.rowSpec.toString();
            switch(i) {
                case(0):
                    layout.x = 5;
                    layout.y = 5;
                    break;
                case(1):
                    layout.x = 110;
                    layout.y = 5;
                    break;
                case(2):
                    layout.x = 215;
                    layout.y = 5;
                    break;
                case(3):
                    layout.x = 5;
                    layout.y = 110;
                    break;
                case(4):
                    layout.x =110;
                    layout.y =110;
                    break;
                case(5):
                    layout.x = 215;
                    layout.y =110;
                    break;
                case(6):
                    layout.x = 5;
                    layout.y = 215;
                    break;
                case(7):
                    layout.x = 110;
                    layout.y = 215;
                    break;
                case(8):
                    layout.x = 215;
                    layout.y = 215;
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

