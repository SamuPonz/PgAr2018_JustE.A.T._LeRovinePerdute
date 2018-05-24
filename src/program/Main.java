package program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph();
		ArrayList<Node> tonatiuh = new ArrayList<>();
        ArrayList<Node> metztli = new ArrayList<>();

        Utility.read("PgAr_Map_10000.xml", graph);
		graph.setEdges();


        String[] teams = {"Tonatiuh", "Metztli"};

        Dijkstra dijkstra = new Dijkstra(graph);

        tonatiuh.addAll( dijkstra.shortestPath(graph.searchNode(0), teams[0]));

        metztli.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[1]));
        System.out.println(metztli.size() + "\n" + tonatiuh.size());
        Utility.write(tonatiuh, metztli, "PgAr_Map_10000_OUTPUT.xml", teams);
	}

}
