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
	
	public Writer() {}
	
	/**
	 * Metodo che stampa il file senza alterarne la formattazione originale (scarsa utilita')
	 * 
	 * @param graph
	 * @param filename
	 * @return
	 */
	public boolean writeWithoutFormatting(Graph graph, String filename) {
		
		System.out.println("Writing in process...");
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer;
		
		try {
			writer = output.createXMLStreamWriter(new FileWriter(filename));

			writer.writeStartDocument("utf-8","1.0");
			
			for(int i = 0; i < graph.elements.get(0).size(); i++) {
				for(int j = 0; j < graph.tags.size(); j++) {
					writer.writeStartElement(graph.tags.get(j));
					if (!graph.elements.get(j).isEmpty())
						writer.writeCharacters(graph.elements.get(j).get(i));
					writer.writeEndElement();
				}				
			}
			
			writer.writeEndDocument();
			writer.flush();
			writer.close();
			
			System.out.println("End");
			
		} catch (Exception e) {
			
			System.out.print("Error");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}