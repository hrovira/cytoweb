package org.systemsbiology.cytoweb.network.simple;

import org.systemsbiology.cytoweb.network.CoordinatePosition;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 2:41:09 PM
 */
public class SimpleCoordinatePosition implements CoordinatePosition {
    private Number x;
    private Number y;

    public SimpleCoordinatePosition(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    /*
     Method Implementations: CoordinatePosition
    */
    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }


    public void setX(Number x) {
        this.x = x;
    }

    public void setY(Number y) {
        this.y = y;
    }
}
