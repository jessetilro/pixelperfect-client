package nl.tudelft.pixelperfect.pixelperfect;

import android.content.pm.ActivityInfo;

/**
 * Created by Jesse Tilro on 9-5-2016.
 */
public class JMEActivity extends com.jme3.app.AndroidHarness{

    public JMEActivity() {
        // Set the application class to run
        appClass = "nl.tudelft.pixelperfect.client.GameClient";

        // Exit Dialog title & message
        exitDialogTitle = "Quit game?";
        exitDialogMessage = "Do you really want to quit the game?";

        // Invert the MouseEvents X (default = true)
        mouseEventsInvertX = true;

        // Invert the MouseEvents Y (default = true)
        mouseEventsInvertY = true;
    }

}
