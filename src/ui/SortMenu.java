package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.Director;

/**
 * Menu usato per selezionare la modalità di ordinamento (casuale o originale).
 * 
 * @author esame_07
 *
 */

public class SortMenu extends JMenu {
	private static final long serialVersionUID = 2;
	
	private Director director;
	private JMenuItem casuale;
	private JMenuItem originale;
	
	public SortMenu(String text) {
		super(text);
		director = Director.getUnicoDirector();
		casuale = new JMenuItem("Ordine casuale");
		originale = new JMenuItem("Ordine originale");
		
		/* Se ritenuto necessario, si potrebbe implementare un proxy
		 * che astrae sul tipo di ordinamento in maniera analoga
		 * a quanto fatto per la modalità di visualizzazione.
		 */
		
		casuale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				director.shuffleEtichette();
			}
		});
		
		originale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				director.resetEtichette();
			}
		});
		
		add(casuale);
		add(originale);
		
	}

}
