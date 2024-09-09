package elements;

import java.util.ArrayList;

import gui.Point;

import java.io.*;

public abstract class Piece{
	public char type;
	public char color;
	public String name;
	public ArrayList<Point> moves;
	public ArrayList<Point> captures;
	
	public Piece(char t,char c){
		type = t;
		color = c;
		
		String s1="", s2="";
		
		if(c=='w'){
			s1 = "white";
		}
		else if(c=='b'){
			s1 = "black";
		}
		
		switch(t){
			case 'r':
				s2 = "rook";
				break;
			case 'n':
				s2 = "knight";
				break;
			case 'b':
				s2 = "bishop";
				break;
			case 'q':
				s2 = "queen";
				break;
			case 'k':
				s2 = "king";
				break;
			case 'p':
				s2 = "pawn";
				break;
		}
		
		name = s1+"-"+s2;
		
	}
	
	public void clearMoves(){
		moves = new ArrayList();
		captures = new ArrayList();
	}
	
	//public abstract void possibleMoves(int x0,int y0,Piece[][] board);

	public boolean seePlace(int x0,int y0,int x1,int y1,Piece p){
		if(isNotSame(x0,y0,x1,y1)&&inGrid(x1,y1)){
			if(p==null){
				moves.add(new Point(x1,y1));
			}
			else if(p.color!=color){
				captures.add(new Point(x1,y1));
				return true;
			}
		}
		return false;
	}
	
	public boolean inGrid(int x,int y){
		return ((x>=0)&&(x<8)&&(y>=0)&&(y<8));
	}
	
	public boolean isNotSame(int x1,int y1,int x2,int y2){
		return !((x1==x2)&&(y1==y2));
	}
}