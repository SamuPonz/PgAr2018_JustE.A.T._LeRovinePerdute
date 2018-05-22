package program;

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
	
	/**
	 * 
	 * Il metodo "explore" ha il compito di scorrere tutto il file XML passato come parametro
	 * e di salvare i singoli tags e attributes nelle apposite strutture dati dell'oggetto
	 * di tipo DataSet passato come parametro.
	 * Il metodo presenta inoltre delle chiamate al metodo println() di System.out: questa
	 * funzionalita' ha lo scopo di stampare a console, in tempo reale, i dati che vengono letti.
	 * 
	 * @param data
	 * @param filename
	 */
	public void explore(Graph graph, String filename) {
		
		try {
			
			XMLInputFactory xmlif = XMLInputFactory.newInstance();
	        XMLStreamReader xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
	        
	        String temp = "";
	        
	        while(xmlr.hasNext()) {
	        	
	            switch(xmlr.getEventType()) {
	            
	            case XMLStreamConstants.START_DOCUMENT:
	            	System.out.println("Start Read Doc "+ filename);
	            	break;
	            	
	            case XMLStreamConstants.START_ELEMENT:
	            	System.out.println("Tag "+ xmlr.getLocalName());
	            	break;
	            	
	            case XMLStreamConstants.NOTATION_DECLARATION:
	            	System.out.println("Inside "+ xmlr.getText());
	            	break;
	            	
	            case XMLStreamConstants.CHARACTERS:
	            	if(xmlr.getText().trim().length() > 0)
	            		System.out.println("-> "+ xmlr.getText());
	            	break;
	            	
	            case XMLStreamConstants.ATTRIBUTE:
	            	if(xmlr.getText().trim().length() > 0)
	            		for (int i = 0; i < xmlr.getAttributeCount(); i++) {
	            			System.out.println(xmlr.getAttributeLocalName(i));
	            			System.out.println(xmlr.getAttributeValue(i));
	            		}
	            		System.out.println("-> "+ xmlr.getText());
	            	break;
	            	
	            default:
	            	break;
	            	
	            }
	            xmlr.next();
	        }
	        
	    } catch(Exception e) {
	    	System.err.println("Error detected");
	    	System.err.println(e.getMessage());
	    }
	}
}