package org.systemsbiology.cytoweb.network.simple;

import org.systemsbiology.cytoweb.network.Link;
import org.systemsbiology.cytoweb.network.Node;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:41:01 PM
 */
public class SimpleLink implements Link {
    private final String label;
    private final Node startNode;
    private final Node endNode;

    public SimpleLink(String label, Node startNode, Node endNode) {
        this.label = label;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    /*
     Method Implementations: Link
    */
    public String getLabel() {
        return label;
    }

    public Node getStartNode() {
        return startNode;
    }

    public Node getEndNode() {
        return endNode;
    }
}
