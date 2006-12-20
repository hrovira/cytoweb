package org.systemsbiology.cytoweb.network;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:21:32 PM
 */
public interface Provider {
    public Network getNetwork();

    public void setNetworkFile(String networkFile);
}
