package model;

import javax.swing.JOptionPane;

/**
 * Una delle possibili implementazioni di visualizzazione,
 * nonché una possibile implementazione concreta di ProxyMode.
 * 
 * @author esame_07
 *
 */

public class LinearMode implements IMode{
	
	private Director director;
	private int newIndex = 0;
	
	public LinearMode() {
		director = Director.getUnicoDirector();
	}
	
	/**
	 * Metodi per incrementare/decrementare l'indice specifici per LinearMode.
	 * 
	 */

	@Override
	public int increaseIndex(int directorIndex) {
		
		if(directorIndex >= director.getEtichette().size() - 1){
			newIndex = director.getEtichette().size() - 1;
			JOptionPane.showMessageDialog(null, "Sei già all'ultimo elemento", "Errore", JOptionPane.ERROR_MESSAGE);
		} else {
			newIndex = directorIndex + 1;
		}
			
		return newIndex;
	}

	@Override
	public int decreaseIndex(int directorIndex) {
		
		if (directorIndex <= 0) {
			newIndex = 0;
			JOptionPane.showMessageDialog(null, "Sei già al primo elemento", "Errore", JOptionPane.ERROR_MESSAGE);
		} else {
			newIndex = directorIndex - 1;
		}
		
		return newIndex;
	}
	
	

}
