package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.menutab.*;

public class Menu extends JMenuBar{
	private Panel panel;
	
	public Menu(Panel panel){
		super();
		
		this.panel = panel;

		MenuMain menu_main = new MenuMain(panel);
		MenuGame menu_game = new MenuGame(panel);
		MenuView menu_view = new MenuView(panel);
		MenuTools menu_tools = new MenuTools(panel);
		MenuSettings menu_settings = new MenuSettings(panel);
		MenuHelp menu_help = new MenuHelp(panel);
		
		add(menu_main);
		add(menu_game);
		add(menu_view);
		add(menu_tools);
		add(menu_settings);
		add(menu_help);
	}
}