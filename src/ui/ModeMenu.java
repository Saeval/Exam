package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import model.CircularMode;
import model.Director;
import model.LinearMode;
import model.ProxyMode;

/**
 * Menu usato per selezionare la modalità di visualizzazione (lineare o circolare).
 * 
 * @author esame_07
 *
 */

public class ModeMenu extends JMenu {
	private static final long serialVersionUID = 3;
	
	private JMenuItem lineare;
	private JMenuItem circolare;
	private static ProxyMode proxyMode;
	
	public ModeMenu(String text) {
		super(text);
		lineare = new JMenuItem("Modalità lineare");
		circolare = new JMenuItem("Modalità circolare");
		proxyMode = Director.getProxyMode();
		
		/* Modalità di default per evitare NullPointerException se l'utente clicca un bottone 
		 * prima di aver selezionato un opzione di visualizzazione. */
		proxyMode.setMode(new LinearMode());
		
		lineare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proxyMode.setMode(new LinearMode());
			}
		});
		
		circolare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				proxyMode.setMode(new CircularMode());
			}
		});
		
		add(lineare);
		add(circolare);
		
	}

}
