package program;

import java.util.HashSet;
import java.util.Set;


public class Dijkstra {
	
 	
	public void shortestPath(Graph graph, Node root, String vehicle) {
		
		Set<Node> uncheckedNodes = new HashSet<Node>();
		
		for(Node node : graph.getNodes()) {
			node.setDistanceFromRoot(Double.POSITIVE_INFINITY);
			node.addPreviousNode(null);
			uncheckedNodes.add(node);
		}
		
		root.setDistanceFromRoot(0);
		
		double finalDistance = 0;
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
					if(finalDistance < currentAdjNode.getDistanceFromRoot()) {
						currentAdjNode.setDistanceFromRoot(finalDistance);
						currentAdjNode.addPreviousNode(currentNode);
					}
					else if(finalDistance == currentAdjNode.getDistanceFromRoot()) {
						currentAdjNode.setDistanceFromRoot(finalDistance);
						currentAdjNode.addPreviousNode(currentNode);
					}
					
				}
				else if (vehicle.equals("Tonatiuh")) {
					finalDistance = currentNode.getDistanceFromRoot() + currentNode.searchEdge(currentAdjNode).getWeightTonatiuh();
					if(finalDistance < currentAdjNode.getDistanceFromRoot()) {
						currentAdjNode.setDistanceFromRoot(finalDistance);
						currentAdjNode.addPreviousNode(currentNode);
					}	
					else if(finalDistance == currentAdjNode.getDistanceFromRoot()) {
						currentAdjNode.setDistanceFromRoot(finalDistance);
						currentAdjNode.addPreviousNode(currentNode);
					}
				}
			}
		}
	}
	
	public Node nearestNodeFromRoot(Set<Node> uncheckedNodes) {
		Node nearestNode = new Node(-1);
		for(Node node : uncheckedNodes) {
			if(node.getDistanceFromRoot() < nearestNode.getDistanceFromRoot())
				nearestNode = node;
		}
		return nearestNode;
	}
}
