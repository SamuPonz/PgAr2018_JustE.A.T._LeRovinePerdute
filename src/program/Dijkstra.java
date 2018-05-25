package program;

import java.util.ArrayList;
import java.util.Collections;

public class Dijkstra {

    private Graph graph = null;
    private Node baseCamp = null;
    private Node ruins = null;

    public Dijkstra(Graph graph) {
        this.graph = graph;
        baseCamp = graph.searchNode(0);
        ruins = graph.searchNode(graph.getNodes().size()-1);
    }
 	
	public ArrayList<Node> shortestPath(Node root, String vehicle) {
		
		ArrayList<Node> uncheckedNodes = new ArrayList<>();
		
		for(Node node : graph.getNodes()) {
			node.setDistanceFromRoot(Double.POSITIVE_INFINITY);
			node.setNodesFromRoot(Integer.MAX_VALUE);
			node.setPreviousNode(null);
			uncheckedNodes.add(node);
		}
		
		root.setDistanceFromRoot(0);
		root.setNodesFromRoot(0);

		double finalDistance = 0;
		int nodesFromRoot = 0;
		Node currentNode = null;

		while(!uncheckedNodes.isEmpty()) {
			currentNode = nearestNodeFromRoot(uncheckedNodes);
			uncheckedNodes.remove(currentNode);
			for(Node currentAdjNode : currentNode.getAdj()){
				if(!uncheckedNodes.contains(currentAdjNode)) {
					continue;
				}
				if(vehicle.equals("Metztli")) {
					finalDistance = currentNode.getDistanceFromRoot() + currentNode.searchEdge(currentAdjNode).getWeightMetztli();
				}
				else if (vehicle.equals("Tonatiuh")) {
					finalDistance = currentNode.getDistanceFromRoot() + currentNode.searchEdge(currentAdjNode).getWeightTonatiuh();
				}
				nodesFromRoot = currentNode.getNodesFromRoot() + 1;
				if(finalDistance < currentAdjNode.getDistanceFromRoot()) {
					currentAdjNode.setDistanceFromRoot(finalDistance);
					currentAdjNode.setPreviousNode(currentNode);
					currentAdjNode.setNodesFromRoot(nodesFromRoot);
				}
				else if(finalDistance == currentAdjNode.getDistanceFromRoot()) {
					if (nodesFromRoot < currentAdjNode.getNodesFromRoot()) {
						currentAdjNode.setDistanceFromRoot(finalDistance);
						currentAdjNode.setNodesFromRoot(nodesFromRoot);
						currentAdjNode.setPreviousNode(currentNode);

					}
					else if (nodesFromRoot == currentAdjNode.getNodesFromRoot()){
						if (currentAdjNode.getPreviousNode().getId() < currentNode.getId()) {
							currentAdjNode.setDistanceFromRoot(finalDistance);
							currentAdjNode.setNodesFromRoot(nodesFromRoot);
							currentAdjNode.setPreviousNode(currentNode);
						}
					}
				}
			}
		}
		return buildPath();
	}

	public Node nearestNodeFromRoot(ArrayList<Node> uncheckedNodes) {
		Node nearestNode = new Node(-1);
		for(Node node : uncheckedNodes) {
			if(node.getDistanceFromRoot() < nearestNode.getDistanceFromRoot()) {
				nearestNode = node;
			}
			else if(node.getDistanceFromRoot() == nearestNode.getDistanceFromRoot()) {
				if(node.getNodesFromRoot() < nearestNode.getNodesFromRoot()) {
					nearestNode = node;
				}
				else if(node.getNodesFromRoot() == nearestNode.getNodesFromRoot()) {
					if(node.getId() > nearestNode.getId())
					nearestNode = node;
				}
			}
		}
		return nearestNode;
	}

    private ArrayList<Node> buildPath() {
        boolean finished = false;
        ArrayList<Node> path = new ArrayList<>();
        Node currentNode = ruins;
        path.add(currentNode);
        while(!finished) {
            path.add(currentNode.getPreviousNode());
            if(currentNode.getPreviousNode().equals(baseCamp))
                finished = true;
            currentNode = currentNode.getPreviousNode();
        }
        Collections.reverse(path);
        return path;
    }
}
