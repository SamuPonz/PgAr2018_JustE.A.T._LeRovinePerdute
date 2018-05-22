package program;

import java.io.FileWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

/**
 * Classe che si occupa di produrre il file XML da restituire come output
 * 
 * @author Just E.A.T.
 *
 */
public class Writer {
		
	/**
	 * Metodo che stampa il file senza alterarne la formattazione originale (scarsa utilita')
	 * 
	 * @param graph
	 * @param filename
	 * @return
	 */
	public boolean write(Graph graph, String filename, String... teamNames) {
		
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
			return false;
		}
		
		return true;
	}
}