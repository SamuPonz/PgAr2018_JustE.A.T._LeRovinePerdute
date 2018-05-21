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
    
}