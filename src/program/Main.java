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

        String[] teams = {"Tonatiuh", "Metztli"};

        Dijkstra dijkstra = new Dijkstra(graph);

        tonatiuh.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[0]));
        
        Double tonatiuhCost = tonatiuh.get(tonatiuh.size()-1).getDistanceFromRoot();
        
        metztli.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[1]));

        Double metztliCost = metztli.get(metztli.size()-1).getDistanceFromRoot();
        
        Utility.write(tonatiuh, tonatiuhCost, metztli, metztliCost, "PgAr_Map_10000_OUTPUT.xml", teams);
	}

}
