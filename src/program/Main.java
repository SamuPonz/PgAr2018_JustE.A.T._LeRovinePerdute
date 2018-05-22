package program;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph();
		Utility.read("PgAr_Map_12.xml", graph);
		graph.printer();
		
		graph.linkNodes();

        graph.printEdges(); //Per utilità
        
        String[] teams = {"Metztli", "Tonatiuh"};
        Utility.write(graph, "PgAr_Map_12_OUTPUT.xml", teams);
	}

}
