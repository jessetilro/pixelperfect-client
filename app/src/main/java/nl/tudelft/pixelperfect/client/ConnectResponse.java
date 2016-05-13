package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;

/**
 * Created by jesse on 10-5-2016.
 */
public interface ConnectResponse {
    void connectFinish(Client client);
}
