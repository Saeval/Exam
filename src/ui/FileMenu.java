package ui;

import io.TextFileLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * TODO: Menu usato per selezionare il file aperto.
 * 
 * @author esame_07
 *
 */

public class FileMenu extends JMenu {
	private static final long serialVersionUID = 4;

	private JMenuItem file1;
	private JMenuItem file2;
	private String file1name = "etichette_tarocche.txt";
	private String file2name = "etichette_tarocche_2.txt";
	private TextFileLoader textFileLoader;

	public FileMenu(String text) {
		super(text);
		file1 = new JMenuItem(file1name);
		file2 = new JMenuItem(file2name);

		file1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFileLoader.refreshFilename(file1name);
			}
		});

		file2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFileLoader.refreshFilename(file2name);
			}
		});
		
		add(file1);
		add(file2);
	}

}
