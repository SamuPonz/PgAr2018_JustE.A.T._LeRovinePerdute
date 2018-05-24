package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph();
		Utility.read("PgAr_Map_2000.xml", graph);
		graph.printer();
		graph.setEdges();
        graph.printEdges(); //Per utilità

        String[] teams = {"Metztli", "Tonatiuh"};

        Dijkstra dijkstra = new Dijkstra();
        Node baseCamp = null;

        for(Node node : graph.getNodes()) {
        	if(node.getId() == 0) {
        		baseCamp = node;
        	}
        }

        Node rovineM = new Node(-1);
        Node rovineT = new Node(-1);
        dijkstra.shortestPath(graph, baseCamp, teams[0]);
        System.out.println(graph.getNodes().get(graph.getNodes().size()-1).getName());
        System.out.println(graph.getNodes().get(graph.getNodes().size()-1).getDistanceFromRoot());
        dijkstra.shortestPath(graph, baseCamp, teams[1]);
        System.out.println(graph.getNodes().get(graph.getNodes().size()-1).getName());
        System.out.println(graph.getNodes().get(graph.getNodes().size()-1).getDistanceFromRoot());

        Utility.write(graph, "PgAr_Map_12_OUTPUT.xml", teams);

	}

}
