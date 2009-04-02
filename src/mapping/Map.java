package mapping;

public class Map {

	final static int FREE = 0;  // empty square
	final static int STONE = 1;  // square with a stone in it
	final static int PLAYER = 2;   // square where a player is

	int[][] board = new int[24][24]; {
		
		// Fill out the whole board with free squares
		
		for (int i=0; i < 24; i++)
			   for (int j=0; j < 24; j++)
			      board[i][j] = FREE;

	}
}
