package mapping;

public class Map {

	final static int FREE = 0;  // Empty square
	final static int STONE = 1;  // Square with a stone in it
	final static int UNBREAKABLE = 2; // Unbreakable path, a player can't stand here
	final static int PLAYER = 3;   // Square where a player is
	
	final static int HEIGHT = 24; // Height of the board
	final static int WIDTH = 24; // Width of the board

	int[][] board = new int[HEIGHT][WIDTH]; {
		
		// Fill out the whole board with free squares
		// Assumes that everything outside the board is UNBREAKABLE
		
		for (int i=0; i < HEIGHT ; i++)
			   for (int j=0; j < WIDTH; j++)
			      board[i][j] = FREE;

	}
}