package elements.pieces;

import elements.Piece;

import java.io.*;

public class Pawn extends Piece{
	public boolean first_move;
	public Pawn(char color){
		super('p',color);
		first_move = true;
	}
	
	public void possibleMoves(int x0,int y0,Piece[][] board){
		clearMoves();

		int c;
		if(color=='w'){
			c = -1;
		}
		else if(color='b'){
			c = 1;
		}
		
		int x1, x2, y1, y2;
		x1 = x0-1;
		x2 = x0+1;
		y1 = y0+c*1;
		if(first_move){
			y2 = y0+c*2;			
		}
		
		//Piece p = board[x1][y1];
		//seePlace(x0,y0,x1,y1,p);
	}
}