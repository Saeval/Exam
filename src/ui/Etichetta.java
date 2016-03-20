package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * Estensione di JLabel.
 * Usata per ogni riga di file di testo.
 * 
 * @author esame_07
 *
 */

public class Etichetta extends JLabel {
	private static final long serialVersionUID = 0;

	private String text;
	private Color color;
	private int dimension;
	private String fontName;
	
	public Etichetta(String colorString, int dimension, String fontName, String text) {
		super();
		this.text = text;
		this.color = setColorFromString(colorString);
		this.fontName = fontName;
		this.dimension = dimension;
		setFont(new Font(fontName, dimension, dimension));
		setText(text);
		setForeground(color);
	}
	
	/* TODO: Trovare una soluzione migliore a questa roba,
	 * che risulta in qualche modo accettabile solo in quanto
	 * il numero di colori è limitato. */
	
	private Color setColorFromString(String colorString) {
		if (colorString.equals("RED")) {
			color = Color.RED;
		}
		if (colorString.equals("BLUE")) {
			color = Color.BLUE;
		}
		if (colorString.equals("YELLOW")) {
			color = Color.YELLOW;
		}
		if (colorString.equals("GREEN")) {
			color = Color.GREEN;
		}
		
		return color;
	}

}
