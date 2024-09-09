package elements;

public class Game{
	public Board board;
	public boolean[][] captured_pieces;
	public char turn = 'w';
	
	public Game(){
		board = new Board();
		captured_pieces = new boolean[2][16];
		for(int i=0;i<16;i++){
			for(int j=0;j<2;j++){
				captured_pieces[j][i]=false;
			}
		}
	}
	
	public void play(){
		
	}
}