package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

import elements.Game;
import elements.Piece;

public class Panel extends JPanel{
	private int X = 100; int Y = 50; int ssq = 50;
	private int size_font = 25;
	private String[] letterList = {"a","b","c","d","e","f","g","h"};
	private String[] numberList = {"8","7","6","5","4","3","2","1"};
	private String[] names = {"rook","rook","knight","knight","bishop","bishop","queen","king"};
	private char orientation = 'w';
	private Game game;
	private Point click;
	private boolean valid_select = false;
	
	public Panel(Game g){
		super();
		game = g;
		click = new Point();
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = (int) (e.getX()-X)/ssq;
				int y = (int) (e.getY()-Y)/ssq;
				click.setX(x);
				click.setY(y);
				valid_select = (x>=0)&&(x<8)&&(y>=0)&&(y<8)&&(e.getX()>=X)&&(e.getY()>=Y);
		    }

 		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		X = 3*ssq;
		Piece[][] board = game.board.getBoard();
		boolean[][] captured = game.captured_pieces;
		
		g.setColor(Color.cyan);
		g.fillRect(0,0,700,600);
		Font font = new Font("Serif", Font.PLAIN, size_font);
		g.setFont(font);
		
		int d;
		if(orientation=='w'){
			d =0;
		}
		else if(orientation=='b'){
			d=1;
		}
		else{
			d=0;
		}
		
		// draw board
		for(int i=0;i<8;i++){
			g.setColor(Color.black);
			int dx = (int) (ssq/2);
			g.drawString(letterList[i],X+i*ssq+dx-5, Y-10);
			g.drawString(letterList[i],X+i*ssq+dx-5, Y+8*ssq+20);
			g.drawString(numberList[7*d+(1-d*2)*i],X-size_font, Y+i*ssq+dx);
			g.drawString(numberList[7*d+(1-d*2)*i],X+8*ssq+10, Y+i*ssq+dx);
			for(int j=0;j<8;j++){
				if((i+j+d)%2==0){
					g.setColor(Color.white);
				}
				else{
					g.setColor(Color.green);
				}
				g.fillRect(X+i*ssq,Y+j*ssq,ssq,ssq);
				if(board[i][7*d+(1-d*2)*j]!=null){
					String name = (board[i][7*d+(1-d*2)*j]).name;
					Image image = Toolkit.getDefaultToolkit().getImage("img/"+name+".png");
					g.drawImage(image, X+i*ssq,Y+j*ssq, this);
				}	
			}
		}
		
		// draw captured pieces
		for(int i=0;i<8;i++){
			if(captured[0][i]){
				Image image = Toolkit.getDefaultToolkit().getImage("img/"+"white-"+names[i]+".png");
				g.drawImage(image, 0,Y+i*ssq, this);
			}
			if(captured[1][i]){
				Image image = Toolkit.getDefaultToolkit().getImage("img/"+"black-"+names[i]+".png");
				g.drawImage(image,13*ssq,Y+i*ssq , this);
			}
		}
		for(int i=8;i<16;i++){
			if(captured[0][i]){
				Image image = Toolkit.getDefaultToolkit().getImage("img/"+"white-pawn"+".png");
				g.drawImage(image, ssq,Y+(15-i)*ssq, this);
			}
			if(captured[1][i]){
				Image image = Toolkit.getDefaultToolkit().getImage("img/"+"black-pawn"+".png");
				g.drawImage(image, 12*ssq,Y+(15-i)*ssq, this);
			}
		}
		
		if(valid_select){
			g.setColor(Color.blue);
			g.drawRect(X+click.getX()*ssq,Y+click.getY()*ssq,ssq,ssq);
			Piece p = board[click.getX()][click.getY()];
			if((p!=null)&&(p.color==game.turn)){
				p.possibleMoves(click.getX(),click.getY(),board);
				ArrayList<Point> moves = p.moves;
				for(int i=0;i<moves.size();i++){
					Point z = moves.get(i);
					int x = z.getX();
					int y = z.getY();
					int dl = (int) ssq/8;
					g.fillOval(X+x*ssq+3*dl,Y+y*ssq+3*dl,2*dl,2*dl);
				}
			}
		}
		repaint();
	}
	
	/*
	public void swap(){
		orientation = !orientation;
	}*/
	
	public void setOrientation(char b){
		orientation = b;
	}
}