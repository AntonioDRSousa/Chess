package gui.menutab;

import javax.swing.JMenu;

import gui.Panel;

public class MenuHelp extends JMenu{
	private Panel panel;
	
	public MenuHelp(Panel panel){
		super("Help");
		
		this.panel = panel;
	}
}