package program;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import it.unibs.fp.mylib.MyMenu;

/**
 * Classe contenente il main
 * 
 * @author Just E.A.T.
 *
 */
public class Main {
	
	private final static String TITLE = "Select a file to read";
	private final static String READING_FROM_DIRECTORY = "Reading files from the following directory: %s";
	private final static String END_MESSAGE = "Reading process complete";

	/**
	 * Metodo main: determina il flusso di esecuzione del programma e permette all'utente
	 * di selezionare i files da leggere dalla cartella in cui sono salvati
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		File file = new File(System.getProperty("user.dir"), "InputFiles");
        String folder = file.getAbsolutePath();
        
		String[] menuVoices = setMenuVoices(folder);
		
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

        	Utility.read((folder + "\\" + chosenFile), graph);

        	Dijkstra dijkstra = new Dijkstra(graph);

        	tonatiuh.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[0]));
        
        	Double tonatiuhCost = tonatiuh.get(tonatiuh.size()-1).getDistanceFromRoot();
        
        	metztli.addAll(dijkstra.shortestPath(graph.searchNode(0), teams[1]));

        	Double metztliCost = metztli.get(metztli.size()-1).getDistanceFromRoot();
        	
        	Utility.write(tonatiuh, tonatiuhCost, metztli, metztliCost, (chosenFile + "_OUTPUT.xml"), teams);
    	
		} while (true);
	}
	
	/**
	 * Metodo che si occupa di salvare in una lista tutti i files contenuti in una cartella
	 * 
	 * @param directory La directory in cui cercare i file
	 * @return filenames La lista dei files nella directory
	 */
	private static List<String> fileList(String directory) {
        List<String> fileNames = new Vector<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toFile().getName());
            }
        } catch (IOException ex) {}
        return fileNames;
    }
	
	/**
	 * Metodo che permette di leggere il nome dei files presenti in una cartella e inserirli in un vettore di stringhe
	 * 
	 * @param folder La stringa che rappresenta la directory in cui sono salvati i files
	 * @return menuVoices Il vettore di stringhe da passare al costruttore dell'oggetto menu', di tipo MyMenu
	 */
	private static String[] setMenuVoices(String folder) {
		
        System.out.println(String.format(READING_FROM_DIRECTORY, folder));
        
        String[] menuVoices = new String[fileList(folder).size()];
        menuVoices = fileList(folder).toArray(menuVoices);

        return menuVoices;
	}

}
