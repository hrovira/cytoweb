package org.systemsbiology.cytoweb.network.simple;

import org.systemsbiology.cytoweb.network.Node;
import org.systemsbiology.cytoweb.network.CoordinatePosition;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:40:56 PM
 */
public class SimpleNode implements Node {
    private final Object identifier;
    private final String label;
    private CoordinatePosition position;

    public SimpleNode(Object identifier, String label, CoordinatePosition position) {
        this.identifier = identifier;
        this.label = label;
        this.position = position;
    }

    /*
     Method Implementations: Node
    */
    public Object getIdentifier() {
        return identifier;
    }

    public String getLabel() {
        return label;
    }

    public CoordinatePosition getPosition() {
        return position;
    }

    public void setPosition(CoordinatePosition position) {
        this.position = position;
    }
}
