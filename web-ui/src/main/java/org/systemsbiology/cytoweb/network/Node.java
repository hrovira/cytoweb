package org.systemsbiology.cytoweb.network;


/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:21:21 PM
 */
public interface Node {
    public CoordinatePosition getPosition();

    public Object getIdentifier();

    public String getLabel();

    public void setPosition(CoordinatePosition coordinatePosition);
}
