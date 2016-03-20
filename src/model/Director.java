package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import ui.Etichetta;

/**
 * 
 * Classe che si occupa di gestire le interazioni che i vari componenti grafici hanno fra di loro.
 * Ovviamente è unico, quindi viene usato in Singleton.
 * 
 * @author esame_07
 *
 */

public class Director extends Observable {
	
	private ArrayList<Etichetta> originalEtichette;
	private ArrayList<Etichetta> etichette;
	private int index = 0;
	private static Director unicoDirector = new Director();
	private static ProxyMode proxyMode = new ProxyMode(null);
	
	private Director() {
		etichette = new ArrayList<Etichetta>();
	}
	
	public static Director getUnicoDirector() {
		return unicoDirector;
	}
	
	/**
	 * Metodo che viene usato per modificare l'indice.
	 * Solo il director ha questo privilegio quindi viene impostato a private.
	 * Ogni volta che index viene modificato, l'Observer (MainPanel)
	 * va notificato in quanto deve aggiornare la visualizzazione.
	 * 
	 * @param index
	 */
	
	private void setIndex(int index) {
		this.index = index;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Incrementa l'indice che indica l'Etichetta mostrata attualmente.
	 * Applicata sul proxy in quanto la modalità dell'incremento
	 * dipende dal tipo di visualizzazione selezionata (lineare o circolare).
	 * 
	 */
	public void goNext(){
		setIndex(proxyMode.increaseIndex(index));
		System.err.println(index);
	}
	
	/**
	 * Decrementa l'indice che indica l'Etichetta mostrata attualmente.
	 * Valgono le stesse considerazioni fatte per goNext().
	 * 
	 */
	
	public void goPrevious(){
		setIndex(proxyMode.decreaseIndex(index));
		System.err.println(index);
	}
	
	/**
	 * Metodo invocato nel momento in cui si è finito di leggere il file (cfr. TextFileLoader.java).
	 * Effettua una copia delle etichette (che sono ancora in ordine originale)
	 * per poterle ripristinare in futuro.
	 * 
	 * TODO: Controllare la documentazione di Collections.copy()
	 * 
	 */
	
	public void inizializzaOriginalEtichette(){
		originalEtichette = new ArrayList<Etichetta>(etichette.size());
//		Collections.copy(etichette, originalEtichette);
		originalEtichette = etichette;
	}
	
	/**
	 * Ripristina l'ArrayList che viene effettivamente utilizzato "etichette"
	 * allo stato originale, salvato nel metodo prima.
	 * Notifica l'observer (MainPanel) in quanto le etichette vanno ricaricate.
	 * 
	 * TODO: Così non funziona, probabilmente va usato Collections.copy() in qualche modo.
	 * 
	 */
	
	public void resetEtichette(){
//		Collections.copy(originalEtichette, etichette);
		etichette = originalEtichette;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Il nome del metodo parla da sé.
	 * Notifica l'observer (MainPanel) in quanto le etichette vanno ricaricate.
	 * 
	 */
	
	public void shuffleEtichette(){
		Collections.shuffle(etichette);
		setChanged();
		notifyObservers();
		return;
	}
	
	/**
	 * Metodo get da usare nelle altre classi (e.g. ModeMenu).
	 * 
	 * @return proxyMode Unico proxy istanziato.
	 */
	
	public static ProxyMode getProxyMode() {
		return proxyMode;
	}
	
	public Etichetta getCurrentEtichetta(){
		return etichette.get(index);
	}
	
	public ArrayList<Etichetta> getEtichette() {
		return etichette;
	}

}
