package program;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
	
    private String name;
    
    private double x;
    private double y;
    private double altitude;
    private int id;
    private List<Integer> adjacentNodes = new ArrayList<>();


    private Node previousNode;
    private double distanceFromRoot = Double.POSITIVE_INFINITY;
    private int nodesFromRoot;
    private List<Edge> edges = new ArrayList<>();

	public Node(String name, double x, double y, double altitude, int id) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.altitude = altitude;
        this.id = id;
    }

    public Node(int id) {
        this.id = id;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addAdjacentNodes(int adj) {
        adjacentNodes.add(adj);
    }

    public void printer() {
        System.out.println(name + " id: " + id);
        for (Integer adj : adjacentNodes)
            System.out.println("\t" +adj);
    }
    
    public List<Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public double getDistanceFromRoot() {
		return distanceFromRoot;
	}

	public void setDistanceFromRoot(double distanceFromRoot) {
		this.distanceFromRoot = distanceFromRoot;
	}

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode =previousNode;
	}
	
	public int compareTo(Node node) {
		if(id < node.id)
			return -1;
		else return 1;
	}

    public void setEdges(Node from, ArrayList<Node> adjs) {
        for(Node to : adjs){
           edges.add(new Edge(from, to));
        }
    }

    public void printEdges() {
        for (Edge edge: edges)
            edge.printer();
    }


    public List<Node> getAdj() {
	    List<Node> adjacents =new ArrayList<>();
	    for (Edge edge : edges){
	        adjacents.add(edge.getTo());
        }
        return adjacents;
    }

    public Edge searchEdge(Node to){
	    for(Edge edge: edges){
	        if (to == edge.getTo())
	            return edge;
	    }
	    return null;
    }

    public void setNodesFromRoot(int nodesFromRoot) {
        this.nodesFromRoot = nodesFromRoot;
    }

    public int getNodesFromRoot() {
        return nodesFromRoot;
    }
}
