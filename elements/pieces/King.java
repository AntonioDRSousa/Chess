package elements.pieces;

import elements.Piece;
//import gui.Point;

public class King extends Piece{
	public boolean first_move;
	
	public King(char color){
		super('k',color);
		first_move = true;
	}
	
	public void possibleMoves(int x0,int y0,Piece[][] board){
		clearMoves();
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				int x1 = x0+i;
				int y1 = y0+j;
				Piece p = board[x1][y1];
				seePlace(x0,y0,x1,y1,p);
			}
		}
	}
}