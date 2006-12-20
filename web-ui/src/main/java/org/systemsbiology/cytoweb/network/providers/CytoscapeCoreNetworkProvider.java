package org.systemsbiology.cytoweb.network.providers;

import cytoscape.CyEdge;
import cytoscape.CyNetwork;
import cytoscape.CyNode;
import cytoscape.Cytoscape;
import cytoscape.view.CyNetworkView;
import giny.view.NodeView;
import giny.view.EdgeView;
import giny.model.Edge;
import giny.util.SpringEmbeddedLayouter;
import org.systemsbiology.cytoweb.network.Network;
import org.systemsbiology.cytoweb.network.Node;
import org.systemsbiology.cytoweb.network.Provider;
import org.systemsbiology.cytoweb.network.simple.SimpleCoordinatePosition;
import org.systemsbiology.cytoweb.network.simple.SimpleNetwork;
import org.systemsbiology.cytoweb.network.simple.SimpleNode;

import java.util.Iterator;

/**
 * @author trollswagen
 *         Date: Dec 10, 2006
 *         Time: 3:47:26 PM
 */
public class CytoscapeCoreNetworkProvider extends SimpleNetworkProvider implements Provider {
    private String networkFile;

    /*
      Dependency Injection
     */
    public String getNetworkFile() {
        return networkFile;
    }

    public void setNetworkFile(String networkFile) {
        this.networkFile = networkFile;
    }

    /*
     Method Implementations: Provider
    */
    public Network getNetwork() {
        Network network = new SimpleNetwork("cytoscape network", "simple network from file: " + getNetworkFile());
        appendNodes(network);
        return network;
    }

    public void finito() {
        Cytoscape.firePropertyChange(Cytoscape.CYTOSCAPE_EXIT, null, "now");
    }

    /*
      Private Methods
     */
    private void appendNodes(Network network) {
        CyNetwork cyNetwork = getCyNetwork();
        CyNetworkView view = Cytoscape.createNetworkView(cyNetwork);

        SpringEmbeddedLayouter layouter = new SpringEmbeddedLayouter(view);
        layouter.doLayout();
        
        Iterator nodeViewsItr = view.getNodeViewsIterator();
        while (nodeViewsItr.hasNext()) {
            NodeView nodeView = (NodeView)nodeViewsItr.next();
            network.addNode(getNode(nodeView));
        }

        adjustNodePosition(network);

        Iterator edgeViewsItr = view.getEdgeViewsIterator();
        while (edgeViewsItr.hasNext()) {
            EdgeView edgeView = (EdgeView)edgeViewsItr.next();
            Edge edge = edgeView.getEdge();
            Node source = network.getNode(edge.getSource().getIdentifier());
            Node target = network.getNode(edge.getTarget().getIdentifier());
            addLink(network, source, target);
        }
    }

    private void adjustNodePosition(Network network) {
        double lowestX = network.getLowestX().doubleValue();
        double shiftX = 0;
        if (lowestX < 0) {
            shiftX = Math.abs(lowestX);
        }

        double lowestY = network.getLowestY().doubleValue();
        double shiftY = 0;
        if (lowestY < 0) {
            shiftY = Math.abs(lowestY);
        }

        if (shiftX != 0 && shiftY != 0) {
            for (Node node : network.getNodes()) {
                double newX = node.getPosition().getX().doubleValue() + shiftX;
                double newY = node.getPosition().getY().doubleValue() + shiftY;
                node.setPosition(new SimpleCoordinatePosition(newX, newY));
            }
        }
    }

    private CyNetwork getCyNetwork() {
        if (getNetworkFile() != null) {
            return Cytoscape.createNetworkFromFile(getNetworkFile(), false);
        } else {
            return getDummyNetwork();
        }
    }
    
    private CyNetwork getDummyNetwork() {
        CyNode node1 = Cytoscape.getCyNode("node1", true);
        CyNode node2 = Cytoscape.getCyNode("node2", true);
        CyEdge edge1 = Cytoscape.getCyEdge("node1", "node1 (pp) node2", "node2", "pp");
        CyEdge edge2 = Cytoscape.getCyEdge("node2", "node2 (pp) node1", "node1", "pp");
        int[] nodeArray = {node1.getRootGraphIndex(), node2.getRootGraphIndex()};
        int[] edgeArray = {edge1.getRootGraphIndex(), edge2.getRootGraphIndex()};

        return Cytoscape.createNetwork(nodeArray, edgeArray, null);
    }

    private Node getNode(NodeView nv) {
        String id = nv.getNode().getIdentifier();
        return new SimpleNode(id, id, new SimpleCoordinatePosition(nv.getXPosition(), nv.getYPosition()));
    }
}
