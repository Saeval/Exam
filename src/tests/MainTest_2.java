package tests;

import io.TextFileLoader;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import ui.FileMenu;
import ui.MainPanel;
import ui.ModeMenu;
import ui.SortMenu;

public class MainTest_2 {
	
	public static void main(String[] args) {
		
		TextFileLoader textFileLoader = new TextFileLoader("etichette_tarocche.txt");
		JFrame frame = new JFrame();
		MainPanel mainPanel = new MainPanel();
		SortMenu sortMenu = new SortMenu("Menu ordinamento");
		ModeMenu modeMenu = new ModeMenu("Menu modalità");
		FileMenu fileMenu = new FileMenu("Menu file");
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.add(sortMenu);
		menuBar.add(modeMenu);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(mainPanel);
		
		frame.setTitle(textFileLoader.getFilename());
		frame.setVisible(true);
		
	}

}
