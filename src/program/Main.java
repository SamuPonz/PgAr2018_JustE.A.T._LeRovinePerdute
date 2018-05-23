package program;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Graph graph = new Graph();
		Utility.read("PgAr_Map_50.xml", graph);
		graph.printer();
		
		graph.linkNodes();

        graph.printEdges(); //Per utilità
        
        String[] teams = {"Metztli", "Tonatiuh"};
        
        Dijkstra dijkstra = new Dijkstra();
        Node baseCamp = null;
        
        for(Node node : graph.getNodes()) {
        	if(node.getId() == 0) {
        		baseCamp = node;
        	}
        }
               
//        Node rovineT= dijkstra.shortestPath(graph, baseCamp, teams[1]);
        
//        System.out.println();
//        System.out.println(rovineT.getName());
//        System.out.println(rovineT.getDistanceFromRoot());
//        		
        		
//        for(Node city : pathMetztli) {
//        	System.out.println(city.getName());
//        }
//        
//        System.out.println();
//        for(Node city : pathTonatiuh) {
//        	System.out.println(city.getName());
//        }
//        
//        System.out.println(pathMetztli.get(pathMetztli.size()-1).getName());
//        System.out.println(pathMetztli.get(pathMetztli.size()-1).getDistanceFromRoot());
//        System.out.println(pathTonatiuh.get(pathTonatiuh.size()-1).getName());
//        System.out.println(pathTonatiuh.get(pathTonatiuh.size()-1).getDistanceFromRoot());
//        
//        
        
        
        
        
//        Utility.write(graph, "PgAr_Map_12_OUTPUT.xml", teams);
        
        
        
	}

}
