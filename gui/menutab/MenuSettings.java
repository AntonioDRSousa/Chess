package gui.menutab;

import javax.swing.JMenu;

import gui.Panel;

public class MenuSettings extends JMenu{
	private Panel panel;
	
	public MenuSettings(Panel panel){
		super("Settings");
		
		this.panel = panel;
	}
}