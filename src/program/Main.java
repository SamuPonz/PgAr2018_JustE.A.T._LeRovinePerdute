package program;

public class Main {

	public static void main(String[] args) {
		
		Graph citiesGraph = new Graph();
		Reader xml_reader = new Reader();
		Writer xml_writer = new Writer();
		
		xml_reader.explore(citiesGraph, "PgAr_Map_5.xml");
		
		xml_writer.writeWithoutFormatting(citiesGraph, "PgAr_Map_5_OUTPUT.xml");
		
	}

}
