package org.systemsbiology.cytoweb.network.providers;

import org.systemsbiology.cytoweb.network.Network;
import org.systemsbiology.cytoweb.network.Node;
import org.systemsbiology.cytoweb.network.Provider;
import org.systemsbiology.cytoweb.network.simple.SimpleCoordinatePosition;
import org.systemsbiology.cytoweb.network.simple.SimpleLink;
import org.systemsbiology.cytoweb.network.simple.SimpleNetwork;
import org.systemsbiology.cytoweb.network.simple.SimpleNode;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:55:02 PM
 */
public class SimpleNetworkProvider implements Provider {
    /*
      Method Implementations: Provider
     */
    public Network getNetwork() {
        Network network = new SimpleNetwork("simple network", "this is a test of the proof of concept");

        Node nodeA = new SimpleNode("A", "nodeA", new SimpleCoordinatePosition(50, 33));
        network.addNode(nodeA);

        Node nodeB = new SimpleNode("B", "nodeB", new SimpleCoordinatePosition(100, 100));
        network.addNode(nodeB);

        Node nodeC = new SimpleNode("C", "nodeC", new SimpleCoordinatePosition(150, 211));
        network.addNode(nodeC);

        Node nodeD = new SimpleNode("D", "nodeD", new SimpleCoordinatePosition(132, 66));
        network.addNode(nodeD);

        addLink(network, nodeA, nodeB);
        addLink(network, nodeB, nodeC);
        addLink(network, nodeC, nodeD);
        addLink(network, nodeB, nodeD);

        return network;
    }

    public void setNetworkFile(String networkFile) {
        // do nothing ;
    }

    /*
      Protected Methods
     */
    protected void addLink(Network network, Node startNode, Node endNode) {
        String linkName = "link_" + startNode.getIdentifier() + "-" + endNode.getIdentifier();
        network.getLinks().add(new SimpleLink(linkName, startNode, endNode));
    }
}
