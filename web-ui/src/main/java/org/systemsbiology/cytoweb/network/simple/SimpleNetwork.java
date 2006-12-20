package org.systemsbiology.cytoweb.network.simple;

import org.systemsbiology.cytoweb.network.Link;
import org.systemsbiology.cytoweb.network.Network;
import org.systemsbiology.cytoweb.network.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:40:50 PM
 */
public class SimpleNetwork implements Network {
    private final String label;
    private final String description;
    private Collection<Node> nodes = new ArrayList<Node>();
    private HashMap<Object, Node> nodesByIdentifier = new HashMap<Object, Node>();
    private Collection<Link> links = new ArrayList<Link>();

    public SimpleNetwork(String label, String description) {
        this.label = label;
        this.description = description;
    }

    /*
      Method Implementations: Network
     */
    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public Node getNode(Object identifier) {
        return nodesByIdentifier.get(identifier);
    }

    public void addNode(Node node) {
        this.nodes.add(node);
        nodesByIdentifier.put(node.getIdentifier(), node);
    }


    public Number getLowestX() {
        double lowestX = 0;
        for (Node node : getNodes()) {
            double x = node.getPosition().getX().doubleValue();
            if (x < lowestX) {
                lowestX = x;
            }
        }
        return lowestX;
    }

    public Number getLowestY() {
        double lowestY = 0;
        for (Node node : getNodes()) {
            double y = node.getPosition().getY().doubleValue();
            if (y < lowestY) {
                lowestY = y;
            }
        }
        return lowestY;
    }
}
