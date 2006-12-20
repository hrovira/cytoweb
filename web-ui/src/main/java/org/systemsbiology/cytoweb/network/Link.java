package org.systemsbiology.cytoweb.network;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:22:18 PM
 */
public interface Link {
    public String getLabel();
    
    public Node getStartNode();

    public Node getEndNode();
}
