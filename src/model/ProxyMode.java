package model;

/**
 * Proxy / Astrazione sul tipo di metodo di visualizzazione.
 * 
 * @author esame_07
 *
 */

public class ProxyMode implements IMode{
	
	private IMode iMode;
//	private int index;
	
	public ProxyMode(IMode iMode) {
		this.iMode = iMode;
	}
	
	public void setMode(IMode iMode) {
		this.iMode = iMode;
	}

	@Override
	public int increaseIndex(int index) {
		return iMode.increaseIndex(index);
	}

	@Override
	public int decreaseIndex(int index) {
		return iMode.decreaseIndex(index);
	}

}
