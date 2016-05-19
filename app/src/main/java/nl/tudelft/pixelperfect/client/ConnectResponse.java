package nl.tudelft.pixelperfect.client;

import com.jme3.network.Client;

/**
 * The interface for MainActivity.
 *
 * @author Jesse Tilro
 * @author Floris Doolaard
 */
public interface ConnectResponse {
    void connectFinish(Client client);
}
