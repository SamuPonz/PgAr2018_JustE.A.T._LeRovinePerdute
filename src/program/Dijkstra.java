package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class Dijkstra {
	
 	
	public void shortestPath(Graph graph, Node root, String vehicle) {
		
		for(Node node : graph.getNodes()) {
			node.setDistanceFromRoot(Double.POSITIVE_INFINITY);
			node.addPreviousNode(null);
		}
		
		
		Set<Node> uncheckedNodes = new HashSet<Node>();
		
		for(Node node : graph.getNodes()) {
			uncheckedNodes.add(node);
		}
		
		root.setDistanceFromRoot(0);
		
		double finalDistance = 0;
		Node currentNode = null;
		Node currentAdjNode = null;
		
		while(!uncheckedNodes.isEmpty()) {
			currentNode = nearestNodeFromRoot(uncheckedNodes);
			uncheckedNodes.remove(currentNode);
			
			for(int i = 0; i < currentNode.getAdjacentNodes().size(); i++) {
				currentAdjNode = currentNode.getAdjacentNodes().get(i);
				if(!uncheckedNodes.contains(currentAdjNode)) {
					continue;
				}
				if(vehicle.equals("Metztli")) {
					finalDistance = currentNode.getDistanceFromRoot() + graph.searchEdge(currentNode, currentAdjNode).getWeightMetztli();
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
					finalDistance = currentNode.getDistanceFromRoot() + graph.searchEdge(currentNode, currentAdjNode).getWeightTonatiuh();
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

//	public Graph minPathBuilder(Node currentNode) {
//		Graph result = null;
//		graph
//		return result;
//	} 
}
