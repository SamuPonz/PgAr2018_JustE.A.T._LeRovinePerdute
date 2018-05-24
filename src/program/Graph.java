package program;

import java.util.ArrayList;
import java.util.List;


public class Graph {

    private ArrayList<Node> nodes = new ArrayList<>();


    public Node addNode(Node newNode) {
        nodes.add(newNode);
        return newNode;
    }

    public void printer() {
        for (Node node : nodes) {
            node.printer();
            System.out.println();
        }
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setEdges() {
        for(Node node : nodes){
            ArrayList<Node> adjs = new ArrayList<>();
            for (Integer adj : node.getAdjacentNodes()){
                adjs.add(searchNode(adj));
            }
            node.setEdges(node, adjs);
        }
    }

    public Node searchNode(int id){
        return nodes.get(id);
    }

    public void printEdges() {
        for (Node node : nodes)
            node.printEdges();
    }
}

