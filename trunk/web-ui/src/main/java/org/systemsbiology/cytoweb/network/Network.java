package org.systemsbiology.cytoweb.network;

import java.util.Collection;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:21:10 PM
 */
public interface Network {
    public String getLabel();

    public String getDescription();
    
    public Collection<Node> getNodes();

    public Collection<Link> getLinks();

    public Node getNode(Object identifier);

    public void addNode(Node node);

    public Number getLowestX();

    public Number getLowestY();
}
