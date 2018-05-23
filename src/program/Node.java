package program;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
    private String name;
    
    private double x;
    private double y;
    private double altitude;
    private int id;
    
    private double distanceFromRoot = Double.MAX_VALUE; 
    private List<Node> adjacentNodes = new LinkedList<>();

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

    public void addAdjacentNodes(Node adj) {
        adjacentNodes.add(adj);
    }

    public void init(String name, double x, double y, double altitude) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.altitude = altitude;
    }

    public void printer() {
        System.out.println(name + " id: " + id);
        for (Node adj : adjacentNodes)
            System.out.println("\t" + adj.name + " id: "+ adj.id);
    }
    
    public List<Node> getAdjacentNodes() {
		return adjacentNodes;
	}

	public double getDistanceFromRoot() {
		return distanceFromRoot;
	}

	public void setDistanceFromRoot(double distanceFromRoot) {
		this.distanceFromRoot = distanceFromRoot;
	}


}
