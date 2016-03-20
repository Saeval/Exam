package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener utilizzato dal bottone che riporta all'Etichetta precedente.
 * 
 * - Classe creata in prima fase, forse ora risulta inutile. -
 * 
 * @author esame_07
 *
 */

public class PreviousButtonListener implements ActionListener{

private Director director;
	
	public PreviousButtonListener() {
		director = Director.getUnicoDirector();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		director.goPrevious();
	}

}
