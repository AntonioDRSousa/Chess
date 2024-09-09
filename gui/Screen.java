package gui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import elements.Game;

public class Screen extends JFrame{
	private static int dimx = 1000;
	private static int dimy = 600;
	private Panel gpanel;
	private Game game;
	private Menu menu;
	
	public Screen(){
		editWindow();
		
		game = new Game();
		gpanel = new Panel(game);
		menu = new Menu(gpanel);
		setJMenuBar(menu);
		
		add(gpanel);
		revalidate();
		repaint();
	}
	
	private void editWindow(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Chess");
		setSize(dimx,dimy);
		setResizable(false);
		getContentPane().setBackground(Color.yellow);
		setVisible(true);
	}
}
