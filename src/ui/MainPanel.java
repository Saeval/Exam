package ui;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Director;
import model.NextButtonListener;
import model.PreviousButtonListener;

/**
 * Pannello che si occupa della visualizzazione di tutti gli elementi.
 * 
 * @author esame_07
 *
 */

public class MainPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1;
	
	private Director director;
	private Etichetta etichetta;
	private JButton previous;
	private JButton next;
	
	public MainPanel() {
		director = Director.getUnicoDirector();
		director.addObserver(this);
		
		previous = new JButton("Precedente");
		next = new JButton("Successiva");
		
		setLayout(new GridLayout(3, 1));
		rendiMagiciIBottoni();
		addComponentsToPanel();
	}
	private void addComponentsToPanel() {
		add(previous);
		add(director.getCurrentEtichetta());
		add(next);
	}
	
	/**
	 * Aggiunge gli ActionListener ai bottoni.
	 * Se si rimuovono le due classi -ButtonListener potrebbe essere inglobato in un'altra funzione.
	 * 
	 */
	
	public void rendiMagiciIBottoni(){
		PreviousButtonListener previousListener = new PreviousButtonListener();
		previous.addActionListener(previousListener);
		
		NextButtonListener nextListener = new NextButtonListener();
		next.addActionListener(nextListener);
	}
	
	/**
	 * Metodo che viene invocato ogni qualvolta l'etichetta da visualizzare cambia.
	 * 
	 */

	@Override
	public void update(Observable arg0, Object arg1) {
		System.err.println("Update chiamato");
		removeAll();
		etichetta = director.getCurrentEtichetta();
		addComponentsToPanel();
		updateUI();
	}

}
