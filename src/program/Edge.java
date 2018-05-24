package program;

/**
 * 
 * Classe che rappresenta il prototipo di una Strada
 * 
 * @author Just E.A.T.
 *
 */

public class Edge {

    private Node from;
    private Node to;
    private double weightTonatiuh;
    private double weightMetztli;
    
    /**
     * 
     * Costruttore
     * 
     * @param from Citta' da cui parte la strada
     * @param to Citta' a cui arriva la strada
     */
   
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        weightMetztli = distanceMetztli();
        weightTonatiuh = distanceTonatiuh();

    }

    /**
     * 
     * Metodo che calcola la differenza di altitudine in modulo tra due citta'
     * 
     * @return Distanza tra due citta'
     */
    
    private double distanceMetztli() {
       return Math.abs(from.getAltitude() - to.getAltitude());
    }

    /**
     * 
     *Metodo che calcola la distanza euclidea tra due citta' 
     *
     * @return Distanza tra due citta'
     */
    
    private double distanceTonatiuh() {
        double deltaX = Math.pow(from.getX() - to.getX(),2);
        double deltaY = Math.pow(from.getY() - to.getY(),2);
        double distance = Math.sqrt(deltaX + deltaY);
        return distance;
    }

    /**
     * 
     * Metodo che ritorna il carburante usato dal veicolo Tonatiuh per percorrere questa strada
     * 
     * @return Carburante usato dal veicolo Tonatiuh per percorrere questa strada
     */
    
    public double getWeightTonatiuh() {
        return weightTonatiuh;
    }
    
    /**
     * 
     * Metodo che ritorna il carburante usato dal veicolo Metztli per percorrere questa strada
     * 
     * @return Carburante usato dal veicolo Metztli per percorrere questa strada
     */

    public double getWeightMetztli() {
        return weightMetztli;
    }
    
    /**
     * 
     * Metodo che restituisce la citta' di partenza
     * 
     * @return Citta' di partenza
     */

    public Node getFrom() {
        return from;
    }

    /**
     * 
     * Metodo che restituisce la citta' di arrivo 
     * 
     * @return Citta' di arrivo
     */
    
    public Node getTo() {
        return to;
    }

    /**
     * 
     * Metodo che stampa le citta' colegate dalla strada
     * 
     */
    
    public void printer() {
        System.out.println("From: " + from.getId() + " to: " + to.getId());
    }
    
}
