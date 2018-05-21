package program;

import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Node> nodes = new LinkedList<Node>();
	private LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public void addNode(Node newNode) {
		nodes.add(newNode);
	}
	
	public void addEdge(Node from, Node to) {
		
	}
	
	public Node searchNode(int id) {
		return null;
	}
	
	public Edge searchEdge(Node arrivalNode) {
		return null;
	}
	
}
