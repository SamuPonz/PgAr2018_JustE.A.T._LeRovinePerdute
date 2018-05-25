package program;

import java.util.ArrayList;

/**
 * 
 * Classe che rappresenta il prototipo di un oggetto grafo
 * 
 * @author Just E.A.T.
 *
 */

public class Graph {

    private ArrayList<Node> nodes = new ArrayList<>();

    /**
     * 
     * Metodo cge aggiunge un nodo al grafo
     * 
     * @param Nodo da aggiungere al grafo
     * @return Nodo aggiunto al grafo
     */
    
    public Node addNode(Node newNode) {
        nodes.add(newNode);
        return newNode;
    }

    /**
     * 
     * Metodo che stampa la lista di nodi del grafo
     * 
     */
    
    public void printer() {
        for (Node node : nodes) {
            node.printer();
            System.out.println();
        }
    }

    /**
     * 
     * Metodo che ritorna la lista di nodi del grafo
     * 
     * @return Lista di nodi del grafo
     */
    
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * 
     * Metodo che modifica gli Edge del grafo
     * 
     */
    
    public void setEdges() {
        for(Node node : nodes){
            ArrayList<Node> adjs = new ArrayList<>();
            for (Integer adj : node.getAdjacentNodes()){
                adjs.add(searchNode(adj));
            }
            node.setEdges(node, adjs);
        }
    }
    
    /**
     * 
     * Metodo che cerca un nodo nel grafo in base all'ID
     * 
     * @param id ID del nodo
     * @return Nodo cercato
     */

    public Node searchNode(int id){
        return nodes.get(id);
    }

    /**
     * 
     * Metodo che stampa gli Edges del grafo
     * 
     */
    
    public void printEdges() {
        for (Node node : nodes)
            node.printEdges();
    }
}

