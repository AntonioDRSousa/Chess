package gui.menutab;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.*;

import gui.Panel;

public class MenuView extends JMenu{
	private Panel panel;
	
	public MenuView(Panel panel){
		super("View");
		
		this.panel = panel;

		

		JMenuItem change_view = new JMenuItem("Change View");
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButtonMenuItem fwhite = new JRadioButtonMenuItem("Front White");
		JRadioButtonMenuItem fblack = new JRadioButtonMenuItem("Front Black");
		JRadioButtonMenuItem fswap = new JRadioButtonMenuItem("Swap");
		
		fwhite.setSelected(true);
		
		group.add(fwhite);
		group.add(fblack);
		group.add(fswap);
		
		add(change_view);
		add(new JSeparator());
		add(fwhite);
		add(fblack);
		add(fswap);
		
		change_view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(fwhite.isSelected()){
					panel.setOrientation('w');
				}
				else if(fblack.isSelected()){
					panel.setOrientation('b');
				}
				panel.repaint();
			}
		});
	}
}