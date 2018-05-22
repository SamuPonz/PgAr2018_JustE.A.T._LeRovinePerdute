package program;

import java.util.LinkedList;

public class Graph {

	private LinkedList<Node> nodes = new LinkedList<>();
	private LinkedList<Edge> edges = new LinkedList<>();
    private LinkedList<Integer> idList = new LinkedList<>();

    public Graph() {

    }

    public void addNode(Node newNode) {
        nodes.add(newNode);
    }

    public void addEdge(Node from, Node to) {
        edges.add(new Edge(from, to));
    }

    public Node searchNode(int id) {
        for (Node element : nodes){
            if(element.getId() == id)
                return element;
        }
        return null;
    }
    
    public void printer() {
        for(Node node : nodes) {
            node.printer();
            System.out.println();
        }
    }
    
    public void linkNodes() {
    	for(Node node: nodes)
    		for(int i = 0; i < node.getAdjacentNodes().size(); i++)
    			addEdge(node, node.getAdjacentNodes().get(i));
    }

    //Serve per utilità, per stampare quali edges sono stati creati
	public void printEdges() {
		for(Edge edge: edges)
			System.out.println(edge.getFrom().getId() + "\t" + edge.getTo().getId() + "\t" + edge.getWeightMetztli() + "\t" + edge.getWeightTonatiuh());
	}
	
	public LinkedList<Node> getNodes() {
		return nodes;
	}

}
