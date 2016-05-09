package nl.tudelft.pixelperfect.client;

import com.jme3.system.JmeContext;

/**
 * Created by jesse on 9-5-2016.
 */
public class GameClient extends com.jme3.app.SimpleApplication {

    public static void main(String[] args) {
        GameClient app = new GameClient();
        app.start(JmeContext.Type.Display);
    }

    @Override
    public void simpleInitApp() {

    }

}
