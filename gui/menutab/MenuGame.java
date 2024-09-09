package gui.menutab;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.*;

import gui.Panel;

public class MenuGame extends JMenu{
	private Panel panel;
	
	public MenuGame(Panel panel){
		super("Game");
		
		this.panel = panel;
	
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem it_pwhite = new JRadioButtonMenuItem("White");
		JRadioButtonMenuItem it_pblack = new JRadioButtonMenuItem("Black");
		JRadioButtonMenuItem it_prand = new JRadioButtonMenuItem("Random");
		
		it_pwhite.setSelected(true);
		
		group.add(it_pwhite);
		group.add(it_pblack);
		group.add(it_prand);
		
		add(it_pwhite);
		add(it_pblack);
		add(it_prand);
	}
}