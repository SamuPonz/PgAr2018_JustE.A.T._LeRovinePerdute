package program;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe che rappresenta il prototipo della classe Node, che rappresenta una singola citta'
 * 
 * @author Just E.A.T.
 *
 */

public class Node implements Comparable<Node>{
	
    private String name;
    
    private double x;
    private double y;
    private double altitude;
    private int id;
    private List<Integer> adjacentNodes = new ArrayList<>();
    
    private Node previousNode;
    private double distanceFromRoot = Double.POSITIVE_INFINITY;
    private int nodesFromRoot = Integer.MAX_VALUE;
    private List<Edge> edges = new ArrayList<>();
    
    /**
     * 
     * Costruttore 1
     * 
     * @param name Nome della citta'
     * @param x Ascissa della citta'
     * @param y Ordinata della citta'
     * @param altitude Altitudine della citta'
     * @param id ID unico della citta'
     */

	public Node(String name, double x, double y, double altitude, int id) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.altitude = altitude;
        this.id = id;
    }

	/**
	 * 
	 * Costruttore 2
	 * 
	 * @param id ID unico della citta'
	 */
	
    public Node(int id) {
        this.id = id;
    }

    /**
     * 
     * Metodo che ritorna l'altitudine della citta'
     * 
     * @return Altitudine
     */
    
    public double getAltitude() {
        return altitude;
    }
    
    /**
     * 
     * Metodo che ritorna l'ascissa della citta'
     * 
     * @return Ascissa
     */

    public double getX() {
        return x;
    }

    /**
     * 
     * Metodo che ritorna l'ordinata della citta'
     * 
     * @return Ordinata
     */
    
    public double getY() {
        return y;
    }

    /**
     * 
     * Metodo che ritorna il nome della citta'
     * 
     * @return Nome della citta'
     */
    
    public String getName() {
        return name;
    }

    /**
     * 
     * Metodo che ritorna l'ID della citta'
     * 
     * @return ID della citta'
     */
    
    public int getId() {
        return id;
    }

    /**
     * 
     * Metodo che aggiunge una nuova citta' all'elenco delle citta' vicine
     * 
     * @param ID della citta vicina da aggiungere all'elenco
     */
    
    public void addAdjacentNodes(int adj) {
        adjacentNodes.add(adj);
    }

    /**
     * 
     * Metodo che stampa la lista delle citta' vicine alla citta'
     * 
     */
    
    public void printer() {
        System.out.println(name + " id: " + id);
        for (Integer adj : adjacentNodes)
            System.out.println("\t" +adj);
    }
    
    /**
     * 
     * Metodo che ritorna le citta' vicine alla citta'
     * 
     * @return Lista delle citta' vicine alla citta'
     */
    
    public List<Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

    /**
     * 
     * Metodo che ritorna la distanza della citta' dal campo base
     * 
     * @return Distanza della citta' dal campo base
     */
    
	public double getDistanceFromRoot() {
		return distanceFromRoot;
	}

	/**
	 * 
	 * Metodo che modifica il valore della distanza minima della citta' dal campo base
	 * 
	 * @param Nuova distanza minima della citta' dal campo base
	 */
	
	public void setDistanceFromRoot(double distanceFromRoot) {
		this.distanceFromRoot = distanceFromRoot;
	}

	/**
	 * 
	 * Metodo che ritorna la citta' precedente nel percorso minimo dal campo base
	 * 
	 * @return Citta' precedente nel percorso minimo dal campo base
	 */
	
	public Node getPreviousNode() {
		return previousNode;
	}

	/**
	 * 
	 * Metodo che modifica la citta' precedente nel cammino minimo dal campo base
	 *
	 * @param Citta' precedente nel percorso minimo dal campo base
	 */
	
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	/**
	 * 
	 * Metodo che confronta due citta' in base al loro ID
	 * 
	 */
	
	public int compareTo(Node node) {
		if(id < node.id)
			return -1;
		else return 1;
	}

	/**
	 * 
	 * Metodo che modifica la lista di strade che collegano la citta' alle citta' vicine
	 * 
	 * @param from Citta' di partenza
	 * @param adjs Citta' vicine
	 */
	
    public void setEdges(Node from, ArrayList<Node> adjs) {
        for(Node to : adjs){
           edges.add(new Edge(from, to));
        }
    }

    /**
     * 
     * Metodo che stampa la lista di strade che partono dalla citta'
     * 
     */
    
    public void printEdges() {
        for (Edge edge: edges)
            edge.printer();
    }
    
    public List<Node> getAdj() {
	    List<Node> adjacents = new ArrayList<>();
	    for (Edge edge : edges){
	        adjacents.add(edge.getTo());
        }
        return adjacents;
    }
    
    /**
     * 
     * Metodo che cerca una strada
     * 
     * @param to Citta' da cui parte la strada
     * @return Strada cercata
     */

    public Edge searchEdge(Node to){
	    for(Edge edge: edges){
	        if (to == edge.getTo())
	            return edge;
	    }
	    return null;
    }

    /**
     * 
     * Metodo che modifica il numero di citta' che precedono la citta' nel cammino ottimale
     * 
     * @param Numero di citta' che preceodono la citta' nel cammino ottimale 
     */
    
    public void setNodesFromRoot(int nodesFromRoot) {
        this.nodesFromRoot = nodesFromRoot;
    }

    /**
     * 
     * Metodo che ritorna il numero di citta' che preceodono la citta' nel cammino ottimale
     * 
     * @return Numero di citta' che preceodono la citta' nel cammino ottimale
     */
    
    public int getNodesFromRoot() {
        return nodesFromRoot;
    }

    /**
     * 
     * Metodo che ritorna la lista di strade che partono dalla citta' 
     * 
     * @return Lista di strade che partono dalla citta'
     */
    
    public List<Edge> getEdges() {
        return edges;
    }
}
