package program;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		Reader.read("PgAr_Map_50.xml", graph);
		graph.printer();

	}

}
