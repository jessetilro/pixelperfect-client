package nl.tudelft.pixelperfect.client.message;

import com.jme3.network.AbstractMessage;
import com.jme3.network.serializing.Serializable;

/**
 * Created by Dmitry on 08/06/2016.
 */
@Serializable
public class RepairMessage extends AbstractMessage {

    private int amount;

    public RepairMessage() {
        amount = 1;
    }

    public RepairMessage(int repair) {
        amount = repair;
    }

    public int getAmount() {
        return amount;
    }
}
