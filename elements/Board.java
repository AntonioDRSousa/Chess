package elements;

import elements.pieces.*;

public class Board{
	private Piece board[][] = new Piece[8][8];
	
	public Board(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[j][i] = null;
			}
		}
		for(int i=0;i<8;i++){
			board[i][6] = new Pawn('w');
			board[i][1] = new Pawn('b');
		}

		for(int j=0;j<8;j++){
			if((j==0)||(j==7)){
				board[j][7] = new Rook('w');
				board[j][0] = new Rook('b');
			}
			else if((j==1)||(j==6)){
				board[j][7] = new Knight('w');
				board[j][0] = new Knight('b');
			}
			else if((j==2)||(j==5)){
				board[j][7] = new Bishop('w');
				board[j][0] = new Bishop('b');
			}
			else if(j==3){
				board[j][7] = new Queen('w');
				board[j][0] = new Queen('b');
			}
			else if(j==4){
				board[j][7] = new King('w');
				board[j][0] = new King('b');
			}
		}
	}
	
	public Piece[][] getBoard(){
		return board;
	}
}