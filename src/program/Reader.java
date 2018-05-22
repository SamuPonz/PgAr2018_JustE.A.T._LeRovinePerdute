package program;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

/**
 * 
 * Classe che si occupa della lettura di files in formato XML, in particolare
 * dell'archiviazione dei tags e attributes letti in oggetti del tipo DataSet.
 * 
 * @author Just E.A.T.
 *
 */
public class Reader {
	
	public Reader() {}
	
    //LEGGE DAL FILE SOLO I TAG CHE CI INTERESSANO E SALVA I VALORI
    public static void read(String fileName, Graph graph) {
        int id;
        String name;
        double x, y , h;
        Node node = null;
        
        try {
            XMLInputFactory xmlif=XMLInputFactory.newInstance();
            XMLStreamReader xmlr = xmlif.createXMLStreamReader(fileName, new FileInputStream(fileName));
            
            while(xmlr.hasNext()) {
                switch(xmlr.getEventType()) {
                    
                case XMLStreamConstants.START_ELEMENT:
                        if(xmlr.getLocalName().equals("city")) {
                            id = Integer.valueOf(xmlr.getAttributeValue(null, "id"));
                            name = xmlr.getAttributeValue(null, "name");
                            x = Double.valueOf(xmlr.getAttributeValue(null, "x"));
                            y = Double.valueOf(xmlr.getAttributeValue(null, "y"));
                            h = Double.valueOf(xmlr.getAttributeValue(null, "h"));
                            node = graph.searchNode(id);
                            if (node == null) {
                                graph.addNode(new Node(name, x, y, h, id));
                                node = graph.searchNode(id);
                            }
                            else
                                node.init(name, x , y, h);
                        }
                        if(xmlr.getLocalName().equals("link")) {
                            id = Integer.valueOf(xmlr.getAttributeValue(null, "to"));
                            if (graph.searchNode(id) == null)
                                graph.addNode(new Node(id));
                            node.addAdjacentNodes(graph.searchNode(id));
                        }
                        break;
                default:
                	break;
                }
                xmlr.next();
            }
        }
        catch(Exception e){
            System.err.println("Error detected");
            System.err.println(e.getMessage());
        }
    }
}
