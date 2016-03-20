package model;

/**
 * Interfaccia utilizzata per implementare il Proxy.
 * I due metodi differiscono a seconda della modalità.
 * 
 * @author esame_07
 *
 */

public interface IMode {
	
	public abstract int increaseIndex(int index);
	public abstract int decreaseIndex(int index);

}
