package gui.menutab;

import javax.swing.JMenu;

import gui.Panel;

public class MenuTools extends JMenu{
	private Panel panel;
	
	public MenuTools(Panel panel){
		super("Tools");
		
		this.panel = panel;
	}
}