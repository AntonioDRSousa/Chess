package gui.menutab;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.*;

import gui.Panel;

public class MenuMain extends JMenu{
	private Panel panel;
	
	public MenuMain(Panel panel){
		super("Main");
		
		this.panel = panel;

		JMenuItem it_new_game = new JMenuItem("New Game");
		
		ButtonGroup type_game = new ButtonGroup();
		
		JRadioButtonMenuItem two_players = new JRadioButtonMenuItem("Player vs Player");
		JRadioButtonMenuItem player_computer = new JRadioButtonMenuItem("Player vs Computer");
		
		type_game.add(two_players);
		type_game.add(player_computer);
		
		two_players.setSelected(true);
		
		JMenuItem it_quit = new JMenuItem("Quit");
		
		add(it_new_game);
		add(new JSeparator());
		add(two_players);
		add(player_computer);
		add(new JSeparator());
		add(it_quit);
		
		
		it_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}