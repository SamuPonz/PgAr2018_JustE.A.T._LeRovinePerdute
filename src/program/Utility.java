package program;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileInputStream;
import java.io.FileWriter;

/**
 * 
 * Classe che si occupa della lettura di files in formato XML, in particolare
 * dell'archiviazione dei tags e attributes letti in oggetti del tipo Graph.
 * 
 * @author Just E.A.T.
 *
 */
public class Utility {
	
    //LEGGE DAL FILE SOLO I TAG CHE CI INTERESSANO E SALVA I VALORI
    public static void read(String fileName, Graph graph) {
        int id;
        String name;
        double x, y , h;
        Node node = null;
        
        try {
        	
            XMLInputFactory xmlif = XMLInputFactory.newInstance();
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
                        if (graph.searchNode(id) == null) {
                        	graph.addNode(new Node(id));
                        }
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
    
    
    /**
	 * Metodo che stampa il file senza alterarne la formattazione originale (scarsa utilita')
	 * 
	 * @param graph
	 * @param filename
	 * @return
	 */
	public static void write(Graph graph, String filename, String[] teamNames) {
		
		System.out.println("Writing in process...");
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;
		
		try {
			
			writer = output.createXMLStreamWriter(new FileWriter(filename));

			writer.writeStartDocument("utf-8","1.0");
			
			writer.writeStartElement("routes"); //Start routes
			
			writer.writeStartElement("route"); //Start route
			
			
			for(Node node: graph.getNodes())
				for(int i = 0; i < graph.getNodes().size(); i++)
					writer.writeAttribute("id", Integer.toString(graph.getNodes().get(i).getId())); //Da verificare
								
			writer.writeEndElement(); //End route
			
			writer.writeEndDocument();
			writer.flush();
			writer.close();
			
			System.out.println("End");
			
		}
		
		catch (Exception e) {
			
			System.out.print("Error");
			e.printStackTrace();
		}
	}
}
