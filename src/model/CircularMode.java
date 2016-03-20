package model;

/**
 * Una delle possibili implementazioni di visualizzazione,
 * nonché una possibile implementazione concreta di ProxyMode.
 * 
 * @author esame_07
 *
 */

public class CircularMode implements IMode{
	
	private Director director;
	private int newIndex;
	
	public CircularMode() {
		director = Director.getUnicoDirector();
	}
	
	/**
	 * Metodi per incrementare/decrementare l'indice specifici per CircularMode.
	 * 
	 */

	@Override
	public int increaseIndex(int directorIndex) {
		
		if(directorIndex >= director.getEtichette().size() - 1)
			newIndex = 0;
		else 
			newIndex = directorIndex + 1;
		
		return newIndex;
	}

	@Override
	public int decreaseIndex(int directorIndex) {
		
		if(directorIndex <= 0)
			newIndex = director.getEtichette().size() - 1;
		else
			newIndex = directorIndex - 1;
				
		return newIndex;
	}
	
	

}
