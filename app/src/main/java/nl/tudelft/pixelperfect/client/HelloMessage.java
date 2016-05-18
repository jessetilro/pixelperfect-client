package nl.tudelft.pixelperfect.client;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 * @author Jesse Tilro
 */
@Serializable
class HelloMessage extends AbstractMessage {

    private String hello;

    public HelloMessage() {

    }

    public HelloMessage(String s) {
        hello = s;
    }

    public String getSomething() {
        return hello;
    }
}
