package program;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Classe che si occupa della lettura di files in formato XML, in particolare
 * dell'archiviazione dei tags e attributes letti in oggetti del tipo Graph.
 * 
 * @author Just E.A.T.
 *
 */
public class Utility {
	
    /**
     * Metodo che legge i file in formato xml
     * 
     * @param fileName Nome del file
     * @param graph Istanza della classe grafo da sovrascrivere con i valori letti con il metodo read
     */
	
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
                        node = graph.addNode(new Node(name, x, y, h, id));

                	}
                    
                	if(xmlr.getLocalName().equals("link")) {
                		id = Integer.valueOf(xmlr.getAttributeValue(null, "to"));
                		node.addAdjacentNodes(id);
                	}
                    break;
                    
                default:
                	break;
                }
                
                xmlr.next();
            }
            graph.setEdges();
        }
        
        catch(Exception e){
            System.err.println("Error detected");
            System.err.println(e.getMessage());
        }
    }

	/**
	 * 
	 * Metodo che stampa file in formato xml, formattati in modo corretto
	 * 
	 * @param tonatiuh ArrayList di Nodi del percorso ottimale del veicolo Tonatiuh
	 * @param tonatiuhCost Carburante richiesto dal veicolo Tonatiuh
	 * @param metztli ArrayList di Nodi del percorso ottimale del veicolo Metztli
	 * @param metztliCost Carburante richiesto dal veicolo Metztli
	 * @param filename Nome del file da produrre
	 * @param teamNames Array di stringhe contenente i nomi delle squadre di esplorazione
	 */
    
	public static void write(ArrayList<Node> tonatiuh, Double tonatiuhCost, ArrayList<Node> metztli, Double metztliCost, String filename, String[] teamNames) {

		System.out.println("Writing in process...");
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;

		try {

			writer = output.createXMLStreamWriter(new FileWriter(filename));

			writer.writeStartDocument("utf-8","1.0");
			writer.writeCharacters("\n");
			writer.writeStartElement("solution"); //Start solution
			writer.writeCharacters("\n\t");
			writer.writeStartElement("route"); //Start route

			writer.writeAttribute("team", teamNames[0]);
			writer.writeAttribute("cost", Double.toString(tonatiuhCost));
			writer.writeAttribute("cities", Integer.toString(tonatiuh.size()));

			for(int i = 0; i < tonatiuh.size(); i++) {
				writer.writeCharacters("\n\t\t");
				writer.writeEmptyElement("city");
				writer.writeAttribute("id", Integer.toString(tonatiuh.get(i).getId()));
				writer.writeAttribute("name", tonatiuh.get(i).getName());
			}
			writer.writeCharacters("\n\t");
			writer.writeEndElement(); //End route
			writer.writeCharacters("\n\t");
			writer.writeStartElement("route"); //Start route
			writer.writeAttribute("team", teamNames[1]);
			writer.writeAttribute("cost", Double.toString(metztliCost));
			writer.writeAttribute("cities", Integer.toString(metztli.size()));

			for(int i = 0; i < metztli.size(); i++) {
				writer.writeCharacters("\n\t\t");
				writer.writeEmptyElement("city"); //Start city
				writer.writeAttribute("id", Integer.toString(metztli.get(i).getId()));
				writer.writeAttribute("name", metztli.get(i).getName());
			}
			writer.writeCharacters("\n\t");

			writer.writeEndElement(); //End route
			writer.writeCharacters("\n");
			writer.writeEndElement(); //End solution

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
