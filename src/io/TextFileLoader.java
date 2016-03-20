package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JOptionPane;

import model.Director;

import ui.Etichetta;

/**
 * Classe usata per leggere da file (di testo).
 * TODO: Potrebbe essere implementato in Singleton per avere 
 * un unico gestore file in grado di aprire file diversi.
 * 
 * @author esame_07
 *
 */

public class TextFileLoader extends Observable{
	
	private String filename;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private Director director;
	
	public TextFileLoader(String filename) {
		this.filename = filename;
		director = Director.getUnicoDirector();
		
		try {
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Errore in fase di creazione dello stream input", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		try {
			loadEtichetteFromFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Errore in fase di lettura del file", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo che si occupa di leggere le righe del file
	 * e di creare un'Etichetta per ognuna di essa.
	 * 
	 * @throws IOException In caso di problemi di I/O.
	 */
	
	public void loadEtichetteFromFile() throws IOException{
		try{
			while(true){
				String[] line = bufferedReader.readLine().split(";");
				director.getEtichette().add(new Etichetta(line[0], 
											Integer.parseInt(line[1]),
											line[2],
											line[3])
								);
				
			}
			
		}
		catch (NullPointerException e){
			director.inizializzaOriginalEtichette();
			bufferedReader.close();
			fileReader.close();
		}
		
		return;
	}
	
	public String getFilename() {
		return filename;
	}
	
	/**
	 * TODO: Metodo da usare per leggere da un altro file (cfr. punto 3).
	 * 
	 * @param filename Il nome del nuovo file da leggere.
	 */
	
	public void refreshFilename(String filename) {
		this.filename = filename;
		try {
			loadEtichetteFromFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Errore in fase di lettura del file", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

}
