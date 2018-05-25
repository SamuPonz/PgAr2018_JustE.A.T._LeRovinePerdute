package program;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import it.unibs.fp.mylib.MyMenu;

public class Main {
	
	private final static String TITLE = "Select a file to read";
	private final static String READING_FROM_DIRECTORY = "Reading files from the following directory: %s";
	private final static String END_MESSAGE = "Reading process complete";

	public static void main(String[] args) {

		String[] menuVoices = setMenuVoices();
		
		MyMenu menu = new MyMenu(TITLE, menuVoices, TITLE.length());
		
		int choice;
		String chosenFile = "";
		String[] teams = {"Tonatiuh", "Metztli"};
		
		do {
			choice = menu.choose();
			
			if(choice == 0) {
				System.out.println(END_MESSAGE);
				break;
			}
			
			Graph graph = new Graph();
			chosenFile = menuVoices[choice - 1];
		
			ArrayList<Node> tonatiuh = new ArrayList<>();
			ArrayList<Node> metztli = new ArrayList<>();

        	Utility.read(chosenFile, graph);

        	Dijkstra dijkstra = new Dijkstra(graph);

        	tonatiuh.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[0]));
        
        	Double tonatiuhCost = tonatiuh.get(tonatiuh.size()-1).getDistanceFromRoot();
        
        	metztli.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[1]));

        	Double metztliCost = metztli.get(metztli.size()-1).getDistanceFromRoot();
        	
        	Utility.write(tonatiuh, tonatiuhCost, metztli, metztliCost, (chosenFile + "_OUTPUT.xml"), teams);
    	
		} while (true);
	}
	
	private static List<String> fileList(String directory) {
        List<String> fileNames = new Vector<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {}
        return fileNames;
    }
	
	private static String[] setMenuVoices() {
		File file = new File(System.getProperty("user.dir"), "Files");
        String folder = file.getAbsolutePath();
        
        System.out.println(String.format(READING_FROM_DIRECTORY, folder));
        
        String[] menuVoices = new String[fileList(folder).size()];
        menuVoices = fileList(folder).toArray(menuVoices);
        
        return menuVoices;
	}

}
