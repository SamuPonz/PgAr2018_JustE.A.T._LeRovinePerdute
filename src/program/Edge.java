package program;

public class Edge {

    private Node from;
    private Node to;
    private double weightTonatiuh;
    private double weightMetztli;
   
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        weightMetztli = distanceMetztli();
        weightTonatiuh = distanceTonatiuh();

    }

    private double distanceMetztli() {
       return Math.abs(from.getAltitude() - to.getAltitude());
    }

    private double distanceTonatiuh() {
        double deltaX = Math.pow(from.getX() - to.getX(),2);
        double deltaY = Math.pow(from.getY() - to.getY(),2);
        double distance = Math.sqrt(deltaX + deltaY);
        return distance;
    }

    public double getWeightTonatiuh() {
        return weightTonatiuh;
    }

    public double getWeightMetztli() {
        return weightMetztli;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }
    
}
